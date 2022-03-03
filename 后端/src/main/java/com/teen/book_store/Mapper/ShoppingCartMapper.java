package com.teen.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.book_store.Bean.Book;
import com.teen.book_store.Bean.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/25 17:52
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    public Integer addBook(String username,Long bookId);

    public ShoppingCart selectByUsername(String username);

    public Integer deleteByBookId(String username,Long bookId);
}
