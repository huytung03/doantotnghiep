package com.example.doantotnghiep_tranhuytung.Service;

import com.example.doantotnghiep_tranhuytung.Entity.UserEntity;

public interface UserService {
    UserEntity dangnhap (String email, String password);
    void dangky(UserEntity userEntity);
}

