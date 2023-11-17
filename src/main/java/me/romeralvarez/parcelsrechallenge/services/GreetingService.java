package me.romeralvarez.parcelsrechallenge.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  public String greet(String customerId) {
    if (customerId.equals("A")) {
      return "Hi";
    }
    return "Hello";
  }
}
