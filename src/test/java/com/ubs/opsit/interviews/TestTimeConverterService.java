package com.ubs.opsit.interviews;

import com.ubs.opsit.exception.BerlinClockException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by cwr.prabhat.tiwari on 12/22/14.
 */
public class TestTimeConverterService {
    TimeConverterService instTimeConverterService = null;
    @Before
    public void setUp() {
        instTimeConverterService = new TimeConverterService();


    }

    @Test
    public void testWhenTime000000ShouldReturnTopHourAs0000() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getTopHour(0);
        assertEquals(strTopHour,"OOOO");
    }

    @Test
    public void testWhenTime240000ShouldReturnTopHourAsRRRR() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getTopHour(24);
        assertEquals(strTopHour,"RRRR");
    }

    @Test
    public void testWhenTime130000ShouldReturnTopHourAsRROO() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getTopHour(13);
        assertEquals(strTopHour,"RROO");
    }

    @Test
    public void testWhenTime230000ShouldReturnTopHourAsRROO() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getTopHour(23);
        assertEquals(strTopHour,"RRRR");
    }

    @Test(expected=BerlinClockException.class)
    public void testWhenTime250000ShouldReturnTopHourAsException() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getTopHour(25);

    }

    @Test
    public void testWhenTime000000ShouldReturnBottomHourAs0000() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getBottomHour(0);
        assertEquals(strTopHour,"OOOO");
    }

    @Test
    public void testWhenTime240000ShouldReturnBottomHourAsRRRR() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getBottomHour(24);
        assertEquals(strTopHour,"RRRR");
    }

    @Test
    public void testWhenTime130000ShouldReturnBottomHourAsRROO() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getBottomHour(13);
        assertEquals(strTopHour,"RRRO");
    }

    @Test
    public void testWhenTime230000ShouldReturnBottomHourAsRROO() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getBottomHour(23);
        assertEquals(strTopHour,"RRRO");
    }

    @Test(expected=BerlinClockException.class)
    public void testWhenTime250000ShouldReturnBottomHourAsException() throws BerlinClockException {
        String strTopHour = instTimeConverterService.getBottomHour(25);

    }

    @Test
    public void testWhenTime000000ShouldReturnTopMinuteAs00000000000() throws BerlinClockException {
        String strTopMinute = instTimeConverterService.getTopMinute(0);
        assertEquals(strTopMinute,"OOOOOOOOOOO");

    }
    @Test
    public void testWhenTime001700ShouldReturnTopMinuteAsYYROOOOOOOO() throws BerlinClockException {
        String strTopMinute = instTimeConverterService.getTopMinute(17);
        assertEquals(strTopMinute,"YYROOOOOOOO");

    }
    @Test
    public void testWhenTime005900ShouldReturnTopMinuteAsYYROOOOOOOO() throws BerlinClockException {
        String strTopMinute = instTimeConverterService.getTopMinute(59);
        assertEquals(strTopMinute,"YYRYYRYYRYY");

    }
    @Test(expected = BerlinClockException.class)
    public void testWhenTime006000ShouldReturnTopMinuteAsYYROOOOOOOO() throws BerlinClockException {
        String strTopMinute = instTimeConverterService.getTopMinute(60);
        }
    @Test
    public void testWhenTime000000ShouldReturnBottomMinuteAsOOOO() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.getBottomMinute(0);
        assertEquals(strBottomMinute,"OOOO");
    }
    @Test
    public void testWhenTime001700ShouldReturnBottomMinuteAsYYOO() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.getBottomMinute(17);
        assertEquals(strBottomMinute,"YYOO");
    }
    @Test
    public void testWhenTime005900ShouldReturnBottomMinuteAsYYYY() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.getBottomMinute(59);
        assertEquals(strBottomMinute,"YYYY");
    }
    @Test(expected = BerlinClockException.class)
    public void testWhenTime006000ShouldReturnBottomMinuteAsException() throws BerlinClockException {
        String strTopMinute = instTimeConverterService.getBottomMinute(60);
    }
    @Test
    public void testWhenTime000000ShouldReturnY_OOOO_OOOO_OOOOOOOOOOO_OOOO() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.convertTime("00:00:00");
        assertEquals(strBottomMinute,"Y\n" +
                "OOOO\n" +
                "OOOO\n" +
                "OOOOOOOOOOO\n" +
                "OOOO");
    }
    @Test
    public void testWhenTime131701ShouldReturnO_RROO_RRRO_YYROOOOOOOO_YYOO() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.convertTime("13:17:01");
        assertEquals(strBottomMinute,"O\n" +
                "RROO\n" +
                "RRRO\n" +
                "YYROOOOOOOO\n" +
                "YYOO");
    }
    @Test
    public void testWhenTime235959ShouldReturnO_RRRR_RRRO_YYRYYRYYRYY_YYYY() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.convertTime("23:59:59");
        assertEquals(strBottomMinute,"O\n" +
                "RRRR\n" +
                "RRRO\n" +
                "YYRYYRYYRYY\n" +
                "YYYY");
    }
    @Test
    public void testWhenTime240000shouldReturnO_RRRR_RRRR_OOOOOOOOOOO_OOOO() throws BerlinClockException {
        String strBottomMinute = instTimeConverterService.convertTime("24:00:00");
        assertEquals(strBottomMinute,"Y\n" +
                "RRRR\n" +
                "RRRR\n" +
                "OOOOOOOOOOO\n" +
                "OOOO");
    }
}
