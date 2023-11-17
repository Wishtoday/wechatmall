package com.example.springboot.service;

import com.example.springboot.entity.UserInfo;

import java.util.List;


public interface UserService {

    /**
     * 用户列表查询
     * @return
     * @throws Exception
     */
    public List<UserInfo> queryUserList() throws Exception;

    /**
     * 注册
     * @param userInfo
     * @return
     * @throws Exception
     */
    public Integer regist(UserInfo userInfo) throws Exception;

    /**
     * 用户信息查询
     * @param userInfo
     * @return
     * @throws Exception
     */
    public UserInfo queryUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     * @throws Exception
     */
    public Integer edit(UserInfo userInfo) throws Exception;
}
