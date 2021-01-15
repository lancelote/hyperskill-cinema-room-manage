package stage5.hw03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        if (line1.replace(" ", "").equals(line2.replace(" ", ""))) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
