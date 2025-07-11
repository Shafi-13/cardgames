
import java.util.ArrayList;
import java.util.Collections;

class pokerrules{
    private int pot;
    public void bet(int amount) {
        if (amount > 0) {
            this.pot += amount;
            System.out.println("You have bet: " + amount + ". Current pot: " + this.pot);
        } 
        else {
            System.out.println("Invalid bet amount.");
        }
    }
    public int winnings() {
        int w = this.pot;
        this.pot = 0;
        return w;
    }
    public void isflush(Player hand) {
        String suit = hand.getHand().get(0).getSuit();
        boolean flush = true;
        for (Card card : hand.getHand()) {
            if (!card.getSuit().equals(suit)) {
                flush = false;
                break;
            }
        }
        if (flush){
            int value;
            Collections.sort(hand.getcardvalue());
            value = hand.getcardvalue().getLast();
            hand.setpokerhand(5);
            hand.setscore(value);
        }
    }
    public void isstraight(Player hand){
        boolean straight = true;
        Collections.sort(hand.getcardvalue());
        ArrayList<Integer> lowstraight = new ArrayList<>();
        lowstraight.add(14);
        lowstraight.add(2);
        lowstraight.add(3);
        lowstraight.add(4);
        lowstraight.add(5);
        for (int i = 0; i < hand.getcardvalue().size() - 1; i++) {
            if (hand.getcardvalue().get(i) + 1 != hand.getcardvalue().get(i + 1)) {
                straight = false;
                break;
            }
        }
        if (hand.getcardvalue().equals(lowstraight)) {
            straight = true;
        }
        if (straight) {
            int value = 0;
            for (Card card : hand.getHand()) {
                value += card.getPokerval();
            }
            if (hand.getcardvalue().equals(lowstraight)) {
                value -= 13; 
            }
            hand.setpokerhand(4);
            hand.setscore(value);
        }
    }
}