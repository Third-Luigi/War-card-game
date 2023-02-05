import java.util.Random;

public class Deck {
  private Card[] deck;
  private Random rand;

  public Deck() {
    //initialize instance variables
    this.deck = new Card[52];
    this.rand = new Random();
    
    //add cards to deck in new deck order
    this.newDeckOrder();
  }

  public Card[] getDeck() {
    return this.deck;
  }

  public void shuffleDeck() {
    for(int i = 0; i < 100000; i++) {
      int randIndex1 = this.rand.nextInt(52);
      int randIndex2 = this.rand.nextInt(52);
      while(randIndex1 == randIndex2) {
        randIndex1 = this.rand.nextInt(52);
        randIndex1 = this.rand.nextInt(52);
      }
      Card temp = this.deck[randIndex1];
      this.deck[randIndex1] = this.deck[randIndex2];
      this.deck[randIndex2] = temp;
    }
  }

  public void newDeckOrder() {
    //create some local variables for support
    String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
    int cardNum = 0;
    //loop through all possible values and suits
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 13; j++) {
        //cycle through values
        int value = j + 1;
        //cycle through suit array
        String suit = suits[i];
        //initialize each Card of deck
        this.deck[cardNum] = new Card(value, suit);

        cardNum++;
      }
    }
  }

  @Override
  public String toString() {
    String output = "";
    for(Card c : deck) {
      output += c.toString() + "\n";
    }
    return output;
  }
}
