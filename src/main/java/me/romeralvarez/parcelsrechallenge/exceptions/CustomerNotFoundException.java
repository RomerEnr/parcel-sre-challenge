package me.romeralvarez.parcelsrechallenge.exceptions;

public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String customerId) {
    super("Customer ID '" + customerId + "' not found.");
  }
}
