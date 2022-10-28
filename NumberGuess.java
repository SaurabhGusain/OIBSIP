import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    
    int NUMBER;
    int max;
    Scanner scanner = new Scanner(System.in);

    public NumberGuess() {
        Random rand = new Random();
        max = 100;
        NUMBER = Math.abs(rand.nextInt()) % (max + 1);
    }

    public void play() {
        int count=0;
        while (true) {
            count++;
            int move = scanner.nextInt();
            if (move > NUMBER) {
                System.out.println("Your number is big");
            } else if (move < NUMBER) {
                System.out.println("Your number is small");
            } else {
                System.out.println("YOU GOT IT. ");
                System.out.println("You try "+count+" times. ");
                System.out.println("Your Score is: "+ (100-(count)*10));
                break;
            }
        }
    }

    public static void main(String[] args) {
        NumberGuess guessGame = new NumberGuess();
        System.out.println("-----Welcome to Guess The Nimber game.-----");
        System.out.println("Try and Guess the number. ");
        System.out.println("It's between 0 and "+guessGame.max+" inclusive. Just type a number to get started.");
        guessGame.play();
    }

}
