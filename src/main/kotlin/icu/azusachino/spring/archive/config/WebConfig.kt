package icu.azusachino.spring.archive.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class WebConfig {

    @Bean
    fun threadPool(): ThreadPoolTaskExecutor {
        return ThreadPoolTaskExecutor();
    }
}
