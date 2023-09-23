package com.example.webapp.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Book", description = "图书")
public class Book {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;
}
