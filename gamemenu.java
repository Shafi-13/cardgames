import java.util.Scanner;
class gamemenu{
    public static void main(String[] args) {
        System.out.println("Welcome to the Card Games Menu!");
        System.out.println("1. Play Blackjack");
        System.out.println("2. Play Poker");
        System.out.println("3. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                GameBJ gameBJ = new GameBJ();
                gameBJ.startbj();
            }
            case 2 -> {
                poker pokerGame = new poker();
                pokerGame.startPoker();
            }
            case 3 -> System.out.println("Exiting the game. Goodbye!");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}