package com.example.doantotnghiep_tranhuytung.Repository;

import com.example.doantotnghiep_tranhuytung.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // tim kiem user theo email
    Optional<UserEntity> findByEmail(String email);
    // kiem tra email da ton tai hay chua
    boolean existsByEmail(String email);
}
