// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HomeSecurity.proto

package com.CA.gRPC;

public final class SecurityProto {
  private SecurityProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OpenRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OpenRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OpenResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OpenResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CloseRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CloseRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CloseResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CloseResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022HomeSecurity.proto\"\035\n\013OpenRequest\022\016\n\006d" +
      "oorID\030\001 \001(\t\"\036\n\014OpenResponse\022\016\n\006status\030\001 " +
      "\001(\t\"\036\n\014CloseRequest\022\016\n\006doorID\030\001 \001(\t\"\037\n\rC" +
      "loseResponse\022\016\n\006status\030\001 \001(\t2l\n\021SmartDoo" +
      "rServices\022)\n\010OpenDoor\022\014.OpenRequest\032\r.Op" +
      "enResponse\"\000\022,\n\tCloseDoor\022\r.CloseRequest" +
      "\032\016.CloseResponse\"\000B\036\n\013com.CA.gRPCB\rSecur" +
      "ityProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_OpenRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_OpenRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OpenRequest_descriptor,
        new java.lang.String[] { "DoorID", });
    internal_static_OpenResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_OpenResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OpenResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_CloseRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CloseRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CloseRequest_descriptor,
        new java.lang.String[] { "DoorID", });
    internal_static_CloseResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_CloseResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CloseResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}