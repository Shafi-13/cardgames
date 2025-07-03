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

    public String winner (ArrayList<Player> players){
        Player winner; 

        for (Player player : players) {
            if (isBust(score(player.getHand()))) {
                players.remove(player);
            }
        }
        winner = players.get(0);
        for (Player player :players){
            if (score(player.getHand()) > score(winner.getHand())) {
                winner = player;
        }
        }

        if (winner == null) {
            return "No winner, all players busted.";
        }
        return (winner + " is the winner");
    }
}