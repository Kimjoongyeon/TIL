package com.example.EverydayTraining.diner.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequest {
    private String userId;
    private String password;
    private String email;
    private String name;
    private String birth;
    private String sex;
    private String phone;
    private int pause;

    private String auth;

    public MemberRequest(String userId, String password, String auth) {
        this.userId = userId;
        this.password = password;
        this.auth = auth;
    }
}
