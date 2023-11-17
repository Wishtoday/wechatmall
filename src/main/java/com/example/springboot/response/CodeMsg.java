package com.example.springboot.response;

public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(-1, "用户不存在");
    public static CodeMsg SERVER_ERROR = new CodeMsg(-9, "系统异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    //登录模块 5002XX
    public static CodeMsg USER_EXIST_ERROR = new CodeMsg(500201, "用户已注册！");
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg STUDENTID_EMPTY = new CodeMsg(500212, "用户名不能为空");
    public static CodeMsg STUDENTID_ERROR = new CodeMsg(500213, "输入格式错误");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }


    private CodeMsg(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

}
