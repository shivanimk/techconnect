package com.congressional.techconnect.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * This class configures the school database table with some default records.
 */
@Configuration
public class SchoolConfig {

        @Bean
        CommandLineRunner commandLineRunner1(SchoolRepository repository){
            return args -> {
                School commack = new School(
                        "Commack High School",
                        "1 Scholar lane",
                        "Commack",
                        "NY",
                        "11725",
                        "TCadvisor@commack.k12.ny.us",
                        "abc123"
                );

                School jericho = new School(
                        "Jericho High School",
                        "99 Cedar Swamp Rd",
                        "Jericho",
                        "NY",
                        "11753",
                        "TCadvisor@jericho.k12.ny.us",
                        "abc123"
                );
                repository.saveAll(
                        List.of(commack,jericho)
                );
            };
        }
}
