package stage3.project;

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

    private static Cinema readCinema() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cols = scanner.nextInt();

        return new Cinema(rows, cols);
    }

    private String getTopRow() {
        String[] topRow = new String[this.cols + 1];

        topRow[0] = " ";
        for (int i = 1; i < topRow.length; i++) {
            topRow[i] = String.valueOf(i);
        }

        return String.join(" ", topRow);
    }

    private void print() {
        System.out.println();
        System.out.println("Cinema:");

        String topRow = getTopRow();
        System.out.println(topRow);

        for (int i = 1; i <= seats.length; i++) {
            System.out.printf("%d ", i);
            String row = String.join(" ", seats[i - 1]);
            System.out.println(row);
        }
    }

    private void takeSeat(Seat seat) {
        seats[seat.row - 1][seat.col - 1] = "B";
    }

    private static Seat readSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();

        return new Seat(row, col);
    }

    private int totalSeats() {
        return cols * rows;
    }

    private boolean isFrontHalf(Seat seat) {
        return seat.row <= rows / 2;
    }

    private void printPrice(Seat seat) {
        System.out.println();
        int price;

        if (totalSeats() <= 60 || isFrontHalf(seat)) {
            price = 10;
        } else {
            price = 8;
        }

        System.out.printf("Ticket price: $%s", price);
        System.out.println();
    }

    public static void main(String[] args) {
        Cinema cinema = readCinema();
        cinema.print();

        Seat seat = readSeat();
        cinema.takeSeat(seat);
        cinema.printPrice(seat);

        cinema.print();
    }
}
