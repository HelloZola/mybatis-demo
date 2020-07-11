package com.mybatis.dao;

import com.mybatis.mapper.UserMapper;
import com.mybatis.utils.MyBatisUtils;
import com.mybatis.vo.User;
import org.apache.ibatis.session.SqlSession;

public class UserDao {

    /*
     * 增加的方法2
     */
    public void add2(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int i = userMapper.insert(user);

            //第二种实现，直接定位mapper方法位置：
            // int i = sqlSession.insert("com.mybatis.mapper.UserMapper.insert", user);

            System.out.println("本次操作影响了" + i + "行数据");

            //事务提交
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}