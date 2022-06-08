package com.example.credential.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin(origins = "http://localhost:3000/*")
public class Hazelcastconfig {
    @Bean
    public Config Hconfig() {
        return new Config().setInstanceName("hazelcast-instance")
                .addMapConfig(new MapConfig().setName("OTPMap")
                        .setTimeToLiveSeconds(12000));
    }
}
