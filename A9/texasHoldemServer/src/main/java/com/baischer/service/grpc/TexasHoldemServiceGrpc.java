package com.baischer.service.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: texasHoldemService.proto")
public final class TexasHoldemServiceGrpc {

  private TexasHoldemServiceGrpc() {}

  public static final String SERVICE_NAME = "TexasHoldemService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.baischer.service.grpc.GetHandValueRequest,
      com.baischer.service.grpc.GetHandValueResponse> getGetHandValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getHandValue",
      requestType = com.baischer.service.grpc.GetHandValueRequest.class,
      responseType = com.baischer.service.grpc.GetHandValueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.baischer.service.grpc.GetHandValueRequest,
      com.baischer.service.grpc.GetHandValueResponse> getGetHandValueMethod() {
    io.grpc.MethodDescriptor<com.baischer.service.grpc.GetHandValueRequest, com.baischer.service.grpc.GetHandValueResponse> getGetHandValueMethod;
    if ((getGetHandValueMethod = TexasHoldemServiceGrpc.getGetHandValueMethod) == null) {
      synchronized (TexasHoldemServiceGrpc.class) {
        if ((getGetHandValueMethod = TexasHoldemServiceGrpc.getGetHandValueMethod) == null) {
          TexasHoldemServiceGrpc.getGetHandValueMethod = getGetHandValueMethod = 
              io.grpc.MethodDescriptor.<com.baischer.service.grpc.GetHandValueRequest, com.baischer.service.grpc.GetHandValueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TexasHoldemService", "getHandValue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.baischer.service.grpc.GetHandValueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.baischer.service.grpc.GetHandValueResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TexasHoldemServiceMethodDescriptorSupplier("getHandValue"))
                  .build();
          }
        }
     }
     return getGetHandValueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.baischer.service.grpc.CompareHandsRequest,
      com.baischer.service.grpc.CompareHandsResponse> getCompareHandsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "compareHands",
      requestType = com.baischer.service.grpc.CompareHandsRequest.class,
      responseType = com.baischer.service.grpc.CompareHandsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.baischer.service.grpc.CompareHandsRequest,
      com.baischer.service.grpc.CompareHandsResponse> getCompareHandsMethod() {
    io.grpc.MethodDescriptor<com.baischer.service.grpc.CompareHandsRequest, com.baischer.service.grpc.CompareHandsResponse> getCompareHandsMethod;
    if ((getCompareHandsMethod = TexasHoldemServiceGrpc.getCompareHandsMethod) == null) {
      synchronized (TexasHoldemServiceGrpc.class) {
        if ((getCompareHandsMethod = TexasHoldemServiceGrpc.getCompareHandsMethod) == null) {
          TexasHoldemServiceGrpc.getCompareHandsMethod = getCompareHandsMethod = 
              io.grpc.MethodDescriptor.<com.baischer.service.grpc.CompareHandsRequest, com.baischer.service.grpc.CompareHandsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TexasHoldemService", "compareHands"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.baischer.service.grpc.CompareHandsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.baischer.service.grpc.CompareHandsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TexasHoldemServiceMethodDescriptorSupplier("compareHands"))
                  .build();
          }
        }
     }
     return getCompareHandsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.baischer.service.grpc.GetProbabilityToWinRequest,
      com.baischer.service.grpc.GetProbabilityToWinResponse> getGetProbabilityToWinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProbabilityToWin",
      requestType = com.baischer.service.grpc.GetProbabilityToWinRequest.class,
      responseType = com.baischer.service.grpc.GetProbabilityToWinResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.baischer.service.grpc.GetProbabilityToWinRequest,
      com.baischer.service.grpc.GetProbabilityToWinResponse> getGetProbabilityToWinMethod() {
    io.grpc.MethodDescriptor<com.baischer.service.grpc.GetProbabilityToWinRequest, com.baischer.service.grpc.GetProbabilityToWinResponse> getGetProbabilityToWinMethod;
    if ((getGetProbabilityToWinMethod = TexasHoldemServiceGrpc.getGetProbabilityToWinMethod) == null) {
      synchronized (TexasHoldemServiceGrpc.class) {
        if ((getGetProbabilityToWinMethod = TexasHoldemServiceGrpc.getGetProbabilityToWinMethod) == null) {
          TexasHoldemServiceGrpc.getGetProbabilityToWinMethod = getGetProbabilityToWinMethod = 
              io.grpc.MethodDescriptor.<com.baischer.service.grpc.GetProbabilityToWinRequest, com.baischer.service.grpc.GetProbabilityToWinResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TexasHoldemService", "getProbabilityToWin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.baischer.service.grpc.GetProbabilityToWinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.baischer.service.grpc.GetProbabilityToWinResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TexasHoldemServiceMethodDescriptorSupplier("getProbabilityToWin"))
                  .build();
          }
        }
     }
     return getGetProbabilityToWinMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TexasHoldemServiceStub newStub(io.grpc.Channel channel) {
    return new TexasHoldemServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TexasHoldemServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TexasHoldemServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TexasHoldemServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TexasHoldemServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TexasHoldemServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getHandValue(com.baischer.service.grpc.GetHandValueRequest request,
        io.grpc.stub.StreamObserver<com.baischer.service.grpc.GetHandValueResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetHandValueMethod(), responseObserver);
    }

    /**
     */
    public void compareHands(com.baischer.service.grpc.CompareHandsRequest request,
        io.grpc.stub.StreamObserver<com.baischer.service.grpc.CompareHandsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCompareHandsMethod(), responseObserver);
    }

