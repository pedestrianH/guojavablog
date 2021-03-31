package cn.guojava.controller;

import cn.guojava.entity.User;
import cn.guojava.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RegisterController {
    @Autowired
    private RegisterMapper registerMapper;


    @PostMapping("/api/register")
    public void registerUser(@RequestBody User user){
        registerMapper.registerUser(user);
    }
}
