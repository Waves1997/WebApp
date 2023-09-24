package com.example.webapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webapp.domain.Address;
import com.example.webapp.service.AddressService;
import com.example.webapp.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author 13505
* @description 针对表【t_address(地址)】的数据库操作Service实现
* @createDate 2023-09-24 00:06:41
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

}




