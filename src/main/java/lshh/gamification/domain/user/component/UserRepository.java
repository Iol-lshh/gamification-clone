package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.User;

public interface UserRepository {
    User save(User user);
}
