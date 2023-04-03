package com.example.webapp.domain.dto;

import com.example.webapp.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author waves
 */
@Data
public class Query {
    private int current;
    private int size;
    private Book book;
}
