package com.teen.book_store.Controller;

import com.teen.book_store.Bean.Book;
import com.teen.book_store.Mapper.UserShelfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/24 8:43
 */
@RestController
public class UserHomeController {
    @Autowired
    UserShelfMapper userShelfMapper;

    /**
     * 将书籍加入用户书架
     * @param username
     * @param bookId
     * @return
     */
    @PostMapping("/userHome/addMyShelf")
    public String addUserShelf(@RequestParam("username") String username,
                               @RequestParam("id") Long bookId){

        /*if(userShelfMapper.selectBookId(username,bookId)>=1)
        {
            return "已经在您的书架了哦";
        }*/
        try {
            userShelfMapper.saveBookId(username,bookId);
            return "成功加入书架";
        }catch (Exception e){
            return "已经在您的书架中了";
        }

    }

    /**
     * 查询用户书架
     * @param username
     * @return
     */
    @PostMapping("/userHome/selectBook")
    public List<Book> selectUserShelf(@RequestParam("username") String username){
        return userShelfMapper.selectByUsername(username).getBooks();
    }

    /**
     * 删除用户书架的书
     * @param username
     * @param bookId
     * @return
     */
    @PostMapping("/userHome/deleteMyShelf")
    public String deleteUserShelf(@RequestParam("username") String username,
                                  @RequestParam("id") Long bookId){

        if(userShelfMapper.deleteByBookId(username,bookId) !=1){
            return "删除失败！";
        }
        return "删除成功";
    }
}
