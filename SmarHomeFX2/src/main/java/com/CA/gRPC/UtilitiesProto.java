// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DomesticUtility.proto

package com.CA.gRPC;

public final class UtilitiesProto {
  private UtilitiesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EnergyMonitorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EnergyMonitorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EnergyMonitorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EnergyMonitorResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DisableEnergyMonitorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DisableEnergyMonitorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DisableEnergyMonitorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_DisableEnergyMonitorResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025DomesticUtility.proto\"*\n\024EnergyMonitor" +
      "Request\022\022\n\nrequestMsg\030\001 \001(\t\",\n\025EnergyMon" +
      "itorResponse\022\023\n\013responseMsg\030\001 \001(\005\"5\n\033Dis" +
      "ableEnergyMonitorRequest\022\026\n\016disableReque" +
      "st\030\001 \001(\t\"7\n\034DisableEnergyMonitorResponse" +
      "\022\027\n\017disableResponse\030\001 \001(\t2\266\001\n\031DomesticUt" +
      "ilitiesServices\022B\n\renergyMonitor\022\025.Energ" +
      "yMonitorRequest\032\026.EnergyMonitorResponse\"" +
      "\0000\001\022U\n\024disableEnergyMonitor\022\034.DisableEne" +
      "rgyMonitorRequest\032\035.DisableEnergyMonitor" +
      "Response\"\000B\037\n\013com.CA.gRPCB\016UtilitiesProt" +
      "oP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_EnergyMonitorRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EnergyMonitorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EnergyMonitorRequest_descriptor,
        new java.lang.String[] { "RequestMsg", });
    internal_static_EnergyMonitorResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_EnergyMonitorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EnergyMonitorResponse_descriptor,
        new java.lang.String[] { "ResponseMsg", });
    internal_static_DisableEnergyMonitorRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_DisableEnergyMonitorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DisableEnergyMonitorRequest_descriptor,
        new java.lang.String[] { "DisableRequest", });
    internal_static_DisableEnergyMonitorResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_DisableEnergyMonitorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_DisableEnergyMonitorResponse_descriptor,
        new java.lang.String[] { "DisableResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}