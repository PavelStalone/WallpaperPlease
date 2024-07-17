package com.example.wallpaper;

import com.example.wallpaper.core.system.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.wallpaper.domain.repository")
@PropertySource(value = "application.properties")
public class ApplicationConfig {

    @Bean
    public OptimalActiveOrderSystem injectOptimalActiveOrderSystem(){
        return new OptimalActiveOrderSystemImpl();
    }

    @Bean
    public OptimalCostSystem injectOptimalCostSystem(){
        return new OptimalCostSystemImpl();
    }

    @Bean
    public ChanceTakingOrderSystem injectChanceTakingOrderSystem(){
        return new ChanceTakingOrderSystemImpl();
    }
}
