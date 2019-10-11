package com.vitasport.starlabs.vitasport.view_models.listeners;

public interface BaseListener {
    void onLoading(boolean isLoading);
    void onError(String message);
}
