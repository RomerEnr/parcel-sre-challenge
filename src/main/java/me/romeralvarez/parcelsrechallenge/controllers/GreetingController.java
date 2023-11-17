package me.romeralvarez.parcelsrechallenge.controllers;

import lombok.AllArgsConstructor;
import me.romeralvarez.parcelsrechallenge.exceptions.CustomerNotFoundException;
import me.romeralvarez.parcelsrechallenge.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GreetingController {

  private GreetingService greetingService;

  @GetMapping("/greeting/{customerId}")
  public String greet(@PathVariable String customerId) {
    return greetingService.greet(customerId);
  }

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}
