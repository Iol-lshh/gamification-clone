package lshh.gamification.common.config.demo;

import lshh.gamification.common.user.CommonUserClient;
import lshh.gamification.common.user.DemoCommonUserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {
    @Bean
    public CommonUserClient commonUserClient() {
        return new DemoCommonUserClient();
    }
}
