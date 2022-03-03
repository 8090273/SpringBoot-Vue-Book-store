package com.teen.book_store.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.teen.book_store.Bean.Book;

import java.util.List;

/**购物车
 * @author teen
 * @create 2021/11/23 11:26
 */
@TableName("shopping_cart")
public class ShoppingCart {
    private String username;
    //一个用户的购物车里有多本书，是一对多
    @TableField(exist = false)
    private List<Book> books;

    public ShoppingCart() {
    }

    public ShoppingCart(String username, List<Book> books) {
        this.username = username;
        this.books = books;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "username='" + username + '\'' +
                ", books=" + books +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getbooks() {
        return books;
    }

    public void setbooks(List<Book> books) {
        this.books = books;
    }
}
