package stage5.hw02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int start = scanner.nextInt();
        int stop = scanner.nextInt();
        System.out.println(string.substring(start, stop + 1));
    }
}
