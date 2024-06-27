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
public class PostImageDTO {
    private int postImageNo;
    private String postImageOrgFileName;
    private String postImageStoredFileName;
    private Date createdDate;
    private boolean isDeleted;
    private int postNo;
}
