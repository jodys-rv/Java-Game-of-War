package FinalProject.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import FinalProject.App;
import FinalProject.Card;
import FinalProject.Deck;
class AppTests {

  @Test
  void dealCardsReturnsMapContainingListsOf26Cards() {
    
    Map<String, List<Card>> hands = new HashMap<String, List<Card>>();
    hands = App.dealCards();
    List<Card> hand1 = hands.get("player1");
    List<Card> hand2 = hands.get("player2");
    
    assertEquals(hand1.size(), 26);
    assertEquals(hand2.size(), 26);
    
  }

}
