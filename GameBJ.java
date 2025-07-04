import java.util.ArrayList;
import java.util.Scanner;

public class GameBJ {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        System.out.println("please Enter the number of players:");
        Scanner intput = new Scanner(System.in);
        Scanner Strinput = new Scanner(System.in);
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
    }
}