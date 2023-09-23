package com.example.webapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webapp.domain.Book;
import org.apache.ibatis.annotations.*;

/**
 * @author waves
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
