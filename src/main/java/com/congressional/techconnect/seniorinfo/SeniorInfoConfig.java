package com.congressional.techconnect.seniorinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SeniorInfoConfig {
    @Bean
    CommandLineRunner commandLineRunner(SeniorInfoRepository repository){
        return args -> {
            SeniorInfo sh1 = new SeniorInfo(
                    "Senior Home",
                    "Artis Senior Living of Commack",
                    "1131 Jericho Turnpike",
                    "Commack",
                    "NY",
                    "11725",
                    "arborscoordinator@gmail.com",
                    "abc123"
            );
            SeniorInfo sh2 = new SeniorInfo(
                    "Individual",
                    "Maggie Levin",
                    "123 xyz court",
                    "Smithtown",
                    "NY",
                    "11725",
                    "mlevin@gmail.com",
                    "abc123"
            );


            repository.saveAll(
                    List.of(sh1, sh2)
            );
        };
    }
}
