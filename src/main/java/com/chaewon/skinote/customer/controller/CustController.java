package com.chaewon.skinote.customer.controller;

import java.util.Map;

import com.chaewon.skinote.common.box.Box;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chaewon.skinote.customer.service.CustService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequiredArgsConstructor
public class CustController {


    private final CustService custService;

        @PostMapping("/cust/searchCustList")
        public ResponseEntity<Box> searchCustList (@RequestBody Map<String, Object> requestBody,HttpSession session) {
        Box box = new Box(requestBody);
        Box modelBox = new Box();

        box.put("userId",session.getAttribute("userId"));
        custService.searchCustList(box, modelBox);
 
        return ResponseEntity.ok(modelBox);
    }

     @PostMapping("/cust/searchTodayCustList")
        public ResponseEntity<Box> todayCustList (@RequestBody Map<String, Object> requestBody,HttpSession session) {
        Box box = new Box(requestBody);
        Box modelBox = new Box();

        box.put("userId",session.getAttribute("userId"));
        custService.todayCustList(box, modelBox);
 
        return ResponseEntity.ok(modelBox);
    }

    

}
