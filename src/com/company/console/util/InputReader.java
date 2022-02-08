package com.company.console.util;

import java.util.Scanner;

public class InputReader {

    private static final String INPUT_CURSOR = "> ";
    private static final Scanner scanner = new Scanner(System.in);

    private InputReader() {
    }

    public static String readLine() {
        System.out.print(INPUT_CURSOR);
        return scanner.nextLine();
    }

    public static char readOption() {
        return readLine().trim().charAt(0);
    }

    public static void enterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
