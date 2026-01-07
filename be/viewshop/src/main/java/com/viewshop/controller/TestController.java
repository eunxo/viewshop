// package com.viewshop.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// @RestController
// public class TestController {

//     @GetMapping("/hello")
//     public String hello() {
//         return "스프링 부트와 연결되었습니다!";
//     }

//     // Vue의 fetchPosts()가 호출하는 경로와 일치시켜야 합니다.
//     @GetMapping("/community/posts")
//     public List<Map<String, Object>> getPosts() {
//         List<Map<String, Object>> posts = new ArrayList<>();
        
//         // 프런트엔드에서 사용하는 키 값(id, title, author, date, status)과 일치시켜야 합니다.
//         Map<String, Object> post1 = new HashMap<>();
//         post1.put("id", 1);
//         post1.put("title", "배송은 보통 얼마나 걸리나요?");
//         post1.put("author", "김**");
//         post1.put("date", "2024-03-20");
//         post1.put("status", "답변완료");
        
//         posts.add(post1);
//         return posts;
//     }
// }