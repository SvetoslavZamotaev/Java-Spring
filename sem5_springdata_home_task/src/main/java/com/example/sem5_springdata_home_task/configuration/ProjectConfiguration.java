package com.example.sem5_springdata_home_task.configuration;

import com.example.sem5_springdata_home_task.loggerAspect.LoggerTerminal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public LoggerTerminal aspect(){
        return new LoggerTerminal();
    }
}
