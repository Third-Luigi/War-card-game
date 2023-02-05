import java.util.ArrayList;
import java.util.Random;

public class War {
  //declare your instance variables
  private ArrayList<Card> player1;
	private ArrayList<Card> player2;
	private ArrayList<Card> discard1;
	private ArrayList<Card> discard2;
  private Deck deck;
  private Random rand;
	private	int rounds = 0;
  private	int player1Wins = 0;
	private	int player2Wins = 0;
	private boolean gameOver;

  public War() {
    this.Battles();
	}
    //intialize your instance variables
	public void Battles() { 
    this.player1 = new ArrayList<Card>();
    this.player2 = new ArrayList<Card>();
		this.discard1 = new ArrayList<Card>();
		this.discard2 = new ArrayList<Card>();
		this.gameOver = false;
		rand = new Random();
    deck = new Deck();
		deck.shuffleDeck();
		for ( int i = deck.getDeck().length-1; i >= 26; i--) {
			player1.add(deck.getDeck()[i]);
		}
		for ( int i = 25; i >= 0; i--) {
			player2.add(deck.getDeck()[i]);
		}





		while (gameOver == false) {
		rounds++;
		int FirstCard = player1.get(0).getValue();
		int SecondCard = player2.get(0).getValue();
    if (FirstCard > SecondCard) {
			player1Wins++;
      writing("one",rounds);
			discard1.add(player1.get(0));
			discard1.add(player2.get(0));
			player1.remove(player1.get(0));
			player2.remove(player2.get(0));
		} else if (SecondCard > FirstCard) {
			player2Wins++;
      writing("two",rounds);
			discard2.add(player1.get(0));
			discard2.add(player2.get(0));
			player1.remove(player1.get(0));
			player2.remove(player2.get(0));
		} else {
			int decider = rand.nextInt(2);
			  if (decider == 1) {
				writing("one",rounds);
				player1Wins++;
			  discard1.add(player1.get(0));
			  discard1.add(player2.get(0));
			  player1.remove(player1.get(0));
			  player2.remove(player2.get(0));
			  }
			  else {
				writing("two",rounds);
				player2Wins++;
			  discard2.add(player1.get(0));
			  discard2.add(player2.get(0));
			  player1.remove(player1.get(0));
			  player2.remove(player2.get(0));
			  }
		}
      checkPiles();

		}


  }

  public void writing ( String winner, int round) {
		System.out.println("Player " + winner + " won \nPlayer one placed " + player1.get(0).getSuit() + " " + player1.get(0).getValue() + " and player two placed " + player2.get(0).getSuit() + " " + player2.get(0).getValue() + "\nPlayer one has " + (player1.size() + discard1.size()) + " Player two has " + (player2.size() + discard2.size()) + "\nRound number " + round + "\n\n\n");
	}



  public void checkPiles() {
		if (player1.size() == 0 && discard1.size() == 0) {
			  gameOver = true;
				declareWinner();
		} else if (player1.size() == 0 && discard1.size() > 0) {
					shuffle(discard1);
        for ( int i = 0; i < discard1.size(); i++) {
					player1.add(discard1.get(0));
					discard1.remove(discard1.get(0));
					i--;
				}
			}
		
    if (player2.size() == 0 && discard2.size() == 0) {
			  gameOver = true;
				declareWinner();
	  } else if ( player2.size() == 0 && discard2.size() > 0) {
				  shuffle(discard2);
			for ( int i = 0; i < discard2.size(); i++) {
					player2.add(discard2.get(0));
					discard2.remove(discard2.get(0));
					i--;
			}
		}
		}
	


public void shuffle(ArrayList<Card> some) {
    Random rand = new Random();
    for(int i = 0; i < 100000; i++) {
      int rand1 = rand.nextInt(some.size());
      int rand2 = rand.nextInt(some.size());
      while(rand1 == rand2) {
        rand1 = rand.nextInt(some.size());
        rand2 = rand.nextInt(some.size());
      }
      Card temp = some.get(rand1);
      some.set(rand1, some.get(rand2));
      some.set(rand2, temp);
    }}
    

  public void declareWinner() {
	  if (player1Wins > player2Wins) {
			System.out.println("Player one wins in " + rounds + " rounds!!");
		} else if (player2Wins > player1Wins) {
			System.out.println("Player two wins in " + rounds + " rounds!!");
		}
	}


  // PLAN //   
	//Shuffle deck
	
	//hand out cards
	  //equal amounts
	//loop

	//War
	//different counts
	
	  //disperse pile / normal pile / round # / # of rounds won for each player
	
	    //check the amount of cards players have
		    //if none use dispersepile
			    //suffle cards and move to main
			      //none in disperse end
	
	  //check the num amt
	  	//if equal rand player
	
		//move to disperse pile
	
		//write out everything
      //Round num / winner / pile amount
	//loop
	//write out overall winner

	  
} 
