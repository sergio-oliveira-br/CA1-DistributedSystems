package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: HomeSecuity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SmartDoorServicesGrpc {

  private SmartDoorServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartDoorServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.OpenRequest,
      com.CA.gRPC.OpenResponse> getOpenDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenDoor",
      requestType = com.CA.gRPC.OpenRequest.class,
      responseType = com.CA.gRPC.OpenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.OpenRequest,
      com.CA.gRPC.OpenResponse> getOpenDoorMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.OpenRequest, com.CA.gRPC.OpenResponse> getOpenDoorMethod;
    if ((getOpenDoorMethod = SmartDoorServicesGrpc.getOpenDoorMethod) == null) {
      synchronized (SmartDoorServicesGrpc.class) {
        if ((getOpenDoorMethod = SmartDoorServicesGrpc.getOpenDoorMethod) == null) {
          SmartDoorServicesGrpc.getOpenDoorMethod = getOpenDoorMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.OpenRequest, com.CA.gRPC.OpenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.OpenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.OpenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartDoorServicesMethodDescriptorSupplier("OpenDoor"))
              .build();
        }
      }
    }
    return getOpenDoorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.CloseRequest,
      com.CA.gRPC.CloseResponse> getCloseDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseDoor",
      requestType = com.CA.gRPC.CloseRequest.class,
      responseType = com.CA.gRPC.CloseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.CloseRequest,
      com.CA.gRPC.CloseResponse> getCloseDoorMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.CloseRequest, com.CA.gRPC.CloseResponse> getCloseDoorMethod;
    if ((getCloseDoorMethod = SmartDoorServicesGrpc.getCloseDoorMethod) == null) {
      synchronized (SmartDoorServicesGrpc.class) {
        if ((getCloseDoorMethod = SmartDoorServicesGrpc.getCloseDoorMethod) == null) {
          SmartDoorServicesGrpc.getCloseDoorMethod = getCloseDoorMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.CloseRequest, com.CA.gRPC.CloseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.CloseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.CloseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartDoorServicesMethodDescriptorSupplier("CloseDoor"))
              .build();
        }
      }
    }
    return getCloseDoorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartDoorServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartDoorServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartDoorServicesStub>() {
        @java.lang.Override
        public SmartDoorServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartDoorServicesStub(channel, callOptions);
        }
      };
    return SmartDoorServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartDoorServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartDoorServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartDoorServicesBlockingStub>() {
        @java.lang.Override
        public SmartDoorServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartDoorServicesBlockingStub(channel, callOptions);
        }
      };
    return SmartDoorServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartDoorServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartDoorServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartDoorServicesFutureStub>() {
        @java.lang.Override
        public SmartDoorServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartDoorServicesFutureStub(channel, callOptions);
        }
      };
    return SmartDoorServicesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service definition
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void openDoor(com.CA.gRPC.OpenRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.OpenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenDoorMethod(), responseObserver);
    }

    /**
     */
    default void closeDoor(com.CA.gRPC.CloseRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.CloseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseDoorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SmartDoorServices.
   * <pre>
   *Service definition
   * </pre>
   */
  public static abstract class SmartDoorServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SmartDoorServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SmartDoorServices.
   * <pre>
   *Service definition
   * </pre>
   */
  public static final class SmartDoorServicesStub
      extends io.grpc.stub.AbstractAsyncStub<SmartDoorServicesStub> {
    private SmartDoorServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartDoorServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartDoorServicesStub(channel, callOptions);
    }

    /**
     */
    public void openDoor(com.CA.gRPC.OpenRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.OpenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeDoor(com.CA.gRPC.CloseRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.CloseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseDoorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SmartDoorServices.
   * <pre>
   *Service definition
   * </pre>
   */
  public static final class SmartDoorServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SmartDoorServicesBlockingStub> {
    private SmartDoorServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartDoorServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartDoorServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.CA.gRPC.OpenResponse openDoor(com.CA.gRPC.OpenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenDoorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.CA.gRPC.CloseResponse closeDoor(com.CA.gRPC.CloseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseDoorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SmartDoorServices.
   * <pre>
   *Service definition
   * </pre>
   */
  public static final class SmartDoorServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<SmartDoorServicesFutureStub> {
    private SmartDoorServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartDoorServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartDoorServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.OpenResponse> openDoor(
        com.CA.gRPC.OpenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.CloseResponse> closeDoor(
        com.CA.gRPC.CloseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseDoorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPEN_DOOR = 0;
  private static final int METHODID_CLOSE_DOOR = 1;

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
        case METHODID_OPEN_DOOR:
          serviceImpl.openDoor((com.CA.gRPC.OpenRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.OpenResponse>) responseObserver);
          break;
        case METHODID_CLOSE_DOOR:
          serviceImpl.closeDoor((com.CA.gRPC.CloseRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.CloseResponse>) responseObserver);
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
          getOpenDoorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.OpenRequest,
              com.CA.gRPC.OpenResponse>(
                service, METHODID_OPEN_DOOR)))
        .addMethod(
          getCloseDoorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.CloseRequest,
              com.CA.gRPC.CloseResponse>(
                service, METHODID_CLOSE_DOOR)))
        .build();
  }

  private static abstract class SmartDoorServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartDoorServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.SecurityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartDoorServices");
    }
  }

  private static final class SmartDoorServicesFileDescriptorSupplier
      extends SmartDoorServicesBaseDescriptorSupplier {
    SmartDoorServicesFileDescriptorSupplier() {}
  }

  private static final class SmartDoorServicesMethodDescriptorSupplier
      extends SmartDoorServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SmartDoorServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SmartDoorServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartDoorServicesFileDescriptorSupplier())
              .addMethod(getOpenDoorMethod())
              .addMethod(getCloseDoorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
