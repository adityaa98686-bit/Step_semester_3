package Session8.assignment_problems;

import java.util.*;
import java.time.*;
import java.time.format.*;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Subscription {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Subscription[] subscriptions = new Subscription[n];

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");

            String type = data[0];
            String name = data[1];
            LocalDate date = LocalDate.parse(data[2]);

            switch (type) {
                case "BASIC":
                    subscriptions[i] = new Basic(name, date);
                    break;
                case "STANDARD":
                    subscriptions[i] = new Standard(name, date);
                    break;
                case "PREMIUM":
                    subscriptions[i] = new Premium(name, date);
                    break;
            }
        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Subscription s : subscriptions) {
            System.out.println(s.name + ": "
                    + s.getRenewalDate().format(formatter));
        }

        sc.close();
    }
}
