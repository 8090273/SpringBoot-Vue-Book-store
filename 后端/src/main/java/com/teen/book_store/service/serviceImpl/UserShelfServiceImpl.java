package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.UserShelf;
import com.teen.book_store.Mapper.UserShelfMapper;
import com.teen.book_store.service.UserShelfService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/11/24 8:56
 */
@Service
public class UserShelfServiceImpl extends ServiceImpl<UserShelfMapper, UserShelf> implements UserShelfService {
}
