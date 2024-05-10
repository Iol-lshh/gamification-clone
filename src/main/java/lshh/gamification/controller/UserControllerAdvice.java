package lshh.gamification.controller;

import lshh.gamification.controller.dto.ResultModel;
import lshh.gamification.domain.user.exception.UserJoinException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(value = UserJoinException.class)
    public ResultModel<?> handleUserCreationException(UserJoinException e) {
        return ResultModel.badRequest();
    }
}
