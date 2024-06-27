package com.ohgiraffers.techmya.board.controller;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class PostController {

    @GetMapping("boardmain")
    public String pagePostList() {
        return "admin/board/boardmain";
    }
    @GetMapping("write")
    public String write() {
        return "admin/board/write";
    }

    @PostMapping("submitWrite")
    public String submitWrite(@RequestParam("title") String title,
                              @RequestParam("content") String content,
                              @RequestParam("writer") String writer,
                              @RequestParam("image") MultipartFile image) {
        // 글쓰기 로직 구현 (데이터베이스에 저장 등)
        // 예: postService.savePost(new Post(title, content, writer, image));
        return "redirect:admin/board/boardmain"; // 글 작성 후 리다이렉트할 경로 설정
    }

    @GetMapping("reply")
    public String reply(@RequestParam("postNo") int postNo, Model model) {
        model.addAttribute("postNo", postNo);
        return "admin/board/reply"; // reply.html로 이동
    }

    @GetMapping("edit")
    public String edit(@RequestParam("postNo") int postNo, Model model) {
        // 게시글 정보를 가져와서 모델에 추가
        //PostDTO post = postService.getPost(postNo); // 여기서 postService는 게시글 정보를 가져오는 서비스입니다.
        //model.addAttribute("post", post);
        return "adminboard/edit"; // edit.html로 이동
    }

    @PostMapping("submitReply")
    public String submitReply(@RequestParam("postNo") int postNo,
                              @RequestParam("responseContent") String responseContent,
                              @RequestParam("userNo") int userNo,
                              @RequestParam("isPublic") boolean isPublic) {
        return "redirect:admin/board/boardmain"; // 답글 작성 후 리다이렉트할 경로 설정
    }
}
