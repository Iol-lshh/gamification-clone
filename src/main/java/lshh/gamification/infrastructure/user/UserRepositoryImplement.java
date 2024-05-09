package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImplement implements UserRepository {
    private final UserRepository jpaRepository;
}
