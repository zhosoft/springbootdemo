package com.zhosoft.springbootdemo.mapper;

import com.zhosoft.springbootdemo.dao.UserDao;

public interface UserMapper {
    public void insertUser(UserDao userDao);
    public Object selectUserList(int id);
}
