package com.example.webapp.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webapp.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author waves
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
