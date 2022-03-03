package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.Author;
import com.teen.book_store.Mapper.AuthorMapper;
import com.teen.book_store.service.AuthorService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/11/18 16:25
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper,Author> implements AuthorService {
}
