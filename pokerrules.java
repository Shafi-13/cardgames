
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
    public void isstraightflush(Player hand){
               String suit = hand.getHand().get(0).getSuit();
        boolean flush = true;
        for (Card card : hand.getHand()) {
            if (!card.getSuit().equals(suit)) {
                flush = false;
                break;
            }
        }
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
        if (straight && flush) {
            int value = 0;
            for (Card card : hand.getHand()) {
                value += card.getPokerval();
            }
            if (hand.getcardvalue().equals(lowstraight)) {
                value -= 13; 
            }
            hand.setpokerhand(8);
            hand.setscore(value);
        }
    }
    public void otherhands(Player hand){
        ArrayList<Integer> cardvalues = hand.getcardvalue();
        Collections.sort(cardvalues);
        Collections.reverse(cardvalues);
        int counter1 = 0;
        int counter2 = 0;
        int value = cardvalues.get(0);
        for(int i = 0; i< cardvalues.size()-1; i++){
            if(cardvalues.get(i) == value){
                counter1++;
            }
            else if(cardvalues.get(i) != value && counter2 == 2 && counter1 == 1){
                value = cardvalues.get(i);
            }
            else{
                value = cardvalues.get(i);
                counter2 = counter1;
                counter1 = 1;
            }
        }
        if (counter1 == 4 || counter2 == 4){
            hand.setpokerhand(7);
            if (counter1 == 4){
                hand.setscore(cardvalues.get(0));
            }
            else{
                hand.setscore(cardvalues.getLast());
            }
        }
        if ((counter1 == 3 && counter2 == 2) || (counter1 == 2 && counter2 == 3)) {
            hand.setpokerhand(6);
            if (counter2 == 3) {
                hand.setscore(cardvalues.get(0));
            } 
            else{
                hand.setscore(cardvalues.getLast());
            }
        }
        if((counter1 == 3 && counter2 == 1) || (counter1 == 1 && counter2 == 3)){
            hand.setpokerhand(3);
            if (counter2 == 3){
                hand.setscore(cardvalues.get(0));
            }
            else{
                hand.setscore(cardvalues.getLast());
            }
        }
        if (counter1 == 2 && counter2 == 2) {
            hand.setpokerhand(2);
            if (cardvalues.get(0).equals(cardvalues.get(1))) {
                hand.setscore(cardvalues.get(0));
            }
            else{
                hand.setscore(cardvalues.get(1));
            }
        }
        if ((counter1 == 2 && counter2 == 1)||(counter1 == 1 && counter2 == 2)) {
            hand.setpokerhand(1);
            for (int i = 0; i < cardvalues.size() - 1; i++) {
                if (cardvalues.get(i).equals(cardvalues.get(i + 1))) {
                    hand.setscore(cardvalues.get(i));
                    break;
                }
            }
        }
        if (counter1 == 1 && counter2 == 1) {
            hand.setpokerhand(0);
            hand.setscore(cardvalues.getLast());
        }
    }
}
