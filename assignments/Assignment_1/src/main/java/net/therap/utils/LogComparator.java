package net.therap.utils;

import net.therap.model.Log;

import java.util.Comparator;

/**
 * @author rokib.ahmed
 * @since 10/19/23
 */
public class LogComparator implements Comparator<Log> {

    @Override
    public int compare(Log log1, Log log2) {
        return log1.getTotalGetRequest() + log1.getTotalPostRequest() - log2.getTotalGetRequest() + log2.getTotalPostRequest();
    }

}
