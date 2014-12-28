package com.ubs.opsit.interviews;

import com.ubs.opsit.exception.BerlinClockException;

public interface TimeConverter {

    String convertTime(String aTime) throws BerlinClockException;

}
