package com.gao.mybatis.mapper;

import com.gao.mybatis.domain.UserInfo;
import com.gao.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends MyMapper<UserInfo> {

    int saveUser(UserInfo user);

    // @Select("select * from user;")
    /*由于在MyBatisMapper.xml中配置了getUserList方法及sql 可以不写@Select注解
    如果重复配置 启动时会报错: Mapped Statements collection already contains value for
    com.gao.mybatis.mapper.UserMapper.getUserList*/
    List<UserInfo> getUserList();

    UserInfo getById(Integer id);

    @Select("select * from t_user where account=#{account}")
    UserInfo findByAccount(String account);
}
