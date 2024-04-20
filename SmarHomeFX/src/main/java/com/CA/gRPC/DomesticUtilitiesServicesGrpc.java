package com.CA.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 *Service definition (Server-Side Streaming) - This service allows the user gets information about what energy consume
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: DomesticUtility.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DomesticUtilitiesServicesGrpc {

  private DomesticUtilitiesServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "DomesticUtilitiesServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.EnergyMonitorRequest,
      com.CA.gRPC.EnergyMonitorResponse> getEnergyMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "energyMonitor",
      requestType = com.CA.gRPC.EnergyMonitorRequest.class,
      responseType = com.CA.gRPC.EnergyMonitorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.EnergyMonitorRequest,
      com.CA.gRPC.EnergyMonitorResponse> getEnergyMonitorMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.EnergyMonitorRequest, com.CA.gRPC.EnergyMonitorResponse> getEnergyMonitorMethod;
    if ((getEnergyMonitorMethod = DomesticUtilitiesServicesGrpc.getEnergyMonitorMethod) == null) {
      synchronized (DomesticUtilitiesServicesGrpc.class) {
        if ((getEnergyMonitorMethod = DomesticUtilitiesServicesGrpc.getEnergyMonitorMethod) == null) {
          DomesticUtilitiesServicesGrpc.getEnergyMonitorMethod = getEnergyMonitorMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.EnergyMonitorRequest, com.CA.gRPC.EnergyMonitorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "energyMonitor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.EnergyMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.EnergyMonitorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DomesticUtilitiesServicesMethodDescriptorSupplier("energyMonitor"))
              .build();
        }
      }
    }
    return getEnergyMonitorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.DisableEnergyMonitorRequest,
      com.CA.gRPC.DisableEnergyMonitorResponse> getDisableEnergyMonitorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "disableEnergyMonitor",
      requestType = com.CA.gRPC.DisableEnergyMonitorRequest.class,
      responseType = com.CA.gRPC.DisableEnergyMonitorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.DisableEnergyMonitorRequest,
      com.CA.gRPC.DisableEnergyMonitorResponse> getDisableEnergyMonitorMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.DisableEnergyMonitorRequest, com.CA.gRPC.DisableEnergyMonitorResponse> getDisableEnergyMonitorMethod;
    if ((getDisableEnergyMonitorMethod = DomesticUtilitiesServicesGrpc.getDisableEnergyMonitorMethod) == null) {
      synchronized (DomesticUtilitiesServicesGrpc.class) {
        if ((getDisableEnergyMonitorMethod = DomesticUtilitiesServicesGrpc.getDisableEnergyMonitorMethod) == null) {
          DomesticUtilitiesServicesGrpc.getDisableEnergyMonitorMethod = getDisableEnergyMonitorMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.DisableEnergyMonitorRequest, com.CA.gRPC.DisableEnergyMonitorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "disableEnergyMonitor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.DisableEnergyMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.DisableEnergyMonitorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DomesticUtilitiesServicesMethodDescriptorSupplier("disableEnergyMonitor"))
              .build();
        }
      }
    }
    return getDisableEnergyMonitorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DomesticUtilitiesServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DomesticUtilitiesServicesStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DomesticUtilitiesServicesStub>() {
        @java.lang.Override
        public DomesticUtilitiesServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DomesticUtilitiesServicesStub(channel, callOptions);
        }
      };
    return DomesticUtilitiesServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DomesticUtilitiesServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DomesticUtilitiesServicesBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DomesticUtilitiesServicesBlockingStub>() {
        @java.lang.Override
        public DomesticUtilitiesServicesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DomesticUtilitiesServicesBlockingStub(channel, callOptions);
        }
      };
    return DomesticUtilitiesServicesBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DomesticUtilitiesServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DomesticUtilitiesServicesFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DomesticUtilitiesServicesFutureStub>() {
        @java.lang.Override
        public DomesticUtilitiesServicesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DomesticUtilitiesServicesFutureStub(channel, callOptions);
        }
      };
    return DomesticUtilitiesServicesFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *Service definition (Server-Side Streaming) - This service allows the user gets information about what energy consume
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void energyMonitor(com.CA.gRPC.EnergyMonitorRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.EnergyMonitorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnergyMonitorMethod(), responseObserver);
    }

    /**
     */
    default void disableEnergyMonitor(com.CA.gRPC.DisableEnergyMonitorRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.DisableEnergyMonitorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableEnergyMonitorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DomesticUtilitiesServices.
   * <pre>
   *Service definition (Server-Side Streaming) - This service allows the user gets information about what energy consume
   * </pre>
   */
  public static abstract class DomesticUtilitiesServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DomesticUtilitiesServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DomesticUtilitiesServices.
   * <pre>
   *Service definition (Server-Side Streaming) - This service allows the user gets information about what energy consume
   * </pre>
   */
  public static final class DomesticUtilitiesServicesStub
      extends io.grpc.stub.AbstractAsyncStub<DomesticUtilitiesServicesStub> {
    private DomesticUtilitiesServicesStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DomesticUtilitiesServicesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DomesticUtilitiesServicesStub(channel, callOptions);
    }

    /**
     */
    public void energyMonitor(com.CA.gRPC.EnergyMonitorRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.EnergyMonitorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getEnergyMonitorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disableEnergyMonitor(com.CA.gRPC.DisableEnergyMonitorRequest request,
        io.grpc.stub.StreamObserver<com.CA.gRPC.DisableEnergyMonitorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableEnergyMonitorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DomesticUtilitiesServices.
   * <pre>
   *Service definition (Server-Side Streaming) - This service allows the user gets information about what energy consume
   * </pre>
   */
  public static final class DomesticUtilitiesServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DomesticUtilitiesServicesBlockingStub> {
    private DomesticUtilitiesServicesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DomesticUtilitiesServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DomesticUtilitiesServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.CA.gRPC.EnergyMonitorResponse> energyMonitor(
        com.CA.gRPC.EnergyMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getEnergyMonitorMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.CA.gRPC.DisableEnergyMonitorResponse disableEnergyMonitor(com.CA.gRPC.DisableEnergyMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableEnergyMonitorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DomesticUtilitiesServices.
   * <pre>
   *Service definition (Server-Side Streaming) - This service allows the user gets information about what energy consume
   * </pre>
   */
  public static final class DomesticUtilitiesServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<DomesticUtilitiesServicesFutureStub> {
    private DomesticUtilitiesServicesFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DomesticUtilitiesServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DomesticUtilitiesServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.CA.gRPC.DisableEnergyMonitorResponse> disableEnergyMonitor(
        com.CA.gRPC.DisableEnergyMonitorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableEnergyMonitorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENERGY_MONITOR = 0;
  private static final int METHODID_DISABLE_ENERGY_MONITOR = 1;

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
        case METHODID_ENERGY_MONITOR:
          serviceImpl.energyMonitor((com.CA.gRPC.EnergyMonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.EnergyMonitorResponse>) responseObserver);
          break;
        case METHODID_DISABLE_ENERGY_MONITOR:
          serviceImpl.disableEnergyMonitor((com.CA.gRPC.DisableEnergyMonitorRequest) request,
              (io.grpc.stub.StreamObserver<com.CA.gRPC.DisableEnergyMonitorResponse>) responseObserver);
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
          getEnergyMonitorMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.CA.gRPC.EnergyMonitorRequest,
              com.CA.gRPC.EnergyMonitorResponse>(
                service, METHODID_ENERGY_MONITOR)))
        .addMethod(
          getDisableEnergyMonitorMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.CA.gRPC.DisableEnergyMonitorRequest,
              com.CA.gRPC.DisableEnergyMonitorResponse>(
                service, METHODID_DISABLE_ENERGY_MONITOR)))
        .build();
  }

  private static abstract class DomesticUtilitiesServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DomesticUtilitiesServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.UtilitiesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DomesticUtilitiesServices");
    }
  }

  private static final class DomesticUtilitiesServicesFileDescriptorSupplier
      extends DomesticUtilitiesServicesBaseDescriptorSupplier {
    DomesticUtilitiesServicesFileDescriptorSupplier() {}
  }

  private static final class DomesticUtilitiesServicesMethodDescriptorSupplier
      extends DomesticUtilitiesServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DomesticUtilitiesServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DomesticUtilitiesServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DomesticUtilitiesServicesFileDescriptorSupplier())
              .addMethod(getEnergyMonitorMethod())
              .addMethod(getDisableEnergyMonitorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
