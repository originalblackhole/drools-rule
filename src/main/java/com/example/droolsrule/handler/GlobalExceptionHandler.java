package com.example.droolsrule.handler;

import com.example.droolsrule.common.CommonMessageCode;
import com.example.droolsrule.common.ResponseData;
import com.example.droolsrule.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p></p>
 *
 * @author rui.zhou
 * @date 2021/4/17 16:55
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private String debug = "Exception occurred while processing your request : Cause by ";

    //业务异常统一处理
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)//200
    public ResponseData businessExceptionHandler(BusinessException e) {
        log.error( "An error occurred while processing your request : Cause by "+ e,e);
        return new ResponseData(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)//200
    public ResponseData otherExceptionHandler(Exception e) {
        log.error( "An error occurred while processing your request : Cause by "+ e,e);
        return new ResponseData(CommonMessageCode.UNKNOWN_EXCEPTION);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)//200
    public ResponseData methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.debug(debug + e, e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return new ResponseData(CommonMessageCode.INVALID_ARGUMENT.formatMessage(message));
    }


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)//200
    public ResponseData bindExceptionHandler(BindException e) {
        log.debug(debug + e, e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return new ResponseData(CommonMessageCode.INVALID_ARGUMENT.formatMessage(message));
    }
}
