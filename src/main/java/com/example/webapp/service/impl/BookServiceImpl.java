package com.example.webapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webapp.domain.Book;
import com.example.webapp.service.BookService;
import com.example.webapp.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 13505
* @description 针对表【t_book】的数据库操作Service实现
* @createDate 2023-09-23 17:36:20
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




