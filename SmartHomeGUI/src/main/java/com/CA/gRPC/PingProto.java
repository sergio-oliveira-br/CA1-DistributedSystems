// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartHomePing.proto

package com.CA.gRPC;

public final class PingProto {
  private PingProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UnaryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UnaryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UnaryResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UnaryResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ClientInformation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ClientInformation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ServerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ServerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023SmartHomePing.proto\"\034\n\014UnaryRequest\022\014\n" +
      "\004name\030\001 \001(\t\" \n\rUnaryResponse\022\017\n\007message\030" +
      "\001 \001(\t\"9\n\021ClientInformation\022\022\n\nclientName" +
      "\030\001 \001(\t\022\020\n\010dateTime\030\002 \001(\t\"!\n\016ServerRespon" +
      "se\022\017\n\007message\030\001 \001(\t2\215\001\n\026StreamingClientS" +
      "ervice\0221\n\020sendUnaryRequest\022\r.UnaryReques" +
      "t\032\016.UnaryResponse\022@\n\027streamClientInforma" +
      "tion\022\022.ClientInformation\032\017.ServerRespons" +
      "e(\001B\032\n\013com.CA.gRPCB\tPingProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_UnaryRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_UnaryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UnaryRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_UnaryResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_UnaryResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UnaryResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_ClientInformation_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ClientInformation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ClientInformation_descriptor,
        new java.lang.String[] { "ClientName", "DateTime", });
    internal_static_ServerResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ServerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ServerResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}