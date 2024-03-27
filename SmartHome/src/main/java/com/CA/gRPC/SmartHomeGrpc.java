package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: SmartHomeProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SmartHomeGrpc {

  private SmartHomeGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartHome";

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
    if ((getControlLightsMethod = SmartHomeGrpc.getControlLightsMethod) == null) {
      synchronized (SmartHomeGrpc.class) {
        if ((getControlLightsMethod = SmartHomeGrpc.getControlLightsMethod) == null) {
          SmartHomeGrpc.getControlLightsMethod = getControlLightsMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.LightRequest, com.CA.gRPC.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.LightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartHomeMethodDescriptorSupplier("ControlLights"))
              .build();
        }
      }
    }
    return getControlLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartHomeStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartHomeStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartHomeStub>() {
        @java.lang.Override
        public SmartHomeStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartHomeStub(channel, callOptions);
        }
      };
    return SmartHomeStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartHomeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartHomeBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartHomeBlockingStub>() {
        @java.lang.Override
        public SmartHomeBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartHomeBlockingStub(channel, callOptions);
        }
      };
    return SmartHomeBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartHomeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartHomeFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartHomeFutureStub>() {
        @java.lang.Override
        public SmartHomeFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartHomeFutureStub(channel, callOptions);
        }
      };
    return SmartHomeFutureStub.newStub(factory, channel);
  }

  /**
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
   * Base class for the server implementation of the service SmartHome.
   */
  public static abstract class SmartHomeImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SmartHomeGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SmartHome.
   */
  public static final class SmartHomeStub
      extends io.grpc.stub.AbstractAsyncStub<SmartHomeStub> {
    private SmartHomeStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHomeStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartHomeStub(channel, callOptions);
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
   * A stub to allow clients to do synchronous rpc calls to service SmartHome.
   */
  public static final class SmartHomeBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SmartHomeBlockingStub> {
    private SmartHomeBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHomeBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartHomeBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.CA.gRPC.LightResponse controlLights(com.CA.gRPC.LightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlLightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SmartHome.
   */
  public static final class SmartHomeFutureStub
      extends io.grpc.stub.AbstractFutureStub<SmartHomeFutureStub> {
    private SmartHomeFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHomeFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartHomeFutureStub(channel, callOptions);
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

  private static abstract class SmartHomeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartHomeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.SmartHomeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartHome");
    }
  }

  private static final class SmartHomeFileDescriptorSupplier
      extends SmartHomeBaseDescriptorSupplier {
    SmartHomeFileDescriptorSupplier() {}
  }

  private static final class SmartHomeMethodDescriptorSupplier
      extends SmartHomeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SmartHomeMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SmartHomeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartHomeFileDescriptorSupplier())
              .addMethod(getControlLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
