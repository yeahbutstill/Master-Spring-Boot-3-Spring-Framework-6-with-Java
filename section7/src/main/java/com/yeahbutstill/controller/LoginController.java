package com.yeahbutstill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    // login?name=Dani
//    @RequestMapping("/login")
//    public String goToLogginPage(@RequestParam String name, ModelMap modelMap) {
//        modelMap.put("name", name);
//        log.info("Req param is {}", name);
//        return "login";
//    }

    @RequestMapping("/login")
    public String goToLogginPage() {
        return "login";
    }

}
