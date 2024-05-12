package lshh.gamification.common.config.demo;

import lshh.gamification.common.library.democache.AdvisoryLockBuffer;
import lshh.gamification.common.library.user.CommonUserClient;
import lshh.gamification.common.library.user.DemoCommonUserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {
    @Bean
    public CommonUserClient commonUserClient() {
        return new DemoCommonUserClient();
    }

    @Bean
    public AdvisoryLockBuffer advisoryLockBuffer() {
        return new AdvisoryLockBuffer() {
        };
    }
}
