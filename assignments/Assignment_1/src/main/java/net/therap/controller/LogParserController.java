package net.therap.controller;

import net.therap.model.Log;
import net.therap.service.LogParserService;
import net.therap.utils.Constant;
import net.therap.utils.LogFormatter;
import net.therap.validator.LogParserValidator;
import net.therap.view.LogParserView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author rokib.ahmed
 * @since 10/16/23
 */
public class LogParserController {

    public static void main(String[] args) {
        try {
            LogParserValidator.validateCommandLineArguments(args);

            String filename = args[0];
            boolean isSortingNeeded = asList(args).contains(Constant.SORT_ARG);

            Map<Integer, Log> logList = LogParserService.parseLog(filename, isSortingNeeded);

            List<String> logStringList = LogFormatter.format(logList);

            LogParserView.displayLog(logStringList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
