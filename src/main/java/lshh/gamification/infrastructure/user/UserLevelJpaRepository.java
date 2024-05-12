package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.entity.UserLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLevelJpaRepository extends JpaRepository<UserLevel, Long> {
}
