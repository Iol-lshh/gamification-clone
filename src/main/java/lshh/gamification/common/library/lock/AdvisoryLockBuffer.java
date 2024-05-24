package lshh.gamification.common.library.lock;

import java.util.concurrent.locks.Lock;

public interface AdvisoryLockBuffer {

    Lock getLock(String key);
    void clear(String key);
}
