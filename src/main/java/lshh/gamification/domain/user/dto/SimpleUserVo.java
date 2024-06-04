package lshh.gamification.domain.user.dto;

import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public record SimpleUserVo(
        Long idx,
        String userId,
        SchoolClass schoolClass,
        String name,
        LocalDateTime regDate,
        String nickNameFullString,
        Integer grade
){
    public static List<SimpleUserVo> from(List<User> users) {
        return users.stream()
                .map(user -> new SimpleUserVo(
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
