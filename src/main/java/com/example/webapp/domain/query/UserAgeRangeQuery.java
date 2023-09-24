package com.example.webapp.domain.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAgeRangeQuery {
    private Integer maxAge;

    private Integer minAge;
}
