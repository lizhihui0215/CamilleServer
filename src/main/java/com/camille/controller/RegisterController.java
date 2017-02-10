package com.camille.controller;

import com.camille.domain.UserService;
import com.camille.model.ResponseObject;
import com.camille.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lizhihui on 09/02/2017.
 *
 */
@Controller
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/register")
    @ResponseBody
    public ResponseObject<String> register(@RequestBody User user){
        this.userService.save(user);
        System.out.print(user);
        return new ResponseObject<String>(0, "success","success");
    }
}
