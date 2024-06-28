package com.ohgiraffers.techmya.board.controller;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;
import com.ohgiraffers.techmya.board.model.dto.ReplyDTO;
import com.ohgiraffers.techmya.board.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class PostController {

    private final PostService postService;
    private final String uploadDir = "uploads";

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/boardmain")
    public String list(@RequestParam(value = "boardNo", required = false) Integer boardNo, Model model) {
        List<PostDTO> posts;
        String boardTitle;

        if (boardNo != null) {
            posts = postService.getPostsByBoardType(boardNo);
            boardTitle = boardNo == 1 ? "공지사항 및 문의" : "자주 묻는 질문";
        } else {
            posts = postService.getAllPosts();
            boardTitle = "모든 게시글";
        }

        model.addAttribute("posts", posts);
        model.addAttribute("boardTitle", boardTitle);
        model.addAttribute("currentPage", "board"); // 네비 메뉴 활성화용

        return "admin/board/boardmain";
    }

    @GetMapping("/view/{postNo}")
    public String view(@PathVariable("postNo") int postNo, Model model) {
        PostDTO post = postService.getPost(postNo);
        List<PostImageDTO> postImages = postService.getPostImagesByPostId(postNo);
        List<ReplyDTO> replies = postService.getRepliesByPostId(postNo);
        model.addAttribute("post", post);
        model.addAttribute("postImages", postImages);
        model.addAttribute("replies", replies);
        return "admin/board/view";
    }

    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "admin/board/write";
    }

    @PostMapping("/submitWrite")
    public String submitWrite(@RequestParam("title") String title,
                              @RequestParam("content") String content,
                              @RequestParam("isPublic") Boolean isPublic,
                              @RequestParam("userNo") Integer userNo,
                              @RequestParam("boardNo") Integer boardNo,
                              @RequestParam("image") MultipartFile image) {
        PostDTO post = new PostDTO();
        post.setPostTitle(title);
        post.setPostContent(content);
        post.setIsPublic(isPublic);
        post.setUserNo(userNo);
        post.setBoardNo(boardNo);
        post.setCreatedDate(new Date());
        postService.insertPost(post);

        if (!image.isEmpty()) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());
            Path targetLocation = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(fileName);

            try {
                Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
            }

            PostImageDTO postImage = new PostImageDTO();
            postImage.setPostImageOrgFileName(fileName);
            postImage.setPostImageStoredFileName(fileName);
            postImage.setCreatedDate(new Date());
            postImage.setDeleted(false);
            postImage.setPostNo(post.getPostNo());
            postService.insertPostImage(postImage);
        }

        return "redirect:/board/boardmain?boardNo=" + boardNo; // 글 작성 후 리다이렉트할 경로 설정
    }

    @GetMapping("/edit/{postNo}")
    public String editForm(@PathVariable("postNo") int postNo, Model model) {
        PostDTO post = postService.getPost(postNo);
        List<PostImageDTO> postImages = postService.getPostImagesByPostId(postNo);
        model.addAttribute("post", post);
        model.addAttribute("postImages", postImages);
        return "admin/board/edit";
    }

    @PostMapping("/submitEdit")
    public String editPost(@RequestParam("postNo") int postNo,
                           @RequestParam("title") String title,
                           @RequestParam("content") String content,
                           @RequestParam("isPublic") Boolean isPublic,
                           @RequestParam("userNo") Integer userNo,
                           @RequestParam("boardNo") Integer boardNo,
                           @RequestParam(value = "image", required = false) MultipartFile image) {
        PostDTO post = postService.getPost(postNo);
        post.setPostTitle(title);
        post.setPostContent(content);
        post.setIsPublic(isPublic);
        post.setUserNo(userNo);
        post.setBoardNo(boardNo);
        postService.updatePost(post);

        if (image != null && !image.isEmpty()) {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());
            Path targetLocation = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(fileName);

            try {
                Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
            }

            PostImageDTO postImage = new PostImageDTO();
            postImage.setPostImageOrgFileName(fileName);
            postImage.setPostImageStoredFileName(fileName);
            postImage.setCreatedDate(new Date());
            postImage.setDeleted(false);
            postImage.setPostNo(post.getPostNo());
            postService.insertPostImage(postImage);
        }

        return "redirect:/board/view/" + postNo; // 수정 후 리다이렉트할 경로 설정
    }

    @GetMapping("/delete/{postNo}")
    public String delete(@PathVariable("postNo") int postNo, @RequestParam("boardNo") int boardNo) {
        postService.deletePost(postNo);
        return "redirect:/board/boardmain?boardNo=" + boardNo; // 삭제 후 리다이렉트할 경로 설정
    }

    @PostMapping("/submitReply")
    public String submitReply(@RequestParam("postNo") int postNo,
                              @RequestParam("responseContent") String responseContent,
                              @RequestParam("userNo") int userNo) {
        ReplyDTO reply = new ReplyDTO();
        reply.setPostNo(postNo);
        reply.setResponseContent(responseContent);
        reply.setUserNo(userNo);
        reply.setCreatedDate(new Date());
        reply.setPublic(true); // Assuming the reply is public by default
        postService.insertReply(reply);
        return "redirect:/board/view/" + postNo; // Redirect back to the post view
    }

    @GetMapping("/deleteReply")
    public String deleteReply(@RequestParam("replyNo") int replyNo,
                              @RequestParam("postNo") int postNo) {
        postService.deleteReply(replyNo);
        return "redirect:/board/view/" + postNo; // Redirect back to the post view
    }

    @PostMapping("/editReply")
    public String editReply(@RequestParam("replyNo") int replyNo,
                            @RequestParam("postNo") int postNo,
                            @RequestParam("responseContent") String responseContent) {
        ReplyDTO reply = new ReplyDTO();
        reply.setResponseNo(replyNo);
        reply.setResponseContent(responseContent);
        postService.updateReply(reply);
        return "redirect:/board/view/" + postNo; // Redirect back to the post view
    }
}
