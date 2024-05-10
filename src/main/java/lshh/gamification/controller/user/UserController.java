package lshh.gamification.controller.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.controller.ResultModel;
import lshh.gamification.domain.user.UserService;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 회원 가입
    public ResultModel<UserJoinResult> join(UserJoinCommand userJoinCommand){
        UserJoinResult view = userService.join(userJoinCommand);
        return ResultModel.success(view);
    }

}
