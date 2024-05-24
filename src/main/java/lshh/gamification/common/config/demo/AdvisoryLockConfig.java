package lshh.gamification.common.config.demo;

import lombok.RequiredArgsConstructor;
import lshh.gamification.common.library.aop.AopTransaction;
import lshh.gamification.common.library.lock.AdvisoryLockBuffer;
import lshh.gamification.common.library.lock.AdvisoryLockManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AdvisoryLockConfig {
    private final AdvisoryLockBuffer advisoryLockBuffer;
    private final AopTransaction aopTransaction;

    @Bean
    public AdvisoryLockManager advisoryLockManager() {
        return new AdvisoryLockManager(advisoryLockBuffer, aopTransaction) {
        };
    }
}
