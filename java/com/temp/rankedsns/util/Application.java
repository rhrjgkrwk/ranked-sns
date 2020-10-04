package com.navercorp.rankedsns.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class Application {
	@Bean
    public ScheduledTask bean() {
        return new ScheduledTask();
    }
}