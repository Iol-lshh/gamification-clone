package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.UserEquippedInfo;

import java.util.Optional;

public interface UserEquippedInfoRepository {

    void save(UserEquippedInfo of);

    Optional<UserEquippedInfo> findByUserIdx(Long idx);
}
