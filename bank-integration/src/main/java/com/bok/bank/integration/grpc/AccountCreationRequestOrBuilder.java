// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bank.proto

package com.bok.bank.integration.grpc;

public interface AccountCreationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:AccountCreationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 accountId = 1;</code>
   * @return The accountId.
   */
  long getAccountId();

  /**
   * <code>string email = 2;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 2;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();
}