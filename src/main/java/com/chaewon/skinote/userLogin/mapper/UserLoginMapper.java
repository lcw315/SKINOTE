package com.chaewon.skinote.userLogin.mapper;

import com.chaewon.skinote.common.box.Box;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 👈 1. 스프링이 이 인터페이스를 매퍼로 인식할 수 있게 어노테이션을 붙여줍니다.
public interface UserLoginMapper { // 👈 2. class를 interface로 바꿔줍니다!

    // 3. 서비스에서 호출할 메서드 명세를 적어줍니다.
    Box userlogin(Box box);

}