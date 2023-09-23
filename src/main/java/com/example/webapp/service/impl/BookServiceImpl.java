package com.example.webapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webapp.controller.Code;
import com.example.webapp.mapper.BookMapper;
import com.example.webapp.domain.Book;
import com.example.webapp.exception.BusinessException;
import com.example.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author waves
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    public Book getById(Integer id) {
        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERR,"请不要使用你的技术挑战我的耐性!");
        }
        return bookMapper.selectById(id);
    }

    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }
}
