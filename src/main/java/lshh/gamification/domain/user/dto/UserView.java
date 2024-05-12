package lshh.gamification.domain.user.dto;

import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public record UserView(
        Long idx,
        String userId,
        SchoolClass schoolClass,
        String name,
        LocalDateTime regDate,
        String nickNameFullString,
        Integer grade
){
    public static List<UserView> from(List<User> users) {
        return users.stream()
                .map(user -> new UserView(
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
