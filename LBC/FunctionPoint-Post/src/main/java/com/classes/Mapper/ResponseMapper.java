package com.classes.Mapper;

import com.classes.DTO.PostResponseDTO;
import com.classes.User.User;
import com.classes.post.Post;
import java.time.format.DateTimeFormatter;

import java.util.List;

public class ResponseMapper {   // 将 Post 实体转换为 PostResponseDTO
    public static PostResponseDTO toPostResponseDTO(Post post, User user) {
        // 设置 postResponse 的属性
        PostResponseDTO postResponse = new PostResponseDTO();
        postResponse.setId(String.valueOf(post.getPostId()));
        postResponse.setTitle(post.getTitle());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());
        postResponse.setImageUrl(post.getImageUrl());
        postResponse.setCategory(post.getCategory());
        postResponse.setCreatedAt(post.getCreatedAt().format(DateTimeFormatter.ISO_DATE_TIME)); // ISO 8601 格式
        postResponse.setUpdatedAt(post.getUpdatedAt().format(DateTimeFormatter.ISO_DATE_TIME)); // 转换时间格式

        // 设置 author 信息
        PostResponseDTO.Author author = new PostResponseDTO.Author();
        author.setName(user.getName());
        author.setRole(user.getRole());
        postResponse.setAuthor(author);

        // 设置 tags 信息
        postResponse.setTags(List.of(post.getTags().split(","))); // 逗号分隔转 List

        return postResponse;
    }
}
