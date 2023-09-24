package com.example.webapp.domain.query;

import com.example.webapp.domain.Book;
import lombok.Data;

/**
 * @author waves
 */
@Data
public class PageQuery {
    private int current;
    private int size;
    private Book book;
}
