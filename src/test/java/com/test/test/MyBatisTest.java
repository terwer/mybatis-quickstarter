package com.test.test;

import com.test.dao.IUserDao;
import com.test.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test1() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        // List<User> users = sqlSession.selectList("user.findAll");

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        User user = new User();
        user.setUsername("哈哈1");

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.saveUser(user);

        // sqlSession.insert("user.saveUser", user);
        // 注意：一定要提交事务
        // sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test3() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        User user = new User();
        user.setId(5);
        user.setUsername("dali");

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.updateUser(user);

        //  sqlSession.insert("user.updateUser", user);
        // 注意：一定要提交事务
        // sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void test4() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.deleteUser(8);

        // sqlSession.insert("user.deleteUser", 8);
        // 注意：一定要提交事务
        // sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test5() throws Exception {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> all = userDao.findAll();

        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test6() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        User user = new User();
        user.setId(1);
        user.setUsername("tyw");
        List<User> all = userDao.findByCondition(user);

        for (User user1 : all) {
            System.out.println(user1);
        }

        sqlSession.close();
    }

    @Test
    public void test7() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        Integer[] ids = {1, 2};
        List<User> all = userDao.findByIds(ids);

        for (User user1 : all) {
            System.out.println(user1);
        }

        sqlSession.close();
    }
}
