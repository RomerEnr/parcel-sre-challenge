package me.romeralvarez.parcelsrechallenge.services;

import me.romeralvarez.parcelsrechallenge.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GreetingService {
  private static final Map<String, String> greetings = Map.of(
      "A", "Hi",
      "B", "Dear Sir or Madam",
      "C", "Moin"
  );

  public String greet(String customerId) {
    String greetingMessage = greetings.get(customerId);
    if (greetingMessage == null) {
      throw new CustomerNotFoundException(customerId);
    }
    return greetingMessage;
  }
}
