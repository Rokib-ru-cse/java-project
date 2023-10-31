package net.therap.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rokib.ahmed
 * @since 10/16/23
 */
public class Log {

    private int totalGetRequest;
    private int totalPostRequest;
    private int totalResponseTime;

    private Set<String> uniqueUri = new HashSet<>();

    public int getTotalGetRequest() {
        return totalGetRequest;
    }

    public void setTotalGetRequest(int totalGetRequest) {
        this.totalGetRequest = totalGetRequest;
    }

    public int getTotalPostRequest() {
        return totalPostRequest;
    }

    public void setTotalPostRequest(int totalPostRequest) {
        this.totalPostRequest = totalPostRequest;
    }

    public Set<String> getUniqueUri() {
        return uniqueUri;
    }

    public void setUniqueUri(Set<String> uniqueUri) {
        this.uniqueUri = uniqueUri;
    }

    public int getTotalResponseTime() {
        return totalResponseTime;
    }

    public void setTotalResponseTime(int totalResponseTime) {
        this.totalResponseTime = totalResponseTime;
    }

}
