package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.entity.UserEquippedInfo;
import lshh.gamification.domain.user.component.UserEquippedInfoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserEquippedInfoRepositoryImplement implements UserEquippedInfoRepository {

    private final UserEquippedInfoJpaRepository jpaRepository;

    @Override
    public void save(UserEquippedInfo entity) {
        jpaRepository.save(entity);
    }

    @Override
    public Optional<UserEquippedInfo> findByUserIdx(Long userIdx) {
        return jpaRepository.findById(userIdx);
    }


}
