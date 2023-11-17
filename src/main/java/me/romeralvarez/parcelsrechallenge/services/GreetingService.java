package me.romeralvarez.parcelsrechallenge.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {


  public String greet(String customerId) {
    String greeting;
    if (customerId.equals("A")) {
      greeting = "Hi";
    } else {
      greeting = "Dear Sir or Madam";
    }
    return greeting;
  }
}
