// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartHomeProto.proto

package com.CA.gRPC;

public final class SmartHomeProto {
  private SmartHomeProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LightRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LightRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LightResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LightResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024SmartHomeProto.proto\"\037\n\014LightRequest\022\017" +
      "\n\007lightOn\030\001 \001(\010\" \n\rLightResponse\022\017\n\007mess" +
      "age\030\001 \001(\t2;\n\tSmartHome\022.\n\rControlLights\022" +
      "\r.LightRequest\032\016.LightResponseB\037\n\013com.CA" +
      ".gRPCB\016SmartHomeProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_LightRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_LightRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LightRequest_descriptor,
        new java.lang.String[] { "LightOn", });
    internal_static_LightResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_LightResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LightResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
