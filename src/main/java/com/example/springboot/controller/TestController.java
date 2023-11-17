package com.example.springboot.controller;

import com.example.springboot.GlobalException.GlobalException;
import com.example.springboot.response.CodeMsg;
import com.example.springboot.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.example.springboot.entity.UserInfo;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户信息管理")
@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfo userInfo;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @GetMapping("/queryAll")
    @ResponseBody
    @ApiOperation(value="查询所有用户信息")
    public List<UserInfo> queryUserList() throws Exception{
        List<UserInfo> userInfoList = userService.queryUserList();
        log.debug(String.valueOf("------->"+userInfoList));
        return userInfoList;
    }

    /**
     * 根据用户明查询用户信息
     * @return
     * @throws Exception
     */
   // @RequestMapping("/queryUserInfo")
    @PostMapping("/queryUserInfo")
    @ResponseBody
    @ApiOperation(value="根据用户名查询用户信息")
    public UserInfo queryUserList(@RequestBody UserInfo userInfo) throws Exception{
        log.debug("前端上送参数------->"+userInfo);
        UserInfo user = userService.queryUserInfo(userInfo);
        return user;
    }

    /**
     * 登录
     * @param userInfo
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value="用户登录")
    public UserInfo login(@RequestBody UserInfo userInfo) throws Exception{
        UserInfo user = userService.queryUserInfo(userInfo);
        if(user == null){
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        String password = user.getPassword();
        String passwordLogin = userInfo.getPassword();
        if(!password.equals(passwordLogin)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        return user;
    }

    /**
     * 注册
     * @param userInfo
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    @ResponseBody
    @ApiOperation(value="用户注册")
    public Result<String> register(@RequestBody UserInfo userInfo) throws Exception{
        UserInfo user = userService.queryUserInfo(userInfo);
        if(user != null){
            throw new GlobalException(CodeMsg.USER_EXIST_ERROR);
        }
        userService.regist(userInfo);
        return Result.success("用户："+userInfo.getUserName()+" 注册成功！");
//        return user;
    }
    /**
     * 编辑用户信息
     * @param userInfo
     * @return
     * @throws Exception
     */
    @PostMapping("/edit")
    @ResponseBody
    @ApiOperation(value="修改用户信息")
    public Result<String> edit(@RequestBody UserInfo userInfo) throws Exception{
        userService.edit(userInfo);
        return Result.success("用户："+userInfo.getUserName()+" 注册成功！");
//        return user;
    }
}
