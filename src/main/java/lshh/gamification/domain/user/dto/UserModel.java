package lshh.gamification.domain.user.dto;

import lshh.gamification.domain.user.entity.User;

public record UserModel(
        String nickName,
        Integer ruby,
        String defaultAvatar,
        String defaultRoom,
        Boolean createAvatarYn,
        Boolean createRoomYn,
        Boolean noticeYn,
        Boolean ServicePauseYn,
        //String TodayAttendanceEventCode,
        //String TodayConnectEventCode,

        Integer goodCnt,
        Integer friendCnt,
        Integer visitCnt,
        String profileType,
        String profilePath
) {
    public static UserModel from(User user) {
        return new UserModel(
                user.getNickName(),
                user.getRuby(),
                user.getDefaultAvatar(),
                user.getDefaultRoom(),
                user.isCreateAvatarYn(),
                user.isCreateRoomYn(),
                user.isNoticeYn(),
                user.isServicePauseYn(),
                //user.getTodayAttendanceEventCode(),
                //user.getTodayConnectEventCode(),

                user.getEtcInfo().getGoodCount(),
                user.getEtcInfo().getFriendCount(),
                user.getEtcInfo().getVisitCount(),
                user.getEtcInfo().getProfileType().name(),
                user.getEtcInfo().getProfilePath()
        );
    }
}
