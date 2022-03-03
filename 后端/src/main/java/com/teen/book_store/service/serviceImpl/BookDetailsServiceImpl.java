package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.BookDetails;
import com.teen.book_store.Mapper.BookDetailsMapper;
import com.teen.book_store.service.BookDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/11/22 9:28
 */
@Service
public class BookDetailsServiceImpl extends ServiceImpl<BookDetailsMapper, BookDetails> implements BookDetailsService {
}
