package com.example.cinemaweb.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class TokenControllerAdvice {

    @ExceptionHandler({RefreshTokenException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Object handleRequestValidationException(Exception ex, HttpServletRequest request) {
        Map<String, Object> responseBody = new LinkedHashMap<>();
         
        responseBody.put("timestamp", new Date());
        responseBody.put("status", HttpStatus.FORBIDDEN.value());
        responseBody.put("error", "Phiên làm việc đã hết hạn. Vui lòng đăng nhập lại!");
        responseBody.put("path", request.getServletPath());
         
        return responseBody;
    }

}
