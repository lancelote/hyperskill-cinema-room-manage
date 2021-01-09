package stage2.project;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int cols = scanner.nextInt();

        int seats = rows * cols;
        int profit;

        System.out.println("Total income:");
        if (seats <= 60) {
            profit = seats * 10;
        } else {
            int frontHalf = (rows / 2) * cols;
            int backHalf = seats - frontHalf;
            profit = frontHalf * 10 + backHalf * 8;
        }

        System.out.printf("$%d", profit);
    }
}
