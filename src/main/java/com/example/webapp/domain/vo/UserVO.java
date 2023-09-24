package com.example.webapp.domain.vo;

import com.example.webapp.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends User {
    private List<AddressVO> addresses;
}
