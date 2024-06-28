package com.ohgiraffers.techmya.board.model.dao;

import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;
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
    List<PostImageDTO> selectPostImagesByPostId(@Param("postNo") int postNo);
    void insertPostImage(PostImageDTO postImage);
    void deletePostImage(@Param("postImageNo") int postImageNo);
    void deletePostImagesByPostNo(int postNo);
}
