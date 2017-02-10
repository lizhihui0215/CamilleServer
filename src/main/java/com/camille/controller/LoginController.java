package com.camille.controller;

import com.camille.domain.UserService;
import com.camille.model.ResponseObject;
import com.camille.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by lizhihui on 08/02/2017.
 *
 */
@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseObject<User> loginWith(@RequestBody Map<String, String> parameters){
        User user = this.userService.findByUsernameAndPassword(parameters.get("username"), parameters.get("password"));

        return new ResponseObject<User>(0,"success",user);
    }

}
