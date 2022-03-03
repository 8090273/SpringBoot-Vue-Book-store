package com.teen.book_store.Controller;

import com.teen.book_store.Bean.Author;
import com.teen.book_store.Mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author teen
 * @create 2021/11/18 16:21
 */

@RestController
public class SelectAuthor {

    @Autowired
    AuthorMapper authorMapper;

    @PostMapping("/selectAuthor")
    public Author selectAuthor(@RequestParam("authorName") String authorName){
        return authorMapper.getAuthorByName(authorName);
    }
}
