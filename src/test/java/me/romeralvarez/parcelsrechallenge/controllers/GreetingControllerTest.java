package me.romeralvarez.parcelsrechallenge.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class GreetingControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testGreetingForCustomerA() throws Exception {
    mockMvc.perform(get("/greeting/A"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hi"));
  }

  @Test
  public void testGreetingForCustomerB() throws Exception {
    mockMvc.perform(get("/greeting/B"))
        .andExpect(status().isOk())
        .andExpect(content().string("Dear Sir or Madam"));
  }
}
