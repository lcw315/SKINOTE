package com.chaewon.skinote.userLogin.controller;

import com.chaewon.skinote.common.box.Box;
import com.chaewon.skinote.userLogin.service.UserLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
public class UserLoginController {

    private final UserLoginService userLoginService;


    @PostMapping("/auth/login")
    public ResponseEntity<Box> login(@RequestBody Map<String, Object> requestBody) {
        Box box = new Box(requestBody);
        Box modelBox = new Box();
 
        userLoginService.login(box, modelBox);
 
        return ResponseEntity.ok(modelBox);
    }


    
}