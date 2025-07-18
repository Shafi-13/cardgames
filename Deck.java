
import java.util.ArrayList;

public class Deck{
    Card AceOfSpades = new Card("Spades", "Ace",14);
    Card TwoOfSpades = new Card("Spades", "2",2);
    Card ThreeOfSpades = new Card("Spades", "3",3);
    Card FourOfSpades = new Card("Spades", "4",4);
    Card FiveOfSpades = new Card("Spades", "5",5);
    Card SixOfSpades = new Card("Spades", "6",6);
    Card SevenOfSpades = new Card("Spades", "7",7);
    Card EightOfSpades = new Card("Spades", "8",8);
    Card NineOfSpades = new Card("Spades", "9",9);
    Card TenOfSpades = new Card("Spades", "10",10);
    Card JackOfSpades = new Card("Spades", "Jack",11);
    Card QueenOfSpades = new Card("Spades", "Queen",12);
    Card KingOfSpades = new Card("Spades", "King",13);
    Card AceOfHearts = new Card("Hearts", "Ace",14);
    Card TwoOfHearts = new Card("Hearts", "2",2);
    Card ThreeOfHearts = new Card("Hearts", "3",3);
    Card FourOfHearts = new Card("Hearts", "4",4);
    Card FiveOfHearts = new Card("Hearts", "5",5);
    Card SixOfHearts = new Card("Hearts", "6",6);
    Card SevenOfHearts = new Card("Hearts", "7",7);
    Card EightOfHearts = new Card("Hearts", "8",8);
    Card NineOfHearts = new Card("Hearts", "9",9);
    Card TenOfHearts = new Card("Hearts", "10",10);
    Card JackOfHearts = new Card("Hearts", "Jack",11);
    Card QueenOfHearts = new Card("Hearts", "Queen",12);
    Card KingOfHearts = new Card("Hearts", "King",13);
    Card AceOfDiamonds = new Card("Diamonds", "Ace",14);
    Card TwoOfDiamonds = new Card("Diamonds", "2",2);
    Card ThreeOfDiamonds = new Card("Diamonds", "3",3);
    Card FourOfDiamonds = new Card("Diamonds", "4",4);
    Card FiveOfDiamonds = new Card("Diamonds", "5",5);
    Card SixOfDiamonds = new Card("Diamonds", "6",6);
    Card SevenOfDiamonds = new Card("Diamonds", "7",7);
    Card EightOfDiamonds = new Card("Diamonds", "8",8);
    Card NineOfDiamonds = new Card("Diamonds", "9",9);
    Card TenOfDiamonds = new Card("Diamonds", "10",10);
    Card JackOfDiamonds = new Card("Diamonds", "Jack",11);
    Card QueenOfDiamonds = new Card("Diamonds", "Queen",12);
    Card KingOfDiamonds = new Card("Diamonds", "King",13);
    Card AceOfClubs = new Card("Clubs", "Ace",14);
    Card TwoOfClubs = new Card("Clubs", "2",2);
    Card ThreeOfClubs = new Card("Clubs", "3",3);
    Card FourOfClubs = new Card("Clubs", "4",4);
    Card FiveOfClubs = new Card("Clubs", "5",5);
    Card SixOfClubs = new Card("Clubs", "6",6);
    Card SevenOfClubs = new Card("Clubs", "7",7);
    Card EightOfClubs = new Card("Clubs", "8",8);
    Card NineOfClubs = new Card("Clubs", "9",9);
    Card TenOfClubs = new Card("Clubs", "10",10);
    Card JackOfClubs = new Card("Clubs", "Jack",11);
    Card QueenOfClubs = new Card("Clubs", "Queen",12);
    Card KingOfClubs = new Card("Clubs", "King",13);
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Card> deck;
    public Deck(int numDecks) {
        if (numDecks < 1) {
            numDecks = 1;
        }
        deck = new ArrayList<>();
        for (int i = 0; i < numDecks; i++) {
        deck.add(AceOfSpades);
        deck.add(TwoOfSpades);
        deck.add(ThreeOfSpades);
        deck.add(FourOfSpades);
        deck.add(FiveOfSpades);
        deck.add(SixOfSpades);
        deck.add(SevenOfSpades);
        deck.add(EightOfSpades);
        deck.add(NineOfSpades);
        deck.add(TenOfSpades);
        deck.add(JackOfSpades);
        deck.add(QueenOfSpades);
        deck.add(KingOfSpades);
        deck.add(AceOfHearts);
        deck.add(TwoOfHearts);
        deck.add(ThreeOfHearts);
        deck.add(FourOfHearts);
        deck.add(FiveOfHearts);
        deck.add(SixOfHearts);
        deck.add(SevenOfHearts);
        deck.add(EightOfHearts);
        deck.add(NineOfHearts);
        deck.add(TenOfHearts);
        deck.add(JackOfHearts);
        deck.add(QueenOfHearts);
        deck.add(KingOfHearts);
        deck.add(AceOfDiamonds);
        deck.add(TwoOfDiamonds);
        deck.add(ThreeOfDiamonds);
        deck.add(FourOfDiamonds);
        deck.add(FiveOfDiamonds);
        deck.add(SixOfDiamonds);
        deck.add(SevenOfDiamonds);
        deck.add(EightOfDiamonds);
        deck.add(NineOfDiamonds);
        deck.add(TenOfDiamonds);
        deck.add(JackOfDiamonds);
        deck.add(QueenOfDiamonds);
        deck.add(KingOfDiamonds);
        deck.add(AceOfClubs);
        deck.add(TwoOfClubs);
        deck.add(ThreeOfClubs);
        deck.add(FourOfClubs);
        deck.add(FiveOfClubs);
        deck.add(SixOfClubs);
        deck.add(SevenOfClubs);
        deck.add(EightOfClubs);
        deck.add(NineOfClubs);
        deck.add(TenOfClubs);
        deck.add(JackOfClubs);
        deck.add(QueenOfClubs);
        deck.add(KingOfClubs);
        }
    }
    public void shuffle() {
        java.util.Collections.shuffle(deck);
    }
    public void stack() {
        java.util.Collections.shuffle(deck);
        deck.add(0, AceOfSpades);
        deck.add(1, JackOfSpades);
    }
    public Card dealCard() {
        if (deck.isEmpty()) {
            return null; // No cards left to deal
        }
        Card topCard = deck.get(0);
        deck.remove(0); 
        deck.trimToSize();
        return topCard; // Deal the top card
    }
        
    
}