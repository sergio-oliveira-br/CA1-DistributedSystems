import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;
import com.ncirl.demo.demoservice.DemoServiceGrpc;
import com.ncirl.demo.demoservice.UnaryRequest;
import com.ncirl.demo.demoservice.UnaryResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class DemoClient {

    private final ConsulClient consulClient;
    private final String consulServiceName;

    public DemoClient(String consulHost, int consulPort, String consulServiceName) {
        this.consulClient = new ConsulClient(consulHost, consulPort);
        this.consulServiceName = consulServiceName;
    }

    public void makeUnaryRequest() {
        // Lookup service details from Consul
        List<HealthService> healthServices = consulClient.getHealthServices(consulServiceName, true, null).getValue();
        if (healthServices.isEmpty()) {
            System.err.println("No healthy instances of " + consulServiceName + " found in Consul.");
            return;
        }

        // Pick the first healthy instance (you can implement a load balancing strategy here)
        HealthService healthService = healthServices.get(0);

        // Debug output for service details
        System.out.println("Service details from Consul:");
        System.out.println("Service ID: " + healthService.getService().getId());
        System.out.println("Service Name: " + healthService.getService().getService());
        System.out.println("Service Address: " + healthService.getService().getAddress());
        System.out.println("Service Port: " + healthService.getService().getPort());

        // Extract host and port from the service details
        String serverHost = healthService.getService().getAddress();
        int serverPort = healthService.getService().getPort();

        // Debug output for extracted host and port
        System.out.println("Server host: " + serverHost);
        System.out.println("Server port: " + serverPort);

        // Create a gRPC channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverHost, serverPort).usePlaintext().build();

        // Create a stub for the gRPC service
        DemoServiceGrpc.DemoServiceBlockingStub stub = DemoServiceGrpc.newBlockingStub(channel);

        // Prepare and send the unary request
        UnaryRequest request = UnaryRequest.newBuilder().setRequest("Hello from client").build();
        UnaryResponse response = stub.sendUnaryRequest(request);

        // Process the response
        System.out.println("Unary response from server: " + response.getResponse());

        // Shutdown the channel when done
        channel.shutdown();
    }

    public static void main(String[] args) {
        String consulHost = "localhost"; // Consul host
        int consulPort = 8500; // Consul port
        String consulServiceName = "demo-service"; // Name of the service registered in Consul

        DemoClient client = new DemoClient(consulHost, consulPort, consulServiceName);
        client.makeUnaryRequest();
    }
}
