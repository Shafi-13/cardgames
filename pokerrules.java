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
}