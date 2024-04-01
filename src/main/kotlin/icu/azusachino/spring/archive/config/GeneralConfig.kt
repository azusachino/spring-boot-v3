package icu.azusachino.spring.archive.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import javax.sql.DataSource

@Configuration
class DbConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    fun datasource(): DataSource {
        return DataSourceBuilder.create().build();
    }

}

@Configuration
class WebConfig {

    @Bean
    fun taskExecutor(): ThreadPoolTaskExecutor {
        val executor = ThreadPoolTaskExecutor();
        executor.setBeanName("taskExecutor")
        executor.setThreadGroupName("async-task-pool")
        return executor
    }
}
