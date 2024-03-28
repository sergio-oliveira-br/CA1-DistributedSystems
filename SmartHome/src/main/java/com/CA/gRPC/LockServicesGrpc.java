package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: SmartHomeLockersProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LockServicesGrpc {

  private LockServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "LockServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.LockRequest,
      com.CA.gRPC.LockResponse> getControlLocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlLocks",
      requestType = com.CA.gRPC.LockRequest.class,
      responseType = com.CA.gRPC.LockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.LockRequest,
      com.CA.gRPC.LockResponse> getControlLocksMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.LockRequest, com.CA.gRPC.LockResponse> getControlLocksMethod;
    if ((getControlLocksMethod = LockServicesGrpc.getControlLocksMethod) == null) {
      synchronized (LockServicesGrpc.class) {
        if ((getControlLocksMethod = LockServicesGrpc.getControlLocksMethod) == null) {
          LockServicesGrpc.getControlLocksMethod = getControlLocksMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.LockRequest, com.CA.gRPC.LockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlLocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.LockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.LockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LockServicesMethodDescriptorSupplier("ControlLocks"))
              .build();
        }
      }
    }
    return getControlLocksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LockServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LockServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LockServicesStub>() {
        @java.lang.Override
        public LockServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LockServicesStub(channel, callOptions);
        }
      };
    return LockServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LockServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LockServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LockServicesBlockingStub>() {
        @java.lang.Override
        public LockServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LockServicesBlockingStub(channel, callOptions);
        }
      };
    return LockServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LockServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LockServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LockServicesFutureStub>() {
        @java.lang.Override
        public LockServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LockServicesFutureStub(channel, callOptions);
        }
      };
    return LockServicesFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void controlLocks(com.CA.gRPC.LockRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.LockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlLocksMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LockServices.
   */
  public static abstract class LockServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return LockServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LockServices.
   */
  public static final class LockServicesStub
      extends io.grpc.stub.AbstractAsyncStub<LockServicesStub> {
    private LockServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LockServicesStub(channel, callOptions);
    }

    /**
     */
    public void controlLocks(com.CA.gRPC.LockRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.LockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlLocksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LockServices.
   */
  public static final class LockServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LockServicesBlockingStub> {
    private LockServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LockServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.CA.gRPC.LockResponse controlLocks(com.CA.gRPC.LockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlLocksMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LockServices.
   */
  public static final class LockServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<LockServicesFutureStub> {
    private LockServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LockServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.LockResponse> controlLocks(
        com.CA.gRPC.LockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlLocksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_LOCKS = 0;

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
        case METHODID_CONTROL_LOCKS:
          serviceImpl.controlLocks((com.CA.gRPC.LockRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.LockResponse>) responseObserver);
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
          getControlLocksMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.LockRequest,
              com.CA.gRPC.LockResponse>(
                service, METHODID_CONTROL_LOCKS)))
        .build();
  }

  private static abstract class LockServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LockServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.LockProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LockServices");
    }
  }

  private static final class LockServicesFileDescriptorSupplier
      extends LockServicesBaseDescriptorSupplier {
    LockServicesFileDescriptorSupplier() {}
  }

  private static final class LockServicesMethodDescriptorSupplier
      extends LockServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LockServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LockServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LockServicesFileDescriptorSupplier())
              .addMethod(getControlLocksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
