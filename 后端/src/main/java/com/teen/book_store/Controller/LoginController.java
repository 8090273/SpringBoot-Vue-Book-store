package com.teen.book_store.Controller;

import com.teen.book_store.Bean.User;
import com.teen.book_store.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


/**
 * @author teen
 * @create 2021/11/10 21:13
 */

@Controller
public class LoginController {

    //将Mapper自动注入
    @Autowired
    UserMapper userMapper;

    //编写登录业务
    /**
     *
     * @param user 直接将前端的数据封装为对象
     * @return 返回值虽然为字符串，但前端会自动解析为布尔值
     */
    @ResponseBody
    @PostMapping("/Login")
    public Map login(User user) {
        //将前端传来的密码进行md5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        //根据user的username去数据库查询对应的数据,并将查询到的数据封装到daoUser对象中
        User daoUser = userMapper.getUserByUsername(user.getUsername());

        //创建map用来返回map类型给浏览器
        Map<Object, Object> map = new HashMap<>();

        System.out.println(daoUser);
        //如果查到了登录账号
        if (daoUser !=null){
                //小bug，不能用 == ,必须使用 .equals
            if (daoUser.getPassword().equals(user.getPassword()) ){
                //如果查到的账号密码与用户提交的密码相同
                System.out.println("登陆成功");
                map.put("success",true);
                map.put("message","登陆成功!");
                return map;
            }else {
                //否则提示密码错误
                map.put("success",false);
                map.put("message","密码错误");
                System.out.println("密码错误");
                return map ;
            }
        }
        //否则提示输入正确的用户名
        map.put("success",false);
        map.put("message","请输入正确的用户名!");
        System.out.println("请输入正确的用户名");
        return map;
    }
}
