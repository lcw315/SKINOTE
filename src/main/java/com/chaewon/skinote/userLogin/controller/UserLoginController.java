package com.chaewon.skinote.userLogin.controller;

import com.chaewon.skinote.common.box.Box;
import com.chaewon.skinote.userLogin.service.UserLoginService;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
public class UserLoginController {

    private final UserLoginService userLoginService;


    @PostMapping("/auth/login")
    public ResponseEntity<Box> login(@RequestBody Map<String, Object> requestBody,HttpSession session) {
        Box box = new Box(requestBody);
        Box modelBox = new Box();

        userLoginService.login(box, modelBox);
        if(modelBox.get("success").equals(true)) { // 로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("userId", modelBox.get("userId"));
            session.setAttribute("userName", modelBox.get("userName"));
        }

        return ResponseEntity.ok(modelBox);
    }

    
}