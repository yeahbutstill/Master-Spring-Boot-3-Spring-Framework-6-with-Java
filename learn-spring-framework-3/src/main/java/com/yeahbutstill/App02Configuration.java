package com.yeahbutstill;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App02Configuration {

    @Bean
    public String name() {
        return "Dani Setiawan";
    }

    @Bean
    public Integer age() {
        return 15;
    }

    @Bean
    public Person person() {
        var person = new Person("Ravi", 20);
        return person;
    }

    @Bean
    public Address address() {
      return new Address("JL. Semoga Awet 2", "Depok");
    }

}
