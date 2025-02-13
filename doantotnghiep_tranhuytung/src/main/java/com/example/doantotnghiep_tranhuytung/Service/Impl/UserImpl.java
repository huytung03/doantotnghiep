package com.example.doantotnghiep_tranhuytung.Service.Impl;

import com.example.doantotnghiep_tranhuytung.Entity.UserEntity;
import com.example.doantotnghiep_tranhuytung.Repository.UserRepository;
import com.example.doantotnghiep_tranhuytung.Service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class UserImpl implements UserService {
    private final UserRepository userRepository;

    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity dangnhap(String email, String password) {
        try {
            UserEntity user=userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("mật khẩu không chính xác");
            }
            return user;

        } catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }

    @Override
    public void dangky(UserEntity userEntity) {
        try {
            boolean isemail =userRepository.existsByEmail(userEntity.getEmail());
            if (isemail){
                throw new RuntimeException("Email đã tồn tại ");
            }
            if (userEntity.getPassword().length() <8){
                throw new RuntimeException("Mật khẩu tối thiêu 8 kí tự ");
            }
            if (userEntity.getPassword().contains(" ")){
                throw new RuntimeException("Mật khẩu không thể chứa khoảng trắng ");
            }
            userEntity.setRole("USER");
            userEntity.setCreatedAt(Timestamp.from(Instant.now()));
            userRepository.save(userEntity);

        }catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }
}
