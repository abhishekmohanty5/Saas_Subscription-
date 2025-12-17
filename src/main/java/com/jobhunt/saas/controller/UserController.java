package com.jobhunt.saas.controller;

import com.jobhunt.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        String res="Works Fine though";
        return ResponseEntity.ok().body(res);
    }

}
