package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.UserLevel;

import java.util.Optional;

public interface UserLevelRepository {

    void save(UserLevel entity);

    Optional<UserLevel> findByUserIdx(Long userIdx);
}
