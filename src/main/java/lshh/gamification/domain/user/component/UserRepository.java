package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByUserId(String userId);
}
