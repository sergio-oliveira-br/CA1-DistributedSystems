package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service definition - Server-side streaming RPC
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: OvenTemperature.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TemperatureRampGrpc {

  private TemperatureRampGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TemperatureRamp";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.SetPointTemp,
      com.CA.gRPC.TempRamp> getSendTempDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendTempData",
      requestType = com.CA.gRPC.SetPointTemp.class,
      responseType = com.CA.gRPC.TempRamp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.SetPointTemp,
      com.CA.gRPC.TempRamp> getSendTempDataMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.SetPointTemp, com.CA.gRPC.TempRamp> getSendTempDataMethod;
    if ((getSendTempDataMethod = TemperatureRampGrpc.getSendTempDataMethod) == null) {
      synchronized (TemperatureRampGrpc.class) {
        if ((getSendTempDataMethod = TemperatureRampGrpc.getSendTempDataMethod) == null) {
          TemperatureRampGrpc.getSendTempDataMethod = getSendTempDataMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.SetPointTemp, com.CA.gRPC.TempRamp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendTempData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.SetPointTemp.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TempRamp.getDefaultInstance()))
              .setSchemaDescriptor(new TemperatureRampMethodDescriptorSupplier("SendTempData"))
              .build();
        }
      }
    }
    return getSendTempDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureRampStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureRampStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureRampStub>() {
        @java.lang.Override
        public TemperatureRampStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureRampStub(channel, callOptions);
        }
      };
    return TemperatureRampStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureRampBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureRampBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureRampBlockingStub>() {
        @java.lang.Override
        public TemperatureRampBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureRampBlockingStub(channel, callOptions);
        }
      };
    return TemperatureRampBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureRampFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TemperatureRampFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TemperatureRampFutureStub>() {
        @java.lang.Override
        public TemperatureRampFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TemperatureRampFutureStub(channel, callOptions);
        }
      };
    return TemperatureRampFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service definition - Server-side streaming RPC
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     *Streaming the Temp Ramp
     * </pre>
     */
    default void sendTempData(com.CA.gRPC.SetPointTemp request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TempRamp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendTempDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TemperatureRamp.
   * <pre>
   *Service definition - Server-side streaming RPC
   * </pre>
   */
  public static abstract class TemperatureRampImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TemperatureRampGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TemperatureRamp.
   * <pre>
   *Service definition - Server-side streaming RPC
   * </pre>
   */
  public static final class TemperatureRampStub
      extends io.grpc.stub.AbstractAsyncStub<TemperatureRampStub> {
    private TemperatureRampStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureRampStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureRampStub(channel, callOptions);
    }

    /**
     * <pre>
     *Streaming the Temp Ramp
     * </pre>
     */
    public void sendTempData(com.CA.gRPC.SetPointTemp request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TempRamp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSendTempDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TemperatureRamp.
   * <pre>
   *Service definition - Server-side streaming RPC
   * </pre>
   */
  public static final class TemperatureRampBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TemperatureRampBlockingStub> {
    private TemperatureRampBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureRampBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureRampBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Streaming the Temp Ramp
     * </pre>
     */
    public java.util.Iterator<com.CA.gRPC.TempRamp> sendTempData(
        com.CA.gRPC.SetPointTemp request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSendTempDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TemperatureRamp.
   * <pre>
   *Service definition - Server-side streaming RPC
   * </pre>
   */
  public static final class TemperatureRampFutureStub
      extends io.grpc.stub.AbstractFutureStub<TemperatureRampFutureStub> {
    private TemperatureRampFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureRampFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TemperatureRampFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_TEMP_DATA = 0;

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
        case METHODID_SEND_TEMP_DATA:
          serviceImpl.sendTempData((com.CA.gRPC.SetPointTemp) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.TempRamp>) responseObserver);
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
          getSendTempDataMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.CA.gRPC.SetPointTemp,
              com.CA.gRPC.TempRamp>(
                service, METHODID_SEND_TEMP_DATA)))
        .build();
  }

  private static abstract class TemperatureRampBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureRampBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.OvenTempRampProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemperatureRamp");
    }
  }

  private static final class TemperatureRampFileDescriptorSupplier
      extends TemperatureRampBaseDescriptorSupplier {
    TemperatureRampFileDescriptorSupplier() {}
  }

  private static final class TemperatureRampMethodDescriptorSupplier
      extends TemperatureRampBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TemperatureRampMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TemperatureRampGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureRampFileDescriptorSupplier())
              .addMethod(getSendTempDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
