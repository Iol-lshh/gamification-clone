package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.common.library.user.CommonUser;
import lshh.gamification.common.library.user.CommonUserClient;
import lshh.gamification.domain.user.component.CommonUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CommonUserRepositoryImplement implements CommonUserRepository {
    private final CommonUserClient commonUserClient;

    @Override
    public Optional<CommonUser> findCommonUserByUserId(String userId) {
        return commonUserClient.findByUserId(userId);
    }
}
