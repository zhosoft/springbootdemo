package com.zhosoft.springbootdemo.controller;

import com.zhosoft.springbootdemo.dao.UserDao;
import com.zhosoft.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class User {

    @Autowired
    UserMapper userMapper;

//    @Autowired
//    UserDao userDao;

    @RequestMapping("/hello")
    public String list(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("zhangsan");
        arrayList.add("lisi");
        return arrayList.toString();
    }

    @RequestMapping("/map")
    public Object map(){

        Map<String,String> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age","20");
        return map;
    }

    @RequestMapping("/userList2")
    public Object user(){
        UserDao userDao  = new UserDao();
        userDao.setAge(20);
        userDao.setName("张三");
        Map<String,String> m = new HashMap<>();
        m.put("name",userDao.getName());
        m.put("age",userDao.getAge()+"");
        return m;
    }

    @RequestMapping("/insertUser")
    public String insertUser(UserDao userDao){
        userMapper.insertUser(userDao);
        return "添加成功";
    }

    /**
     *
     * 根据id来查询记录
     * @param id
     * @return
     */
    @RequestMapping("/userList/{id}")
    public Object userList(@PathVariable("id") Integer id){
       return userMapper.selectUserList(id);
    }
}
