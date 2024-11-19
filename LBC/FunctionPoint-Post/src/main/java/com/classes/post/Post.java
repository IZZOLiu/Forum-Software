package com.classes.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "post", schema = "szulab") // 指定 schema 和 table 名称
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    @JsonProperty("id")
    private Long postId; // 帖子id

    @Column(name = "title", nullable = false, length = 256)
    @JsonProperty("title")
    private String title; // 帖子标题

    @Column(name = "description", length = 1000)
    @JsonProperty("description")
    private String description; // 帖子描述

    @Column(name = "content", nullable = false)
    @JsonProperty("content")
    private String content; // 帖子内容

    @Column(name = "category", nullable = false)
    @JsonProperty("category")
    private String category; // 帖子分类

    @Column(name = "user_id", nullable = false)
    @JsonProperty("userId")
    private Long userId; // 用户id

    @Column(name = "image_url", length = 356)
    @JsonProperty("imageUrl")
    private String imageUrl; // 图片地址

    @Column(name = "create_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt; // 帖子创建时间

    @Column(name = "update_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt; // 帖子更新时间

    @Column(name = "tags", length = 1000)
    @JsonProperty("tags")
    private String tags; // 标签数组，以逗号分隔的字符串

    // Getters and Setters
    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
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

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
}