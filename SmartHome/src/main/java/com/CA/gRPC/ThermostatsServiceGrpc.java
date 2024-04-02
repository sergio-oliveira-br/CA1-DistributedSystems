package com.CA.gRPC;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: ThermostatsProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ThermostatsServiceGrpc {

  private ThermostatsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ThermostatsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.CA.gRPC.ThermostatsRequest,
      com.CA.gRPC.ThermostatsResponse> getControlThermostatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlThermostats",
      requestType = com.CA.gRPC.ThermostatsRequest.class,
      responseType = com.CA.gRPC.ThermostatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.CA.gRPC.ThermostatsRequest,
      com.CA.gRPC.ThermostatsResponse> getControlThermostatsMethod() {
    io.grpc.MethodDescriptor<com.CA.gRPC.ThermostatsRequest, com.CA.gRPC.ThermostatsResponse> getControlThermostatsMethod;
    if ((getControlThermostatsMethod = ThermostatsServiceGrpc.getControlThermostatsMethod) == null) {
      synchronized (ThermostatsServiceGrpc.class) {
        if ((getControlThermostatsMethod = ThermostatsServiceGrpc.getControlThermostatsMethod) == null) {
          ThermostatsServiceGrpc.getControlThermostatsMethod = getControlThermostatsMethod =
              io.grpc.MethodDescriptor.<com.CA.gRPC.ThermostatsRequest, com.CA.gRPC.ThermostatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlThermostats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.ThermostatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.CA.gRPC.ThermostatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ThermostatsServiceMethodDescriptorSupplier("ControlThermostats"))
              .build();
        }
      }
    }
    return getControlThermostatsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThermostatsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatsServiceStub>() {
        @java.lang.Override
        public ThermostatsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatsServiceStub(channel, callOptions);
        }
      };
    return ThermostatsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThermostatsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatsServiceBlockingStub>() {
        @java.lang.Override
        public ThermostatsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatsServiceBlockingStub(channel, callOptions);
        }
      };
    return ThermostatsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ThermostatsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ThermostatsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ThermostatsServiceFutureStub>() {
        @java.lang.Override
        public ThermostatsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ThermostatsServiceFutureStub(channel, callOptions);
        }
      };
    return ThermostatsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.CA.gRPC.ThermostatsRequest> controlThermostats(
        io.grpc.stub.StreamObserver<com.CA.gRPC.ThermostatsResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getControlThermostatsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ThermostatsService.
   */
  public static abstract class ThermostatsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ThermostatsServiceGrpc.bindService(this);
    }

    //StreamObserver: This is an interface that is used to receive responses from streaming service calls.
    public abstract StreamObserver<ThermostatsRequest> ControlThermostats(StreamObserver<ThermostatsResponse> responseStreamObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ThermostatsService.
   */
  public static final class ThermostatsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ThermostatsServiceStub> {
    private ThermostatsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.CA.gRPC.ThermostatsRequest> controlThermostats(
        io.grpc.stub.StreamObserver<com.CA.gRPC.ThermostatsResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getControlThermostatsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ThermostatsService.
   */
  public static final class ThermostatsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ThermostatsServiceBlockingStub> {
    private ThermostatsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ThermostatsService.
   */
  public static final class ThermostatsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ThermostatsServiceFutureStub> {
    private ThermostatsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ThermostatsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CONTROL_THERMOSTATS = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_THERMOSTATS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlThermostats(
              (io.grpc.stub.StreamObserver<com.CA.gRPC.ThermostatsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getControlThermostatsMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.CA.gRPC.ThermostatsRequest,
              com.CA.gRPC.ThermostatsResponse>(
                service, METHODID_CONTROL_THERMOSTATS)))
        .build();
  }

  private static abstract class ThermostatsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ThermostatsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.CA.gRPC.ThermoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ThermostatsService");
    }
  }

  private static final class ThermostatsServiceFileDescriptorSupplier
      extends ThermostatsServiceBaseDescriptorSupplier {
    ThermostatsServiceFileDescriptorSupplier() {}
  }

  private static final class ThermostatsServiceMethodDescriptorSupplier
      extends ThermostatsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ThermostatsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ThermostatsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThermostatsServiceFileDescriptorSupplier())
              .addMethod(getControlThermostatsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
