package com.ohgiraffers.techmya.board.model.service;

import com.ohgiraffers.techmya.board.model.dao.PostMapper;
import com.ohgiraffers.techmya.board.model.dto.PostDTO;
import com.ohgiraffers.techmya.board.model.dto.PostImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postMapper.selectAllPosts();
    }

    @Override
    public List<PostDTO> getPostsByBoardType(int boardNo) {
        return postMapper.selectPostsByBoardType(boardNo);
    }

    @Override
    public PostDTO getPost(int postNo) {
        return postMapper.selectPostById(postNo);
    }

    @Override
    public List<PostImageDTO> getPostImagesByPostId(int postNo) {
        return postMapper.selectPostImagesByPostId(postNo);
    }

    @Override
    public void insertPost(PostDTO post) {
        postMapper.insertPost(post);
    }

    @Override
    public void insertPostImage(PostImageDTO postImage) {
        postMapper.insertPostImage(postImage);
    }

    @Override
    public void updatePost(PostDTO post) {
        postMapper.updatePost(post);
    }

    @Override
    public void deletePost(int postNo) {
        postMapper.deletePostImagesByPostNo(postNo);
        postMapper.deletePost(postNo);
    }

    @Override
    public void deletePostImage(int postImageNo) {
        postMapper.deletePostImage(postImageNo);
    }
}
