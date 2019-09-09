/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.clock;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class calcAngleBetweenAnalogClockHandsTest {

    calcAngleBetweenAnalogClockHands calc = new calcAngleBetweenAnalogClockHands();

    public calcAngleBetweenAnalogClockHandsTest() {
    }

    
    
    @Test
    public void test9oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T09:00:00");
        assertEquals(0, calc.calcAngle(dt), 0.1);
    }
    
    @Test
    public void testSecondStuff() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T03:15:45");
        assertEquals(180.0, calc.calcAngle(dt), 0.1);
    }
    
    
    
    /*Tests for Hour and Minute Hand
    @Test
    public void test9oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T09:00:00");
        assertEquals(90.0, calc.calcAngle(dt));
    }

    @Test
    public void test21oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T21:00:00");
        assertEquals(90.0, calc.calcAngle(dt));
    }

    @Test
    public void test3oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T03:00:00");
        assertEquals(90.0, calc.calcAngle(dt));
    }

    @Test
    public void test6oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T06:00:00");
        assertEquals(180.0, calc.calcAngle(dt));
    }
    
    @Test
    public void test417oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T04:17:00");
        assertEquals(18, calc.calcAngle(dt), 0.1);
    }
    
    @Test
    public void test345oclock() {
        LocalDateTime dt = LocalDateTime.parse("2004-12-03T15:45:00");
        assertEquals(180, calc.calcAngle(dt), 0.1);
    } */

}
