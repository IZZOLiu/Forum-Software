package com.classes.DAO;

import com.classes.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 连接JPA
public interface PostRepository extends JpaRepository<Post, Long> {
    // 自定义查询方法
}