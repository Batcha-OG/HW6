import java.util.Scanner;

public class Game_Chair {

    Shuffle s = new Shuffle();
    BetMore bet = new BetMore(s);
    Player computer = new Player(bet);
    Player player2 = new Player(bet);

    public static void main(String[] args) {
        Game_Chair chair = new Game_Chair();
        chair.start();
        chair.findWinner();
        System.out.println("--------------------------------------------");
    }
    public void start(){
        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("Welcome to BetMore!");
        System.out.println("The cards can be from 1 to 100");
        System.out.println("HINT: to continue enter 0");
        System.out.println("--------------------");
        checkInput(in);

        System.out.println("Computer picked a card");
        System.out.println("--------------------");
        computer.play();
        checkInput(in);

        System.out.println("It's your turn to pick a card");
        System.out.println("HINT: You can request a new card for a maximum of 5");
        System.out.println("--------------------");
        checkInput(in);
        int count = 4;
        do {
            player2.play();
            System.out.println("Do you want to pick " + player2.getCard() + "? - You have " + count + " rerolls left");
            System.out.println("If YES enter 1 if NO enter any other number");
            count--;
        } while (1 != in.nextInt() && count >= 0);
        if(count >= 4) {
            System.out.println("You reached the maximum of 5 rerolls!");
        }
        System.out.println("You picked " + player2.getCard() + "!");

        in.close();
    }

    private void checkInput(Scanner in){
        while (0 != in.nextInt()) {
            System.out.println("Please enter 0 to continue!");
        }
    }

    public void findWinner(){
        System.out.println("");
        System.out.println("Computers Card is " + computer.getCard() + "!");
        System.out.println("Your Card is " + player2.getCard() + "!");
        System.out.println("");
        if(computer.getCard() == player2.getCard()){
            System.out.println("IT'S A DRAW!");
        }
        if(computer.getCard() > player2.getCard()){
            System.out.println("GAME OVER --- YOU LOST!");
        }
        if (computer.getCard() < player2.getCard()){
            System.out.println("CONGRATULATIONS --- YOU WON!");
        }
    }
}
