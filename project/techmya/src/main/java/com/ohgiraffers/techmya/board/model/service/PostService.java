package com.ohgiraffers.techmya.board.model.service;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();
    List<PostDTO> getPostsByBoardType(int boardNo);
    PostDTO getPost(int postNo);
    List<PostImageDTO> getPostImagesByPostId(int postNo);
    void insertPost(PostDTO post);
    void insertPostImage(PostImageDTO postImage);
    void updatePost(PostDTO post);
    void deletePost(int postNo);
    void deletePostImage(int postImageNo);
}
