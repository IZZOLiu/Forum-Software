package com.classes.DTO;

import java.util.List;

public class PostResponseDTO { // 对应前端的响应体信息
    private String id; // 前端传递的 作为 ID
    private String title; // 标题
    private String description; // 描述
    private String content; // 内容
    private String imageUrl; // 图片链接
    private String category; // 分类
    private Author author; // 嵌套的作者信息
    private String createdAt; // ISO 时间格式
    private String updatedAt; // ISO 时间格式
    private List<String> tags;

    // 内部类，表示作者信息
    public static class Author {
        private String name;
        private String role;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(Integer role) { // 数据库中的 role 是整数，而前端需要字符串，因此需要转换
            if (role == 0) {
                this.role = "学生";
            } else if (role == 1) {
                this.role = "教师";
            } else {
                this.role = "其他";
            }
        }
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
