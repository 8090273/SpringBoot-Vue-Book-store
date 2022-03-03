package com.teen.book_store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teen.book_store.Bean.Book;
import com.teen.book_store.Bean.ShoppingCart;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/25 18:35
 */
public interface ShoppingCartService extends IService<ShoppingCart> {
    public Integer addBook(String username,Long bookId);

    public List<Book> selectByUsername(String username);

    public String deleteByBookId(String username,Long bookId);
}
