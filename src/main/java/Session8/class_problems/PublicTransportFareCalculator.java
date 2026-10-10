package Session8.class_problems;

import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return Math.min(2 + 0.10 * distance, 10);
    }

    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }

    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    double peakFactor;

    Metro(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakFactor;
    }

    String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Transport[] journeys = new Transport[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            switch (type) {
                case "BUS":
                    journeys[i] = new Bus(distance);
                    break;
                case "TRAIN":
                    journeys[i] = new Train(distance);
                    break;
                case "METRO":
                    double factor = sc.nextDouble();
                    journeys[i] = new Metro(distance, factor);
                    break;
            }
        }

        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n", t.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
