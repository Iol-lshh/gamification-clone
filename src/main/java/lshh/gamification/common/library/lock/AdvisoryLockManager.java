package lshh.gamification.common.library.lock;

import lshh.gamification.common.library.aop.AopTransaction;
import lshh.gamification.common.library.parser.ExpressionLanguageParser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;

@Aspect
public class AdvisoryLockManager {
    private static final String LOCK_PREFIX = "LOCK:";

    private final AdvisoryLockBuffer advisoryLockBuffer;
    private final AopTransaction aopTransaction;


    public AdvisoryLockManager(AdvisoryLockBuffer advisoryLockBuffer, AopTransaction aopTransaction) {
        this.advisoryLockBuffer = advisoryLockBuffer;
        this.aopTransaction = aopTransaction;
    }

    @Around("@annotation(lshh.gamification.common.library.lock.AdvisoryLock)")
    public Object tryLock(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AdvisoryLock advisoryLock = method.getAnnotation(AdvisoryLock.class);
        String keyExpression = advisoryLock.key();
        String key = LOCK_PREFIX + ExpressionLanguageParser.getDynamicValue(signature.getParameterNames(), joinPoint.getArgs(), keyExpression);
        long waitTime = advisoryLock.waitTime();

        Lock lock = advisoryLockBuffer.getLock(key);
        if(!lock.tryLock(waitTime, advisoryLock.timeUnit())) {
            throw new AdvisoryLockException("Failed to acquire lock - over wait time: " + key);
        }
        try {
            return aopTransaction.proceed(joinPoint);
        } finally {
            lock.unlock();
        }
    }
}
