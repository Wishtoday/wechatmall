package com.example.springboot.GlobalException;

import com.example.springboot.response.CodeMsg;
import com.example.springboot.response.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice //该注解定义全局异常处理类
//@ControllerAdvice(basePackages ="com.example.demo.controller") 可指定包
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class) //该注解声明异常处理方法
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        //对于自定义异常的处理
        if(e instanceof GlobalException) {
            GlobalException ex = (GlobalException)e;
            return Result.error(ex.getCm());
            //对于绑定异常的处理，使用jsr303中的自定义注解抛出的异常属于绑定异常
        }else if(e instanceof BindException) {
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
