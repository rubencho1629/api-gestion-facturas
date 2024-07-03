package com.api.gestion.dao;

import com.api.gestion.pojo.User;
import com.api.gestion.wrapper.UserWrapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(@Param("email") String email);

    @Query(name = "User.getAllUsers")
    List<UserWrapper> getAllUsers();

    @Transactional
    @Modifying
    @Query(name = "User.updateStatus")
    Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
}
