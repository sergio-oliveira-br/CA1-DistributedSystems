// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StreamingServerService.proto

package com.ncirl.streaming.streamingserverservice;

public final class StreamingServerServiceProto {
  private StreamingServerServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_streaming_UnaryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_streaming_UnaryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_streaming_UnaryResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_streaming_UnaryResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_streaming_StreamServerRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_streaming_StreamServerRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ncirl_streaming_StreamServerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_ncirl_streaming_StreamServerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034StreamingServerService.proto\022\023com.ncir" +
      "l.streaming\"\034\n\014UnaryRequest\022\014\n\004name\030\001 \001(" +
      "\t\" \n\rUnaryResponse\022\017\n\007message\030\001 \001(\t\")\n\023S" +
      "treamServerRequest\022\022\n\nserverName\030\001 \001(\t\"\'" +
      "\n\024StreamServerResponse\022\017\n\007message\030\001 \001(\t2" +
      "\341\001\n\026StreamingServerService\022Y\n\020sendUnaryR" +
      "equest\022!.com.ncirl.streaming.UnaryReques" +
      "t\032\".com.ncirl.streaming.UnaryResponse\022l\n" +
      "\023streamServerRequest\022(.com.ncirl.streami" +
      "ng.StreamServerRequest\032).com.ncirl.strea" +
      "ming.StreamServerResponse0\001BK\n*com.ncirl" +
      ".streaming.streamingserverserviceB\033Strea" +
      "mingServerServiceProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_ncirl_streaming_UnaryRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ncirl_streaming_UnaryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_streaming_UnaryRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_com_ncirl_streaming_UnaryResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ncirl_streaming_UnaryResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_streaming_UnaryResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_ncirl_streaming_StreamServerRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_ncirl_streaming_StreamServerRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_streaming_StreamServerRequest_descriptor,
        new java.lang.String[] { "ServerName", });
    internal_static_com_ncirl_streaming_StreamServerResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_ncirl_streaming_StreamServerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_ncirl_streaming_StreamServerResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
