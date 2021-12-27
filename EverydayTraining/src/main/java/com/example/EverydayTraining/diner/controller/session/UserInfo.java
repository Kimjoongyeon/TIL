package com.example.EverydayTraining.diner.controller.session;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Data
@NoArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String auth;
    private Long memberNo;
}
