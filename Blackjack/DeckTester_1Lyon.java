import java.util.ArrayList;

/**
 * Jared Lyon
 * AList-A5: Deck o' Cards
 * Creates an arraylist deck with class card to create a 52 card deck to play blackjack with
 */
public class DeckTester_1Lyon {
    public static void main( String[] args ) {
        //test the cards
        System.out.println("Testing cards:");
        Card kingHearts = new Card(2, 12);
        Card queenDiamonds = new Card(3, 11);
        Card tenSpades = new Card(1, 10);
        System.out.println(kingHearts.toString());
        System.out.println(queenDiamonds.toString());
        System.out.println(tenSpades.toString());
        System.out.println("Testing 3rd card's value parameter: " + tenSpades.getValue());
        System.out.println("Testing 3rd card's suit parameter: " + tenSpades.getSuit());

        System.out.println("------------------------");

        //part two with arraylist
        System.out.println("Testing deck:");
        Deck testDeck = new Deck();
        testDeck.display();
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
        return value;
    }
}

//class for the arraylist of the deck
class Deck {
    private ArrayList<Card> deck;

    //constructor
    public Deck() {
        deck = new ArrayList<Card>();

        for(int i = 1; i <= 4; i++) {
            for(int u = 1; u <= 12; u++) {
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

    //mutators
    public void addCard(int suit, int value) {
        Card addition = new Card(suit, value);
        deck.add(addition);
    }

    public void removeCard(int i) {
        deck.remove(i);
    }
}