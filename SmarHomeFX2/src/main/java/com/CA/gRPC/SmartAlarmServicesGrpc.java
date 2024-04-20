package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service definition (Server-Side Streaming RPC) - This allow the user request to turn on/off the alarm,
 *and get response from server that alarm is on by streaming information (like a pulse)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: HomeSecuity.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SmartAlarmServicesGrpc {

  private SmartAlarmServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SmartAlarmServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.TurnOnAlarmRequest,
      com.CA.gRPC.TurnOnAlarmResponse> getTurnOnAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TurnOnAlarm",
      requestType = com.CA.gRPC.TurnOnAlarmRequest.class,
      responseType = com.CA.gRPC.TurnOnAlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.TurnOnAlarmRequest,
      com.CA.gRPC.TurnOnAlarmResponse> getTurnOnAlarmMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.TurnOnAlarmRequest, com.CA.gRPC.TurnOnAlarmResponse> getTurnOnAlarmMethod;
    if ((getTurnOnAlarmMethod = SmartAlarmServicesGrpc.getTurnOnAlarmMethod) == null) {
      synchronized (SmartAlarmServicesGrpc.class) {
        if ((getTurnOnAlarmMethod = SmartAlarmServicesGrpc.getTurnOnAlarmMethod) == null) {
          SmartAlarmServicesGrpc.getTurnOnAlarmMethod = getTurnOnAlarmMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.TurnOnAlarmRequest, com.CA.gRPC.TurnOnAlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TurnOnAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TurnOnAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TurnOnAlarmResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartAlarmServicesMethodDescriptorSupplier("TurnOnAlarm"))
              .build();
        }
      }
    }
    return getTurnOnAlarmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.TurnOffAlarmRequest,
      com.CA.gRPC.TurnOffAlarmResponse> getTurnOffAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TurnOffAlarm",
      requestType = com.CA.gRPC.TurnOffAlarmRequest.class,
      responseType = com.CA.gRPC.TurnOffAlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.TurnOffAlarmRequest,
      com.CA.gRPC.TurnOffAlarmResponse> getTurnOffAlarmMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.TurnOffAlarmRequest, com.CA.gRPC.TurnOffAlarmResponse> getTurnOffAlarmMethod;
    if ((getTurnOffAlarmMethod = SmartAlarmServicesGrpc.getTurnOffAlarmMethod) == null) {
      synchronized (SmartAlarmServicesGrpc.class) {
        if ((getTurnOffAlarmMethod = SmartAlarmServicesGrpc.getTurnOffAlarmMethod) == null) {
          SmartAlarmServicesGrpc.getTurnOffAlarmMethod = getTurnOffAlarmMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.TurnOffAlarmRequest, com.CA.gRPC.TurnOffAlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TurnOffAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TurnOffAlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.TurnOffAlarmResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartAlarmServicesMethodDescriptorSupplier("TurnOffAlarm"))
              .build();
        }
      }
    }
    return getTurnOffAlarmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartAlarmServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartAlarmServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartAlarmServicesStub>() {
        @java.lang.Override
        public SmartAlarmServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartAlarmServicesStub(channel, callOptions);
        }
      };
    return SmartAlarmServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartAlarmServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartAlarmServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartAlarmServicesBlockingStub>() {
        @java.lang.Override
        public SmartAlarmServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartAlarmServicesBlockingStub(channel, callOptions);
        }
      };
    return SmartAlarmServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartAlarmServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartAlarmServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartAlarmServicesFutureStub>() {
        @java.lang.Override
        public SmartAlarmServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartAlarmServicesFutureStub(channel, callOptions);
        }
      };
    return SmartAlarmServicesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service definition (Server-Side Streaming RPC) - This allow the user request to turn on/off the alarm,
   *and get response from server that alarm is on by streaming information (like a pulse)
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void turnOnAlarm(com.CA.gRPC.TurnOnAlarmRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TurnOnAlarmResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTurnOnAlarmMethod(), responseObserver);
    }

    /**
     */
    default void turnOffAlarm(com.CA.gRPC.TurnOffAlarmRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TurnOffAlarmResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTurnOffAlarmMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SmartAlarmServices.
   * <pre>
   *Service definition (Server-Side Streaming RPC) - This allow the user request to turn on/off the alarm,
   *and get response from server that alarm is on by streaming information (like a pulse)
   * </pre>
   */
  public static abstract class SmartAlarmServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SmartAlarmServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SmartAlarmServices.
   * <pre>
   *Service definition (Server-Side Streaming RPC) - This allow the user request to turn on/off the alarm,
   *and get response from server that alarm is on by streaming information (like a pulse)
   * </pre>
   */
  public static final class SmartAlarmServicesStub
      extends io.grpc.stub.AbstractAsyncStub<SmartAlarmServicesStub> {
    private SmartAlarmServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartAlarmServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartAlarmServicesStub(channel, callOptions);
    }

    /**
     */
    public void turnOnAlarm(com.CA.gRPC.TurnOnAlarmRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TurnOnAlarmResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getTurnOnAlarmMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void turnOffAlarm(com.CA.gRPC.TurnOffAlarmRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.TurnOffAlarmResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTurnOffAlarmMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SmartAlarmServices.
   * <pre>
   *Service definition (Server-Side Streaming RPC) - This allow the user request to turn on/off the alarm,
   *and get response from server that alarm is on by streaming information (like a pulse)
   * </pre>
   */
  public static final class SmartAlarmServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SmartAlarmServicesBlockingStub> {
    private SmartAlarmServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartAlarmServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartAlarmServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.CA.gRPC.TurnOnAlarmResponse> turnOnAlarm(
        com.CA.gRPC.TurnOnAlarmRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getTurnOnAlarmMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.CA.gRPC.TurnOffAlarmResponse turnOffAlarm(com.CA.gRPC.TurnOffAlarmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTurnOffAlarmMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SmartAlarmServices.
   * <pre>
   *Service definition (Server-Side Streaming RPC) - This allow the user request to turn on/off the alarm,
   *and get response from server that alarm is on by streaming information (like a pulse)
   * </pre>
   */
  public static final class SmartAlarmServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<SmartAlarmServicesFutureStub> {
    private SmartAlarmServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartAlarmServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartAlarmServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.TurnOffAlarmResponse> turnOffAlarm(
        com.CA.gRPC.TurnOffAlarmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTurnOffAlarmMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURN_ON_ALARM = 0;
  private static final int METHODID_TURN_OFF_ALARM = 1;

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
        case METHODID_TURN_ON_ALARM:
          serviceImpl.turnOnAlarm((com.CA.gRPC.TurnOnAlarmRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.TurnOnAlarmResponse>) responseObserver);
          break;
        case METHODID_TURN_OFF_ALARM:
          serviceImpl.turnOffAlarm((com.CA.gRPC.TurnOffAlarmRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.TurnOffAlarmResponse>) responseObserver);
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
          getTurnOnAlarmMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.CA.gRPC.TurnOnAlarmRequest,
              com.CA.gRPC.TurnOnAlarmResponse>(
                service, METHODID_TURN_ON_ALARM)))
        .addMethod(
          getTurnOffAlarmMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.TurnOffAlarmRequest,
              com.CA.gRPC.TurnOffAlarmResponse>(
                service, METHODID_TURN_OFF_ALARM)))
        .build();
  }

  private static abstract class SmartAlarmServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartAlarmServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.SecurityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartAlarmServices");
    }
  }

  private static final class SmartAlarmServicesFileDescriptorSupplier
      extends SmartAlarmServicesBaseDescriptorSupplier {
    SmartAlarmServicesFileDescriptorSupplier() {}
  }

  private static final class SmartAlarmServicesMethodDescriptorSupplier
      extends SmartAlarmServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SmartAlarmServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SmartAlarmServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartAlarmServicesFileDescriptorSupplier())
              .addMethod(getTurnOnAlarmMethod())
              .addMethod(getTurnOffAlarmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
