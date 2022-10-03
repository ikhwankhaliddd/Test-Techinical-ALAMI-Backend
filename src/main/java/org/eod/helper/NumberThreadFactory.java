package org.eod.helper;

import java.util.concurrent.ThreadFactory;

public class NumberThreadFactory implements ThreadFactory {
    int count = 0;
    public Thread newThread(Runnable r) {
        return new Thread(r, String.valueOf(count++));
    }
}