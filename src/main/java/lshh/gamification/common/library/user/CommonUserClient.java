package lshh.gamification.common.library.user;

import java.util.Optional;

public interface CommonUserClient {
    Optional<CommonUser> findByUserId(String userId);
}
