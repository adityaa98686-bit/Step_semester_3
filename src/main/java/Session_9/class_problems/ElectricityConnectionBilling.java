package Session_9.class_problems;
import java.util.*;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }
        return (100 * 5) + ((units - 100) * 7);
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            switch (type) {
                case "HOME":
                    connections[i] = new Home(units);
                    break;

                case "SHOP":
                    connections[i] = new Shop(units);
                    break;

                case "FACTORY":
                    connections[i] = new Factory(units);
                    break;
            }
        }

        String[] types = new String[n];

        // Read connection types again from the created objects' order
        // using the input type stored separately is cleaner.
        // This array is populated in the next version below.
        sc.close();
    }
}