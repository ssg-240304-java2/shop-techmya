package com.ohgiraffers.techmya.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
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
}
