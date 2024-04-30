package com.HongSP.project.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Team {
    LG("엘지", "잠실"),
    DOOSAN("두산", "잠실"),
    KIWOOM("키움", "고척"),
    LOTTE("롯데", "사직"),
    SAMSUNG("삼성", "대구"),
    HANWHA("한화", "대전"),
    KIA("기아", "광주"),
    KT("KT", "수원"),
    NC("NC", "창원"),
    SSG("신세계", "인천");

    private final String teamName;
    private final String teamRegion;
}
