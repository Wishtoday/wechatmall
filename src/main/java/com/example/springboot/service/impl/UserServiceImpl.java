package com.example.springboot.service.impl;

import com.example.springboot.entity.UserInfo;
import com.example.springboot.mapper.UserInfoMapper;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryUserList() {
       List list = new ArrayList<String>();
       list.add("sdf");
        List<UserInfo> userList = userInfoMapper.queryUserList();
        return userList;
    }

    @Override
    public Integer regist(UserInfo userInfo) throws Exception {
        return userInfoMapper.registUser(userInfo);
    }

    @Override
    public UserInfo queryUserInfo(UserInfo userInfo) throws Exception {
        return userInfoMapper.queryUserInfo(userInfo);
    }

    @Override
    public Integer edit(UserInfo userInfo) throws Exception {
        return userInfoMapper.editUserInfo(userInfo);
    }
}
