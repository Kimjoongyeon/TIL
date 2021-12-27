package com.example.EverydayTraining.diner.DTO;


import com.example.EverydayTraining.diner.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private String userId;
    private String password;
    private String email;
    private String name;
    private String birth;
    private String sex;
    private String phone;

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .email(email)
                .name(name)
                .birth(birth)
                .sex(sex)
                .phone(phone)
                .build();
    }

}
