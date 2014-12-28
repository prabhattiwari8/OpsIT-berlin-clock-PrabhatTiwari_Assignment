package com.ubs.opsit.exception;

/**
 * Created by cwr.prabhat.tiwari on 12/23/14.
 */
public class BerlinClockException extends Exception {
    public BerlinClockException(String message){
        super(message);
    }

    public BerlinClockException(String message, Throwable cause){
        super(message,cause);
    }

}
