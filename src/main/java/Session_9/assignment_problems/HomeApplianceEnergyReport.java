package Session_9.assignment_problems;
import java.util.Scanner;

interface SaverMode {
    default double applySaver(double units) {
        return units * 0.75;
    }
}

abstract class Appliance {
    double power;

    Appliance(double power) {
        this.power = power;
    }

    double calculateUnits(double hours) {
        return power * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge() {
        super(150.0);
    }
}

class AC extends Appliance implements SaverMode {
    AC() {
        super(1500.0);
    }
}

class TV extends Appliance {
    TV() {
        super(100.0);
    }
}

class Washer extends Appliance implements SaverMode {
    Washer() {
        super(500.0);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length == 3
                    && input[2].equals("SAVER");

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AC();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                case "WASHER":
                    appliance = new Washer();
                    break;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(hours);

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}