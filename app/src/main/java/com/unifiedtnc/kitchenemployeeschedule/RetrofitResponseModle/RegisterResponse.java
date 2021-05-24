package com.unifiedtnc.kitchenemployeeschedule.RetrofitResponseModle;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("message")
    public  String message;
    @SerializedName("status")
    public  String status;

    public RegisterResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
