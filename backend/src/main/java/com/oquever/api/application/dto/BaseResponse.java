package com.oquever.api.application.dto;

import java.util.List;

public class BaseResponse<T> {

  private boolean success;
  private String message;
  private T data;
  private List<String> errors;

  public BaseResponse() {
  }

  public BaseResponse(boolean success, String message, T data, List<String> errors) {
    this.success = success;
    this.message = message;
    this.data = data;
    this.errors = errors;
  }

  public static <T> BaseResponse<T> ok(T data) {
    return new BaseResponse<>(true, "OK", data, null);
  }

  public static <T> BaseResponse<T> error(String errorMessage) {
    return new BaseResponse<>(false, errorMessage, null, List.of(errorMessage));
  }

  public static <T> BaseResponse<T> error(String generalMessage, List<String> errorDetails) {
    return new BaseResponse<>(false, generalMessage, null, errorDetails);
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public List<String> getErrors() {
    return errors;
  }
}
