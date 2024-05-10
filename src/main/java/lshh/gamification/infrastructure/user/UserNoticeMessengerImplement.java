package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.User;
import lshh.gamification.domain.user.component.UserNoticeMessenger;
import org.springframework.stereotype.Component;

@Component
public class UserNoticeMessengerImplement implements UserNoticeMessenger {

    @Override
    public void sendJoinNotice(User user) {

    }
}
