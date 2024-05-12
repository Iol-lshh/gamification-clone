package lshh.gamification.common.library.democache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AdvisoryLockBuffer extends SimpleBuffer<Lock>{

    public Lock getLock(String key) {
        cacheMap.putIfAbsent(key, new ReentrantLock());
        return cacheMap.get(key);
    }

    @Override
    public void clear(String key) {
        Lock lock = cacheMap.get(key);
        if(lock == null) {
            return;
        }
        super.clear(key);
    }
}
