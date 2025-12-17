package com.jobhunt.saas.controller;

import com.jobhunt.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
   private UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        String res="Works Fine though";
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/demo")
    public ResponseEntity<String> demo(@RequestParam String text){
        String res=text+" is demo";
        return ResponseEntity.ok().body(res);
    }


}
