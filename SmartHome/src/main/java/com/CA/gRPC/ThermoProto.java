// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ThermostatsProto.proto

package com.CA.gRPC;

public final class ThermoProto {
  private ThermoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ThermostatsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ThermostatsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ThermostatsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ThermostatsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026ThermostatsProto.proto\")\n\022ThermostatsR" +
      "equest\022\023\n\013requestTemp\030\001 \001(\005\"+\n\023Thermosta" +
      "tsResponse\022\024\n\014responseTemp\030\001 \001(\0052Y\n\022Ther" +
      "mostatsService\022C\n\022ControlThermostats\022\023.T" +
      "hermostatsRequest\032\024.ThermostatsResponse(" +
      "\0010\001B\034\n\013com.CA.gRPCB\013ThermoProtoP\001b\006proto" +
      "3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ThermostatsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ThermostatsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ThermostatsRequest_descriptor,
        new java.lang.String[] { "RequestTemp", });
    internal_static_ThermostatsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ThermostatsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ThermostatsResponse_descriptor,
        new java.lang.String[] { "ResponseTemp", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
