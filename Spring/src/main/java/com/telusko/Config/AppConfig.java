package com.telusko.Config;

import com.telusko.DeskTop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean

    public DeskTop deskTop(){
        return new DeskTop();
    }
}
