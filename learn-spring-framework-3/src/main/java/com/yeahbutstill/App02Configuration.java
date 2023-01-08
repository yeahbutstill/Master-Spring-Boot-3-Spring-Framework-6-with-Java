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
    public Person person1() {
        return new Person("Maya", 20, new Address("JL. Bawang merah", "Japan"));
    }

    @Bean
    public Person person2() {
        return new Person("Winda", 17, new Address("JL. Bawang putih" , "Depok"));
    }

    @Bean
    public Person person3MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person4Parameters(String name, Integer age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    public Address address() {
      return new Address("JL. Semoga Awet 2", "Citayam");
    }

    @Bean(name = "address3")
    public Address address3() {
        return new Address("JL. Wali Songong", "Bojong Gede");
    }

}
