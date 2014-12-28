package com.ubs.opsit.interviews;

import com.ubs.opsit.exception.BerlinClockException;

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

/**
 * Created by cwr.prabhat.tiwari on 12/22/14.
 */
public class TimeConverterService implements TimeConverter {
    @Override
    public String convertTime(String time) throws BerlinClockException {
        List<Integer> parts = new ArrayList<Integer>();
        for (String part : time.split(":")) {
            parts.add(Integer.parseInt(part));
        }
        return new String(
                getSeconds(parts.get(2))+"\n"
                +getTopHour(parts.get(0))+"\n"
                +getBottomHour(parts.get(0))+"\n"
                +getTopMinute(parts.get(1))+"\n"
                +getBottomMinute(parts.get(1))
        );
    }

    protected String getBottomHour(int number) throws BerlinClockException {
        if(number > 24)
            throw new BerlinClockException("Incorrect Value for Hour");

        int iBottomHourCount=number % 5;

        return createTopHourCountString(4,iBottomHourCount);
    }

    protected String getTopHour(int number) throws BerlinClockException {

        if(number > 24){
            throw new BerlinClockException("Incorrect Value for Hour");
        }
        int iTopHourCount=number / 5;

        return createTopHourCountString(4,iTopHourCount);
    }

    private String createTopHourCountString(int iTotalTopHourCount,int iTopHourCount) {
        StringBuffer strTopHour = new StringBuffer();
        for(int i =0;i<iTotalTopHourCount;i++){
            if(i < iTopHourCount)
            strTopHour.append("R");
            else
             strTopHour.append("O");
        }
        return strTopHour.toString();

    }

    protected String getTopMinute(int iTopMinute) throws BerlinClockException {
        if(iTopMinute > 59){
            throw new BerlinClockException("Incorrect Value for Minute");
        }

        int iTopMinuteCount=iTopMinute/5;
        return createTopMinuteCountString(11, iTopMinuteCount);

    }

    protected  String getBottomMinute(int iBottomMinute) throws BerlinClockException{
        if(iBottomMinute > 59){
            throw new BerlinClockException("Incorrect Value for Minute");
        }
        int iBottomMinuteCount=iBottomMinute%5;
        return createBottomMinuteCountString(4, iBottomMinuteCount);
    }

    private String createBottomMinuteCountString(int iTotalBottomMinuteCount, int iBottomMinuteCount) {
        StringBuffer strBottomMinute = new StringBuffer();
        for(int i =0;i<iTotalBottomMinuteCount;i++){
            if(i < iBottomMinuteCount)
                strBottomMinute.append("Y");
            else
                strBottomMinute.append("O");
        }
        return strBottomMinute.toString();
    }

    private String createTopMinuteCountString(int iTotalMinuteCount,int iMinuteCount) {
        StringBuffer strMinute = new StringBuffer();
        for(int i =1;i<=iTotalMinuteCount;i++) {
            if (i <= iMinuteCount) {
                if ((i != 1) && (i % 3 == 0))
                    strMinute.append("R");
                else
                    strMinute.append("Y");
            }
            else{
                strMinute.append("O");
            }
        }
        return strMinute.toString();
    }
    protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }

}

