package com;

import com.mybatis.dao.UserDao;
import com.mybatis.vo.User;

public class Demo {

    public static void main(String[] args) {
        try {
            UserDao userDao = new UserDao();
            User user = new User();
            user.setName("chen");
            user.setAge(1);
            userDao.add2(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
