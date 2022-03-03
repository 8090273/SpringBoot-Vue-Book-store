package com.teen.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.book_store.Bean.UserShelf;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author teen
 * @create 2021/11/24 8:53
 */
@Mapper
public interface UserShelfMapper extends BaseMapper<UserShelf> {
    public Integer saveBookId(String username,Long bookId);

    public int selectBookId(String username,Long bookId);

    public UserShelf selectByUsername(String username);

    public Integer deleteByBookId(String username, Long bookId);
}
