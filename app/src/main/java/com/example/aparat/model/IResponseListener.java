package com.example.aparat.model;

public interface IResponseListener<T> {
    void onSuccess(T responseMessage);

    void onFailure(String errorResponseMessage);
}
