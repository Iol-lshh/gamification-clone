package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.entity.UserEtcInfo;
import lshh.gamification.domain.user.component.UserEtcInfoRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserEtcInfoRepositoryImplement implements UserEtcInfoRepository {
    private final UserEtcInfoJpaRepository jpaRepository;

    @Override
    public void save(UserEtcInfo entity) {
        jpaRepository.save(entity);
    }
}
