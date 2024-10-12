package FinalProject;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// I just found the enum thingy. I don't know much about it yet, but it worked here!

public class Deck {
  List<Card> deck = new ArrayList<Card>();
  public enum Suits  {hearts, spades, diamonds, clubs};
  public enum Names {two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, Ace};
  
  
  /**
   * builds a deck from scratch, with all of the cards that should be in a deck.
   */
  public Deck() {
    for (Suits suit : Suits.values()) {
      int i = 1;
      for (Names name : Names.values()) {
        i++;
        deck.add( new Card(name.toString(), suit.toString(), i));
      }
    }
  }
  
  /**
   * turns a list of cards into a deck.
   * @param newCards (a list of cards)
   */
  public Deck(List<Card> newCards) {
        
    for (Card each : newCards) {
      deck.add(each);
    }
  }
  
  /**
   * prints the name, suit and value of the card.
   */
  public void describe() {
    for (Card card : deck) {
      System.out.println(card.getName() + " of " + card.getSuit());
    }
  }
  
  /**
   * shuffles (randomizes) the deck.
   */
  public void shuffle() {
    Random rand = new Random();
    
    List<Card> shuffledList = new ArrayList<>();
    for (int i = 0; i < 52; i++) {
      Card c = deck.remove(rand.nextInt(deck.size()));
      
      shuffledList.add(c);
      }
    
    deck.clear();
    for (Card card : shuffledList) {
      deck.add(card); 
    }
    System.out.println("shuffled");
  }
  
  /**
   * prints out the name, suit, and value of a given card from the deck.
   * @param i
   */
  public String describe(int i) {
    return deck.get(i).describe();
  }
  
  /**
   * gets the card that is on the top of the deck.
   * @return the first card.
   */
  public Card draw() {
    Card aCard;
    aCard = deck.remove(0);
    return aCard;
  } 
  
  /**
   * determines whether there are any cards left in the deck.
   * @return true if the deck is empty, false if there are cards remaining.
   */
  public boolean isEmpty() {
    if (deck.isEmpty()){
      return true;
    } else {
      return false;
    }
  }
  public int size() {
    return deck.size();
  }

}
