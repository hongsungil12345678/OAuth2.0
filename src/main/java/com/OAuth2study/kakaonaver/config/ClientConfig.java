package com.OAuth2study.kakaonaver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
