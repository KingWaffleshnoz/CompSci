import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

/**
 * @author Jared Lyon
 * AList-A11: Blackjack Game
 * Creates a BlackjackGame Class and an object of that class that will play one or more games of BlackJack.
 */
public class BlackjackGame_1LyonV5 {
    public static void main( String[] args ) {
        BlackjackGame newGame = new BlackjackGame();
        newGame.run();
    }
}

//creates a class that implements a game of blackjack utilizing all other classes
class BlackjackGame {
    private String banner = 
    "<<------------------------------------------->>\n" +
    "<---------    B L A C K J A C K !   ---------->\n" +
    "<<------------------------------------------->>\n";
    /**
     * Plays a game of blackjack pro-style in successive order
     * Uses a loop mechanism to continually play indefinitely by reshuffling the deck
     */
    public void run() {
        System.out.println(banner);
        //create deck & shuffle, then set table w/ dealer
        System.out.println("Welcome, player(s)!\nInitializing deck...");
        Deck deck1 = new Deck();
        deck1.shuffle();
        Dealer dealer1 = new Dealer();
        System.out.println("Deck initialized and shuffled!\n----------");

        /**
         * Creates players at table
         * @condition at least 1 player is needed
         */
        Scanner input = new Scanner(System.in);
        System.out.println("How many players will be joining?");
        int playerCount = input.nextInt();
        if (playerCount < 1) {
            System.out.println("Bruh. Come on.\n Creating one player..."); //catches malarkey
            playerCount = 1;
        }
        System.out.println("Initializing table for " + playerCount + " player(s)...");
        System.out.println("Reminder that all players begin with 50 chips!");
        ArrayList<Player> players = new ArrayList<Player>(playerCount);
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Input player " + (i+1) + "'s name:");
            String name = input.next();
            players.add(new Player(name));
        }
        
        //begin loop for playing the table (yay woohoo)
        boolean looping = true;
        while (looping) {
            //dealer first draw
            dealer1.drawCard(deck1.draw()); //card 1
            dealer1.drawCard(deck1.draw()); //card 2

            /**
             * players first draw and ask for bets
             * @condition no bets above fifty or below 1; sets high bets to max amount / low bets to one
             * @condition skips a player if they dont have any more chips
             */
            for (int i = 0; i < playerCount; i++) {
                players.get(i).drawCard(deck1.draw());
                players.get(i).drawCard(deck1.draw());
                System.out.println(players.get(i).getName() + ", you have " + players.get(i).getChips() + " chips. Please place bet:");
                if (players.get(i).getChips() < 1) {
                    System.out.println(players.get(i).getName() + ", since you don't have any more chips, we're gonna skip your bet...");
                    players.get(i).setLastBet(0); //sets last bet to 0 to prevent previous bet from rolling over
                } else {
                    int bet = input.nextInt();
                    if (bet > players.get(i).getChips() || bet < 1) { 
                        System.out.println("You can't bet that amount!"); //also catches malarkey
                        if (bet > players.get(i).getChips()) {
                            System.out.println("Setting bet to max amount...");
                            bet = players.get(i).getChips();
                        } else if (bet < 1) {
                            System.out.println("Setting bet to one...");
                            bet = 1;
                        }
                    }
                    players.get(i).subtractChips(bet);
                    players.get(i).setLastBet(bet);
                    System.out.println("You bet " + players.get(i).getLastBet() + " chips and now have " + players.get(i).getChips() + " chips.");
                }
            }

            //display dealer's first card and check for blackjack
            System.out.println("---------\nDisplaying first dealer card:");
            dealer1.displayDealerHand();
            System.out.println("---------");
            System.out.println("Dealer is checking for blackjack...");
            if (dealer1.getHandValue() == 21) {
                System.out.println("---------\nDealer blackjacks! Everyone loses!\n---------"); //skips the round if dealer blackjack
            } else if (dealer1.getHandValue() != 21) {
                System.out.println("No blackjack! Time to play...\n---------");
                //go around table for hits and stands
                for (int i = 0; i < playerCount; i++) {
                    System.out.println(players.get(i).getName() +  "'s turn! Displaying hand...");
                    players.get(i).displayHand();
                    while (players.get(i).getUserChoice().equals("hit")) {
                        players.get(i).drawCard(deck1.draw());
                        System.out.println("Current hand:");
                        players.get(i).displayHand();
                    }
                    System.out.println("Displaying " + players.get(i).getName() + "'s final hand:");
                    players.get(i).displayHand();
                    if (players.get(i).getHandValue() > 21) {
                        System.out.println(players.get(i).getName() + " busts!");
                    }
                    System.out.println("----------");
                }

                //reveal dealer's full hand
                System.out.println("Displaying dealer hand:");
                dealer1.displayHand();
                System.out.println("----------");

                //dealer plays now
                while (dealer1.dealerDraw()) {
                    System.out.println("Dealer is drawing...");
                    dealer1.drawCard(deck1.draw());
                }
                System.out.println("Final dealer hand:");
                dealer1.displayHand();

                //calculate winners
                if (dealer1.getHandValue() > 21) {
                    System.out.println("Dealer busts! All players that did not bust win!");
                    for (int i = 0; i < playerCount; i++) {
                        if (players.get(i).getHandValue() <= 21) {
                            players.get(i).addChips((int)(players.get(i).getLastBet() * 2));
                        }
                    }
                //dealer blackjacks - all players lose except pushes
                } else if (dealer1.getHandValue() == 21) {
                    System.out.println("Dealer has blackjack! All players lose or push...");
                    for (int i = 0; i < playerCount; i++) {
                        if (players.get(i).getHandValue() == 21) {
                            System.out.println(players.get(i).getName() + " pushes! Nice save!");
                            players.get(i).addChips((int)(players.get(i).getLastBet()));
                        }
                    }
                //when dealer has no edge case
                } else if (dealer1.getHandValue() <= 21) {
                    System.out.println("Calculating winners...");
                    for (int i = 0; i < playerCount; i++) {
                        //players that blackjack
                        if (players.get(i).getHandValue() == 21) {
                            players.get(i).addChips((int)(players.get(i).getLastBet() * 1.5));
                        //players that beat dealer
                        } else if (players.get(i).getHandValue() > dealer1.getHandValue() && players.get(i).getHandValue() <= 21) {
                            System.out.println(players.get(i).getName() + " wins!");
                            players.get(i).addChips((int)(players.get(i).getLastBet() * 2));
                        //players that push
                        } else if (players.get(i).getHandValue() == dealer1.getHandValue() && players.get(i).getHandValue() <= 21) {
                            System.out.println(players.get(i).getName() + " pushes!");
                            players.get(i).addChips((int)(players.get(i).getLastBet()));
                        //players that lose
                        } else if (players.get(i).getHandValue() < dealer1.getHandValue() && players.get(i).getHandValue() <= 21) {
                            System.out.println(players.get(i).getName() + " loses to the dealer...");
                        //all players that busted previously
                        } else {
                            System.out.println(players.get(i).getName() + " busted!");
                        }
                    }
                }
            }

            //display chip counts after round
            System.out.println("Current chip counts:");
            for (int i = 0; i < playerCount; i++) {
                System.out.println(players.get(i).getName() + " finished with " + players.get(i).getChips() + " chips!");
            }

            //break loop?
            System.out.println("Continue (enter 'no' to stop)?");
            String loopCheck = input.next();
            if (loopCheck.equals("no")) {
                looping = false;
            } else {
                if (deck1.getSize() < 26) {
                    System.out.println("Rebuilding deck...");
                    deck1.shuffle();
                    System.out.println("New deck:");
                    deck1.display();
                }
                dealer1.reset();
                for (int i = 0; i < playerCount; i++) {
                    players.get(i).reset();
                }
            }
        } //end of loop

