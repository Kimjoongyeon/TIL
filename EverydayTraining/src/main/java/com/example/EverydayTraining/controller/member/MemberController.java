package com.example.EverydayTraining.controller.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @PostMapping("/register")
    public ResponseEntity<Boolean> jpaRegister(
            @Validated @RequestBody MemberDTO memberDTO) throws Exception {
        log.info("jpaRegister(): " + memberDTO.getEmail() + ", " + memberDTO.getUserName()
                + ", " + memberDTO.getPassword() + ", " + memberDTO.getPasswordConfirm());

        service.register(memberRequest);

        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }
}
