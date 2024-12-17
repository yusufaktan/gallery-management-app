package com.aktanyusuf.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.aktanyusuf.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException exception, WebRequest request){
        return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
    }
    
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
    	Map<String, List<String>> map = new HashMap<>();
    	for (ObjectError objectError : exception.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) objectError).getField();
			if (map.containsKey(fieldName)) {
				map.put(fieldName, addValue(map.get(fieldName), objectError.getDefaultMessage()));
			}else {
				map.put(fieldName, addValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(map, request));
	}
    
    private List<String> addValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;
	}

    public <E> ApiError<E> createApiError(E message, WebRequest request){
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);

        apiError.setException(exception);
        return apiError;
    }

    private String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
