///
//  Generated code. Do not modify.
//  source: texasHoldemService.proto
//
// @dart = 2.12
// ignore_for_file: annotate_overrides,camel_case_types,constant_identifier_names,directives_ordering,library_prefixes,non_constant_identifier_names,prefer_final_fields,return_of_invalid_type,unnecessary_const,unnecessary_import,unnecessary_this,unused_import,unused_shown_name

import 'dart:async' as $async;

import 'dart:core' as $core;

import 'package:grpc/service_api.dart' as $grpc;
import 'texasHoldemService.pb.dart' as $0;
export 'texasHoldemService.pb.dart';

class TexasHoldemServiceClient extends $grpc.Client {
  static final _$getHandValue =
      $grpc.ClientMethod<$0.GetHandValueRequest, $0.GetHandValueResponse>(
          '/TexasHoldemService/getHandValue',
          ($0.GetHandValueRequest value) => value.writeToBuffer(),
          ($core.List<$core.int> value) =>
              $0.GetHandValueResponse.fromBuffer(value));
  static final _$compareHands =
      $grpc.ClientMethod<$0.CompareHandsRequest, $0.CompareHandsResponse>(
          '/TexasHoldemService/compareHands',
          ($0.CompareHandsRequest value) => value.writeToBuffer(),
          ($core.List<$core.int> value) =>
              $0.CompareHandsResponse.fromBuffer(value));
  static final _$getProbabilityToWin = $grpc.ClientMethod<
          $0.GetProbabilityToWinRequest, $0.GetProbabilityToWinResponse>(
      '/TexasHoldemService/getProbabilityToWin',
      ($0.GetProbabilityToWinRequest value) => value.writeToBuffer(),
      ($core.List<$core.int> value) =>
          $0.GetProbabilityToWinResponse.fromBuffer(value));

  TexasHoldemServiceClient($grpc.ClientChannel channel,
      {$grpc.CallOptions? options,
      $core.Iterable<$grpc.ClientInterceptor>? interceptors})
      : super(channel, options: options, interceptors: interceptors);

  $grpc.ResponseFuture<$0.GetHandValueResponse> getHandValue(
      $0.GetHandValueRequest request,
      {$grpc.CallOptions? options}) {
    return $createUnaryCall(_$getHandValue, request, options: options);
  }

  $grpc.ResponseFuture<$0.CompareHandsResponse> compareHands(
      $0.CompareHandsRequest request,
      {$grpc.CallOptions? options}) {
    return $createUnaryCall(_$compareHands, request, options: options);
  }

  $grpc.ResponseFuture<$0.GetProbabilityToWinResponse> getProbabilityToWin(
      $0.GetProbabilityToWinRequest request,
      {$grpc.CallOptions? options}) {
    return $createUnaryCall(_$getProbabilityToWin, request, options: options);
  }
}

abstract class TexasHoldemServiceBase extends $grpc.Service {
  $core.String get $name => 'TexasHoldemService';

  TexasHoldemServiceBase() {
    $addMethod(
        $grpc.ServiceMethod<$0.GetHandValueRequest, $0.GetHandValueResponse>(
            'getHandValue',
            getHandValue_Pre,
            false,
            false,
            ($core.List<$core.int> value) =>
                $0.GetHandValueRequest.fromBuffer(value),
            ($0.GetHandValueResponse value) => value.writeToBuffer()));
    $addMethod(
        $grpc.ServiceMethod<$0.CompareHandsRequest, $0.CompareHandsResponse>(
            'compareHands',
            compareHands_Pre,
            false,
            false,
            ($core.List<$core.int> value) =>
                $0.CompareHandsRequest.fromBuffer(value),
            ($0.CompareHandsResponse value) => value.writeToBuffer()));
    $addMethod($grpc.ServiceMethod<$0.GetProbabilityToWinRequest,
            $0.GetProbabilityToWinResponse>(
        'getProbabilityToWin',
        getProbabilityToWin_Pre,
        false,
        false,
        ($core.List<$core.int> value) =>
            $0.GetProbabilityToWinRequest.fromBuffer(value),
        ($0.GetProbabilityToWinResponse value) => value.writeToBuffer()));
  }

  $async.Future<$0.GetHandValueResponse> getHandValue_Pre(
      $grpc.ServiceCall call,
      $async.Future<$0.GetHandValueRequest> request) async {
    return getHandValue(call, await request);
  }

  $async.Future<$0.CompareHandsResponse> compareHands_Pre(
      $grpc.ServiceCall call,
      $async.Future<$0.CompareHandsRequest> request) async {
    return compareHands(call, await request);
  }

  $async.Future<$0.GetProbabilityToWinResponse> getProbabilityToWin_Pre(
      $grpc.ServiceCall call,
      $async.Future<$0.GetProbabilityToWinRequest> request) async {
    return getProbabilityToWin(call, await request);
  }

  $async.Future<$0.GetHandValueResponse> getHandValue(
      $grpc.ServiceCall call, $0.GetHandValueRequest request);
  $async.Future<$0.CompareHandsResponse> compareHands(
      $grpc.ServiceCall call, $0.CompareHandsRequest request);
  $async.Future<$0.GetProbabilityToWinResponse> getProbabilityToWin(
      $grpc.ServiceCall call, $0.GetProbabilityToWinRequest request);
}
