package Session8.class_problems;

import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 15 + weight + 0.20 * distance;
    }

    String getType() {
        return "EXPRESS";
    }
}

class International extends Delivery {
    double customsFee;

    International(double w, double d, double customsFee) {
        super(w, d);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + 2 * weight + 0.50 * distance + customsFee;
    }

    String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Delivery[] deliveries = new Delivery[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries[i] = new Standard(weight, distance);
                    break;
                case "EXPRESS":
                    deliveries[i] = new Express(weight, distance);
                    break;
                case "INTERNATIONAL":
                    double customs = sc.nextDouble();
                    deliveries[i] =
                            new International(weight, distance, customs);
                    break;
            }
        }

        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", d.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

