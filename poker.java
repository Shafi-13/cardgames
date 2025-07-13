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
        for (Player player: players){
            poker.otherhands(player);
            poker.isstraight(player);
            poker.isflush(player);
            poker.isstraightflush(player);
            playerscores.add((player.whathand()));
        }
        for (int i=0; i<3; i++){
            for (Player player: players){
                if(player.isFolded()){
                    System.out.println(playerNames.get(players.indexOf(player)) + " has folded, next player, please make your bet");
                    continue;
                }
                System.out.println(playerNames.get(players.indexOf(player)) + "'s hand: ");
                player.showHand();
                System.out.println(playerNames.get(players.indexOf(player))+" Please make a bet or fold:");
                String choice = Strinput.nextLine();
                while (!choice.equals("bet") && !choice.equals("fold")) {
                    System.out.println("Invalid choice. Please enter 'bet' to bet or 'fold' to fold.");
                    choice = Strinput.nextLine();
                }
                if (choice.equals("fold")){
                    player.fold();
                    System.out.println(playerNames.get(players.indexOf(player)) + " has folded.");
                }
                else{
                    System.out.println("Please enter call to bet " +call+ "or enter raise the bet:");
                    String betChoice = Strinput.nextLine();
                    while (!betChoice.equals("call") && !betChoice.equals("raise")) {
                        System.out.println("Invalid choice. Please enter 'call' to match the bet or 'raise' to increase the bet.");
                        betChoice = Strinput.nextLine();
                    }
                    if (betChoice.equals("call")) {
                        player.bet(call);
                        poker.bet(call);
                    } 
                    else {
                        System.out.println("Please enter the amount you want to raise to:");
                        int raise = intput.nextInt();
                        while (raise <= call) {
                            System.out.println("Raise amount must be greater than the current bet of " + call + ". Please enter a valid raise amount:");
                            raise = intput.nextInt();
                        }
                        call = raise;
                        player.bet(raise);
                        poker.bet(raise);
                        System.out.println(playerNames.get(players.indexOf(player)) + " has raised the call amount to " + call + ".");
                    }
                }
            }
        }
        int winner = 0;
        int winninghand = 0;
        for (int score : playerscores) {
            if(score> winninghand){
                winninghand = score;
                winner = playerscores.indexOf(score);
            }
        }
        System.out.println("The winner is: " + playerNames.get(winner) + " and will recieve the pot.");
        players.get(winner).addbalance(poker.winnings());
    }
}