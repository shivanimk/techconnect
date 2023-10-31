package com.congressional.techconnect.seniorinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TechRequestConfig {
    @Bean
    CommandLineRunner commandLineRunner3(TechRequestRepository repository){
        return args -> {
            TechRequest req1 = new TechRequest(
                    "iphone",
                    "want to learn iphone useful features and applications",
                    "mlevin@gmail.com",
                    "Maggie Levin"
            );
            TechRequest req2 = new TechRequest(
                    "venmo",
                    "want to learn venmo setup and usages",
                    "mlevin@gmail.com",
                    "Maggie Levin"
            );

            repository.saveAll(
                    List.of(req1, req2)
            );
        };
    }
}
