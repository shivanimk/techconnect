package com.congressional.techconnect.school;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

/**
 * This class configures the school database table with some default records.
 */
@Configuration
public class EventConfig {
        @Bean
        CommandLineRunner commandLineRunner2(EventDepository repository) {
            return args -> {
                Event event1 = new Event(1L, "Commack HS", LocalDateTime.of(2023, Month.AUGUST, 1, 16,00),
                        "2hrs", "Commack Public Library", null, "Instagram",
                        "Instagram Intro, setup account and connect with friends and family");

                Event event2 = new Event(1L, "Commack HS", LocalDateTime.of(2023, Month.DECEMBER, 10, 17, 00),
                        "2hrs", "Artis Senior Living of Commack", 1L, "Video call",
                        "How to make video call from diff devices and connect with friends and family");

                Event event3 = new Event(1L, "Commack HS", LocalDateTime.of(2023, Month.NOVEMBER, 7, 16,00),
                        "2hrs", "Commack Public Library", null, "Ask us anything",
                        "Every Other Monday. Ask us anything about phone setup, social media account setup");

                Event event4 = new Event(1L, "Commack HS", LocalDateTime.of(2023, Month.NOVEMBER, 21, 16,00),
                        "2hrs", "Commack Public Library", null, "Ask us anything",
                        "Every Other Monday. Ask us anything about phone setup, social media account setup");

                Event event5 = new Event(1L, "Commack HS", LocalDateTime.of(2023, Month.DECEMBER, 5, 16,00),
                        "2hrs", "Commack Public Library", null, "Ask us anything",
                        "Every Other Monday. Ask us anything about phone setup, social media account setup");

                Event event6 = new Event(1L, "Commack HS", LocalDateTime.of(2023, Month.DECEMBER, 19, 16,00),
                        "2hrs", "Commack Public Library", null, "Ask us anything",
                        "Every Other Monday. Ask us anything about phone setup, social media account setup");

                repository.saveAll(List.of(event1, event2, event3, event4, event5, event6));
            };
        }
}
