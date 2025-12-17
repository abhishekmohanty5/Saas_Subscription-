package com.jobhunt.saas.controller;

import com.jobhunt.saas.dto.AppResponse;
import com.jobhunt.saas.dto.RegRequest;
import com.jobhunt.saas.dto.RegResponse;
import com.jobhunt.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public ResponseEntity<AppResponse<RegResponse>> regUser(@RequestBody RegRequest regRequest){
      RegResponse response= userService.addUser(regRequest);
      AppResponse<RegResponse> appResponse =
              new AppResponse<>("Success",response,200, LocalDateTime.now());
      return ResponseEntity.ok(appResponse);
    }
}
