package com.abc.dao.idao;

import com.abc.dao.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    int exist(@Param("username") String username) ;

    User login(User user);
}
