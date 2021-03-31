package cn.guojava.controller;

import cn.guojava.entity.User;
import cn.guojava.mapper.LoginMapper;
import cn.guojava.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginMapper loginMapper;

    @PostMapping ("/api/login")
    public Map<String,Object> login(@RequestBody User user){
        System.out.println("====================");





        User user1 =  loginMapper.login(user);
        if(user1 !=null){
            System.out.println(user1);

            Map<String,Object> userInfo = new HashMap<>();
            userInfo.put("user",user1);
            String token = TokenUtil.getToken(user1.getId(),user1.getUsername());
            System.out.println(TokenUtil.getTokenTnfo(token));
            userInfo.put("token",token);


            return userInfo;
        }else {
            return null;
        }

    }
}
