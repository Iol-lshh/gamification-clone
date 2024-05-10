package lshh.gamification.domain.user.component;

import lshh.gamification.common.user.CommonUser;

import java.util.Optional;

public interface CommonUserRepository {

    Optional<CommonUser> findCommonUserByUserId(String userId);
}
