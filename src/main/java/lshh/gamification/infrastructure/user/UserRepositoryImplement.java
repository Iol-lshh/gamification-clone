package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.User;
import lshh.gamification.domain.user.component.UserRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImplement implements UserRepository {
    private final UserRepository jpaRepository;

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }
}
