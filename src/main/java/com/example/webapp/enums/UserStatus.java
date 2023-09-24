package com.example.webapp.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum UserStatus {
    NORMAL(1, "正常"),
    FREEZE(2, "冻结"),
    ;

    UserStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @EnumValue
    private final int value;

    @JsonValue
    private final String description;
}
