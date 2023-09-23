package com.example.webapp.mapper;

import com.example.webapp.domain.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 13505
* @description 针对表【t_book】的数据库操作Mapper
* @createDate 2023-09-23 17:36:20
* @Entity com.example.webapp.domain.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




