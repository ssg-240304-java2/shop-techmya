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
public class ReplyDTO {
    private int responseNo;
    private String responseContent;
    private Date createdDate;
    private boolean isPublic;
    private int userNo;
    private int postNo;
}
