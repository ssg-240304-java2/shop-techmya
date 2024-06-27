package com.ohgiraffers.techmya.board.model.dao;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;
import com.ohgiraffers.techmya.board.model.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> selectAllPosts();
    List<PostDTO> selectPostsByBoardType(@Param("boardType") int boardType);
    PostDTO selectPostById(@Param("postNo") int postNo);
    void insertPost(PostDTO post);
    void updatePost(PostDTO post);
    void deletePost(@Param("postNo") int postNo);
    List<ReplyDTO> selectRepliesByPostId(@Param("postNo") int postNo);
    void insertReply(ReplyDTO reply);
    void deleteReply(@Param("responseNo") int responseNo);
    List<PostImageDTO> selectPostImagesByPostId(@Param("postNo") int postNo);
    void insertPostImage(PostImageDTO postImage);
    void deletePostImage(@Param("postImageNo") int postImageNo);
    void deletePostImagesByPostId(int postNo);

    void deleteRepliesByPostId(int postNo);

    void updateReply(ReplyDTO reply);

    ReplyDTO selectReplyById(int replyNo);

    void deletePostImagesByPostNo(int postNo);
}
