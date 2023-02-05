public class Card {
  private int value;
  private String suit;

  public Card(int value, String suit) {
    this.value = value;
    this.suit = suit;
  }

  public int getValue() {
    return this.value;
  }

  public String getSuit() {
    return this.suit;
  }

  @Override
  public String toString() {
    String cardVal = "";
    if(this.value == 11) {
      cardVal = "Jack";
    } else if(this.value == 12) {
      cardVal = "Queen";
    } else if(this.value == 13) {
      cardVal = "King";
    } else if(this.value == 1) {
      cardVal = "Ace";
    } else {
      cardVal = "" + this.value;
    }
    return cardVal + " of " + this.suit;
  }
}
