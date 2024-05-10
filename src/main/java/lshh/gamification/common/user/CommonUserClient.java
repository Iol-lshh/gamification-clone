package lshh.gamification.common.user;

import java.util.Optional;

public interface CommonUserClient {
    Optional<CommonUser> findByUserId(String userId);
}
