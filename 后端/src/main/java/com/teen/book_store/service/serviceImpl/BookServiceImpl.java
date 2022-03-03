package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.Book;
import com.teen.book_store.Mapper.BookMapper;
import com.teen.book_store.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/11/14 16:54
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
