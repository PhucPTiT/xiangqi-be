package com.xiangqi.server.repository;

import com.xiangqi.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);

    @Query("SELECT u FROM User u " +
            "WHERE " +
            "(u.username LIKE CONCAT('%', :key, '%') " +
            "OR u.email LIKE CONCAT('%', :key, '%') " +
            "OR u.firstName LIKE CONCAT('%', :key, '%') " +
            "OR u.lastName LIKE CONCAT('%', :key, '%') " +
            "OR u.nickName LIKE CONCAT('%', :key, '%') " +
            "OR u.address LIKE CONCAT('%', :key, '%')) " +
            "ORDER BY u.id")
    List<User> searchUsersByKey(@Param("key") String key);
}
