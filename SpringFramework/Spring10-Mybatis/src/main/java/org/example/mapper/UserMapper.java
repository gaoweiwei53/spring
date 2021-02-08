package org.example.mapper;

import org.example.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUser();

    //添加一个用户
    public int addUser(User user);

    // 删除一个user

    public int deleteUser(int id);
}
