package lshh.gamification.domain.user.dto;

import lshh.gamification.common.user.CommonUser;
import lshh.gamification.domain.user.*;
import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.exception.UserCreationException;

public record UserJoinCommand(
        String userId,
        String schoolClass,
        String nickName,
        String defaultAvatar,
        String defaultRoom
) {
    public UserJoinCommand {
        if (userId == null || userId.isEmpty()) {
            throw new UserCreationException("userId is null or empty");
        } else if (defaultAvatar == null || defaultAvatar.isEmpty()) {
            throw new UserCreationException("defaultAvatar is null or empty");
        } else if (defaultRoom == null || defaultRoom.isEmpty()) {
            throw new UserCreationException("defaultRoom is null or empty");
        }
    }

    public User toUserEntityWithCommonUser(CommonUser commonUser) {
        return User.builder()
                .userId(userId)
                .schoolClass(SchoolClass.valueOf(schoolClass))
                .nickName(commonUser.getName())
                .defaultAvatar(defaultAvatar)
                .defaultRoom(defaultRoom)
                .grade(commonUser.getGrade())
                .build();
    }
    public UserEtcInfo toEtcInfoEntity(Long userIdx) {
        return UserEtcInfo.builder()
                .userIdx(userIdx)
                .build();
    }
    public UserEquiped toEquipedEntity(Long userIdx) {
        return UserEquiped.builder()
                .userIdx(userIdx)
                .build();
    }
    public UserLevel toLevelEntity(Long userIdx) {
        return UserLevel.builder()
                .userIdx(userIdx)
                .build();
    }
    public UserInventoryItem toDefaultInventoryItemEntity(Long userIdx) {
        return UserInventoryItem.builder()
                .userIdx(userIdx)
                .itemId(defaultRoom)
                .build();
    }
}
