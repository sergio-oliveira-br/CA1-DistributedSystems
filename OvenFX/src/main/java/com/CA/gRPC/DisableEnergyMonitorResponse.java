// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DomesticUtility.proto

package com.CA.gRPC;

/**
 * Protobuf type {@code DisableEnergyMonitorResponse}
 */
public final class DisableEnergyMonitorResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:DisableEnergyMonitorResponse)
    DisableEnergyMonitorResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DisableEnergyMonitorResponse.newBuilder() to construct.
  private DisableEnergyMonitorResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DisableEnergyMonitorResponse() {
    disableResponse_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DisableEnergyMonitorResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DisableEnergyMonitorResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            disableResponse_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.CA.gRPC.UtilitiesProto.internal_static_DisableEnergyMonitorResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.CA.gRPC.UtilitiesProto.internal_static_DisableEnergyMonitorResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.CA.gRPC.DisableEnergyMonitorResponse.class, com.CA.gRPC.DisableEnergyMonitorResponse.Builder.class);
  }

  public static final int DISABLERESPONSE_FIELD_NUMBER = 1;
  private volatile java.lang.Object disableResponse_;
  /**
   * <code>string disableResponse = 1;</code>
   * @return The disableResponse.
   */
  @java.lang.Override
  public java.lang.String getDisableResponse() {
    java.lang.Object ref = disableResponse_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      disableResponse_ = s;
      return s;
    }
  }
  /**
   * <code>string disableResponse = 1;</code>
   * @return The bytes for disableResponse.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDisableResponseBytes() {
    java.lang.Object ref = disableResponse_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      disableResponse_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(disableResponse_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, disableResponse_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(disableResponse_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, disableResponse_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.CA.gRPC.DisableEnergyMonitorResponse)) {
      return super.equals(obj);
    }
    com.CA.gRPC.DisableEnergyMonitorResponse other = (com.CA.gRPC.DisableEnergyMonitorResponse) obj;

    if (!getDisableResponse()
        .equals(other.getDisableResponse())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DISABLERESPONSE_FIELD_NUMBER;
    hash = (53 * hash) + getDisableResponse().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.CA.gRPC.DisableEnergyMonitorResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.CA.gRPC.DisableEnergyMonitorResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code DisableEnergyMonitorResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:DisableEnergyMonitorResponse)
      com.CA.gRPC.DisableEnergyMonitorResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.CA.gRPC.UtilitiesProto.internal_static_DisableEnergyMonitorResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.CA.gRPC.UtilitiesProto.internal_static_DisableEnergyMonitorResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.CA.gRPC.DisableEnergyMonitorResponse.class, com.CA.gRPC.DisableEnergyMonitorResponse.Builder.class);
    }

    // Construct using com.CA.gRPC.DisableEnergyMonitorResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      disableResponse_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.CA.gRPC.UtilitiesProto.internal_static_DisableEnergyMonitorResponse_descriptor;
    }

    @java.lang.Override
    public com.CA.gRPC.DisableEnergyMonitorResponse getDefaultInstanceForType() {
      return com.CA.gRPC.DisableEnergyMonitorResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.CA.gRPC.DisableEnergyMonitorResponse build() {
      com.CA.gRPC.DisableEnergyMonitorResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.CA.gRPC.DisableEnergyMonitorResponse buildPartial() {
      com.CA.gRPC.DisableEnergyMonitorResponse result = new com.CA.gRPC.DisableEnergyMonitorResponse(this);
      result.disableResponse_ = disableResponse_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.CA.gRPC.DisableEnergyMonitorResponse) {
        return mergeFrom((com.CA.gRPC.DisableEnergyMonitorResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.CA.gRPC.DisableEnergyMonitorResponse other) {
      if (other == com.CA.gRPC.DisableEnergyMonitorResponse.getDefaultInstance()) return this;
      if (!other.getDisableResponse().isEmpty()) {
        disableResponse_ = other.disableResponse_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.CA.gRPC.DisableEnergyMonitorResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.CA.gRPC.DisableEnergyMonitorResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object disableResponse_ = "";
    /**
     * <code>string disableResponse = 1;</code>
     * @return The disableResponse.
     */
    public java.lang.String getDisableResponse() {
      java.lang.Object ref = disableResponse_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        disableResponse_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string disableResponse = 1;</code>
     * @return The bytes for disableResponse.
     */
    public com.google.protobuf.ByteString
        getDisableResponseBytes() {
      java.lang.Object ref = disableResponse_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        disableResponse_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string disableResponse = 1;</code>
     * @param value The disableResponse to set.
     * @return This builder for chaining.
     */
    public Builder setDisableResponse(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      disableResponse_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string disableResponse = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDisableResponse() {
      
      disableResponse_ = getDefaultInstance().getDisableResponse();
      onChanged();
      return this;
    }
    /**
     * <code>string disableResponse = 1;</code>
     * @param value The bytes for disableResponse to set.
     * @return This builder for chaining.
     */
    public Builder setDisableResponseBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      disableResponse_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:DisableEnergyMonitorResponse)
  }

  // @@protoc_insertion_point(class_scope:DisableEnergyMonitorResponse)
  private static final com.CA.gRPC.DisableEnergyMonitorResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.CA.gRPC.DisableEnergyMonitorResponse();
  }

  public static com.CA.gRPC.DisableEnergyMonitorResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DisableEnergyMonitorResponse>
      PARSER = new com.google.protobuf.AbstractParser<DisableEnergyMonitorResponse>() {
    @java.lang.Override
    public DisableEnergyMonitorResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DisableEnergyMonitorResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DisableEnergyMonitorResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DisableEnergyMonitorResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.CA.gRPC.DisableEnergyMonitorResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
