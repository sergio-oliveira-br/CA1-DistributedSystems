package com.ncirl.streaming.streamingclientservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: StreamingClientService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamingClientServiceGrpc {

  private StreamingClientServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.streaming.StreamingClientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ncirl.streaming.streamingclientservice.UnaryRequest,
      com.ncirl.streaming.streamingclientservice.UnaryResponse> getSendUnaryRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendUnaryRequest",
      requestType = com.ncirl.streaming.streamingclientservice.UnaryRequest.class,
      responseType = com.ncirl.streaming.streamingclientservice.UnaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ncirl.streaming.streamingclientservice.UnaryRequest,
      com.ncirl.streaming.streamingclientservice.UnaryResponse> getSendUnaryRequestMethod() {
    io.grpc.MethodDescriptor<com.ncirl.streaming.streamingclientservice.UnaryRequest, com.ncirl.streaming.streamingclientservice.UnaryResponse> getSendUnaryRequestMethod;
    if ((getSendUnaryRequestMethod = StreamingClientServiceGrpc.getSendUnaryRequestMethod) == null) {
      synchronized (StreamingClientServiceGrpc.class) {
        if ((getSendUnaryRequestMethod = StreamingClientServiceGrpc.getSendUnaryRequestMethod) == null) {
          StreamingClientServiceGrpc.getSendUnaryRequestMethod = getSendUnaryRequestMethod =
              io.grpc.MethodDescriptor.<com.ncirl.streaming.streamingclientservice.UnaryRequest, com.ncirl.streaming.streamingclientservice.UnaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendUnaryRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.streaming.streamingclientservice.UnaryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.streaming.streamingclientservice.UnaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingClientServiceMethodDescriptorSupplier("sendUnaryRequest"))
              .build();
        }
      }
    }
    return getSendUnaryRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ncirl.streaming.streamingclientservice.ClientInformation,
      com.ncirl.streaming.streamingclientservice.ServerResponse> getStreamClientInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamClientInformation",
      requestType = com.ncirl.streaming.streamingclientservice.ClientInformation.class,
      responseType = com.ncirl.streaming.streamingclientservice.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.ncirl.streaming.streamingclientservice.ClientInformation,
      com.ncirl.streaming.streamingclientservice.ServerResponse> getStreamClientInformationMethod() {
    io.grpc.MethodDescriptor<com.ncirl.streaming.streamingclientservice.ClientInformation, com.ncirl.streaming.streamingclientservice.ServerResponse> getStreamClientInformationMethod;
    if ((getStreamClientInformationMethod = StreamingClientServiceGrpc.getStreamClientInformationMethod) == null) {
      synchronized (StreamingClientServiceGrpc.class) {
        if ((getStreamClientInformationMethod = StreamingClientServiceGrpc.getStreamClientInformationMethod) == null) {
          StreamingClientServiceGrpc.getStreamClientInformationMethod = getStreamClientInformationMethod =
              io.grpc.MethodDescriptor.<com.ncirl.streaming.streamingclientservice.ClientInformation, com.ncirl.streaming.streamingclientservice.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamClientInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.streaming.streamingclientservice.ClientInformation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.streaming.streamingclientservice.ServerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingClientServiceMethodDescriptorSupplier("streamClientInformation"))
              .build();
        }
      }
    }
    return getStreamClientInformationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamingClientServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingClientServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingClientServiceStub>() {
        @java.lang.Override
        public StreamingClientServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingClientServiceStub(channel, callOptions);
        }
      };
    return StreamingClientServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamingClientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingClientServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingClientServiceBlockingStub>() {
        @java.lang.Override
        public StreamingClientServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingClientServiceBlockingStub(channel, callOptions);
        }
      };
    return StreamingClientServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamingClientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingClientServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingClientServiceFutureStub>() {
        @java.lang.Override
        public StreamingClientServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingClientServiceFutureStub(channel, callOptions);
        }
      };
    return StreamingClientServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    default void sendUnaryRequest(com.ncirl.streaming.streamingclientservice.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.UnaryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendUnaryRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.ClientInformation> streamClientInformation(
        io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.ServerResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamClientInformationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StreamingClientService.
   */
  public static abstract class StreamingClientServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StreamingClientServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StreamingClientService.
   */
  public static final class StreamingClientServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StreamingClientServiceStub> {
    private StreamingClientServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingClientServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingClientServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public void sendUnaryRequest(com.ncirl.streaming.streamingclientservice.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.UnaryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendUnaryRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.ClientInformation> streamClientInformation(
        io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.ServerResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getStreamClientInformationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StreamingClientService.
   */
  public static final class StreamingClientServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamingClientServiceBlockingStub> {
    private StreamingClientServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingClientServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingClientServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.ncirl.streaming.streamingclientservice.UnaryResponse sendUnaryRequest(com.ncirl.streaming.streamingclientservice.UnaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendUnaryRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StreamingClientService.
   */
  public static final class StreamingClientServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamingClientServiceFutureStub> {
    private StreamingClientServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingClientServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingClientServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ncirl.streaming.streamingclientservice.UnaryResponse> sendUnaryRequest(
        com.ncirl.streaming.streamingclientservice.UnaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendUnaryRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_UNARY_REQUEST = 0;
  private static final int METHODID_STREAM_CLIENT_INFORMATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_UNARY_REQUEST:
          serviceImpl.sendUnaryRequest((com.ncirl.streaming.streamingclientservice.UnaryRequest) request,
              (io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.UnaryResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_CLIENT_INFORMATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamClientInformation(
              (io.grpc.stub.StreamObserver<com.ncirl.streaming.streamingclientservice.ServerResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendUnaryRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.ncirl.streaming.streamingclientservice.UnaryRequest,
              com.ncirl.streaming.streamingclientservice.UnaryResponse>(
                service, METHODID_SEND_UNARY_REQUEST)))
        .addMethod(
          getStreamClientInformationMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.ncirl.streaming.streamingclientservice.ClientInformation,
              com.ncirl.streaming.streamingclientservice.ServerResponse>(
                service, METHODID_STREAM_CLIENT_INFORMATION)))
        .build();
  }

  private static abstract class StreamingClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamingClientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.streaming.streamingclientservice.StreamingClientServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamingClientService");
    }
  }

  private static final class StreamingClientServiceFileDescriptorSupplier
      extends StreamingClientServiceBaseDescriptorSupplier {
    StreamingClientServiceFileDescriptorSupplier() {}
  }

  private static final class StreamingClientServiceMethodDescriptorSupplier
      extends StreamingClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StreamingClientServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StreamingClientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamingClientServiceFileDescriptorSupplier())
              .addMethod(getSendUnaryRequestMethod())
              .addMethod(getStreamClientInformationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
