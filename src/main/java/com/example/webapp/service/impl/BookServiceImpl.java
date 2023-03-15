package com.example.webapp.service.impl;

import com.example.webapp.controller.Code;
import com.example.webapp.dao.BookDao;
import com.example.webapp.domain.Book;
import com.example.webapp.exception.BusinessException;
import com.example.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    public Book getById(Integer id) {
        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERR,"请不要使用你的技术挑战我的耐性!");
        }
        return bookDao.selectById(id);
    }

    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
