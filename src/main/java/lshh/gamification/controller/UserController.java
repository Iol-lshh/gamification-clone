package lshh.gamification.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lshh.gamification.controller.dto.ResultModel;
import lshh.gamification.domain.user.UserService;
import lshh.gamification.domain.user.dto.UserCoreVo;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User", description = "사용자")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Tag(name = "User")
    @Operation(summary = "회원가입")
    @PostMapping("/join")
    public ResultModel<UserJoinResult> join(UserJoinCommand userJoinCommand){
        UserJoinResult view = userService.join(userJoinCommand);
        return ResultModel.success(view);
    }

    @Tag(name = "User")
    @Operation(summary = "전체 사용자 목록 조회")
    @GetMapping("/list/all")
    public ResultModel<List<UserCoreVo>> listAll(){
        List<UserCoreVo> list = userService.findAllCore();
        return ResultModel.success(list);
    }

}
