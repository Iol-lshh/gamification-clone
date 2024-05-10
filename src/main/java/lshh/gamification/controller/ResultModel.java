package lshh.gamification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ResultModel <T>{
    HttpStatusCode code;
    String message;
    T data;

    public ResultModel(){
        this.code = HttpStatus.OK;
        this.message = "SUCCESS";
    }
    public ResultModel(T object){
        this.code = HttpStatus.OK;
        this.message = "SUCCESS";
        this.data = object;
    }
    public static ResultModel<?> success(){
        return new ResultModel<>();
    }
    public static <T> ResultModel<T> success(T object){
        return new ResultModel<>(object);
    }
    public static ResultModel<?> notFound(){
        ResultModel<?> result = new ResultModel<>();
        result.code = HttpStatus.NOT_FOUND;
        result.message = "등록된 데이터를 찾을 수 없습니다.";
        return result;
    }
    public static ResultModel<?> badRequest(){
        ResultModel<?> result = new ResultModel<>();
        result.code = HttpStatus.BAD_REQUEST;
        result.message = "필수 파라미터가 부족합니다.";
        return result;
    }
    public static ResultModel<?> unauthorized(){
        ResultModel<?> result = new ResultModel<>();
        result.code = HttpStatus.UNAUTHORIZED;
        result.message = "권한 없습니다.";
        return result;
    }
    public static ResultModel<?> Forbidden(){
        ResultModel<?> result = new ResultModel<>();
        result.code = HttpStatus.FORBIDDEN;
        result.message = "요청이 거부되었습니다.";
        return result;
    }
    public static ResultModel<?> InternalServerError(){
        ResultModel<?> result = new ResultModel<>();
        result.code = HttpStatus.INTERNAL_SERVER_ERROR;
        result.message = "오류가 발생하였습니다.";
        return result;
    }
    public static ResultModel<?> withHttpStatusCode(HttpStatusCode code){
        ResultModel<?> result = new ResultModel<>();
        result.code = code;
        result.message = code.toString();
        return result;
    }
}
