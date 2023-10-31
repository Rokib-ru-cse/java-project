package net.therap.utils;


import net.therap.model.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author rokib.ahmed
 * @since 10/18/23
 */


public class LogFormatter {

    public static List<String> format(Map<Integer, Log> logMap) {
        List<String> logStringList = new ArrayList<>();

        for (Map.Entry<Integer, Log> entry : logMap.entrySet()) {
            Log log = entry.getValue();

            int key = entry.getKey();
            String period = (key < 12) ? "am" : "pm";
            String startTime = ((key % 12 == 0) ? 12 : key % 12) + ".00 " + period + " - ";
            key++;
            period = (key < 12) ? "am" : "pm";
            if (key == 0 || key == 24) {
                period = "am";
            }
            String endTime = ((key % 12 == 0) ? 12 : key % 12) + ".00 " + period;

            String logString = startTime + endTime
                    + "\t\t\t\t"
                    + log.getTotalGetRequest() + "/" + log.getTotalPostRequest()
                    + "\t\t\t\t"
                    + log.getUniqueUri().size()
                    + "\t\t\t\t\t"
                    + log.getTotalResponseTime();

            logStringList.add(logString);
        }

        return logStringList;
    }

}
