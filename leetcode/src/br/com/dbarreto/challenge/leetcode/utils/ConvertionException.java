package br.com.dbarreto.challenge.leetcode.utils;

public class ConvertionException extends RuntimeException {
    public ConvertionException(String message) {
        super(message);
    }

    public ConvertionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertionException(Throwable cause) {
        super(cause);
    }
}
