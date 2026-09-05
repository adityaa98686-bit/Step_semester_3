package Session_5_ArrayAndMethods.class_problems;
import java.util.Scanner;
import java.util.Arrays;

public class CurveScores {

    static void curveScores(int[] scores, int bonus) {

        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + bonus;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();

        curveScores(scores, bonus);

        System.out.println(Arrays.toString(scores));

        sc.close();
    }
}