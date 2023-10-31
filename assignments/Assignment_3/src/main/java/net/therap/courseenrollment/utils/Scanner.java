package net.therap.courseenrollment.utils;

/**
 * @author rokib.ahmed
 * @since 10/26/23
 */
public class Scanner {

    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    private Scanner() {
    }

    public static java.util.Scanner getScanner() {
        return scanner;
    }

}
