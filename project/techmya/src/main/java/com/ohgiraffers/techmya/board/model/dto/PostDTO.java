package com.ohgiraffers.techmya.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
    private Integer postNo;
    private String postTitle;
    private String postContent;
    private Boolean isPublic;
    private Date createdDate;
    private Integer userNo;
    private Integer boardNo;
    private String boardTypeName;
    private List<PostImageDTO> postImages;  // 추가된 속성
}
