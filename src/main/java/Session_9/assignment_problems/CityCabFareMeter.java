package Session_9.assignment_problems;
import java.util.Scanner;

interface NightService {
    default double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    final double calculateFare(boolean night) {
        double fare = Math.max(100.0, km * getRate());

        if (night) {
            fare = ((NightService) this).applyNightCharge(fare);
        }

        return fare;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14.0;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double km = sc.nextDouble();
            times[i] = sc.next();

            switch (types[i]) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean night = times[i].equals("NIGHT");

            if (night && !(cabs[i] instanceof NightService)) {
                System.out.println(types[i] + ": night service not available");
                continue;
            }

            double fare = cabs[i].calculateFare(night);
            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
