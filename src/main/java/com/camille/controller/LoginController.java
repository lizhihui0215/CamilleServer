package com.camille.controller;

import com.camille.domain.UserService;
import com.camille.model.ResponseObject;
import com.camille.model.TUser;
import com.camille.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class LoginController {

    private UserService userService;

    private TUserService tUserService;

    @Autowired
    public LoginController(UserService userService, TUserService tUserService) {
        this.userService = userService;
        this.tUserService = tUserService;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseObject<User> loginWith(@RequestBody Map<String, String> parameters){
        User user = this.userService.findFirstByUsername(parameters.get("username"));

        if (user == null) return new ResponseObject<User>(1,"the user may not exists!", null);

        if (!user.getPassword().equals(parameters.get("password"))) return new ResponseObject<User>(1,"the password was wrong!", null);



        return new ResponseObject<User>(0,"success",user);
    }


    @PostMapping("/api/test")
    @ResponseBody
    public ResponseObject<TUser> testWith(@RequestBody Map<String, String> parameters){
        TUser user = this.tUserService.findFirstByUsername(parameters.get("username"));

        if (user == null) return new ResponseObject<TUser>(1,"the user may not exists!", null);

        if (!user.getPassword().equals(parameters.get("password"))) return new ResponseObject<TUser>(1,"the password was wrong!", null);

        return new ResponseObject<TUser>(0,"success",user);
    }

}
