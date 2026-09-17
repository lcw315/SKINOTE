package com.chaewon.skinote.common.box;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller -> Service -> Mapper 사이를 오가는 범용 데이터 컨테이너.
 * HashMap을 상속받아서 Mapper 파라미터(Map)로도 그대로 쓸 수 있습니다.
 *
 * 변수 이름 관례:
 *   box      = 들어온(요청) 데이터를 담을 때
 *   modelBox = 내보낼(응답) 데이터를 담을 때
 * 둘 다 같은 Box 타입입니다. 클래스가 두 개인 게 아니라, 역할에 따라 변수명만 다르게 씁니다.
 */
public class Box extends HashMap<String, Object> {

    public Box() {
        super();
    }

    public Box(Map<String, ?> map) {
        super(map);
    }

    // null이면 빈 문자열로, 아니면 문자열로 변환
    public String nvl(String key) {
        Object value = get(key);
        return value == null ? "" : value.toString();
    }

    // 값이 비어있는지(null 또는 빈 문자열) 체크 — 필수값 검증에 사용
    public boolean eq(String key) {
        Object value = get(key);
        return value == null || value.toString().isEmpty();
    }

    // 값이 특정 문자열과 같은지 체크
    public boolean eq(String key, String compare) {
        Object value = get(key);
        return value != null && value.toString().equals(compare);
    }

    // 안에 Box가 중첩되어 담겨있을 때 꺼내기
    public Box getBox(String key) {
        Object value = get(key);
        return value instanceof Box ? (Box) value : null;
    }

    public boolean getBoolean(String key) {
        Object value = get(key);
        return value != null && (Boolean) value;
    }

    public int getInt(String key) {
        Object value = get(key);
        return value == null ? 0 : Integer.parseInt(value.toString());
    }

    public String getString(String key) {
        return nvl(key);
    }
}