    /**
     */
    public void getProbabilityToWin(com.baischer.service.grpc.GetProbabilityToWinRequest request,
        io.grpc.stub.StreamObserver<com.baischer.service.grpc.GetProbabilityToWinResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProbabilityToWinMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetHandValueMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.baischer.service.grpc.GetHandValueRequest,
                com.baischer.service.grpc.GetHandValueResponse>(
                  this, METHODID_GET_HAND_VALUE)))
          .addMethod(
            getCompareHandsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.baischer.service.grpc.CompareHandsRequest,
                com.baischer.service.grpc.CompareHandsResponse>(
                  this, METHODID_COMPARE_HANDS)))
          .addMethod(
            getGetProbabilityToWinMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.baischer.service.grpc.GetProbabilityToWinRequest,
                com.baischer.service.grpc.GetProbabilityToWinResponse>(
                  this, METHODID_GET_PROBABILITY_TO_WIN)))
          .build();
    }
  }

  /**
   */
  public static final class TexasHoldemServiceStub extends io.grpc.stub.AbstractStub<TexasHoldemServiceStub> {
    private TexasHoldemServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TexasHoldemServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TexasHoldemServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TexasHoldemServiceStub(channel, callOptions);
    }

    /**
     */
    public void getHandValue(com.baischer.service.grpc.GetHandValueRequest request,
        io.grpc.stub.StreamObserver<com.baischer.service.grpc.GetHandValueResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetHandValueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void compareHands(com.baischer.service.grpc.CompareHandsRequest request,
        io.grpc.stub.StreamObserver<com.baischer.service.grpc.CompareHandsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCompareHandsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProbabilityToWin(com.baischer.service.grpc.GetProbabilityToWinRequest request,
        io.grpc.stub.StreamObserver<com.baischer.service.grpc.GetProbabilityToWinResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProbabilityToWinMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TexasHoldemServiceBlockingStub extends io.grpc.stub.AbstractStub<TexasHoldemServiceBlockingStub> {
    private TexasHoldemServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TexasHoldemServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TexasHoldemServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TexasHoldemServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.baischer.service.grpc.GetHandValueResponse getHandValue(com.baischer.service.grpc.GetHandValueRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetHandValueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.baischer.service.grpc.CompareHandsResponse compareHands(com.baischer.service.grpc.CompareHandsRequest request) {
      return blockingUnaryCall(
          getChannel(), getCompareHandsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.baischer.service.grpc.GetProbabilityToWinResponse getProbabilityToWin(com.baischer.service.grpc.GetProbabilityToWinRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProbabilityToWinMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TexasHoldemServiceFutureStub extends io.grpc.stub.AbstractStub<TexasHoldemServiceFutureStub> {
    private TexasHoldemServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TexasHoldemServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TexasHoldemServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TexasHoldemServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.baischer.service.grpc.GetHandValueResponse> getHandValue(
        com.baischer.service.grpc.GetHandValueRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetHandValueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.baischer.service.grpc.CompareHandsResponse> compareHands(
        com.baischer.service.grpc.CompareHandsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCompareHandsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.baischer.service.grpc.GetProbabilityToWinResponse> getProbabilityToWin(
        com.baischer.service.grpc.GetProbabilityToWinRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProbabilityToWinMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_HAND_VALUE = 0;
  private static final int METHODID_COMPARE_HANDS = 1;
  private static final int METHODID_GET_PROBABILITY_TO_WIN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TexasHoldemServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TexasHoldemServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_HAND_VALUE:
          serviceImpl.getHandValue((com.baischer.service.grpc.GetHandValueRequest) request,
              (io.grpc.stub.StreamObserver<com.baischer.service.grpc.GetHandValueResponse>) responseObserver);
          break;
        case METHODID_COMPARE_HANDS:
          serviceImpl.compareHands((com.baischer.service.grpc.CompareHandsRequest) request,
              (io.grpc.stub.StreamObserver<com.baischer.service.grpc.CompareHandsResponse>) responseObserver);
          break;
        case METHODID_GET_PROBABILITY_TO_WIN:
          serviceImpl.getProbabilityToWin((com.baischer.service.grpc.GetProbabilityToWinRequest) request,
              (io.grpc.stub.StreamObserver<com.baischer.service.grpc.GetProbabilityToWinResponse>) responseObserver);
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

  private static abstract class TexasHoldemServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TexasHoldemServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.baischer.service.grpc.TexasHoldemServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TexasHoldemService");
    }
  }

  private static final class TexasHoldemServiceFileDescriptorSupplier
      extends TexasHoldemServiceBaseDescriptorSupplier {
    TexasHoldemServiceFileDescriptorSupplier() {}
  }

  private static final class TexasHoldemServiceMethodDescriptorSupplier
      extends TexasHoldemServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TexasHoldemServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TexasHoldemServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TexasHoldemServiceFileDescriptorSupplier())
              .addMethod(getGetHandValueMethod())
              .addMethod(getCompareHandsMethod())
              .addMethod(getGetProbabilityToWinMethod())
              .build();
        }
      }
    }
    return result;
  }
}
