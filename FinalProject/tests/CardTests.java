package FinalProject.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import FinalProject.Card;

class CardTests {
  String expectedName = "Ace";
  String expectedSuit = "Hearts";
  int expectedValue = 14;
  
  Card card = new Card(expectedName, expectedSuit, expectedValue);
  

  @Test
  void constructorTakesNameSuitValue() {
   
    
    assertEquals(expectedName, card.getName());
    assertEquals(expectedSuit, card.getSuit());
    assertEquals(expectedValue, card.getValue());
  }
  @Test
  void describeReturnsNameOfSuit() {
    String expected = "Ace of Hearts";
    assertEquals(expected, card.describe());
  }
}
