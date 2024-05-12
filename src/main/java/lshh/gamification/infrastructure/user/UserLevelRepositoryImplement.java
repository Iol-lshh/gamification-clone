package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.entity.UserLevel;
import lshh.gamification.domain.user.component.UserLevelRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserLevelRepositoryImplement implements UserLevelRepository {

    private final UserLevelJpaRepository jpaRepository;

    @Override
    public void save(UserLevel entity) {
        jpaRepository.save(entity);
    }

    @Override
    public Optional<UserLevel> findByUserIdx(Long userIdx) {
        return jpaRepository.findById(userIdx);
    }
}
