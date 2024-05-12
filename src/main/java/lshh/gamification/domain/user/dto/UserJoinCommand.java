package lshh.gamification.domain.user.dto;

import lshh.gamification.common.library.user.CommonUser;
import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.entity.*;
import lshh.gamification.domain.user.exception.UserJoinException;

public record UserJoinCommand(
        String userId,
        String schoolClass,
        String nickName,
        String defaultAvatar,
        String defaultRoom
) {
    public UserJoinCommand {
        if (userId == null || userId.isEmpty()) {
            throw new UserJoinException("userId is null or empty");
        } else if (defaultAvatar == null || defaultAvatar.isEmpty()) {
            throw new UserJoinException("defaultAvatar is null or empty");
        } else if (defaultRoom == null || defaultRoom.isEmpty()) {
            throw new UserJoinException("defaultRoom is null or empty");
        }
    }

    public User toUserEntityWithCommonUser(CommonUser commonUser) {
        User user = User.builder()
                .userId(userId)
                .schoolClass(SchoolClass.valueOf(schoolClass))
                .nickName(commonUser.getName())
                .defaultAvatar(defaultAvatar)
                .defaultRoom(defaultRoom)
                .grade(commonUser.getGrade())
                .build();
        user.initAggregates();
        return user;
    }
}
