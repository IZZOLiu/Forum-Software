package com.classes.service;

import com.classes.DTO.PostRequestDTO;
import com.classes.DTO.PostResponseDTO;
import com.classes.Mapper.RequestMapper;
import com.classes.Mapper.ResponseMapper;
import com.classes.post.*;
import com.classes.DAO.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classes.DAO.UserRepository;
import com.classes.User.User;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class PostService {
    @Autowired // 注入PostRepository
    private PostRepository postRepository;

    @Autowired // 注入UserRepository
    private UserRepository UserRepository;

    public void createPost(PostRequestDTO postRequestDTO) { // 创建文章
        try {
            // 由于只是进行初步测试，并未实现用户注册功能，所以这里直接使用默认用户（前端中写到的guest进行创建），同时也没有对用户进行身份验证
            // 查找或创建用户
            String authorName = postRequestDTO.getAuthor().getName();
            User user = UserRepository.findByName(authorName)
                    .orElseGet(() -> {
                        User newUser = new User();
                        newUser.setName(authorName);
                        newUser.setRole(postRequestDTO.getAuthor().getRole());
                        LocalDateTime now = LocalDateTime.now();
                        newUser.setCreatedTime(now);
                        newUser.setUpdatedTime(now);
                        newUser.setPassword("123456"); // 默认密码
                        newUser.setStuId("default"); // 默认学号
                        return UserRepository.save(newUser);
                    });

            // 构建 Post 实体，使用映射将前端的请求转换体为数据库实体
            Post post = RequestMapper.toPost(postRequestDTO, user);

            // 保存到数据库
            postRepository.save(post);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<PostResponseDTO> getAllPosts() {       // 返回所有文章
        try {
            // 查询所有帖子
            List<Post> posts = postRepository.findAll();

            // 构建 PostResponseDTO 列表
            List<PostResponseDTO> postResponseList = posts.stream().map(post -> {
                // 查询用户信息
                User user = UserRepository.findById(post.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found"));

                // 构建 PostResponse，使用映射将数据库实体转换为前端响应体
                PostResponseDTO postResponse = ResponseMapper.toPostResponseDTO(post, user);

                return postResponse;
            }).collect(Collectors.toList());

            return postResponseList;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PostResponseDTO getPostById(Long postId) {   // 根据 ID 返回文章
        try {
            // 查询特定id的帖子
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new RuntimeException("Post not found"));

            // 查询用户信息
            User user = UserRepository.findById(post.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // 构建 PostResponse，使用映射将数据库实体转换为前端响应体
            PostResponseDTO postResponse = ResponseMapper.toPostResponseDTO(post, user);

            return postResponse;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}