package JavaStringConcepts.class_problems;
import java.util.*;
public class Problem1 {
        static String playRound(String player, String computer) {
            if (player.equals(computer)) return "Draw";
            if ((player.equals("Rock") && computer.equals("Scissors")) || (player.equals("Paper") && computer.equals("Rock")) || (player.equals("Scissors") && computer.equals("Paper"))) return "Player Wins";
            return "Computer Wins";
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random r = new Random();
            int win = 0, loss = 0, draw = 0;
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter Rock, Paper or Scissors: ");
                String player = sc.next();
                String[] moves = {"Rock", "Paper", "Scissors"};
                String computer = moves[r.nextInt(3)];
                String result = playRound(player, computer);
                System.out.println("Round " + i + ": Player = " + player + ", Computer = " + computer + ", Result = " + result);
                if (result.equals("Player Wins")) win++;
                else if (result.equals("Computer Wins")) loss++;
                else draw++;
            }
            System.out.println("Wins: " + win);
            System.out.println("Losses: " + loss);
            System.out.println("Draws: " + draw);
            System.out.println("Win %: " + (win * 100.0 / 5));
        }
    }