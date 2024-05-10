package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.entity.UserEtcInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEtcInfoJpaRepository extends JpaRepository<UserEtcInfo, Long>{
}
