package com.example.newproject.model;

import java.util.List;

public class TemplateCategory {
    private String type;
    private List<Template> data;

    public TemplateCategory(String type, List<Template> data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Template> getData() {
        return data;
    }

    public void setData(List<Template> data) {
        this.data = data;
    }
}