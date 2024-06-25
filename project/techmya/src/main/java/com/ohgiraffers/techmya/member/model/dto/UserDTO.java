package com.ohgiraffers.techmya.member.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int userNo;
    private String userId;
    private String userPw;
    private String userAuth;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String appendDate;
}