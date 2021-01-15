package stage5.hw01;

import java.util.Scanner;

public class Main {
    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int median(int a, int b, int c) {
        return a + b + c - min(a, b, c) - max(a, b, c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();

        int shortest1 = min(x1, y1, z1);
        int median1 = median(x1, y1, z1);
        int longest1 = max(x1, y1, z1);

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();

        int shortest2 = min(x2, y2, z2);
        int median2 = median(x2, y2, z2);
        int longest2 = max(x2, y2, z2);

        if (shortest1 < shortest2 && median1 < median2 && longest1 < longest2) {
            System.out.println("Box 1 < Box 2");
        } else if (shortest2 < shortest1 && median2 < median1 && longest2 < longest1) {
            System.out.println("Box 1 > Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}
