package com.yeahbutstill.service.impl;

import com.yeahbutstill.service.LoginAuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationServiceImpl implements LoginAuthenticationService {

    @Override
    public Boolean authenticate(String username, String password) {
        Boolean isValidUsername = username.equalsIgnoreCase("yeahbutstill");
        Boolean isValidPassword = password.equalsIgnoreCase("dummy");
        return isValidUsername && isValidPassword;
    }

}
