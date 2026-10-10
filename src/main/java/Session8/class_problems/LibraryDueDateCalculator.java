package Session8.class_problems;

import java.util.*;
import java.time.*;
import java.time.format.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getBorrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 3;
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"", 3);

            String type = parts[0].trim();
            String title = parts.length > 1
                    ? parts[1]
                    : parts[0].substring(type.length()).trim();

            switch (type) {
                case "BOOK":
                    items[i] = new Book(title);
                    break;
                case "DVD":
                    items[i] = new DVD(title);
                    break;
                case "MAGAZINE":
                    items[i] = new Magazine(title);
                    break;
            }
        }

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (LibraryItem item : items) {
            System.out.println(item.title + ": "
                    + item.getDueDate().format(format));
        }

        sc.close();
    }
}
