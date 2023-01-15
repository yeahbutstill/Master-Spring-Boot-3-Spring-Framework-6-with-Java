package com.yeahbutstill.controller;

import com.yeahbutstill.service.impl.LoginAuthenticationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
@Slf4j
public class LoginController {

    private final LoginAuthenticationServiceImpl loginAuthenticationService;

    @Autowired
    public LoginController(LoginAuthenticationServiceImpl loginAuthenticationService) {
        this.loginAuthenticationService = loginAuthenticationService;
    }

    @GetMapping(value = "/login")
    public String goToLogginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String goToWellcomePage(@RequestParam String username, @RequestParam String password, ModelMap modelMap) {
        if (Boolean.TRUE.equals(loginAuthenticationService.authenticate(username, password))) {
            modelMap.put("username", username);
            return "wellcome";
        }

        modelMap.put("errorMessage", "Invalid Credentials, please try again");
        return "login";
    }

}
