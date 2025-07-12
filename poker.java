import java.util.ArrayList;
import java.util.Scanner;
public class poker{
    public void startPoker(){
        pokerrules poker = new pokerrules();
        System.out.println("Welcome to Poker!");
        Scanner intput = new Scanner(System.in);
        Scanner Strinput = new Scanner(System.in);
        System.out.println("please Enter the number of players:");
        int n = intput.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Integer> playerscores = new ArrayList<>();
        System.out.println("Enter the names for each player ");
        for (int i = 1; i < n+1; i++) {
            System.out.println("player "+ i+" please enter your name:");
            String name = Strinput.nextLine();
            System.out.println("please Enter your starting balance:");
            int balance = intput.nextInt();
            Player user = new Player(balance);
            players.add(user);
            playerNames.add(name);
        }
        System.out.println("Users: "+playerNames + " are playing the game");
        Deck deck = new Deck(players.size()/4);
        deck.shuffle();
        for (Player x : players) {
            for (int i = 0; i < 5; i++) {
                x.draw(deck.dealCard());
            }
        }
        int call = 10;
        for (int i =0; i<1; i++){
            if(i == 0){
            players.get(i).bet(5);
            }
            else{
                players.get(i).bet(call);
            }
        }
        poker.setpot(15);
        System.out.println("The players "+playerNames.get(0)+" and "+playerNames.get(1)+" have paid the blinds.");
    }
}