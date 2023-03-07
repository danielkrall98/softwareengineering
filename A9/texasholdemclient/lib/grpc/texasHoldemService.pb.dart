///
//  Generated code. Do not modify.
//  source: texasHoldemService.proto
//
// @dart = 2.12
// ignore_for_file: annotate_overrides,camel_case_types,constant_identifier_names,directives_ordering,library_prefixes,non_constant_identifier_names,prefer_final_fields,return_of_invalid_type,unnecessary_const,unnecessary_import,unnecessary_this,unused_import,unused_shown_name

import 'dart:core' as $core;

import 'package:protobuf/protobuf.dart' as $pb;

class GetHandValueRequest extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo(const $core.bool.fromEnvironment('protobuf.omit_message_names') ? '' : 'GetHandValueRequest', createEmptyInstance: create)
    ..aOS(1, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'hand')
    ..hasRequiredFields = false
  ;

  GetHandValueRequest._() : super();
  factory GetHandValueRequest({
    $core.String? hand,
  }) {
    final _result = create();
    if (hand != null) {
      _result.hand = hand;
    }
    return _result;
  }
  factory GetHandValueRequest.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory GetHandValueRequest.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.deepCopy] instead. '
  'Will be removed in next major version')
  GetHandValueRequest clone() => GetHandValueRequest()..mergeFromMessage(this);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.rebuild] instead. '
  'Will be removed in next major version')
  GetHandValueRequest copyWith(void Function(GetHandValueRequest) updates) => super.copyWith((message) => updates(message as GetHandValueRequest)) as GetHandValueRequest; // ignore: deprecated_member_use
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static GetHandValueRequest create() => GetHandValueRequest._();
  GetHandValueRequest createEmptyInstance() => create();
  static $pb.PbList<GetHandValueRequest> createRepeated() => $pb.PbList<GetHandValueRequest>();
  @$core.pragma('dart2js:noInline')
  static GetHandValueRequest getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<GetHandValueRequest>(create);
  static GetHandValueRequest? _defaultInstance;

  @$pb.TagNumber(1)
  $core.String get hand => $_getSZ(0);
  @$pb.TagNumber(1)
  set hand($core.String v) { $_setString(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasHand() => $_has(0);
  @$pb.TagNumber(1)
  void clearHand() => clearField(1);
}

class GetHandValueResponse extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo(const $core.bool.fromEnvironment('protobuf.omit_message_names') ? '' : 'GetHandValueResponse', createEmptyInstance: create)
    ..aOS(1, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'handValue')
    ..hasRequiredFields = false
  ;

  GetHandValueResponse._() : super();
  factory GetHandValueResponse({
    $core.String? handValue,
  }) {
    final _result = create();
    if (handValue != null) {
      _result.handValue = handValue;
    }
    return _result;
  }
  factory GetHandValueResponse.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory GetHandValueResponse.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.deepCopy] instead. '
  'Will be removed in next major version')
  GetHandValueResponse clone() => GetHandValueResponse()..mergeFromMessage(this);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.rebuild] instead. '
  'Will be removed in next major version')
  GetHandValueResponse copyWith(void Function(GetHandValueResponse) updates) => super.copyWith((message) => updates(message as GetHandValueResponse)) as GetHandValueResponse; // ignore: deprecated_member_use
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static GetHandValueResponse create() => GetHandValueResponse._();
  GetHandValueResponse createEmptyInstance() => create();
  static $pb.PbList<GetHandValueResponse> createRepeated() => $pb.PbList<GetHandValueResponse>();
  @$core.pragma('dart2js:noInline')
  static GetHandValueResponse getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<GetHandValueResponse>(create);
  static GetHandValueResponse? _defaultInstance;

  @$pb.TagNumber(1)
  $core.String get handValue => $_getSZ(0);
  @$pb.TagNumber(1)
  set handValue($core.String v) { $_setString(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasHandValue() => $_has(0);
  @$pb.TagNumber(1)
  void clearHandValue() => clearField(1);
}

class CompareHandsRequest extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo(const $core.bool.fromEnvironment('protobuf.omit_message_names') ? '' : 'CompareHandsRequest', createEmptyInstance: create)
    ..aOS(1, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'hand1')
    ..aOS(2, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'hand2')
    ..hasRequiredFields = false
  ;

  CompareHandsRequest._() : super();
  factory CompareHandsRequest({
    $core.String? hand1,
    $core.String? hand2,
  }) {
    final _result = create();
    if (hand1 != null) {
      _result.hand1 = hand1;
    }
    if (hand2 != null) {
      _result.hand2 = hand2;
    }
    return _result;
  }
  factory CompareHandsRequest.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory CompareHandsRequest.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.deepCopy] instead. '
  'Will be removed in next major version')
  CompareHandsRequest clone() => CompareHandsRequest()..mergeFromMessage(this);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.rebuild] instead. '
  'Will be removed in next major version')
  CompareHandsRequest copyWith(void Function(CompareHandsRequest) updates) => super.copyWith((message) => updates(message as CompareHandsRequest)) as CompareHandsRequest; // ignore: deprecated_member_use
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static CompareHandsRequest create() => CompareHandsRequest._();
  CompareHandsRequest createEmptyInstance() => create();
  static $pb.PbList<CompareHandsRequest> createRepeated() => $pb.PbList<CompareHandsRequest>();
  @$core.pragma('dart2js:noInline')
  static CompareHandsRequest getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<CompareHandsRequest>(create);
  static CompareHandsRequest? _defaultInstance;

  @$pb.TagNumber(1)
  $core.String get hand1 => $_getSZ(0);
  @$pb.TagNumber(1)
  set hand1($core.String v) { $_setString(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasHand1() => $_has(0);
  @$pb.TagNumber(1)
  void clearHand1() => clearField(1);

  @$pb.TagNumber(2)
  $core.String get hand2 => $_getSZ(1);
  @$pb.TagNumber(2)
  set hand2($core.String v) { $_setString(1, v); }
  @$pb.TagNumber(2)
  $core.bool hasHand2() => $_has(1);
  @$pb.TagNumber(2)
  void clearHand2() => clearField(2);
}

class CompareHandsResponse extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo(const $core.bool.fromEnvironment('protobuf.omit_message_names') ? '' : 'CompareHandsResponse', createEmptyInstance: create)
    ..a<$core.int>(1, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'result', $pb.PbFieldType.O3)
    ..hasRequiredFields = false
  ;

  CompareHandsResponse._() : super();
  factory CompareHandsResponse({
    $core.int? result,
  }) {
    final _result = create();
    if (result != null) {
      _result.result = result;
    }
    return _result;
  }
  factory CompareHandsResponse.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory CompareHandsResponse.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.deepCopy] instead. '
  'Will be removed in next major version')
  CompareHandsResponse clone() => CompareHandsResponse()..mergeFromMessage(this);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.rebuild] instead. '
  'Will be removed in next major version')
  CompareHandsResponse copyWith(void Function(CompareHandsResponse) updates) => super.copyWith((message) => updates(message as CompareHandsResponse)) as CompareHandsResponse; // ignore: deprecated_member_use
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static CompareHandsResponse create() => CompareHandsResponse._();
  CompareHandsResponse createEmptyInstance() => create();
  static $pb.PbList<CompareHandsResponse> createRepeated() => $pb.PbList<CompareHandsResponse>();
  @$core.pragma('dart2js:noInline')
  static CompareHandsResponse getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<CompareHandsResponse>(create);
  static CompareHandsResponse? _defaultInstance;

  @$pb.TagNumber(1)
  $core.int get result => $_getIZ(0);
  @$pb.TagNumber(1)
  set result($core.int v) { $_setSignedInt32(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasResult() => $_has(0);
  @$pb.TagNumber(1)
  void clearResult() => clearField(1);
}

class GetProbabilityToWinRequest extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo(const $core.bool.fromEnvironment('protobuf.omit_message_names') ? '' : 'GetProbabilityToWinRequest', createEmptyInstance: create)
    ..aOS(1, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'talonCards')
    ..aOS(2, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'playerPocketCards')
    ..a<$core.int>(3, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'numberOfOpponents', $pb.PbFieldType.O3)
    ..a<$core.int>(4, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'numberOfSimulations', $pb.PbFieldType.O3)
    ..hasRequiredFields = false
  ;

  GetProbabilityToWinRequest._() : super();
  factory GetProbabilityToWinRequest({
    $core.String? talonCards,
    $core.String? playerPocketCards,
    $core.int? numberOfOpponents,
    $core.int? numberOfSimulations,
  }) {
    final _result = create();
    if (talonCards != null) {
      _result.talonCards = talonCards;
    }
    if (playerPocketCards != null) {
      _result.playerPocketCards = playerPocketCards;
    }
    if (numberOfOpponents != null) {
      _result.numberOfOpponents = numberOfOpponents;
    }
    if (numberOfSimulations != null) {
      _result.numberOfSimulations = numberOfSimulations;
    }
    return _result;
  }
  factory GetProbabilityToWinRequest.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory GetProbabilityToWinRequest.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.deepCopy] instead. '
  'Will be removed in next major version')
  GetProbabilityToWinRequest clone() => GetProbabilityToWinRequest()..mergeFromMessage(this);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.rebuild] instead. '
  'Will be removed in next major version')
  GetProbabilityToWinRequest copyWith(void Function(GetProbabilityToWinRequest) updates) => super.copyWith((message) => updates(message as GetProbabilityToWinRequest)) as GetProbabilityToWinRequest; // ignore: deprecated_member_use
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static GetProbabilityToWinRequest create() => GetProbabilityToWinRequest._();
  GetProbabilityToWinRequest createEmptyInstance() => create();
  static $pb.PbList<GetProbabilityToWinRequest> createRepeated() => $pb.PbList<GetProbabilityToWinRequest>();
  @$core.pragma('dart2js:noInline')
  static GetProbabilityToWinRequest getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<GetProbabilityToWinRequest>(create);
  static GetProbabilityToWinRequest? _defaultInstance;

  @$pb.TagNumber(1)
  $core.String get talonCards => $_getSZ(0);
  @$pb.TagNumber(1)
  set talonCards($core.String v) { $_setString(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasTalonCards() => $_has(0);
  @$pb.TagNumber(1)
  void clearTalonCards() => clearField(1);

  @$pb.TagNumber(2)
  $core.String get playerPocketCards => $_getSZ(1);
  @$pb.TagNumber(2)
  set playerPocketCards($core.String v) { $_setString(1, v); }
  @$pb.TagNumber(2)
  $core.bool hasPlayerPocketCards() => $_has(1);
  @$pb.TagNumber(2)
  void clearPlayerPocketCards() => clearField(2);

  @$pb.TagNumber(3)
  $core.int get numberOfOpponents => $_getIZ(2);
  @$pb.TagNumber(3)
  set numberOfOpponents($core.int v) { $_setSignedInt32(2, v); }
  @$pb.TagNumber(3)
  $core.bool hasNumberOfOpponents() => $_has(2);
  @$pb.TagNumber(3)
  void clearNumberOfOpponents() => clearField(3);

  @$pb.TagNumber(4)
  $core.int get numberOfSimulations => $_getIZ(3);
  @$pb.TagNumber(4)
  set numberOfSimulations($core.int v) { $_setSignedInt32(3, v); }
  @$pb.TagNumber(4)
  $core.bool hasNumberOfSimulations() => $_has(3);
  @$pb.TagNumber(4)
  void clearNumberOfSimulations() => clearField(4);
}

class GetProbabilityToWinResponse extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo(const $core.bool.fromEnvironment('protobuf.omit_message_names') ? '' : 'GetProbabilityToWinResponse', createEmptyInstance: create)
    ..a<$core.double>(1, const $core.bool.fromEnvironment('protobuf.omit_field_names') ? '' : 'probability', $pb.PbFieldType.OD)
    ..hasRequiredFields = false
  ;

  GetProbabilityToWinResponse._() : super();
  factory GetProbabilityToWinResponse({
    $core.double? probability,
  }) {
    final _result = create();
    if (probability != null) {
      _result.probability = probability;
    }
    return _result;
  }
  factory GetProbabilityToWinResponse.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory GetProbabilityToWinResponse.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.deepCopy] instead. '
  'Will be removed in next major version')
  GetProbabilityToWinResponse clone() => GetProbabilityToWinResponse()..mergeFromMessage(this);
  @$core.Deprecated(
  'Using this can add significant overhead to your binary. '
  'Use [GeneratedMessageGenericExtensions.rebuild] instead. '
  'Will be removed in next major version')
  GetProbabilityToWinResponse copyWith(void Function(GetProbabilityToWinResponse) updates) => super.copyWith((message) => updates(message as GetProbabilityToWinResponse)) as GetProbabilityToWinResponse; // ignore: deprecated_member_use
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static GetProbabilityToWinResponse create() => GetProbabilityToWinResponse._();
  GetProbabilityToWinResponse createEmptyInstance() => create();
  static $pb.PbList<GetProbabilityToWinResponse> createRepeated() => $pb.PbList<GetProbabilityToWinResponse>();
  @$core.pragma('dart2js:noInline')
  static GetProbabilityToWinResponse getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<GetProbabilityToWinResponse>(create);
  static GetProbabilityToWinResponse? _defaultInstance;

  @$pb.TagNumber(1)
  $core.double get probability => $_getN(0);
  @$pb.TagNumber(1)
  set probability($core.double v) { $_setDouble(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasProbability() => $_has(0);
  @$pb.TagNumber(1)
  void clearProbability() => clearField(1);
}

