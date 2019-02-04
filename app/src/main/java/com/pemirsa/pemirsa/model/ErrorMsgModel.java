package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.SerializedName;

public class ErrorMsgModel {

    @SerializedName("error_msg")
    private boolean errorMsg;

    @SerializedName("error")
    private String error;

    public void setErrorMsg(boolean errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isErrorMsg() {
        return errorMsg;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}