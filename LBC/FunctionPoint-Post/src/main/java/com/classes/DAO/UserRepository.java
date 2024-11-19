package com.classes.DAO;

import com.classes.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 连接JPA
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name); // 根据用户名查找用户
}
