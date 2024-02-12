package com.example.spring.test.bts.helpers;

import com.example.spring.test.bts.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static ResponseModel baseResponse(String message, Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        res.setData(data);
        return res;
    }

    public static ResponseModel baseResponse(String message) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        return res;
    }

    public static Map<String, Object> baseResponseMap(String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("data", data);
        return result;
    }

    public static Map<String, Object> baseResponseMap(String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("data", null);
        return result;
    }

    public static ResponseEntity<ResponseModel> success() {
        ResponseModel res = new ResponseModel();
        res.setMesage("Success");
        return ResponseEntity.ok().body(res);
    }

    public static ResponseEntity<ResponseModel> success(Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage("Success");
        res.setData(data);
        return ResponseEntity.ok().body(res);
    }

    public static ResponseEntity<ResponseModel> created(Object data) {
        return new ResponseEntity<>(baseResponse("Created", data), HttpStatus.CREATED);
    }

    public static ResponseEntity<ResponseModel> unprocessableEnity(String message) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        return ResponseEntity.unprocessableEntity().body(res);
    }

    public static ResponseEntity<ResponseModel> badRequest() {
        ResponseModel res = new ResponseModel();
        res.setMesage("Bad Request");
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<ResponseModel> badRequest(Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage("Bad Request");
        res.setData(data);
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<Object> badRequestObject(Object data) {
        return ResponseEntity.badRequest().body(baseResponseMap("Bad Request", data));
    }

    public static ResponseEntity<ResponseModel> badRequest(String message) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<ResponseModel> badRequest(String message, Object data) {
        ResponseModel res = new ResponseModel();
        res.setMesage(message);
        res.setData(data);
        return ResponseEntity.badRequest().body(res);
    }

    public static ResponseEntity<ResponseModel> notFound(String message) {
        return new ResponseEntity<>(baseResponse(message), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<ResponseModel> notFound() {
        return new ResponseEntity<>(baseResponse("Not found"), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<ResponseModel> forbidden() {
        return new ResponseEntity<>(baseResponse("Forbidden"), HttpStatus.FORBIDDEN);
    }
}
