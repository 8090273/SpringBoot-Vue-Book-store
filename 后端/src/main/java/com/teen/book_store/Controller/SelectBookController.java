package com.teen.book_store.Controller;

import com.teen.book_store.Bean.Book;
import com.teen.book_store.Bean.BookDetails;
import com.teen.book_store.Bean.Page;
import com.teen.book_store.Mapper.BookDetailsMapper;
import com.teen.book_store.Mapper.BookMapper;
import com.teen.book_store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author teen
 * @create 2021/11/14 16:51
 */
@RestController
public class SelectBookController {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookService bookService;

    @Autowired
    BookDetailsMapper bookDetailsMapper;
    /**
     * 初始化前端数据
     * @return 将前10本书返回
     */
    @PostMapping("/initBooks")
    public List initBooks(){
        return bookMapper.initBooks();
    }

    /**
     * 模糊查询 about 作者、书名
     * @param queryString 用户输入的关键字
     * @return
     */
    @PostMapping("/selectBooks")
    public List selectBooks(@RequestParam("selectString") String queryString){
        return bookMapper.selectBooks(queryString);
    }

    /**
     * 随机从数据库中查出12条书籍
     * @return 返回List
     */
    @PostMapping("/selectRandomBook")
    public List selectRandomBook(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            books.add(bookMapper.selectRandomBook());
        }
        return books;
    }

    /**
     * 查询书籍的详细信息，两表连接
     * @param id
     * @return
     */
    @PostMapping("/selectBookDetails")
    public Map selectBookDetails(@RequestParam("id") int id){

        return bookMapper.selectBookDetails(id);
    }

    /**
     * 后台分页查询
     * @param page
     * @return
     */
    @PostMapping("/backstage/selectPage")
    public List selectBookPage(Page page){
        //将page加工后传给sql
        page.setPage((page.getPage()-1)*page.getSize());

        System.out.println(page);
        return bookMapper.selectBookByPage(page.getPage(), page.getSize());
    }

    @PostMapping("/backstage/selectCount")
    public long selectBookCount(){
        return bookService.count();
    }

    @PostMapping("/backstage/updateBook")
    public String updateBookById(Book book){
        System.out.println(book);

        bookMapper.updateById(book);
        return "保存成功";
    }

    @PostMapping("/backstage/delete")
    public String deleteBookById(@RequestParam int id){
        bookMapper.deleteById(id);
        bookDetailsMapper.deleteById(id);

        return "删除成功";
    }

    @PostMapping("/backstage/addBook")
    public String addBook(Book book,
                          HttpSession session){
        //将新书存入t_book表
        bookMapper.insert(book);

        //查询新书的id
        book.setId(bookMapper.selectBooks(book.getName()).get(0).getId());
//        将book.id放入session中传给addBookDetails
        session.setAttribute("id",book.getId());

        System.out.println(book + "书籍添加成功");
        return "添加成功";
    }

    @PostMapping("/backstage/addBookDetails")
    public String addBookDetails(BookDetails bookDetails,
                                 HttpSession session){
        //从session中取出id并存入书籍详情
        bookDetails.setId((Long) session.getAttribute("id"));
        System.out.println(bookDetails+ "书籍详情即将添加");

        //这样可以保证id的一致性
        bookDetailsMapper.insert(bookDetails);
        return "书籍详情添加成功";
    }
}
