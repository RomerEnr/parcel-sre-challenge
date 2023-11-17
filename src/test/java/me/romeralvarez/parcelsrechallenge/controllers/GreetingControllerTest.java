package me.romeralvarez.parcelsrechallenge.controllers;


import me.romeralvarez.parcelsrechallenge.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetingService greetingService;

  @Test
  public void testGreetingForCustomerA() throws Exception {
    Mockito.when(greetingService.greet("A")).thenReturn("Hi");

    mockMvc.perform(MockMvcRequestBuilders.get("/greeting/A"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Hi"));
  }

}
