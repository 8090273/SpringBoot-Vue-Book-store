package com.teen.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.book_store.Bean.Author;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author teen
 * @create 2021/11/18 16:24
 */
@Mapper
public interface AuthorMapper extends BaseMapper<Author> {
    public Author getAuthorByName(String name);
}
