package com.example.newproject.model;

import java.util.List;

public class Template {
    private String id;
    private String name;
    private String type;
    private String categoryId;
    private int isPremium;
    private int isRecommend;
    private String tag;
    private String previewUrl;
    private String contentUrl;
    private String createdAt;
    private String updatedAt;
    private String categoryName;

    public Template(String id, String name, String type, String categoryId, int isPremium, int isRecommend, String tag, String previewUrl, String contentUrl, String createdAt, String updatedAt, String categoryName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.categoryId = categoryId;
        this.isPremium = isPremium;
        this.isRecommend = isRecommend;
        this.tag = tag;
        this.previewUrl = previewUrl;
        this.contentUrl = contentUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(int isPremium) {
        this.isPremium = isPremium;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

