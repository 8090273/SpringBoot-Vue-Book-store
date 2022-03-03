package com.teen.book_store;

import com.teen.book_store.Bean.Book;
import com.teen.book_store.Bean.User;
import com.teen.book_store.Mapper.AuthorMapper;
import com.teen.book_store.Mapper.BookMapper;
import com.teen.book_store.Mapper.UserMapper;
import com.teen.book_store.Mapper.UserShelfMapper;
import com.teen.book_store.service.*;
import com.teen.book_store.service.serviceImpl.AuthorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SpringBootTest
class BookStoreApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    AuthorMapper authorMapper;

    @Autowired
    UserShelfMapper userShelfMapper;

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    OrderFormService orderFormService;

    @Test
    void contextLoads() {
    }

    @Test
    void getUserByUsernameTest(){
        User user = userMapper.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    void saveUserTest(){
        User user = new User();
        user.setEmail("123456@123.com");
        user.setUsername("TestUserSave");
        user.setPassword("123456");
        userService.save(user);
    }

    //测试查询所有书籍
    @Test
    void selectAllBookTest(){
        System.out.println(bookService.list());

        /*输出结果:
        * [
        * Book{id=1, name='java从入门到放弃', author='国哥', price=80.0, sales=9999, stock=9, img_path='img/img.jpg'},
        * Book{id=2, name='数据结构与算法', author='严敏君', price=78.5, sales=6, stock=13, img_path='img/img.jpg'},
        * Book{id=3, name='怎样拐跑别人的媳妇', author='龙伍', price=68.0, sales=99999, stock=52, img_path='img/img.jpg'},
        * Book{id=4, name='木虚肉盖饭', author='小胖', price=16.0, sales=1000, stock=50, img_path='img/img.jpg'},
        * Book{id=5, name='C++编程思想', author='刚哥', price=45.5, sales=14, stock=95, img_path='img/img.jpg'},
        * Book{id=6, name='蛋炒饭', author='周星星', price=9.9, sales=12, stock=53, img_path='img/img.jpg'},
        * Book{id=7, name='赌神', author='龙伍', price=66.5, sales=125, stock=535, img_path='img/img.jpg'},
        * Book{id=8, name='Java编程思想', author='阳哥', price=99.5, sales=47, stock=36, img_path='img/img.jpg'},
        * Book{id=9, name='JavaScript从入门到精通', author='婷姐', price=9.9, sales=85, stock=95, img_path='img/img.jpg'},
        * Book{id=10, name='cocos2d-x游戏编程入门', author='国哥', price=49.0, sales=52, stock=62, img_path='img/img.jpg'},
        * Book{id=11, name='C语言游戏设计', author='谭浩强', price=88.0, sales=95, stock=74, img_path='img/img.jpg'},
        * Book{id=12, name='Lua语言程序设计', author='雷丰阳', price=51.5, sales=48, stock=82, img_path='img/img.jpg'},
        * Book{id=13, name='西游记', author='罗贯中', price=12.0, sales=19, stock=9999, img_path='img/img.jpg'},
        * Book{id=14, name='水浒传', author='华仔', price=33.05, sales=22, stock=88, img_path='img/img.jpg'},
        * Book{id=15, name='操作系统原理', author='刘优', price=133.05, sales=122, stock=188, img_path='img/img.jpg'},
        * Book{id=16, name='数据结构 java版', author='封大神', price=173.15, sales=21, stock=81, img_path='img/img.jpg'},
        * Book{id=17, name='UNIX高级环境编程', author='乐天', price=99.15, sales=210, stock=810, img_path='img/img.jpg'},
        * Book{id=19, name='大话设计模式', author='国哥', price=89.15, sales=20, stock=10, img_path='img/img.jpg'},
        * Book{id=20, name='人月神话', author='刚哥', price=88.15, sales=20, stock=80, img_path='img/img.jpg'}
        * ]
         */
    }

    @Test
    void initBooksTest(){
        System.out.println(bookMapper.initBooks());
    }

    @Test
    void selectLikeBook(){
        System.out.println(bookMapper.selectBooks("哥"));
    }
    @Test
    void selectRandomBookTest(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            books.add(bookMapper.selectRandomBook());
        }
        System.out.println(books);

        /*[
        Book{id=1, name='java从入门到放弃', author='国哥', price=80.0, sales=9999, stock=9, img_path='img/img.jpg'},
        Book{id=16, name='数据结构 java版', author='封大神', price=173.15, sales=21, stock=81, img_path='img/img.jpg'},
        Book{id=16, name='数据结构 java版', author='封大神', price=173.15, sales=21, stock=81, img_path='img/img.jpg'},
        Book{id=14, name='水浒传', author='华仔', price=33.05, sales=22, stock=88, img_path='img/img.jpg'},
        Book{id=2, name='数据结构与算法', author='严敏君', price=78.5, sales=6, stock=13, img_path='img/img.jpg'},
        Book{id=9, name='JavaScript从入门到精通', author='婷姐', price=9.9, sales=85, stock=95, img_path='img/img.jpg'},
        Book{id=16, name='数据结构 java版', author='封大神', price=173.15, sales=21, stock=81, img_path='img/img.jpg'},
        Book{id=16, name='数据结构 java版', author='封大神', price=173.15, sales=21, stock=81, img_path='img/img.jpg'},
        Book{id=10, name='cocos2d-x游戏编程入门', author='国哥', price=49.0, sales=52, stock=62, img_path='img/img.jpg'},
        Book{id=5, name='C++编程思想', author='刚哥', price=45.5, sales=14, stock=95, img_path='img/img.jpg'},
        Book{id=12, name='Lua语言程序设计', author='雷丰阳', price=51.5, sales=48, stock=82, img_path='img/img.jpg'},
        Book{id=6, name='蛋炒饭', author='周星星', price=9.9, sales=12, stock=53, img_path='img/img.jpg'}]
         */
    }

    @Test
    void selectBookDetailsTest(){
        System.out.println(bookMapper.selectBookDetails(3));
    }

    @Test
    void selectAuthorTest(){
        System.out.println(authorMapper.getAuthorByName("国哥"));
    }

    @Test
    void selectBookByPageTest(){
        System.out.println(bookMapper.selectBookByPage(0,10));
        /*
        [
            Book{id=1, name='java从入门到放弃', author='国哥', price=80.0, sales=9999, stock=9, img_path='img/img.jpg'},
            Book{id=2, name='数据结构与算法', author='严敏君', price=78.5, sales=6, stock=13, img_path='img/img.jpg'},
            Book{id=3, name='怎样拐跑别人的媳妇', author='龙伍', price=68.0, sales=99999, stock=52, img_path='img/img.jpg'},
            Book{id=4, name='木虚肉盖饭', author='小胖', price=16.0, sales=1000, stock=50, img_path='img/img.jpg'},
            Book{id=5, name='C++编程思想', author='刚哥', price=45.5, sales=14, stock=95, img_path='img/img.jpg'},
            Book{id=6, name='蛋炒饭', author='周星星', price=9.9, sales=12, stock=53, img_path='img/img.jpg'},
            Book{id=7, name='赌神', author='龙伍', price=66.5, sales=125, stock=535, img_path='img/img.jpg'},
            Book{id=8, name='Java编程思想', author='阳哥', price=99.5, sales=47, stock=36, img_path='img/img.jpg'},
            Book{id=9, name='JavaScript从入门到精通', author='婷姐', price=9.9, sales=85, stock=95, img_path='img/img.jpg'},
            Book{id=10, name='cocos2d-x游戏编程入门', author='国哥', price=49.0, sales=52, stock=62, img_path='img/img.jpg'}]
        */
    }

    @Test
    void selectBookCountTest(){
        System.out.println(bookService.count());
    }

    @Test
    void saveBookIdTest(){
        try {
            userShelfMapper.saveBookId("杜金文", 38L);
            System.out.println("添加成功");
        }catch (Exception e){
            System.out.println("添加失败");
        }

    }

    @Test
    void selectBookIdTest(){
        if(userShelfMapper.selectBookId("teen123", 1L) == 1){
            System.out.println("已添加过了");
        }else {
            System.out.println("添加成功");
        }

    }

    @Test
    void selectByUsernameTest(){
        System.out.println(userShelfMapper.selectByUsername("teen123"));
        /*
        UserShelf{
            username='teen123',
            books=[
                Book{id=1, name='java从入门到放弃', author='国哥', price=188.0, sales=0, stock=9, img_path='img/img.jpg'},
                Book{id=2, name='数据结构与算法', author='严敏君', price=78.5, sales=6, stock=13, img_path='img/img.png'}
                ]
         }
        * */
    }

    @Test
    void deleteByBookIdTest(){
        System.out.println(userShelfMapper.deleteByBookId("teen123", 2L));
    }

    @Test
    void addBookToShoppingCartTest(){
        if(shoppingCartService.addBook("teen123",1L) == 1)
        {
            System.out.println("添加成功");
        }else {
            System.out.println("已经在购物车里了");
        }
    }

    @Test
    void selectOrderFormByUsernameTest(){
        System.out.println(orderFormService.selectByUsername("teen123"));
        /*
        * [
        *   OrderForm{
        *       id=1464885728896536578,
        *       username='teen123',
        *       date='2021-11-28 17:15:48',
        *       address='河南省郑州市新郑市郑州升达经贸管理学院',
        *       totalPrice=263.9,
        *       phoneNumber='18737283528',
        *       orderFormItemList=[
        *           OrderFormItem{id=1464885728896536578, bookId=1, bookNum=1, price=188.0},
        *           OrderFormItem{id=1464885728896536578, bookId=4, bookNum=1, price=66.0},
        *           OrderFormItem{id=1464885728896536578, bookId=9, bookNum=1, price=9.9}
        *       ]
        *   }
        * ]
        */
    }

    @Test
    void md5Test(){
        String password = "root123";
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        System.out.println(md5Password);

    }

    @Test
    void test01(){
        Testq testq = new Testq();
        System.out.println(testq.b);
    }
}
class Testq{
    byte a;
    long b;
    float c;

    @Override
    public String toString() {
        return "Testq{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