        System.out.println("Final chip counts:");
        for (int i = 0; i < playerCount; i++) {
            System.out.println(players.get(i).getName() + " finished with " + players.get(i).getChips() + " chips!");
        }
        System.out.println("Thanks for playing!");
    }
}

class Dealer {
    private boolean Ace;
    private ArrayList<Card> dealerHand;

    //constructor
    public Dealer() {
        Ace = false;
        dealerHand = new ArrayList<Card>();
    }

    public int getHandValue() {
        int hand = 0;
        int count = 0;
        for (Card card : dealerHand) {
            hand += card.getValue();
            if (card.getValue() == 1 && hand <= 11) {
                hand += 10; //ace check
            }
        }
        return hand;
    }

    public boolean dealerDraw() {
        int hand = 0;
        int count = 0;
        if (hand <= 11 && count > 0) {
            hand += 10;
            Ace = true;
        }

        for (Card card : dealerHand) {
            if (card.getValue() == 1) {
                count++;
            }
            hand += card.getValue();
        }
        
        if (hand < 17) {
            return true;
        } else {
            return false;
        }
    }

    public void displayHand() {
        int value = getHandValue();

        for (Card card : dealerHand) {
            if (Ace && card.getValue() == 1) {
                System.out.println(card);
                Ace = false;
            } else {
                System.out.println(card);
            }
        }

        System.out.println("Hand value: " + value);
    }

    //only displays dealer's first card
    public void displayDealerHand() {
        int value = getHandValue();

        if (Ace && dealerHand.get(0).getValue() == 1) {
            System.out.println(dealerHand.get(0) + " [" + 11 + "]");
            Ace = false;
        } else {
            System.out.println(dealerHand.get(0) + " [" + dealerHand.get(0).getValue() + "]");
        }
    }

    //mutators
    public void drawCard(Card card) {
        dealerHand.add(card);
    }

    public void reset() {
        while (dealerHand.size() > 0) {
            dealerHand.remove(0);
        }
    }
}

//class player for the user
class Player {
    private boolean Ace;
    private ArrayList<Card> playerHand;
    private int chips = 50;
    private int lastBet;
    private String name;
    Scanner input;

    //constructor
    public Player(String name) {
        Ace = false;
        playerHand = new ArrayList<Card>();
        input = new Scanner(System.in); 
        this.name = name;
    }

