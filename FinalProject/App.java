package FinalProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class App {

  public static void main(String[] args) {
    
    int score1 = 0;
    int score2 = 0;
    
    // unpacking the map returned by dealCards(). It contains two lists of cards, 
    // which I make into separate decks. (I don't really know if it's better to make them
    // into decks or leave them as lists. Actually, maybe I should make them into decks in the
    // method, and return map<string, deck> instead.)
    
    
    
    Map<String, List<Card>> playerHands = new HashMap<>();
    playerHands = dealCards();
    Deck hand1 = new Deck(playerHands.get("player1"));
    Deck hand2 = new Deck(playerHands.get("player2"));
    
    
    // Here's the gameplay. draw one card from each player's deck, compare the values,
    // award the point to whichever card has a higher value (if they are not the same).
    // this section would be tidier if I format the strings, I guess.
    
    // I just saw that the instructions say to use a traditional for loop to do this part.
    // I tried a for loop first, but it only works if I hard code it with index < 26. If I 
    // try to do it with hand.size() or with a variable, it only executes the loop 13 times
    // before throwing an out of bounds exception (which makes sense, because the size of the hand
    // decreases every time I draw a card). I found this while loop more elegant, especially since I had 
    // already created the isEmpty() method for the part where all the cards are being dealt out.
    
    
    while (!hand1.isEmpty()) {
      Card card1 = hand1.draw();
      Card card2 = hand2.draw();
      if (card1.getValue() > card2.getValue()) {
        System.out.println(card1.describe() + " beats " +  card2.describe() + ". one point to player One.");
        score1++;
      } else if (card2.getValue() > card1.getValue() ){
        System.out.println(card2.describe() + " beats " + card1.describe() + ". one point to player Two.");
        score2++;
      } else {
        System.out.println("Tie! no points awarded.");
      }
      
    }
    
    // this section just compares the scores and declares a winner. 
    System.out.println("final score: Player One " + score1 + " Player Two "+ score2);
    if (score1 > score2) {
      System.out.println("Player One is the winner!");
    } else if (score2 > score1) {
      System.out.println("Player Two is the winner!");
    } else {
      System.out.println("Tie!");
    }
    
  }
  
  
  /**
   * deals entire deck alternately to two players.
   * @return map containing two lists of cards, accessed by player1 and player2.
   */
  public static Map<String, List<Card>> dealCards(){
    Deck deck = new Deck();
    deck.shuffle();
    
    Map<String, List<Card>> playerHands = new HashMap<>();
    List<Card> hand1 = new ArrayList<>();
    List<Card> hand2 = new ArrayList<>();
    
    
   
    int index = 0;
    while (!deck.isEmpty()) {
      Card cardFromTop = deck.draw();
      if (index % 2 == 0) {
        hand1.add(cardFromTop);
      } else {
        hand2.add(cardFromTop);
        
      }
      index++;
      playerHands.put("player1", hand1);
      playerHands.put("player2", hand2);
    }
    return playerHands;

  }

}
