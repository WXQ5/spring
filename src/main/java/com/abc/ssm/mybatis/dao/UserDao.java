package com.abc.ssm.mybatis.dao;

import com.abc.ssm.mybatis.dao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findById(@Param("userId") Integer id);
    List<User> findAll();
    List<User> findByPage(@Param("start") Integer start,@Param("size") Integer size);
    List<User> findByName(@Param("username") String username);
    int save( User user);//未测试部分
    int update( User user);
    int delete(@Param("userId") Integer userId);

}
