package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
