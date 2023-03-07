///
//  Generated code. Do not modify.
//  source: texasHoldemService.proto
//
// @dart = 2.12
// ignore_for_file: annotate_overrides,camel_case_types,constant_identifier_names,deprecated_member_use_from_same_package,directives_ordering,library_prefixes,non_constant_identifier_names,prefer_final_fields,return_of_invalid_type,unnecessary_const,unnecessary_import,unnecessary_this,unused_import,unused_shown_name

import 'dart:core' as $core;
import 'dart:convert' as $convert;
import 'dart:typed_data' as $typed_data;
@$core.Deprecated('Use getHandValueRequestDescriptor instead')
const GetHandValueRequest$json = const {
  '1': 'GetHandValueRequest',
  '2': const [
    const {'1': 'hand', '3': 1, '4': 1, '5': 9, '10': 'hand'},
  ],
};

/// Descriptor for `GetHandValueRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getHandValueRequestDescriptor = $convert.base64Decode('ChNHZXRIYW5kVmFsdWVSZXF1ZXN0EhIKBGhhbmQYASABKAlSBGhhbmQ=');
@$core.Deprecated('Use getHandValueResponseDescriptor instead')
const GetHandValueResponse$json = const {
  '1': 'GetHandValueResponse',
  '2': const [
    const {'1': 'hand_value', '3': 1, '4': 1, '5': 9, '10': 'handValue'},
  ],
};

/// Descriptor for `GetHandValueResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getHandValueResponseDescriptor = $convert.base64Decode('ChRHZXRIYW5kVmFsdWVSZXNwb25zZRIdCgpoYW5kX3ZhbHVlGAEgASgJUgloYW5kVmFsdWU=');
@$core.Deprecated('Use compareHandsRequestDescriptor instead')
const CompareHandsRequest$json = const {
  '1': 'CompareHandsRequest',
  '2': const [
    const {'1': 'hand1', '3': 1, '4': 1, '5': 9, '10': 'hand1'},
    const {'1': 'hand2', '3': 2, '4': 1, '5': 9, '10': 'hand2'},
  ],
};

/// Descriptor for `CompareHandsRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List compareHandsRequestDescriptor = $convert.base64Decode('ChNDb21wYXJlSGFuZHNSZXF1ZXN0EhQKBWhhbmQxGAEgASgJUgVoYW5kMRIUCgVoYW5kMhgCIAEoCVIFaGFuZDI=');
@$core.Deprecated('Use compareHandsResponseDescriptor instead')
const CompareHandsResponse$json = const {
  '1': 'CompareHandsResponse',
  '2': const [
    const {'1': 'result', '3': 1, '4': 1, '5': 5, '10': 'result'},
  ],
};

/// Descriptor for `CompareHandsResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List compareHandsResponseDescriptor = $convert.base64Decode('ChRDb21wYXJlSGFuZHNSZXNwb25zZRIWCgZyZXN1bHQYASABKAVSBnJlc3VsdA==');
@$core.Deprecated('Use getProbabilityToWinRequestDescriptor instead')
const GetProbabilityToWinRequest$json = const {
  '1': 'GetProbabilityToWinRequest',
  '2': const [
    const {'1': 'talon_cards', '3': 1, '4': 1, '5': 9, '10': 'talonCards'},
    const {'1': 'player_pocket_cards', '3': 2, '4': 1, '5': 9, '10': 'playerPocketCards'},
    const {'1': 'number_of_opponents', '3': 3, '4': 1, '5': 5, '10': 'numberOfOpponents'},
    const {'1': 'number_of_simulations', '3': 4, '4': 1, '5': 5, '10': 'numberOfSimulations'},
  ],
};

/// Descriptor for `GetProbabilityToWinRequest`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getProbabilityToWinRequestDescriptor = $convert.base64Decode('ChpHZXRQcm9iYWJpbGl0eVRvV2luUmVxdWVzdBIfCgt0YWxvbl9jYXJkcxgBIAEoCVIKdGFsb25DYXJkcxIuChNwbGF5ZXJfcG9ja2V0X2NhcmRzGAIgASgJUhFwbGF5ZXJQb2NrZXRDYXJkcxIuChNudW1iZXJfb2Zfb3Bwb25lbnRzGAMgASgFUhFudW1iZXJPZk9wcG9uZW50cxIyChVudW1iZXJfb2Zfc2ltdWxhdGlvbnMYBCABKAVSE251bWJlck9mU2ltdWxhdGlvbnM=');
@$core.Deprecated('Use getProbabilityToWinResponseDescriptor instead')
const GetProbabilityToWinResponse$json = const {
  '1': 'GetProbabilityToWinResponse',
  '2': const [
    const {'1': 'probability', '3': 1, '4': 1, '5': 1, '10': 'probability'},
  ],
};

/// Descriptor for `GetProbabilityToWinResponse`. Decode as a `google.protobuf.DescriptorProto`.
final $typed_data.Uint8List getProbabilityToWinResponseDescriptor = $convert.base64Decode('ChtHZXRQcm9iYWJpbGl0eVRvV2luUmVzcG9uc2USIAoLcHJvYmFiaWxpdHkYASABKAFSC3Byb2JhYmlsaXR5');
