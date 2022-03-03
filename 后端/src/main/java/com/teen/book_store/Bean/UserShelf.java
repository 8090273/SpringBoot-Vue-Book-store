package com.teen.book_store.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**用户书架
 * @author teen
 * @create 2021/11/24 8:45
 */
@TableName("user_shelf")
public class UserShelf {
    private String username;
    @TableField(exist = false)
    private List<Book> books;

    public UserShelf() {
    }

    public UserShelf(String username, List<Book> books) {
        this.username = username;
        this.books = books;
    }

    @Override
    public String toString() {
        return "UserShelf{" +
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
