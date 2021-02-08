package org.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    public List<User> getUser() {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.getMapper(UserMapper.class).getUser();
    }

    public int addUser(User user) {
        return 0;
    }

    public int deleteUser(int id) {
        return 0;
    }
}
