package Session_9.class_problems;
import java.util.*;

abstract class TravelBooking {
    static final double BOOKING_FEE = 50.0;

    double distanceKm;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    final double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {
    Bus(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return distanceKm * 2;
    }
}

class Train extends TravelBooking {
    Train(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class Flight extends TravelBooking {
    Flight(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return 2500 + distanceKm * 4;
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];
        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            double distance = sc.nextDouble();

            switch (modes[i]) {
                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            double total = bookings[i].calculateTotalFare();
            System.out.printf("%s: %.2f%n", modes[i], total);
        }

        sc.close();
    }
}