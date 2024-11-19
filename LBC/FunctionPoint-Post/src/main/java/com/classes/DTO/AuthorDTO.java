package com.classes.DTO;

public class AuthorDTO { // 对应前端的作者信息
    private String name; // 作者名
    private String role; // 作者角色

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
    public void setRole(String role) {
        this.role = role;
    }
}
