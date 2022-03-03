package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.User;
import com.teen.book_store.Mapper.UserMapper;
import com.teen.book_store.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/11/11 8:28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
