package edu.mum.cs544.l01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import edu.mum.cs544.l01.greeting.HelloPerson;

@SpringBootApplication
public class Application {

  @Autowired
  private HelloPerson helloPerson;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      helloPerson.sayHello();
    };
  }
}
