package lshh.gamification.common.library.democache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// redis 대용
public abstract class SimpleBuffer<T> {
    protected Map<String, T> cacheMap = new ConcurrentHashMap<>();

    public Result set(String key, T value) {
        cacheMap.put(key, value);
        return Result.OK;
    }

    public T get(String key){
        return cacheMap.get(key);
    }

    public void clear(String key) {
        cacheMap.remove(key);
    }

    public enum Result{
        OK
    }
}
