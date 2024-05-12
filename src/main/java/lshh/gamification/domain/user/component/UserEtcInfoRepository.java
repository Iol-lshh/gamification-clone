package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.UserEtcInfo;

import java.util.Optional;

public interface UserEtcInfoRepository {

    void save(UserEtcInfo of);

    Optional<UserEtcInfo> findByUserIdx(Long userIdx);
}
