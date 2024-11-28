package org.example.fj_16_metrics_log.exception;

public class OutOfMemory {
    public static void main(String[] args) {
        int[][] array = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
    }
}
