package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service definition (Unary RPC) - This services allow the user request to open/close and get answer from the server
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: EnvironmentManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnvironmentMgmtServicesGrpc {

  private EnvironmentMgmtServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "EnvironmentMgmtServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.SwitchOnRequest,
      com.CA.gRPC.SwitchOnResponse> getSwitchOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOn",
      requestType = com.CA.gRPC.SwitchOnRequest.class,
      responseType = com.CA.gRPC.SwitchOnResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.SwitchOnRequest,
      com.CA.gRPC.SwitchOnResponse> getSwitchOnMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.SwitchOnRequest, com.CA.gRPC.SwitchOnResponse> getSwitchOnMethod;
    if ((getSwitchOnMethod = EnvironmentMgmtServicesGrpc.getSwitchOnMethod) == null) {
      synchronized (EnvironmentMgmtServicesGrpc.class) {
        if ((getSwitchOnMethod = EnvironmentMgmtServicesGrpc.getSwitchOnMethod) == null) {
          EnvironmentMgmtServicesGrpc.getSwitchOnMethod = getSwitchOnMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.SwitchOnRequest, com.CA.gRPC.SwitchOnResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "switchOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.SwitchOnRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.SwitchOnResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentMgmtServicesMethodDescriptorSupplier("switchOn"))
              .build();
        }
      }
    }
    return getSwitchOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.SwitchOffRequest,
      com.CA.gRPC.SwitchOffResponse> getSwitchOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOff",
      requestType = com.CA.gRPC.SwitchOffRequest.class,
      responseType = com.CA.gRPC.SwitchOffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.SwitchOffRequest,
      com.CA.gRPC.SwitchOffResponse> getSwitchOffMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.SwitchOffRequest, com.CA.gRPC.SwitchOffResponse> getSwitchOffMethod;
    if ((getSwitchOffMethod = EnvironmentMgmtServicesGrpc.getSwitchOffMethod) == null) {
      synchronized (EnvironmentMgmtServicesGrpc.class) {
        if ((getSwitchOffMethod = EnvironmentMgmtServicesGrpc.getSwitchOffMethod) == null) {
          EnvironmentMgmtServicesGrpc.getSwitchOffMethod = getSwitchOffMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.SwitchOffRequest, com.CA.gRPC.SwitchOffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "switchOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.SwitchOffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.SwitchOffResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentMgmtServicesMethodDescriptorSupplier("switchOff"))
              .build();
        }
      }
    }
    return getSwitchOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.ForecastRequest,
      com.CA.gRPC.ForecastResponse> getForecastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "forecast",
      requestType = com.CA.gRPC.ForecastRequest.class,
      responseType = com.CA.gRPC.ForecastResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.ForecastRequest,
      com.CA.gRPC.ForecastResponse> getForecastMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.ForecastRequest, com.CA.gRPC.ForecastResponse> getForecastMethod;
    if ((getForecastMethod = EnvironmentMgmtServicesGrpc.getForecastMethod) == null) {
      synchronized (EnvironmentMgmtServicesGrpc.class) {
        if ((getForecastMethod = EnvironmentMgmtServicesGrpc.getForecastMethod) == null) {
          EnvironmentMgmtServicesGrpc.getForecastMethod = getForecastMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.ForecastRequest, com.CA.gRPC.ForecastResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "forecast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.ForecastRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.ForecastResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentMgmtServicesMethodDescriptorSupplier("forecast"))
              .build();
        }
      }
    }
    return getForecastMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnvironmentMgmtServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentMgmtServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentMgmtServicesStub>() {
        @java.lang.Override
        public EnvironmentMgmtServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentMgmtServicesStub(channel, callOptions);
        }
      };
    return EnvironmentMgmtServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnvironmentMgmtServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentMgmtServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentMgmtServicesBlockingStub>() {
        @java.lang.Override
        public EnvironmentMgmtServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentMgmtServicesBlockingStub(channel, callOptions);
        }
      };
    return EnvironmentMgmtServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnvironmentMgmtServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentMgmtServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentMgmtServicesFutureStub>() {
        @java.lang.Override
        public EnvironmentMgmtServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentMgmtServicesFutureStub(channel, callOptions);
        }
      };
    return EnvironmentMgmtServicesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service definition (Unary RPC) - This services allow the user request to open/close and get answer from the server
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void switchOn(com.CA.gRPC.SwitchOnRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.SwitchOnResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchOnMethod(), responseObserver);
    }

    /**
     */
    default void switchOff(com.CA.gRPC.SwitchOffRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.SwitchOffResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSwitchOffMethod(), responseObserver);
    }

    /**
     */
    default void forecast(com.CA.gRPC.ForecastRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.ForecastResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getForecastMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EnvironmentMgmtServices.
   * <pre>
   *Service definition (Unary RPC) - This services allow the user request to open/close and get answer from the server
   * </pre>
   */
  public static abstract class EnvironmentMgmtServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EnvironmentMgmtServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EnvironmentMgmtServices.
   * <pre>
   *Service definition (Unary RPC) - This services allow the user request to open/close and get answer from the server
   * </pre>
   */
  public static final class EnvironmentMgmtServicesStub
      extends io.grpc.stub.AbstractAsyncStub<EnvironmentMgmtServicesStub> {
    private EnvironmentMgmtServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentMgmtServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentMgmtServicesStub(channel, callOptions);
    }

    /**
     */
    public void switchOn(com.CA.gRPC.SwitchOnRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.SwitchOnResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchOff(com.CA.gRPC.SwitchOffRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.SwitchOffResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void forecast(com.CA.gRPC.ForecastRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.ForecastResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getForecastMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EnvironmentMgmtServices.
   * <pre>
   *Service definition (Unary RPC) - This services allow the user request to open/close and get answer from the server
   * </pre>
   */
  public static final class EnvironmentMgmtServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EnvironmentMgmtServicesBlockingStub> {
    private EnvironmentMgmtServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentMgmtServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentMgmtServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.CA.gRPC.SwitchOnResponse> switchOn(
        com.CA.gRPC.SwitchOnRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSwitchOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.CA.gRPC.SwitchOffResponse switchOff(com.CA.gRPC.SwitchOffRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSwitchOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.CA.gRPC.ForecastResponse forecast(com.CA.gRPC.ForecastRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getForecastMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EnvironmentMgmtServices.
   * <pre>
   *Service definition (Unary RPC) - This services allow the user request to open/close and get answer from the server
   * </pre>
   */
  public static final class EnvironmentMgmtServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<EnvironmentMgmtServicesFutureStub> {
    private EnvironmentMgmtServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentMgmtServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentMgmtServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.SwitchOffResponse> switchOff(
        com.CA.gRPC.SwitchOffRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.ForecastResponse> forecast(
        com.CA.gRPC.ForecastRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getForecastMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_ON = 0;
  private static final int METHODID_SWITCH_OFF = 1;
  private static final int METHODID_FORECAST = 2;

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
        case METHODID_SWITCH_ON:
          serviceImpl.switchOn((com.CA.gRPC.SwitchOnRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.SwitchOnResponse>) responseObserver);
          break;
        case METHODID_SWITCH_OFF:
          serviceImpl.switchOff((com.CA.gRPC.SwitchOffRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.SwitchOffResponse>) responseObserver);
          break;
        case METHODID_FORECAST:
          serviceImpl.forecast((com.CA.gRPC.ForecastRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.ForecastResponse>) responseObserver);
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
          getSwitchOnMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.CA.gRPC.SwitchOnRequest,
              com.CA.gRPC.SwitchOnResponse>(
                service, METHODID_SWITCH_ON)))
        .addMethod(
          getSwitchOffMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.SwitchOffRequest,
              com.CA.gRPC.SwitchOffResponse>(
                service, METHODID_SWITCH_OFF)))
        .addMethod(
          getForecastMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.ForecastRequest,
              com.CA.gRPC.ForecastResponse>(
                service, METHODID_FORECAST)))
        .build();
  }

  private static abstract class EnvironmentMgmtServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnvironmentMgmtServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.EnvironmentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnvironmentMgmtServices");
    }
  }

  private static final class EnvironmentMgmtServicesFileDescriptorSupplier
      extends EnvironmentMgmtServicesBaseDescriptorSupplier {
    EnvironmentMgmtServicesFileDescriptorSupplier() {}
  }

  private static final class EnvironmentMgmtServicesMethodDescriptorSupplier
      extends EnvironmentMgmtServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EnvironmentMgmtServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EnvironmentMgmtServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnvironmentMgmtServicesFileDescriptorSupplier())
              .addMethod(getSwitchOnMethod())
              .addMethod(getSwitchOffMethod())
              .addMethod(getForecastMethod())
              .build();
        }
      }
    }
    return result;
  }
}
