package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.User;

public interface UserNoticeMessenger {
    void sendJoinNotice(User user);
}
