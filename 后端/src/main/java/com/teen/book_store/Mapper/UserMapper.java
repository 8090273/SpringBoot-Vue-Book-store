package com.teen.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.book_store.Bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author teen
 * @create 2021/11/11 8:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public User getUserByUsername(String username);
}
