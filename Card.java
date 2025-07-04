public class Card{
    private String suit;
    private String rank;
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    private int value;
        public void setValue(int value) {
        this.value = value;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
    @SuppressWarnings("ConvertToStringSwitch")
    private int setvalue(String rank){
        if (rank.equals("Ace")) {
            return 11;
        } else if (rank.equals("King")|| rank.equals("Queen") || rank.equals("Jack") || rank.equals("10")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }
    public Card(String suit, String rank){
        this.name = rank + " of " + suit;
        this.suit = suit;
        this.rank = rank;
        this.value = setvalue(rank);
    }  
    public String getSuit() {
        return suit;
    }
    public String getRank() {
        return rank;
    }
    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}