    //accessors
    public String getUserChoice() {
        System.out.println("[Enter Hit/Stand]");
        String output = input.nextLine().toLowerCase();
        
        while (!output.equals("hit") && !output.equals("stand")) {
            System.out.println("Error, please retry...");
            output = input.nextLine().toLowerCase();
        }
        return output;
    }

    public int getHandValue() {
        int hand = 0;
        int count = 0;
        for (Card card : playerHand) {
            hand += card.getValue();
            if (card.getValue() == 1 && hand <= 11) {
                hand += 10; //ace check
            }
        }
        return hand;
    }

    public void displayHand() {
        int value = getHandValue();

        for (Card card : playerHand) {
            if (Ace && card.getValue() == 1) {
                System.out.println(card);
                Ace = false;
            } else {
                System.out.println(card);
            }
        }

        System.out.println("Hand value: " + value);
    }

    public int getChips() {
        return chips;
    }

    public int getLastBet() {
        return lastBet;
    }

    public String getName() {
        return name;
    }

    //mutators
    public void drawCard(Card card) {
        playerHand.add(card);
    }

    public void subtractChips(int input) {
        chips -= input;
    }

    public void addChips(int input) {
        chips += input;
    }

    public void setLastBet(int input) {
        lastBet = input;
    }

    public void reset() {
        while (playerHand.size() > 0) {
            playerHand.remove(0);
        }
    }
}

//class for the arraylist of the deck
class Deck {
    private ArrayList<Card> deck;

    //constructor
    public Deck() {
        deck = new ArrayList<Card>();

        for (int i = 1; i <= 4; i++) {
            for (int u = 1; u <= 12; u++) {
                deck.add(new Card(i, u));
            }
        }
    }

    //accessor
    public void display() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }
    }

    public int getSize() {
        return deck.size();
    }

    //mutators
    public void addCard(int suit, int value) {
        Card addition = new Card(suit, value);
        deck.add(addition);
    }

    public Card draw() {
        Card temp = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return temp;
    }

    public void removeCard(int i) {
        deck.remove(i);
    }

    //shuffles
    //need random generator
    Random random = new Random();
    public void shuffle() {
        //destroy deck
        for (int i = 0; i < deck.size(); i++) {
           deck.remove(0);
        }
        
        //remake it
        for (int i = 1; i <= 4; i++) {
            for (int u = 1; u <= 12; u++) {
                deck.add(new Card(i, u));
            }
        }
        
        //shuffle it
        for (int i = deck.size()-1; i > 0; i--) {
            int x = i;
            int y = random.nextInt(i);
            int loop = 0;
            while (x == y) {
                y = random.nextInt(i);
                loop++;
            }
            Card temp = deck.get(x);
            deck.set(x, deck.get(y));
            deck.set(y, temp);
        }
    }
}

//class for deck objects (card with suit and rank)
class Card {
    private int suit;
    private int value;

    //constructor
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    //accessors
    public String toString() {
        if (value == 10) {
            if (suit == 1) {
                return "Jack of Spades";
            } else if (suit == 2) {
                return "Jack of Hearts";
            } else if (suit == 3) {
                return "Jack of Diamonds";
            } else if (suit == 4) {
                return "Jack of Clubs";
            } else {
                return "error";
            }
        } else if (value == 11) {
            if (suit == 1) {
                return "Queen of Spades";
            } else if (suit == 2) {
                return "Queen of Hearts";
            } else if (suit == 3) {
                return "Queen of Diamonds";
            } else if (suit == 4) {
                return "Queen of Clubs";
            } else {
                return "error";
            }
        } else if (value == 12) {
            if (suit == 1) {
                return "King of Spades";
            } else if (suit == 2) {
                return "King of Hearts";
            } else if (suit == 3) {
                return "King of Diamonds";
            } else if (suit == 4) {
                return "King of Clubs";
            } else {
                return "error";
            }
        } else if (value == 1) {
            if (suit == 1) {
                return "Ace of Spades";
            } else if (suit == 2) {
                return "Ace of Hearts";
            } else if (suit == 3) {
                return "Ace of Diamonds";
            } else if (suit == 4) {
                return "Ace of Clubs";
            } else {
                return "error";
            }
        } else {
            if (suit == 1) {
                return value + " of Spades";
            } else if (suit == 2) {
                return value + " of Hearts";
            } else if (suit == 3) {
                return value + " of Diamonds";
            } else if (suit == 4) {
                return value + " of Clubs";
            } else {
                return "error";
            }
        }
    }

    public String getSuit() {
        if (suit == 1) {
            return "Spades";
        } else if (suit == 2) {
            return "Hearts";
        } else if (suit == 3) {
            return "Diamonds";
        } else if (suit == 4) {
            return "Clubs";
        } else {
            return "error";
        }
    }

    public int getValue() {
        if (value == 1) {
            return 1;
        } else if (value == 10 || value == 11 || value == 12) {
            return 10;
        } else {
            return value;
        }
    }
}

//im surprised you scrolled all the way down here...hi!!
//i hope you have a wonderful day :)