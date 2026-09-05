package Session_5_ArrayAndMethods.class_problems;
import java.util.Scanner;

public class CandidateEligibility {

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        double[] cgpa = new double[n];

        System.out.println("Enter CGPA:");

        for (int i = 0; i < n; i++) {
            cgpa[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {

            if (isEligible(cgpa[i])) {
                System.out.println("Candidate " + (i + 1) + ": Eligible");
            } else {
                System.out.println("Candidate " + (i + 1) + ": Not Eligible");
            }
        }

        sc.close();
    }
}