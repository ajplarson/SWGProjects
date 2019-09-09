/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.clock;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ajplarson
 */
public class calcAngleBetweenAnalogClockHands {

    private static final double MINUTES = 60;
    private static final double SECONDS = 60;
    private static final double HOURS = 12;
    private static final double CLOCK_DEGREES = 360;

    public double calcAngle(LocalDateTime dt) {
        double hourHand = (double) dt.getHour() % 12;
        double minuteHand = (double) dt.getMinute();
        double secondHand = (double) dt.getSecond();

        double angleOfHourHand = (hourHand / HOURS) * CLOCK_DEGREES;
        double angleOfMinuteHand = (minuteHand / MINUTES) * CLOCK_DEGREES;
        double angleOfSecondHand = (secondHand / SECONDS) * CLOCK_DEGREES;

        double angleBetweenSecondAndMinute = Math.abs(angleOfSecondHand - angleOfMinuteHand);
        if (angleBetweenSecondAndMinute > 180) {
            return Math.abs(180 - angleBetweenSecondAndMinute);
        }
        return angleBetweenSecondAndMinute;
        
        /* Angle between hour and minute
        double angleBetweenHands = Math.abs(angleOfHourHand - angleOfMinuteHand);

         if (angleBetweenHands > 180) {
           return Math.abs(180 - angleBetweenHands);
       } 
       return angleBetweenHands; */
    }

}
