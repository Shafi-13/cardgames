import java.util.ArrayList;
import java.util.Scanner;

public class GameBJ {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        Scanner intput = new Scanner(System.in);
        Scanner Strinput = new Scanner(System.in);
        System.out.println("please Enter the number of players:");
        int n = intput.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();
        System.out.println("Enter the names for each player ");
        for (int i = 1; i < n+1; i++) {
            System.out.println("player"+ i+" please enter your name:");
            String name = Strinput.nextLine();
            Player user = new Player(0);
            players.add(user);
            playerNames.add(name);
        }
        System.out.println("Users: "+playerNames + " are playing the game");
        Blackjack bj = new Blackjack();
        Deck deck = new Deck(players.size());
        deck.shuffle();
        for (Player x : players) {
            x.draw(deck.dealCard());
            x.draw(deck.dealCard());
            x.addbalance(bj.score(x.getHand()));
        }
        System.out.println("The players have been dealt their cards.");
        for (int i = 0; i < players.size(); i++) {
            boolean stand = false;
            while ((bj.isBust(players.get(i).showbalance()) == false) && (stand == false)) {
                System.out.println(playerNames.get(i) + "'s hand: ");
                players.get(i).showHand();
                System.out.println("Score: " + players.get(i).showbalance());
                if (bj.isBlackjack(players.get(i).showbalance(), players.get(i).getHand())) {
                    System.out.println(playerNames.get(i) + " has a Blackjack, Your turn will end");
                    break;
                }
                System.out.println("Do you want to hit or stand? (h/s)");
                String choice = Strinput.nextLine();
                while (!choice.equals("h") && !choice.equals("s")) {
                    System.out.println("Invalid choice. Please enter 'h' to hit or 's' to stand.");
                    choice = Strinput.nextLine();
                }
                if (choice.equals("h")){
                    players.get(i).draw(deck.dealCard());
                    players.get(i).addbalance(bj.score(players.get(i).getHand()));
                    if (bj.isBust(players.get(i).showbalance())) {
                        System.out.println(playerNames.get(i) + " has busted");
                    }
                }
                else{
                    System.out.println(playerNames.get(i) + " has chosen to stand.");
                    stand = true;
                }
                players.get(i).showHand();
            }
        }
    }
}