package com.ohgiraffers.techmya.member.model.dto;

import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private int userAuth;
    private LocalDateTime appendDate;
    private int userNo;



    public UserDTO(String userId, String userPw, String userName, String userBirth, String userPhone, String userEmail, LocalDateTime appendDate) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.appendDate = appendDate;
    }
}