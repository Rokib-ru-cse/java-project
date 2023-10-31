package net.therap.view;

import java.util.List;

/**
 * @author rokib.ahmed
 * @since 10/16/23
 */
public class LogParserView {

    public static void displayLog(List<String> logStringList) {
        System.out.print("Time\t\t\t\t\t");
        System.out.print("Get / Post Count\t");
        System.out.print("Unique URI Count\t");
        System.out.println("Total Response Time");

        logStringList.forEach(System.out::println);
    }

}
