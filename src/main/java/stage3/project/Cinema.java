package stage3.project;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private final int rows;
    private final int cols;
    private String[][] seats;

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

    private int getTotalSeats() {
        return rows * cols;
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
        System.out.println("Cinema:");

        String topRow = getTopRow();
        System.out.println(topRow);

        for (int i = 1; i <= seats.length; i++) {
            System.out.printf("%d ", i);
            String row = String.join(" ", seats[i - 1]);
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        Cinema cinema = readCinema();
        cinema.print();
    }
}
