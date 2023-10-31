package net.therap.service;

import net.therap.model.Log;
import net.therap.utils.Constant;
import net.therap.utils.LogComparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author rokib.ahmed
 * @since 10/16/23
 */
public class LogParserService {

    public static Map<Integer, Log> parseLog(String filename, boolean isSortingNeeded) throws IOException {
        Map<Integer, Log> logMap = new LinkedHashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (int i = 0; i < 24; i++) {
            logMap.put(i, new Log());
        }

        for (String line : lines) {
            parseLogLine(line, logMap);
        }

        if (isSortingNeeded) {
            return sortLogMap(logMap);
        }

        return logMap;
    }

    private static void parseLogLine(String line, Map<Integer, Log> logMap) {
        Pattern patternForTime = Pattern.compile(Constant.REGEX_FOR_LOG_TIME);
        Pattern patternForActionMethod = Pattern.compile(Constant.REGEX_FOR_LOG_ACTION_METHOD);
        Pattern patternForURI = Pattern.compile(Constant.REGEX_FOR_LOG_URI);

        Matcher matcherForTime = patternForTime.matcher(line);

        if (matcherForTime.find()) {
            String matchedTime = matcherForTime.group();
            int hour = Integer.parseInt(matchedTime.split(":")[0]);
            Log log = logMap.getOrDefault(hour, new Log());

            Matcher matcherForActionMethod = patternForActionMethod.matcher(line);
            Matcher matcherForURI = patternForURI.matcher(line);

            if (matcherForActionMethod.find()) {
                String actionMethod = matcherForActionMethod.group(1);

                if (actionMethod.charAt(0) == 'G') {
                    log.setTotalGetRequest(log.getTotalGetRequest() + 1);

                } else if (actionMethod.charAt(0) == 'P') {
                    log.setTotalPostRequest(log.getTotalPostRequest() + 1);
                }

                String time = matcherForActionMethod.group(2);
                int responseTime = Integer.parseInt(time.split("m")[0]);

                log.setTotalResponseTime(log.getTotalResponseTime() + responseTime);
            }

            if (matcherForURI.find()) {
                String uri = matcherForURI.group(1);

                log.getUniqueUri().add(uri);
            }
        }
    }

    public static Map<Integer, Log> sortLogMap(Map<Integer, Log> unsortedMap) {

        return unsortedMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, new LogComparator()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
