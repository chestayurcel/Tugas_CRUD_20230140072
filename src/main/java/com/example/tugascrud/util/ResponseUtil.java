package com.example.tugascrud.util;

import com.example.tugascrud.model.WebResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<WebResponse<T>> build(String status, String message, T data, int code) {
        WebResponse<T> res = new WebResponse<>();
        res.setStatus(status);
        res.setMessage(message);
        res.setData(data);
        return ResponseEntity.status(code).body(res);
    }
}