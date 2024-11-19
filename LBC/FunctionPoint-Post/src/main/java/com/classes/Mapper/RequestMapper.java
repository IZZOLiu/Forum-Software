package com.classes.Mapper;

import com.classes.DTO.PostRequestDTO;
import com.classes.post.Post;
import com.classes.User.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestMapper {    // 将 PostRequestDTO 转换为 Post 实体
    public static Post toPost(PostRequestDTO postRequestDTO, User user) {
        // 设置post的属性
        Post post = new Post();
        post.setPostId(Long.parseLong(postRequestDTO.getId())); // 将 String 转换为 Long
        post.setTitle(postRequestDTO.getTitle());
        post.setDescription(postRequestDTO.getDescription());
        post.setContent(postRequestDTO.getContent());
        post.setCategory(postRequestDTO.getCategory());
        post.setUserId(user.getUserId());
        post.setTags(String.join(",", postRequestDTO.getTags())); // 将标签数组转为逗号分隔字符串
        post.setCreatedAt(LocalDateTime.parse(postRequestDTO.getCreatedAt(), DateTimeFormatter.ISO_DATE_TIME));
        post.setUpdatedAt(LocalDateTime.parse(postRequestDTO.getUpdatedAt(), DateTimeFormatter.ISO_DATE_TIME));
        post.setImageUrl(null); // 默认值为 null

        return post;
    }
}
