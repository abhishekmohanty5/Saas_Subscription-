package com.jobhunt.saas.service;

import com.jobhunt.saas.dto.RegRequest;
import com.jobhunt.saas.dto.RegResponse;
import com.jobhunt.saas.entity.Role;
import com.jobhunt.saas.entity.Users;
import com.jobhunt.saas.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
   private  UserRepo userRepo;
   @Autowired
  private PasswordEncoder passwordEncoder ;
    public RegResponse addUser(RegRequest requestDto){
        Users user = new Users();

        user.setUsername(requestDto.getUserName());
        user.setEmail(requestDto.getEmail());

        user.setRole(Role.ROLE_USER);

        String pas=requestDto.getPassword();

        String hashPassword = passwordEncoder.encode(pas);
        user.setPassword(hashPassword);

        //save In Db
        userRepo.save(user);

        return new RegResponse(user.getUsername(), user.getEmail());
    }

    public Users getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }
}
