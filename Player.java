import java.util.ArrayList;

public class Player{
        private ArrayList<Card> hand;
        private int balance;
        private int score;
        private int pokerhand;
        private ArrayList<Integer> cardvalue; 
        private boolean fold = false;
        public void fold() {
            this.fold = true;
        }
        public Boolean isFolded() {
            return fold;
        }
        public Player (int balance) {
            this.balance = balance;
            this.score = 0;
            this.hand = new ArrayList<>();
            this.pokerhand = 0;
            this.cardvalue = new ArrayList<>();
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
        cardvalue.add(card.getValue());
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
    public void setscore(int score) {
        this.score = score;
    }
    public int getscore() {
        return score;
    }
    public void setpokerhand(int pokerhand) {
        this.pokerhand = pokerhand;
    }
    public int whathand(){
        return pokerhand;
    }

    public ArrayList<Integer> getcardvalue() {
        return cardvalue;
    }

    public void setCardvalue(ArrayList<Integer> cardvalue) {
        this.cardvalue = cardvalue;
    }
}