package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageServiceExtended {

  @GetMapping("/Division")
  public float sayDivision(int a, int b) {
    return a / b;
  }

  @GetMapping("/Addition1")
  public int sayAddition(int a, int b, int c) {
    return a + b + c;
  }

  @GetMapping("/Subtraction1")
  public int saySubtraction(int a, int b, int c) {
    return a - b - c;
  }

  @GetMapping("/Multiplication1")
  public long sayMultiplication(int a, int b, int c) {
    return a * b * c;
  }

  @GetMapping("/Mix")
  public long sayMix(int a, int b, int c) {
    return a + b * c;
  }
}
