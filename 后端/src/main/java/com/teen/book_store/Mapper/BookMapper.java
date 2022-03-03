package com.teen.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.book_store.Bean.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author teen
 * @create 2021/11/14 16:52
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
    public List<Book> initBooks();
    //根据书名和作者模糊查询书籍
    public List<Book> selectBooks(String queryString);
    //随机查询出一本书
    public Book selectRandomBook();
    //查看书籍的详细信息
    public Map selectBookDetails(int id);

    //分页查询书籍
    public List<Book> selectBookByPage(int page,int size);
}
