package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.common.library.lock.AdvisoryLockBuffer;
import lshh.gamification.domain.user.component.UserLockBuffer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
@Repository
public class UserLockBufferImplement implements UserLockBuffer {
    private final AdvisoryLockBuffer advisoryLockBuffer;


    @Override
    public Lock getLock(String key) {
        return advisoryLockBuffer.getLock(key);
    }
}
