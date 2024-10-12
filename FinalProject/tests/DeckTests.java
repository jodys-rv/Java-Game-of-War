package FinalProject.tests;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import FinalProject.Card;
import FinalProject.Deck;
class DeckTests {

  @Test
  void emptyConstructorMakes52CardDeck() {
    
    Deck deck = new Deck();
    
    assertEquals(52, deck.size());
  }
  
  @Test
  void constructorFromListShouldMakeDeckFromProvidedCards() {
    
    List<Card> cards = new ArrayList<Card>();
    Card a = new Card("2", "Hearts", 3);
    Card b = new Card("5", "Spades", 6);
    Card c = new Card("jack", "Diamonds", 12);
    
    cards.add(a);
    cards.add(b);
    cards.add(c);
    
    Deck deck = new Deck(cards);
    
    assertEquals(3, deck.size());
    assertEquals("2 of Hearts", deck.draw().describe());
    }
  
  @Test
  void describeShouldReturnNameOfSelectedCard() {
    Deck deck = new Deck();
    String expectedString = "two of hearts";
    
    assertEquals(expectedString, deck.describe(0));
  }
  
  @Test
  void shuffleShouldNotAddOrRemoveCards() {
    Deck deck = new Deck();
    deck.shuffle();
    
    assertEquals(52, deck.size());
  }
    
  @Test
  void shuffleShouldChangeOrderOfCards() {
    Deck deck = new Deck();
    String[] cardsBeforeShuffle = new String[52];
    String[] cardsAfterShuffle = new String[52];
    boolean allCardsSame = true;
    
    for (int i = 0; i < 52; i++) {
      cardsBeforeShuffle[i] = deck.describe(i);
    }
    deck.shuffle();
    for (int i = 0; i < 52; i++) {
      cardsAfterShuffle[i] = deck.describe(i);
    }
    allCardsSame = Arrays.equals(cardsBeforeShuffle, cardsAfterShuffle);
    
    assertTrue(!allCardsSame);  
  }
  
  @Test
  void drawShouldReturnFirstCard() {
    Deck deck = new Deck();
    Card card1 = deck.draw();
    Card card2 = deck.draw();
    
    assertEquals("two of hearts", card1.describe());
    assertEquals("three of hearts", card2.describe());
  }
  
  @Test
  void drawFromEmptyDeckthrowsOutOfBounds() {
    List<Card> emptyDeck = new ArrayList<Card>();
    Deck deck = new Deck(emptyDeck);
    
    try {
      deck.draw();
      fail("expected error not thrown");
    } catch (Exception e) {
    }
  }
  @Test
  void isEmptyReturnsTrueifEmptyFalseIfNotEmpty() {
    Deck deck = new Deck();
    List<Card> noCards = new ArrayList<Card>();
    Deck emptyDeck = new Deck(noCards);
    
    assertTrue(emptyDeck.isEmpty());
    assertTrue(!deck.isEmpty());
  }
    
  

}
