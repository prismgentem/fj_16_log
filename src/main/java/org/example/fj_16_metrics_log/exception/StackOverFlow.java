package org.example.fj_16_metrics_log.exception;

public class StackOverFlow {
    public static void main(String[] args) {
        recursion();
    }

    private static void recursion() {
        recursion();
    }
}
