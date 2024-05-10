package lshh.gamification.domain.user.dto;

import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public record UserCoreVo(
        Long idx,
        String userId,
        SchoolClass schoolClass,
        String name,
        LocalDateTime regDate,
        String nickNameFullString,
        Integer grade
){
    public static List<UserCoreVo> from(List<User> users) {
        return users.stream()
                .map(user -> new UserCoreVo(
                        user.getIdx(),
                        user.getUserId(),
                        user.getSchoolClass(),
                        user.getNickName(),
                        user.getRegDate(),
                        user.getEtcInfo().getNickNameFullString(),
                        user.getGrade()
                ))
                .toList();
    }
}
