import java.util.ArrayList;

public class Player{
        private ArrayList<Card> hand;
        private int balance;
        public Player (int balance){
            this.balance = balance;
            this.hand = new ArrayList<>();
        }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void showHand() {
        for (Card card : hand) {
            System.out.println(card.getName());
        }
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public void draw(Card card){
        hand.add(card);
    }
    public void addbalance(int amount){
        this.balance += amount;
    }
    public void bet(int amount){
        this.balance -= amount;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int showbalance(){
        return balance;
    }
}