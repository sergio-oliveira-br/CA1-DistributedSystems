// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EnvironmentManagement.proto

package com.CA.gRPC;

public final class EnvironmentProto {
  private EnvironmentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_switchOnRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_switchOnRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_switchOnResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_switchOnResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_switchOffRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_switchOffRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_switchOffResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_switchOffResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_forecastRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_forecastRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_forecastResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_forecastResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033EnvironmentManagement.proto\"&\n\017switchO" +
      "nRequest\022\023\n\013temperature\030\001 \001(\005\"-\n\020switchO" +
      "nResponse\022\031\n\021statusTemperature\030\001 \001(\005\"\'\n\020" +
      "switchOffRequest\022\023\n\013temperature\030\001 \001(\005\"#\n" +
      "\021switchOffResponse\022\016\n\006status\030\001 \001(\005\"%\n\017fo" +
      "recastRequest\022\022\n\nmsgRequest\030\001 \001(\t\"\'\n\020for" +
      "ecastResponse\022\023\n\013msgResponse\030\001 \001(\0052\267\001\n\027E" +
      "nvironmentMgmtServices\0223\n\010switchOn\022\020.swi" +
      "tchOnRequest\032\021.switchOnResponse\"\0000\001\0224\n\ts" +
      "witchOff\022\021.switchOffRequest\032\022.switchOffR" +
      "esponse\"\000\0221\n\010forecast\022\020.forecastRequest\032" +
      "\021.forecastResponse\"\000B!\n\013com.CA.gRPCB\020Env" +
      "ironmentProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_switchOnRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_switchOnRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_switchOnRequest_descriptor,
        new java.lang.String[] { "Temperature", });
    internal_static_switchOnResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_switchOnResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_switchOnResponse_descriptor,
        new java.lang.String[] { "StatusTemperature", });
    internal_static_switchOffRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_switchOffRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_switchOffRequest_descriptor,
        new java.lang.String[] { "Temperature", });
    internal_static_switchOffResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_switchOffResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_switchOffResponse_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_forecastRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_forecastRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_forecastRequest_descriptor,
        new java.lang.String[] { "MsgRequest", });
    internal_static_forecastResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_forecastResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_forecastResponse_descriptor,
        new java.lang.String[] { "MsgResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
