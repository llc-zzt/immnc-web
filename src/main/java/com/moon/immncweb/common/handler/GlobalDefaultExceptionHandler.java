package com.moon.immncweb.common.handler;

import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.common.exception.APIException;
import com.moon.immncweb.common.exception.WebAuthorizeException;
import lombok.extern.log4j.Log4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/01
 * @Desc 全部异常拦截统一处理
 */
@ControllerAdvice(basePackages = "com.moon.immncweb.core")
@Log4j
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        String s = "参数验证失败";
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            s = errors.get(0).getDefaultMessage();
        }
        return ResponseVO.builder().code(-100).msg(s).build();
    }
    @ExceptionHandler(WebAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("");
    }

    @ExceptionHandler(APIException.class)
    @ResponseBody
    public ResponseVO apiException(APIException a){
        return ResponseVO.builder().code(a.getStatus()).msg(a.getMsg()).build();
    }

}
