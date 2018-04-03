/**
* Author: DatDoan
* Created Date: Apr 2, 2018
*/
package edu.mum.cs544.l01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import edu.mum.cs544.l01.greeting.HelloPerson;
import edu.mum.cs544.l01.model.Person;

@Configuration
public class BeansConfiguration {
  
  @Bean
  public Person getPerson() {
    Person person = new Person();
    person.setFirstname("George");
    person.setLastname("Washington");
    return person;
  }
  
  @Bean
  public HelloPerson getHelloPerson() {
    HelloPerson helloPerson = new HelloPerson(getPerson());
    return helloPerson;
  }
}
