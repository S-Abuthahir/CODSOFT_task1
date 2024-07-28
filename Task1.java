import java.util.*;

public class Task1 {
    static Scanner in = new Scanner(System.in);
    // Change here to increase or decrease the tries
    final static int ATTEMPTS = 5;
    public static int startGame() {
        int i = 1;
        Random rand = new Random();
        int randomNum = rand.nextInt(100);  // Generates a random number in [1,100]
        while (i <= ATTEMPTS) {
            System.out.print("Guess #" + (i) + "\nGuess a number:\t");
            int guess = in.nextInt();
            if (guess == randomNum) {
                System.out.println("Guessed correctly at #" + i + " attempt.\n");
                return i;
            } else if (guess < randomNum) {
                System.out.println("Guess is too low.\tTry again!\n");
            } else {
                System.out.println("Guess is too high.\tTry again!\n");
            }
            i++;
        }
        return -1;
    }

    public static void printScore(int round, int attempt) {
        System.out.println("+=========================================+");
        System.out.println("Round #" + round + " results");
        if (attempt == -1) {
            System.out.println("Score: 0");
        } else  // Formula: Attempts * 10 / totalAttempts * 10
            System.out.println("Score: " + ((ATTEMPTS - attempt + 1) * 10) + "/" + (ATTEMPTS * 10));
        System.out.println("+=========================================+\n");
    }

    public static void main(String[] args) {
        int rounds, guess;
        System.out.print("Enter no. of rounds:\t");
        rounds = in.nextInt();
        for (int round = 1; round <= rounds; round++) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> Round " + round + " >>>>>>>>>>>>>>>>>>>>>>>>");
            guess = startGame();
            printScore(round, guess);
        }

    }
}