package stage4.project;

import java.util.Arrays;
import java.util.Scanner;

class Seat {
    int row;
    int col;

    Seat(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Cinema {
    private final int rows;
    private final int cols;
    private final String[][] seats;

    private Cinema(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        seats = createEmptySeats(rows, cols);
    }

    private static String[][] createEmptySeats(int rows, int cols) {
        String[][] seats = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] row = new String[cols];
            Arrays.fill(row, "S");
            seats[i] = row;
        }

        return seats;
    }

    private String getTopRow() {
        String[] topRow = new String[this.cols + 1];

        topRow[0] = " ";
        for (int i = 1; i < topRow.length; i++) {
            topRow[i] = String.valueOf(i);
        }

        return String.join(" ", topRow);
    }

    private boolean isFrontHalf(Seat seat) {
        return seat.row <= rows / 2;
    }

    private int totalSeats() {
        return cols * rows;
    }

    private void printPrice(Seat seat) {
        int price;

        if (totalSeats() <= 60 || isFrontHalf(seat)) {
            price = 10;
        } else {
            price = 8;
        }

        System.out.printf("Ticket price: $%s\n", price);
        System.out.println();
    }

    private void takeSeat(Seat seat) {
        seats[seat.row - 1][seat.col - 1] = "B";
    }

    private static Seat selectSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();

        return new Seat(row, col);
    }

    private void buySeat() {
        Seat seat = selectSeat();
        takeSeat(seat);
        printPrice(seat);
    }

    private void printSeats() {
        System.out.println("Cinema:");

        String topRow = getTopRow();
        System.out.println(topRow);

        for (int i = 1; i <= seats.length; i++) {
            System.out.printf("%d ", i);
            String row = String.join(" ", seats[i - 1]);
            System.out.println(row);
        }
        System.out.println();
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");

            int input = scanner.nextInt();
            System.out.println();

            switch (input) {
                case 0:
                    return;
                case 1:
                    printSeats();
                    break;
                case 2:
                    buySeat();
                    break;
                default:
                    throw new RuntimeException(String.format("unknown menu command %d", input));
            }
        }
    }

    private static Cinema readCinema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cols = scanner.nextInt();

        System.out.println();

        return new Cinema(rows, cols);
    }

    public static void main(String[] args) {
        Cinema cinema = readCinema();
        cinema.showMenu();
    }
}
