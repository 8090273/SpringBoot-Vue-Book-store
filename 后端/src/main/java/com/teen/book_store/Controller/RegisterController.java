package com.teen.book_store.Controller;

import com.teen.book_store.Bean.User;
import com.teen.book_store.Mapper.UserMapper;
import com.teen.book_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;

/**
 * @author teen
 * @create 2021/11/13 19:26
 */
@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/registerServer")
    public boolean login(User user){
        //如果前端传来的数据中 通过用户名可以查询到数据
        if(userMapper.getUserByUsername(user.getUsername()) != null){
            //提示用户名已存在 终止注册
            System.out.println("用户名已存在");
            System.out.println(userMapper.getUserByUsername(user.getUsername()));
            //返回失败信息给前端
            return false;
        }
        //将用户的密码使用MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        //调用service层保存用户信息
        userService.save(user);
        System.out.println("注册成功");
        //返回注册成功信息给前端
        return true;
    }
}
