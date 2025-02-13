package com.example.doantotnghiep_tranhuytung.Controller;

import com.example.doantotnghiep_tranhuytung.Entity.UserEntity;
import com.example.doantotnghiep_tranhuytung.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
   @GetMapping("/dangnhap")
    public String dangnhap(){
        return "dangnhap";
    }
    @PostMapping("/dangnhap")
    public String postDangnhap(@RequestParam String email, @RequestParam String password, Model model){
        try {
            UserEntity user =userService.dangnhap(email, password);
            model.addAttribute("user", user);
            return "redirect:/home";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "dangnhap";
        }
    }
    @GetMapping("/dangky")
    public String dangky(){
        return "dangky"; // Trả về trang đăng ký
    }

    @PostMapping("/dangky")
    public String postDangky(@ModelAttribute UserEntity userEntity, Model model){
        try {
            userService.dangky(userEntity);
            model.addAttribute("success", "Đăng ký thành công!");
            return "redirect:/dangnhap"; // Chuyển hướng đến trang đăng nhập
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "dangky"; // Quay lại trang đăng ký nếu có lỗi
        }
    }



}
