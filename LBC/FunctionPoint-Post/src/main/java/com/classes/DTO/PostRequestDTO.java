package com.classes.DTO;

import java.util.List;

public class PostRequestDTO { // 对应前端的请求体信息（与AuthorDTO共同对应）
    private String id; // 前端传递的 Unix 时间戳作为 ID
    private String title; // 标题
    private String description; // 描述
    private String content; // 内容
    private String category; // 分类
    private AuthorDTO author; // 嵌套的作者信息
    private List<String> tags; // 标签数组
    private String createdAt; // ISO 时间格式
    private String updatedAt; // ISO 时间格式

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public AuthorDTO getAuthor() {
        return author;
    }
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
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
}
