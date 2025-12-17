package com.jobhunt.saas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegResponse {
    private String username;
    private String email;
    private String password;
}
