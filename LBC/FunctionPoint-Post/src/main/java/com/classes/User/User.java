package com.classes.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user", schema = "szulab")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @JsonProperty("userId")
    private Long userId; // 用户id

    @Column(name = "username", nullable = false, length = 256)
    @JsonProperty("name")
    private String name; // 用户名

    @Column(name = "password", nullable = false, length = 256)
    @JsonProperty("password")
    private String password; // 密码

    @Column(name = "stu_id", nullable = false, length = 256)
    @JsonProperty("stuId")
    private String stuId; // 学号

    @Column(name = "role", nullable = false, length = 256)
    @JsonProperty("role")
    private int role; // 角色, 0: 学生, 1: 教师, 2: 其他

    @Column(name = "create_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime; // 用户创建时间

    @Column(name = "update_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime; // 用户更新时间

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getStuId() {
        return stuId;
    }
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getRole() {
        return role;
    }
    public void setRole(String role) { // 通过前端传入的字符串设置角色
        if (role.equals("student")) {
            this.role = 0;
        } else if (role.equals("teacher")) {
            this.role = 1;
        } else {
            this.role = 2;
        }
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }
    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
