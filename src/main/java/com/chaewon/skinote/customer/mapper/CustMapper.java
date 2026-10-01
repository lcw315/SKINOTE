package com.chaewon.skinote.customer.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper 
public interface CustMapper {
    

    List<Map<String, Object>> searchCustList(Map<String, Object> requestBody);
    List<Map<String, Object>> todayCustList(Map<String, Object> requestBody);
    

}
