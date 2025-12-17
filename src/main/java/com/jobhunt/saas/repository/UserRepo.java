package com.jobhunt.saas.repository;

import com.jobhunt.saas.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
    boolean existsByEmail(String email);
}
