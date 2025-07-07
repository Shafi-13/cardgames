import java.util.ArrayList;

public class Blackjack{
    public int score(ArrayList<Card> hand){
        int score = 0;
        int aces = 0;

        for (Card card : hand) {
            if(card.getRank().equals("Ace")) {
                aces++;
            }
            score += card.getValue();
        }
        if (aces > 0 && score > 21) {
            score -= 10 * aces;
        }
        return score;
    }
    public boolean isBust(int score){
        return score > 21;
    }
    public boolean isBlackjack(int score, ArrayList<Card> hand){
        return ((hand.size()==2) && (hand.get(0).getRank().equals("Ace") || hand.get(1).getRank().equals("Ace")) && (hand.get(0).getName().equals("Jack of Spades")||hand.get(0).getName().equals("Jack of Clubs")||hand.get(1).getName().equals("Jack of Spades")||hand.get(1).getName().equals("Jack of Clubs")));
    }

    public void winner (ArrayList<Player> players, ArrayList<String> playerNames){
        Player winner = null;  

        for (Player player : players) {
            if (isBust(score(player.getHand()))) {
                continue;
            }
            if (isBlackjack(player.showbalance(), player.getHand())) {
                    winner = player;
            }
            if (winner != null && player.showbalance()<21 && player.showbalance() > winner.showbalance()) {
                winner = player;
            }
            if (winner == null && !isBust(player.showbalance())) {
                winner = player;
            }
        }
        if (winner == null) {
            System.out.println("No winner, all players busted.");
        } 
        else {
            int index = players.indexOf(winner);
            System.out.println("The winner is: " + playerNames.get(index) + " with a score of " + score(winner.getHand()));
        }
    }
}