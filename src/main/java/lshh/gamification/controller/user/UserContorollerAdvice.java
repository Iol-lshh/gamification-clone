package lshh.gamification.controller.user;

import lshh.gamification.controller.ResultModel;
import lshh.gamification.domain.user.exception.UserCreationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserContorollerAdvice {

    @ExceptionHandler(value = UserCreationException.class)
    public ResultModel<?> handleUserCreationException(UserCreationException e) {
        return ResultModel.badRequest();
    }
}
