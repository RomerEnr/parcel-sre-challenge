package me.romeralvarez.parcelsrechallenge.controllers;

import lombok.AllArgsConstructor;
import me.romeralvarez.parcelsrechallenge.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GreetingController {

  private GreetingService greetingService;

  @GetMapping("/greeting/{customerId}")
  public String greeting(@PathVariable String customerId) {
    return greetingService.greet(customerId);
  }
}
