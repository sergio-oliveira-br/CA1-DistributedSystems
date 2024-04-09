package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Unary is request/response. The client wants a service,
 *it sends a request and receives a response.
 *If there is a connection failure, the client has to send the same request again.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: SmartHomeProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightServicesGrpc {

  private LightServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "LightServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.LightRequest,
      com.CA.gRPC.LightResponse> getControlLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLights",
      requestType = com.CA.gRPC.LightRequest.class,
      responseType = com.CA.gRPC.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.LightRequest,
      com.CA.gRPC.LightResponse> getControlLightsMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.LightRequest, com.CA.gRPC.LightResponse> getControlLightsMethod;
    if ((getControlLightsMethod = LightServicesGrpc.getControlLightsMethod) == null) {
      synchronized (LightServicesGrpc.class) {
        if ((getControlLightsMethod = LightServicesGrpc.getControlLightsMethod) == null) {
          LightServicesGrpc.getControlLightsMethod = getControlLightsMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.LightRequest, com.CA.gRPC.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.LightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightServicesMethodDescriptorSupplier("ControlLights"))
              .build();
        }
      }
    }
    return getControlLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServicesStub>() {
        @java.lang.Override
        public LightServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServicesStub(channel, callOptions);
        }
      };
    return LightServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServicesBlockingStub>() {
        @java.lang.Override
        public LightServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServicesBlockingStub(channel, callOptions);
        }
      };
    return LightServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightServicesFutureStub>() {
        @java.lang.Override
        public LightServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightServicesFutureStub(channel, callOptions);
        }
      };
    return LightServicesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Unary is request/response. The client wants a service,
   *it sends a request and receives a response.
   *If there is a connection failure, the client has to send the same request again.
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void controlLights(com.CA.gRPC.LightRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.LightResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlLightsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LightServices.
   * <pre>
   *Unary is request/response. The client wants a service,
   *it sends a request and receives a response.
   *If there is a connection failure, the client has to send the same request again.
   * </pre>
   */
  public static abstract class LightServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LightServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LightServices.
   * <pre>
   *Unary is request/response. The client wants a service,
   *it sends a request and receives a response.
   *If there is a connection failure, the client has to send the same request again.
   * </pre>
   */
  public static final class LightServicesStub
      extends io.grpc.stub.AbstractAsyncStub<LightServicesStub> {
    private LightServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServicesStub(channel, callOptions);
    }

    /**
     */
    public void controlLights(com.CA.gRPC.LightRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.LightResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlLightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LightServices.
   * <pre>
   *Unary is request/response. The client wants a service,
   *it sends a request and receives a response.
   *If there is a connection failure, the client has to send the same request again.
   * </pre>
   */
  public static final class LightServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LightServicesBlockingStub> {
    private LightServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.CA.gRPC.LightResponse controlLights(com.CA.gRPC.LightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlLightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LightServices.
   * <pre>
   *Unary is request/response. The client wants a service,
   *it sends a request and receives a response.
   *If there is a connection failure, the client has to send the same request again.
   * </pre>
   */
  public static final class LightServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<LightServicesFutureStub> {
    private LightServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.LightResponse> controlLights(
        com.CA.gRPC.LightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlLightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_LIGHTS = 0;

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
        case METHODID_CONTROL_LIGHTS:
          serviceImpl.controlLights((com.CA.gRPC.LightRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.LightResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getControlLightsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.LightRequest,
              com.CA.gRPC.LightResponse>(
                service, METHODID_CONTROL_LIGHTS)))
        .build();
  }

  private static abstract class LightServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.LightProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightServices");
    }
  }

  private static final class LightServicesFileDescriptorSupplier
      extends LightServicesBaseDescriptorSupplier {
    LightServicesFileDescriptorSupplier() {}
  }

  private static final class LightServicesMethodDescriptorSupplier
      extends LightServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LightServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LightServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServicesFileDescriptorSupplier())
              .addMethod(getControlLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
