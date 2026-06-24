package com.human.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.human.www.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}