package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.entity.User;
import lshh.gamification.domain.user.component.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImplement implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return jpaRepository.findByUserId(userId);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll();
    }
}
