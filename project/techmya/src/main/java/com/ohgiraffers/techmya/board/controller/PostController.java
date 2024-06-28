package com.ohgiraffers.techmya.board.controller;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;
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
            boardTitle = (boardNo == 1 || boardNo == 2) ? "Notice and Questions" : "FAQ";
        } else {
            posts = postService.getAllPosts();
            boardTitle = "All Posts";
        }

        model.addAttribute("posts", posts);
        model.addAttribute("boardTitle", boardTitle);
        model.addAttribute("boardNo", boardNo);
        return "admin/board/boardmain";
    }

    @GetMapping("/view/{postNo}")
    public String view(@PathVariable("postNo") int postNo, Model model) {
        PostDTO post = postService.getPost(postNo);
        List<PostImageDTO> postImages = postService.getPostImagesByPostId(postNo);
        model.addAttribute("post", post);
        model.addAttribute("postImages", postImages);
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
                           @RequestParam(value = "image", required = false) MultipartFile image,
                           @RequestParam("deleteImages") String deleteImages) {
        PostDTO post = postService.getPost(postNo);
        post.setPostTitle(title);
        post.setPostContent(content);
        post.setIsPublic(isPublic);
        post.setUserNo(userNo);
        post.setBoardNo(boardNo);
        postService.updatePost(post);

        // 이미지 삭제 처리
        if ("delete".equals(deleteImages)) {
            List<PostImageDTO> postImages = postService.getPostImagesByPostId(postNo);
            for (PostImageDTO postImage : postImages) {
                postService.deletePostImage(postImage.getPostImageNo());
                Path targetLocation = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(postImage.getPostImageStoredFileName());
                try {
                    Files.deleteIfExists(targetLocation);
                } catch (IOException ex) {
                    throw new RuntimeException("Could not delete file " + postImage.getPostImageStoredFileName() + ". Please try again!", ex);
                }
            }
        }

        // 새 이미지 업로드 처리
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
    public String deletePost(@PathVariable("postNo") int postNo) {
        postService.deletePost(postNo);
        return "redirect:/board/boardmain";
    }

    @GetMapping("/admin/main")
    public String adminMain(Model model) {
        List<PostDTO> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "admin/admin_main";
    }
}
