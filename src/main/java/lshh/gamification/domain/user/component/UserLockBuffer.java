package lshh.gamification.domain.user.component;

import java.util.concurrent.locks.Lock;

public interface UserLockBuffer {
    Lock getLock(String key);
}
