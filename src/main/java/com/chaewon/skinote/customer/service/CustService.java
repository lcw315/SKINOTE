package com.chaewon.skinote.customer.service;

import com.chaewon.skinote.common.box.Box;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.chaewon.skinote.customer.mapper.CustMapper;


@Service
@Slf4j
@RequiredArgsConstructor
public class CustService {
    
    private final CustMapper custMapper;

    // 고객 리스트 조회
    public void searchCustList(Box box, Box modelBox) {
    
        modelBox.put("custList", custMapper.searchCustList(box));
    
    }

    // 오늘 예약 손님 리스트
    public void todayCustList(Box box, Box modelBox) {
    
        modelBox.put("custList", custMapper.todayCustList(box));
    
    }




}
