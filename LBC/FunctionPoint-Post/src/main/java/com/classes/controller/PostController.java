package com.classes.controller;

import com.classes.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.classes.DTO.PostRequestDTO;
import com.classes.DTO.PostResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/posts") // 定义请求路径
public class PostController {
    @Autowired // 注入postService
    private PostService postService;

    @PostMapping("") // POST /api/posts 接口 —— 处理 POST 请求，新增文章
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO postRequestDTO) {
        try {
            postService.createPost(postRequestDTO);
            return ResponseEntity.ok("Post created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error creating post: " + e.getMessage());
        }
    }

    @GetMapping("") // GET /api/posts 接口 —— 处理 GET 请求，返回所有文章
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        try {
            List<PostResponseDTO> posts = postService.getAllPosts();
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}") // GET /api/posts/{id} 接口 —— 处理 GET 请求，根据 ID 返回文章
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        try {
            PostResponseDTO postResponse = postService.getPostById(id);
            return ResponseEntity.ok(postResponse);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}