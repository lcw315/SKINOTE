package com.chaewon.skinote.userLogin.service;

import com.chaewon.skinote.common.box.Box;
import com.chaewon.skinote.userLogin.mapper.UserLoginMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor 
public class UserLoginService {

    private final UserLoginMapper userLoginMapper;

    /**
     * @param box      요청 데이터 (id, password)
     * @param modelBox 결과를 채워 넣을 응답 데이터
     */
    public void login(Box box, Box modelBox) {
        log.info("로그인 box :: " + box);

        Box resultBox = userLoginMapper.userlogin(box);
        log.info("로그인 결과 resultBox :: " + resultBox);
        if(resultBox == null) {
            modelBox.put("success", false);
            modelBox.put("message", "로그인 실패: 사용자 정보를 찾을 수 없습니다.");
            return;

        }else {
            modelBox.put("success", true);
            modelBox.put("message", "로그인 성공");
            modelBox.put("userId", resultBox.get("userId"));
            modelBox.put("userName", resultBox.get("userName"));
        }

    }
}