package com.example.newproject.viewmodel;

import com.example.newproject.model.TemplateCategory;

import java.util.List;

public class ApiResponse {
    private String timestamp;
    private int statusCode;
    private String httpStatus;
    private String message;
    private List<TemplateCategory> data;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TemplateCategory> getData() {
        return data;
    }

    public void setData(List<TemplateCategory> data) {
        this.data = data;
    }
}
