package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.entity.UserEquippedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEquippedInfoJpaRepository extends JpaRepository<UserEquippedInfo, Long> {
}
