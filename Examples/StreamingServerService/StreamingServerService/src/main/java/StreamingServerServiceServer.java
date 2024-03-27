import com.ncirl.streaming.streamingserverservice.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class StreamingServerServiceServer extends StreamingServerServiceGrpc.StreamingServerServiceImplBase {

    @Override
    public void sendUnaryRequest(UnaryRequest request, StreamObserver<UnaryResponse> responseObserver) {
        String clientName = request.getName();
        String message = "Hello, " + clientName + "! This is a unary response from the server";
        UnaryResponse response = UnaryResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamServerRequest(StreamServerRequest request, StreamObserver<StreamServerResponse> responseObserver) {
        String serverName = request.getServerName();
        Runnable streamingTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String message = "This is a message from the server: " + serverName + ". Current time: " + LocalDateTime.now();
                    StreamServerResponse response = StreamServerResponse.newBuilder()
                            .setMessage(message)
                            .build();
                    responseObserver.onNext(response);
                    Thread.sleep(5000); // Stream every 5 seconds
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                responseObserver.onCompleted();
            }
        };

        Thread streamingThread = new Thread(streamingTask);
        streamingThread.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StreamingServerServiceServer server = new StreamingServerServiceServer();
        Server grpcServer = ServerBuilder.forPort(8080)
                .addService(server)
                .build();

        grpcServer.start();
        System.out.println("Server started, listening on port 8080");

        // Graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server");
            try {
                grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));

        grpcServer.awaitTermination();
    }
}
