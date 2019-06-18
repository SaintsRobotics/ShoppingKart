package frc.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import frc.robot.util.AngleUtilities;

public class testAngleUtilities {

    @Test
    public void testFindAngle() {
        assertEquals(270.0, AngleUtilities.findAngle(-1, 0),0.1);
        assertEquals(90.0,AngleUtilities.findAngle(1,0),0.1);
        assertEquals(45.0,AngleUtilities.findAngle(1,1),0.1);
        assertEquals(48.01,AngleUtilities.findAngle(1,0.9),0.1);
        assertEquals(51.3,AngleUtilities.findAngle(1,0.8),0.1);
        assertEquals(55,AngleUtilities.findAngle(1,0.7),0.1);
        assertEquals(59.03,AngleUtilities.findAngle(1,0.6),0.1);
        assertEquals(63.43,AngleUtilities.findAngle(1,0.5),0.1);
        assertEquals(68.19,AngleUtilities.findAngle(1,0.4),0.1);
        assertEquals(73.3,AngleUtilities.findAngle(1,0.3),0.1);
        assertEquals(78.69,AngleUtilities.findAngle(1,0.2),0.1);
        assertEquals(84.28,AngleUtilities.findAngle(1,0.1),0.1);
        assertEquals(95.71,AngleUtilities.findAngle(1,-0.1),0.1);
        assertEquals(101.3,AngleUtilities.findAngle(1,-0.2),0.1);
        assertEquals(106.69,AngleUtilities.findAngle(1,-0.3),0.1);
        assertEquals(111.8,AngleUtilities.findAngle(1,-0.4),0.1);
        assertEquals(116.56,AngleUtilities.findAngle(1,-0.5),0.1);
        assertEquals(120.96,AngleUtilities.findAngle(1,-0.6),0.1);
        assertEquals(124.99,AngleUtilities.findAngle(1,-0.7),0.1);
        assertEquals(128.65,AngleUtilities.findAngle(1,-0.8),0.1);
        assertEquals(131.98,AngleUtilities.findAngle(1,-0.9),0.1);
        assertEquals(135.0,AngleUtilities.findAngle(1,-1),0.1);
    }
}