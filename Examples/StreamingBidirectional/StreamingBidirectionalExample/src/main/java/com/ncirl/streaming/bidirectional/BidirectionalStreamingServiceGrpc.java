package com.ncirl.streaming.bidirectional;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: StreamingBidirectionalService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BidirectionalStreamingServiceGrpc {

  private BidirectionalStreamingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.ncirl.streaming.BidirectionalStreamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ncirl.streaming.bidirectional.BidirectionalRequest,
      com.ncirl.streaming.bidirectional.BidirectionalResponse> getBidirectionalStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bidirectionalStream",
      requestType = com.ncirl.streaming.bidirectional.BidirectionalRequest.class,
      responseType = com.ncirl.streaming.bidirectional.BidirectionalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.ncirl.streaming.bidirectional.BidirectionalRequest,
      com.ncirl.streaming.bidirectional.BidirectionalResponse> getBidirectionalStreamMethod() {
    io.grpc.MethodDescriptor<com.ncirl.streaming.bidirectional.BidirectionalRequest, com.ncirl.streaming.bidirectional.BidirectionalResponse> getBidirectionalStreamMethod;
    if ((getBidirectionalStreamMethod = BidirectionalStreamingServiceGrpc.getBidirectionalStreamMethod) == null) {
      synchronized (BidirectionalStreamingServiceGrpc.class) {
        if ((getBidirectionalStreamMethod = BidirectionalStreamingServiceGrpc.getBidirectionalStreamMethod) == null) {
          BidirectionalStreamingServiceGrpc.getBidirectionalStreamMethod = getBidirectionalStreamMethod =
              io.grpc.MethodDescriptor.<com.ncirl.streaming.bidirectional.BidirectionalRequest, com.ncirl.streaming.bidirectional.BidirectionalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "bidirectionalStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.streaming.bidirectional.BidirectionalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ncirl.streaming.bidirectional.BidirectionalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BidirectionalStreamingServiceMethodDescriptorSupplier("bidirectionalStream"))
              .build();
        }
      }
    }
    return getBidirectionalStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BidirectionalStreamingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionalStreamingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionalStreamingServiceStub>() {
        @java.lang.Override
        public BidirectionalStreamingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionalStreamingServiceStub(channel, callOptions);
        }
      };
    return BidirectionalStreamingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BidirectionalStreamingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionalStreamingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionalStreamingServiceBlockingStub>() {
        @java.lang.Override
        public BidirectionalStreamingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionalStreamingServiceBlockingStub(channel, callOptions);
        }
      };
    return BidirectionalStreamingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BidirectionalStreamingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionalStreamingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionalStreamingServiceFutureStub>() {
        @java.lang.Override
        public BidirectionalStreamingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionalStreamingServiceFutureStub(channel, callOptions);
        }
      };
    return BidirectionalStreamingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Bidirectional streaming RPC
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.ncirl.streaming.bidirectional.BidirectionalRequest> bidirectionalStream(
        io.grpc.stub.StreamObserver<com.ncirl.streaming.bidirectional.BidirectionalResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBidirectionalStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BidirectionalStreamingService.
   */
  public static abstract class BidirectionalStreamingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BidirectionalStreamingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BidirectionalStreamingService.
   */
  public static final class BidirectionalStreamingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BidirectionalStreamingServiceStub> {
    private BidirectionalStreamingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionalStreamingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionalStreamingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.ncirl.streaming.bidirectional.BidirectionalRequest> bidirectionalStream(
        io.grpc.stub.StreamObserver<com.ncirl.streaming.bidirectional.BidirectionalResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidirectionalStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BidirectionalStreamingService.
   */
  public static final class BidirectionalStreamingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BidirectionalStreamingServiceBlockingStub> {
    private BidirectionalStreamingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionalStreamingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionalStreamingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BidirectionalStreamingService.
   */
  public static final class BidirectionalStreamingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BidirectionalStreamingServiceFutureStub> {
    private BidirectionalStreamingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionalStreamingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionalStreamingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BIDIRECTIONAL_STREAM = 0;

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
        case METHODID_BIDIRECTIONAL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectionalStream(
              (io.grpc.stub.StreamObserver<com.ncirl.streaming.bidirectional.BidirectionalResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getBidirectionalStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.ncirl.streaming.bidirectional.BidirectionalRequest,
              com.ncirl.streaming.bidirectional.BidirectionalResponse>(
                service, METHODID_BIDIRECTIONAL_STREAM)))
        .build();
  }

  private static abstract class BidirectionalStreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BidirectionalStreamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ncirl.streaming.bidirectional.BidirectionalStreamingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BidirectionalStreamingService");
    }
  }

  private static final class BidirectionalStreamingServiceFileDescriptorSupplier
      extends BidirectionalStreamingServiceBaseDescriptorSupplier {
    BidirectionalStreamingServiceFileDescriptorSupplier() {}
  }

  private static final class BidirectionalStreamingServiceMethodDescriptorSupplier
      extends BidirectionalStreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BidirectionalStreamingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BidirectionalStreamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BidirectionalStreamingServiceFileDescriptorSupplier())
              .addMethod(getBidirectionalStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
