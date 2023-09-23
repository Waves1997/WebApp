package com.example.webapp.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.webapp.domain.Book;
import com.example.webapp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
@Api(tags = "图书控制层")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    @ApiOperation(value = "新建图书",httpMethod = "POST")
    public Result save(@ApiParam(value = "图书(book)", required = true) @RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping
    @ApiOperation(value = "新建图书",httpMethod = "PUT")
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "新建图书",httpMethod = "POST")
    public Result delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @DeleteMapping
    public Result delete(@RequestBody Integer[] ids) {
        boolean flag = bookService.removeByIds(new ArrayList<>(List.of(ids)));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "新建图书",httpMethod = "POST")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "数据查询失败，请重试！";
        return new Result(code, book, msg);
    }

    @GetMapping
    @ApiOperation(value = "新建图书",httpMethod = "POST")
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bookList, msg);
    }

    @GetMapping("/pages")
    public Result page(@RequestParam int current, @RequestParam int size, @RequestParam(required = false) String name, @RequestParam(required = false) String type) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.eq("name",name);
        }
        if(!StringUtils.isEmpty(type)){
            queryWrapper.eq("type",type);
        }
        Page<Book> page = bookService.page(Page.of(current, size), queryWrapper);
        List<Book> bookList = page.getRecords();
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, page, msg);
    }

    @GetMapping("/list")
    public Result list(@RequestBody Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Book::getType, book.getType()).eq(Book::getName, book.getName());
        List<Book> bookList = bookService.list(wrapper);
        Integer code = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bookList, msg);
    }
}
