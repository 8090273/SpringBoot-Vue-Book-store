package com.teen.book_store.Controller;

import com.teen.book_store.Bean.Book;
import com.teen.book_store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 本业务使用service接口
 * @author teen
 * @create 2021/11/25 17:52
 */
@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/shoppingCart/addBook")
    public String addBookToShoppingCart(@RequestParam("username") String username,
                                        @RequestParam("id") Long bookId){

        if(shoppingCartService.addBook(username,bookId) == 1)
            return "添加成功 ";
        return "已经添加到购物车了哦";
    }

    @PostMapping("/shoppingCart/selectBook")
    public List<Book> selectByUser(@RequestParam("username") String username){

        return shoppingCartService.selectByUsername(username);
    }

    @PostMapping("/shoppingCart/deleteBook")
    public String deleteBook(@RequestParam("username") String username,
                             @RequestParam("bookId") Long bookId){
        return shoppingCartService.deleteByBookId(username,bookId);
    }
}
