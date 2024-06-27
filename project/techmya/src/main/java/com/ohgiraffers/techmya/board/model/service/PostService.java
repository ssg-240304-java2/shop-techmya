package com.ohgiraffers.techmya.board.model.service;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;
import com.ohgiraffers.techmya.board.model.dto.ReplyDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();
    List<PostDTO> getPostsByBoardType(int boardNo);
    PostDTO getPost(int postNo);
    List<PostImageDTO> getPostImagesByPostId(int postNo);
    List<ReplyDTO> getRepliesByPostId(int postNo);
    void insertPost(PostDTO post);
    void insertPostImage(PostImageDTO postImage);
    void insertReply(ReplyDTO reply);
    void updatePost(PostDTO post);
    void deletePost(int postNo);
    void deleteReply(int replyNo);
    void updateReply(ReplyDTO reply); // 댓글 수정 메소드 추가
}
