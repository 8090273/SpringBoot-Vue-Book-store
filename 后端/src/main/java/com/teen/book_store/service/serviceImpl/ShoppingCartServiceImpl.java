package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.Book;
import com.teen.book_store.Bean.ShoppingCart;
import com.teen.book_store.Mapper.ShoppingCartMapper;
import com.teen.book_store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/25 18:35
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public Integer addBook(String username, Long bookId) {

        try {
            Integer count = shoppingCartMapper.addBook(username, bookId);
            return count;
        }catch (Exception e){
            return -1;
        }

    }

    @Override
    public List<Book> selectByUsername(String username) {

        return shoppingCartMapper.selectByUsername(username).getbooks();
    }

    @Override
    public String deleteByBookId(String username, Long bookId) {
        if (shoppingCartMapper.deleteByBookId(username,bookId) == 1)
            return "删除成功";
        return "删除失败";
    }
}
