package com.HongSP.project.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FREE("자유 게시판", "자유로운 공간", true),
    CHEERING("응원", "각 팀 응원", true),
    REVIEW("리뷰", "오늘 프로야구 리뷰", true),
    TIP("야구장 팁", "각 야구장 별 팁", true);

    private final String categoryName;
    private final String description;
    private final boolean isActive;
}
