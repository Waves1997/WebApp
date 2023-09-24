package com.example.webapp.mapper;

import com.example.webapp.domain.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 13505
* @description 针对表【t_address(地址)】的数据库操作Mapper
* @createDate 2023-09-24 00:06:41
* @Entity com.example.webapp.domain.Address
*/
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}




