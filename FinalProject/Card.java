package FinalProject;

public class Card {

  private String name;
  private String suit; 
  private int value;
  
  // I used two constructors here, so that I can declare a card without arguments or
  // by inputting a name, suit, and value. The second one is used in the construction of a deck, 
  // and the first in my main program when I use a new card variable to store the card I've just drawn.
  
  public Card() {
  }
  
  public Card(String name, String suit, int value) {
    this.name = name;
    this.suit = suit; 
    this.value = value;
  }

  // most of these getters and setters are never used. I wonder if it's best practice to leave
  // them all in just in case, or only the ones I need? 
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name; 
  }

  public String getSuit() {
    return suit;
  }

  public void setSuit(String suit) {
    this.suit = suit;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
  
  /**
   * describes a given card by name and suit.
   * @return string: name + " of " + suit
   */
  public String describe() {
    return (name + " of " + suit);
  }
  

}
