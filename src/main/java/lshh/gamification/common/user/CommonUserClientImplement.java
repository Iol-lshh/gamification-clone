package lshh.gamification.common.user;

import java.util.Optional;

public abstract class CommonUserClientImplement implements CommonUserClient {
    @Override
    public Optional<CommonUser> findByUserId(String userId) {
        return Optional.empty();
    }
}
