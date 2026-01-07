package com.viewshop.controller;

import com.viewshop.entity.Board;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/community")
public class BoardController {

    // 테스트를 위해 임시로 메모리에 저장 (나중에 DB 연결)
    private static List<Board> boardStorage = new ArrayList<>();
    private static AtomicLong idGenerator = new AtomicLong(1);

    // 1. 게시글 등록 API
    @PostMapping("/register")
    public String register(@RequestBody Board board) {
        board.setId(idGenerator.getAndIncrement()); // 번호 자동 생성
        board.setStatus("대기중"); // 기본값 설정
        board.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        
        boardStorage.add(board); // 저장
        
        System.out.println("새 글 등록됨: " + board.getTitle());
        return "success";
    }

    // 2. 게시글 목록 조회 API (CommunityView.vue에서 fetchPosts 할 때 사용)
    @GetMapping("/posts")
    public List<Board> getPosts() {
        System.out.println("목록 요청 들어옴.보낼 데이터 개수: "+boardStorage.size());
        return boardStorage;
    }
    @GetMapping("/posts/{id}")
    public Board getPostDetail(@PathVariable Long id) {
       return boardStorage.stream()
                .filter(board -> board.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}