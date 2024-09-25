package com.core.handle;

import com.core.domain.Build;
import com.core.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理未定义异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex, HandlerMethod handlerMethod){
        ex.printStackTrace();
        log.error(ex.getClass().getName() + "{}",ex.getMessage());
        return Build.result(500,"服务异常");
    }


    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex, HandlerMethod handlerMethod){
        BindingResult bindingResult = ex.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        String handlerErrorMsg = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        log.error(ex.getClass().getName() + "{}",handlerErrorMsg);
        return Build.result(false,handlerErrorMsg);
    }
}
