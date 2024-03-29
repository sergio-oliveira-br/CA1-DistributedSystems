package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: SmartThermostatsProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TemperatureServicesGrpc {

  private TemperatureServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TemperatureServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.TempConfig,
      com.CA.gRPC.TempResponse> getSetTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTemperature",
      requestType = com.CA.gRPC.TempConfig.class,
      responseType = com.CA.gRPC.TempResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.TempConfig,
      com.CA.gRPC.TempResponse> getSetTemperatureMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.TempConfig, com.CA.gRPC.TempResponse> getSetTemperatureMethod;
    if ((getSetTemperatureMethod = TemperatureServicesGrpc.getSetTemperatureMethod) == null) {
      synchronized (TemperatureServicesGrpc.class) {
        if ((getSetTemperatureMethod = TemperatureServicesGrpc.getSetTemperatureMethod) == null) {
          TemperatureServicesGrpc.getSetTemperatureMethod = getSetTemperatureMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.TempConfig, com.CA.gRPC.TempResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TempConfig.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TempResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureServicesMethodDescriptorSupplier("setTemperature"))
              .build();
        }
      }
    }
    return getSetTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.TempRequest,
      com.CA.gRPC.TempUpdate> getCheckTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkTemp",
      requestType = com.CA.gRPC.TempRequest.class,
      responseType = com.CA.gRPC.TempUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.TempRequest,
      com.CA.gRPC.TempUpdate> getCheckTempMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.TempRequest, com.CA.gRPC.TempUpdate> getCheckTempMethod;
    if ((getCheckTempMethod = TemperatureServicesGrpc.getCheckTempMethod) == null) {
      synchronized (TemperatureServicesGrpc.class) {
        if ((getCheckTempMethod = TemperatureServicesGrpc.getCheckTempMethod) == null) {
          TemperatureServicesGrpc.getCheckTempMethod = getCheckTempMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.TempRequest, com.CA.gRPC.TempUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkTemp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TempUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureServicesMethodDescriptorSupplier("checkTemp"))
              .build();
        }
      }
    }
    return getCheckTempMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureServicesStub>() {
        @java.lang.Override
        public TemperatureServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureServicesStub(channel, callOptions);
        }
      };
    return TemperatureServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureServicesBlockingStub>() {
        @java.lang.Override
        public TemperatureServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureServicesBlockingStub(channel, callOptions);
        }
      };
    return TemperatureServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureServicesFutureStub>() {
        @java.lang.Override
        public TemperatureServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureServicesFutureStub(channel, callOptions);
        }
      };
    return TemperatureServicesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *set the temp
     * </pre>
     */
    default void setTemperature(com.CA.gRPC.TempConfig request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TempResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     *keep track the temp
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.CA.gRPC.TempRequest> checkTemp(
        io.grpc.stub.StreamObserver<com.CA.gRPC.TempUpdate> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCheckTempMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TemperatureServices.
   */
  public static abstract class TemperatureServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TemperatureServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TemperatureServices.
   */
  public static final class TemperatureServicesStub
      extends io.grpc.stub.AbstractAsyncStub<TemperatureServicesStub> {
    private TemperatureServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureServicesStub(channel, callOptions);
    }

    /**
     * <pre>
     *set the temp
     * </pre>
     */
    public void setTemperature(com.CA.gRPC.TempConfig request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TempResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *keep track the temp
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.CA.gRPC.TempRequest> checkTemp(
        io.grpc.stub.StreamObserver<com.CA.gRPC.TempUpdate> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getCheckTempMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TemperatureServices.
   */
  public static final class TemperatureServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TemperatureServicesBlockingStub> {
    private TemperatureServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureServicesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *set the temp
     * </pre>
     */
    public com.CA.gRPC.TempResponse setTemperature(com.CA.gRPC.TempConfig request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TemperatureServices.
   */
  public static final class TemperatureServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<TemperatureServicesFutureStub> {
    private TemperatureServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureServicesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *set the temp
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.TempResponse> setTemperature(
        com.CA.gRPC.TempConfig request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TEMPERATURE = 0;
  private static final int METHODID_CHECK_TEMP = 1;

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
        case METHODID_SET_TEMPERATURE:
          serviceImpl.setTemperature((com.CA.gRPC.TempConfig) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.TempResponse>) responseObserver);
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
        case METHODID_CHECK_TEMP:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.checkTemp(
              (io.grpc.stub.StreamObserver<com.CA.gRPC.TempUpdate>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSetTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.TempConfig,
              com.CA.gRPC.TempResponse>(
                service, METHODID_SET_TEMPERATURE)))
        .addMethod(
          getCheckTempMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.CA.gRPC.TempRequest,
              com.CA.gRPC.TempUpdate>(
                service, METHODID_CHECK_TEMP)))
        .build();
  }

  private static abstract class TemperatureServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.ThermostatsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemperatureServices");
    }
  }

  private static final class TemperatureServicesFileDescriptorSupplier
      extends TemperatureServicesBaseDescriptorSupplier {
    TemperatureServicesFileDescriptorSupplier() {}
  }

  private static final class TemperatureServicesMethodDescriptorSupplier
      extends TemperatureServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TemperatureServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TemperatureServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureServicesFileDescriptorSupplier())
              .addMethod(getSetTemperatureMethod())
              .addMethod(getCheckTempMethod())
              .build();
        }
      }
    }
    return result;
  }
}
