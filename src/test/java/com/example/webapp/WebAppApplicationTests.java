package com.example.webapp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.webapp.dao.BookDao;
import com.example.webapp.domain.Book;
import com.example.webapp.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebAppApplicationTests {
    @Autowired
    BookDao bookDao;

    @Test
    void testSave() {
        Book book = new Book();
        book.setId(14);
        book.setName("testName");
        book.setType("testType");
        book.setDescription("testDescription");
        int insert = bookDao.insert(book);
        System.out.println(insert > 0);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(14);
        book.setName("updateName");
        book.setType("updateType");
        book.setDescription("updateDescription");
        int update = bookDao.updateById(book);
        System.out.println(update > 0);
    }

    @Test
    void testDelete() {
        Book book = new Book();
        book.setName("updateName");
        book.setType("updateType");
        book.setDescription("updateDescription");
        int update = bookDao.deleteById(1);
        System.out.println(update > 0);
    }

    @Test
    void testSelectById() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }

    @Test
    void testSelectAll() {
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }

    /**
     * 分页查询
     */
    @Test
    void testSelectPages(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }

    /**
     * 条件查询
     */
    @Test
    void testSelect(){
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(Book::getId,3).lt(Book::getId,7);
        for (Book book : bookDao.selectList(wrapper)) {
            System.out.println(book.getName());
        }
    }
}
