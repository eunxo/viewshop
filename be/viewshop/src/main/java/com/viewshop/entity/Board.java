package com.viewshop.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class Board {
    private Long id;            // 글 번호
    private String title;       // 제목
    private String author;      // 작성자
    private String content;     // 내용
    private String status;      // 답변 상태 (예: '대기중', '답변완료')
    private String date;        // 작성일
}