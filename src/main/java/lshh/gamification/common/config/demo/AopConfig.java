package lshh.gamification.common.config.demo;

import lshh.gamification.common.library.aop.AopTransaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public AopTransaction aopTransaction() {
        return new AopTransaction();
    }
}
