package frc.robot;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import frc.robot.util.AngleUtilities;

public class testAngleUtilities {

    @Test
    public void testFindAngle() {
        assertEquals("(-1.0,-1.0) should be angle", 225.0, AngleUtilities.findAngle(-1.0, -1.0), 0.1);
        assertEquals("(-1.0,-0.8) should be angle", 231.34019174590992, AngleUtilities.findAngle(-1.0, -0.8), 0.1);
        assertEquals("(-1.0,-0.6000000000000001) should be angle", 239.03624346792648,
                AngleUtilities.findAngle(-1.0, -0.6000000000000001), 0.1);
        assertEquals("(-1.0,-0.4000000000000001) should be angle", 248.19859051364818,
                AngleUtilities.findAngle(-1.0, -0.4000000000000001), 0.1);
        assertEquals("(-1.0,-0.20000000000000007) should be angle", 258.69006752597977,
                AngleUtilities.findAngle(-1.0, -0.20000000000000007), 0.1);
        assertEquals("(-1.0,-5.551115123125783E-17) should be angle", 270.0,
                AngleUtilities.findAngle(-1.0, -5.551115123125783E-17), 0.1);
        assertEquals("(-1.0,0.19999999999999996) should be angle", 281.30993247402023,
                AngleUtilities.findAngle(-1.0, 0.19999999999999996), 0.1);
        assertEquals("(-1.0,0.39999999999999997) should be angle", 291.8014094863518,
                AngleUtilities.findAngle(-1.0, 0.39999999999999997), 0.1);
        assertEquals("(-1.0,0.6) should be angle", 300.9637565320735, AngleUtilities.findAngle(-1.0, 0.6), 0.1);
        assertEquals("(-1.0,0.8) should be angle", 308.6598082540901, AngleUtilities.findAngle(-1.0, 0.8), 0.1);
        assertEquals("(-1.0,1.0) should be angle", 315.0, AngleUtilities.findAngle(-1.0, 1.0), 0.1);
        assertEquals("(-0.8,-1.0) should be angle", 218.65980825409008, AngleUtilities.findAngle(-0.8, -1.0), 0.1);
        assertEquals("(-0.8,-0.8) should be angle", 225.0, AngleUtilities.findAngle(-0.8, -0.8), 0.1);
        assertEquals("(-0.8,-0.6000000000000001) should be angle", 233.13010235415598,
                AngleUtilities.findAngle(-0.8, -0.6000000000000001), 0.1);
        assertEquals("(-0.8,-0.4000000000000001) should be angle", 243.43494882292202,
                AngleUtilities.findAngle(-0.8, -0.4000000000000001), 0.1);
        assertEquals("(-0.8,-0.20000000000000007) should be angle", 255.96375653207352,
                AngleUtilities.findAngle(-0.8, -0.20000000000000007), 0.1);
        assertEquals("(-0.8,-5.551115123125783E-17) should be angle", 270.0,
                AngleUtilities.findAngle(-0.8, -5.551115123125783E-17), 0.1);
        assertEquals("(-0.8,0.19999999999999996) should be angle", 284.03624346792645,
                AngleUtilities.findAngle(-0.8, 0.19999999999999996), 0.1);
        assertEquals("(-0.8,0.39999999999999997) should be angle", 296.565051177078,
                AngleUtilities.findAngle(-0.8, 0.39999999999999997), 0.1);
        assertEquals("(-0.8,0.6) should be angle", 306.869897645844, AngleUtilities.findAngle(-0.8, 0.6), 0.1);
        assertEquals("(-0.8,0.8) should be angle", 315.0, AngleUtilities.findAngle(-0.8, 0.8), 0.1);
        assertEquals("(-0.8,1.0) should be angle", 321.3401917459099, AngleUtilities.findAngle(-0.8, 1.0), 0.1);
        assertEquals("(-0.6000000000000001,-1.0) should be angle", 210.96375653207352,
                AngleUtilities.findAngle(-0.6000000000000001, -1.0), 0.1);
        assertEquals("(-0.6000000000000001,-0.8) should be angle", 216.86989764584402,
                AngleUtilities.findAngle(-0.6000000000000001, -0.8), 0.1);
        assertEquals("(-0.6000000000000001,-0.6000000000000001) should be angle", 225.0,
                AngleUtilities.findAngle(-0.6000000000000001, -0.6000000000000001), 0.1);
        assertEquals("(-0.6000000000000001,-0.4000000000000001) should be angle", 236.30993247402023,
                AngleUtilities.findAngle(-0.6000000000000001, -0.4000000000000001), 0.1);
        assertEquals("(-0.6000000000000001,-0.20000000000000007) should be angle", 251.56505117707798,
                AngleUtilities.findAngle(-0.6000000000000001, -0.20000000000000007), 0.1);
        assertEquals("(-0.6000000000000001,-5.551115123125783E-17) should be angle", 270.0,
                AngleUtilities.findAngle(-0.6000000000000001, -5.551115123125783E-17), 0.1);
        assertEquals("(-0.6000000000000001,0.19999999999999996) should be angle", 288.434948822922,
                AngleUtilities.findAngle(-0.6000000000000001, 0.19999999999999996), 0.1);
        assertEquals("(-0.6000000000000001,0.39999999999999997) should be angle", 303.69006752597977,
                AngleUtilities.findAngle(-0.6000000000000001, 0.39999999999999997), 0.1);
        assertEquals("(-0.6000000000000001,0.6) should be angle", 315.0,
                AngleUtilities.findAngle(-0.6000000000000001, 0.6), 0.1);
        assertEquals("(-0.6000000000000001,0.8) should be angle", 323.13010235415595,
                AngleUtilities.findAngle(-0.6000000000000001, 0.8), 0.1);
        assertEquals("(-0.6000000000000001,1.0) should be angle", 329.03624346792645,
                AngleUtilities.findAngle(-0.6000000000000001, 1.0), 0.1);
        assertEquals("(-0.4000000000000001,-1.0) should be angle", 201.80140948635182,
                AngleUtilities.findAngle(-0.4000000000000001, -1.0), 0.1);
        assertEquals("(-0.4000000000000001,-0.8) should be angle", 206.565051177078,
                AngleUtilities.findAngle(-0.4000000000000001, -0.8), 0.1);
        assertEquals("(-0.4000000000000001,-0.6000000000000001) should be angle", 213.6900675259798,
                AngleUtilities.findAngle(-0.4000000000000001, -0.6000000000000001), 0.1);
        assertEquals("(-0.4000000000000001,-0.4000000000000001) should be angle", 225.0,
                AngleUtilities.findAngle(-0.4000000000000001, -0.4000000000000001), 0.1);
        assertEquals("(-0.4000000000000001,-0.20000000000000007) should be angle", 243.43494882292202,
                AngleUtilities.findAngle(-0.4000000000000001, -0.20000000000000007), 0.1);
        assertEquals("(-0.4000000000000001,-5.551115123125783E-17) should be angle", 270.0,
                AngleUtilities.findAngle(-0.4000000000000001, -5.551115123125783E-17), 0.1);
        assertEquals("(-0.4000000000000001,0.19999999999999996) should be angle", 296.565051177078,
                AngleUtilities.findAngle(-0.4000000000000001, 0.19999999999999996), 0.1);
        assertEquals("(-0.4000000000000001,0.39999999999999997) should be angle", 315.0,
                AngleUtilities.findAngle(-0.4000000000000001, 0.39999999999999997), 0.1);
        assertEquals("(-0.4000000000000001,0.6) should be angle", 326.30993247402023,
                AngleUtilities.findAngle(-0.4000000000000001, 0.6), 0.1);
        assertEquals("(-0.4000000000000001,0.8) should be angle", 333.434948822922,
                AngleUtilities.findAngle(-0.4000000000000001, 0.8), 0.1);
        assertEquals("(-0.4000000000000001,1.0) should be angle", 338.1985905136482,
                AngleUtilities.findAngle(-0.4000000000000001, 1.0), 0.1);
        assertEquals("(-0.20000000000000007,-1.0) should be angle", 191.30993247402023,
                AngleUtilities.findAngle(-0.20000000000000007, -1.0), 0.1);
        assertEquals("(-0.20000000000000007,-0.8) should be angle", 194.03624346792648,
                AngleUtilities.findAngle(-0.20000000000000007, -0.8), 0.1);
        assertEquals("(-0.20000000000000007,-0.6000000000000001) should be angle", 198.43494882292202,
                AngleUtilities.findAngle(-0.20000000000000007, -0.6000000000000001), 0.1);
        assertEquals("(-0.20000000000000007,-0.4000000000000001) should be angle", 206.565051177078,
                AngleUtilities.findAngle(-0.20000000000000007, -0.4000000000000001), 0.1);
        assertEquals("(-0.20000000000000007,-0.20000000000000007) should be angle", 225.0,
                AngleUtilities.findAngle(-0.20000000000000007, -0.20000000000000007), 0.1);
        assertEquals("(-0.20000000000000007,-5.551115123125783E-17) should be angle", 270.0,
                AngleUtilities.findAngle(-0.20000000000000007, -5.551115123125783E-17), 0.1);
        assertEquals("(-0.20000000000000007,0.19999999999999996) should be angle", 315.0,
                AngleUtilities.findAngle(-0.20000000000000007, 0.19999999999999996), 0.1);
        assertEquals("(-0.20000000000000007,0.39999999999999997) should be angle", 333.434948822922,
                AngleUtilities.findAngle(-0.20000000000000007, 0.39999999999999997), 0.1);
        assertEquals("(-0.20000000000000007,0.6) should be angle", 341.565051177078,
                AngleUtilities.findAngle(-0.20000000000000007, 0.6), 0.1);
        assertEquals("(-0.20000000000000007,0.8) should be angle", 345.9637565320735,
                AngleUtilities.findAngle(-0.20000000000000007, 0.8), 0.1);
        assertEquals("(-0.20000000000000007,1.0) should be angle", 348.69006752597977,
                AngleUtilities.findAngle(-0.20000000000000007, 1.0), 0.1);
        assertEquals("(-5.551115123125783E-17,-1.0) should be angle", 180.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, -1.0), 0.1);
        assertEquals("(-5.551115123125783E-17,-0.8) should be angle", 180.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, -0.8), 0.1);
        assertEquals("(-5.551115123125783E-17,-0.6000000000000001) should be angle", 180.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, -0.6000000000000001), 0.1);
        assertEquals("(-5.551115123125783E-17,-0.4000000000000001) should be angle", 180.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, -0.4000000000000001), 0.1);
        assertEquals("(-5.551115123125783E-17,-0.20000000000000007) should be angle", 180.00000000000003,
                AngleUtilities.findAngle(-5.551115123125783E-17, -0.20000000000000007), 0.1);
        assertEquals("(-5.551115123125783E-17,-5.551115123125783E-17) should be angle", 225.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, -5.551115123125783E-17), 0.1);
        assertEquals("(-5.551115123125783E-17,0.19999999999999996) should be angle", 0.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, 0.19999999999999996), 0.1);
        assertEquals("(-5.551115123125783E-17,0.39999999999999997) should be angle", 0.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, 0.39999999999999997), 0.1);
        assertEquals("(-5.551115123125783E-17,0.6) should be angle", 0.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, 0.6), 0.1);
        assertEquals("(-5.551115123125783E-17,0.8) should be angle", 0.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, 0.8), 0.1);
        assertEquals("(-5.551115123125783E-17,1.0) should be angle", 0.0,
                AngleUtilities.findAngle(-5.551115123125783E-17, 1.0), 0.1);
        assertEquals("(0.19999999999999996,-1.0) should be angle", 168.6900675259798,
                AngleUtilities.findAngle(0.19999999999999996, -1.0), 0.1);
        assertEquals("(0.19999999999999996,-0.8) should be angle", 165.96375653207352,
                AngleUtilities.findAngle(0.19999999999999996, -0.8), 0.1);
        assertEquals("(0.19999999999999996,-0.6000000000000001) should be angle", 161.565051177078,
                AngleUtilities.findAngle(0.19999999999999996, -0.6000000000000001), 0.1);
        assertEquals("(0.19999999999999996,-0.4000000000000001) should be angle", 153.43494882292202,
                AngleUtilities.findAngle(0.19999999999999996, -0.4000000000000001), 0.1);
        assertEquals("(0.19999999999999996,-0.20000000000000007) should be angle", 135.0,
                AngleUtilities.findAngle(0.19999999999999996, -0.20000000000000007), 0.1);
        assertEquals("(0.19999999999999996,-5.551115123125783E-17) should be angle", 90.00000000000001,
                AngleUtilities.findAngle(0.19999999999999996, -5.551115123125783E-17), 0.1);
        assertEquals("(0.19999999999999996,0.19999999999999996) should be angle", 45.0,
                AngleUtilities.findAngle(0.19999999999999996, 0.19999999999999996), 0.1);
        assertEquals("(0.19999999999999996,0.39999999999999997) should be angle", 26.565051177077976,
                AngleUtilities.findAngle(0.19999999999999996, 0.39999999999999997), 0.1);
        assertEquals("(0.19999999999999996,0.6) should be angle", 18.434948822922024,
                AngleUtilities.findAngle(0.19999999999999996, 0.6), 0.1);
        assertEquals("(0.19999999999999996,0.8) should be angle", 14.036243467926454,
                AngleUtilities.findAngle(0.19999999999999996, 0.8), 0.1);
        assertEquals("(0.19999999999999996,1.0) should be angle", 11.30993247402023,
                AngleUtilities.findAngle(0.19999999999999996, 1.0), 0.1);
        assertEquals("(0.39999999999999997,-1.0) should be angle", 158.19859051364818,
                AngleUtilities.findAngle(0.39999999999999997, -1.0), 0.1);
        assertEquals("(0.39999999999999997,-0.8) should be angle", 153.43494882292202,
                AngleUtilities.findAngle(0.39999999999999997, -0.8), 0.1);
        assertEquals("(0.39999999999999997,-0.6000000000000001) should be angle", 146.30993247402023,
                AngleUtilities.findAngle(0.39999999999999997, -0.6000000000000001), 0.1);
        assertEquals("(0.39999999999999997,-0.4000000000000001) should be angle", 135.0,
                AngleUtilities.findAngle(0.39999999999999997, -0.4000000000000001), 0.1);
        assertEquals("(0.39999999999999997,-0.20000000000000007) should be angle", 116.56505117707799,
                AngleUtilities.findAngle(0.39999999999999997, -0.20000000000000007), 0.1);
        assertEquals("(0.39999999999999997,-5.551115123125783E-17) should be angle", 90.0,
                AngleUtilities.findAngle(0.39999999999999997, -5.551115123125783E-17), 0.1);
        assertEquals("(0.39999999999999997,0.19999999999999996) should be angle", 63.434948822922024,
                AngleUtilities.findAngle(0.39999999999999997, 0.19999999999999996), 0.1);
        assertEquals("(0.39999999999999997,0.39999999999999997) should be angle", 45.0,
                AngleUtilities.findAngle(0.39999999999999997, 0.39999999999999997), 0.1);
        assertEquals("(0.39999999999999997,0.6) should be angle", 33.69006752597977,
                AngleUtilities.findAngle(0.39999999999999997, 0.6), 0.1);
        assertEquals("(0.39999999999999997,0.8) should be angle", 26.565051177077976,
                AngleUtilities.findAngle(0.39999999999999997, 0.8), 0.1);
        assertEquals("(0.39999999999999997,1.0) should be angle", 21.801409486351815,
                AngleUtilities.findAngle(0.39999999999999997, 1.0), 0.1);
        assertEquals("(0.6,-1.0) should be angle", 149.03624346792648, AngleUtilities.findAngle(0.6, -1.0), 0.1);
        assertEquals("(0.6,-0.8) should be angle", 143.13010235415598, AngleUtilities.findAngle(0.6, -0.8), 0.1);
        assertEquals("(0.6,-0.6000000000000001) should be angle", 135.0,
                AngleUtilities.findAngle(0.6, -0.6000000000000001), 0.1);
        assertEquals("(0.6,-0.4000000000000001) should be angle", 123.6900675259798,
                AngleUtilities.findAngle(0.6, -0.4000000000000001), 0.1);
        assertEquals("(0.6,-0.20000000000000007) should be angle", 108.43494882292201,
                AngleUtilities.findAngle(0.6, -0.20000000000000007), 0.1);
        assertEquals("(0.6,-5.551115123125783E-17) should be angle", 90.0,
                AngleUtilities.findAngle(0.6, -5.551115123125783E-17), 0.1);
        assertEquals("(0.6,0.19999999999999996) should be angle", 71.56505117707798,
                AngleUtilities.findAngle(0.6, 0.19999999999999996), 0.1);
        assertEquals("(0.6,0.39999999999999997) should be angle", 56.30993247402023,
                AngleUtilities.findAngle(0.6, 0.39999999999999997), 0.1);
        assertEquals("(0.6,0.6) should be angle", 45.0, AngleUtilities.findAngle(0.6, 0.6), 0.1);
        assertEquals("(0.6,0.8) should be angle", 36.86989764584399, AngleUtilities.findAngle(0.6, 0.8), 0.1);
        assertEquals("(0.6,1.0) should be angle", 30.963756532073546, AngleUtilities.findAngle(0.6, 1.0), 0.1);
        assertEquals("(0.8,-1.0) should be angle", 141.34019174590992, AngleUtilities.findAngle(0.8, -1.0), 0.1);
        assertEquals("(0.8,-0.8) should be angle", 135.0, AngleUtilities.findAngle(0.8, -0.8), 0.1);
        assertEquals("(0.8,-0.6000000000000001) should be angle", 126.86989764584402,
                AngleUtilities.findAngle(0.8, -0.6000000000000001), 0.1);
        assertEquals("(0.8,-0.4000000000000001) should be angle", 116.56505117707799,
                AngleUtilities.findAngle(0.8, -0.4000000000000001), 0.1);
        assertEquals("(0.8,-0.20000000000000007) should be angle", 104.03624346792648,
                AngleUtilities.findAngle(0.8, -0.20000000000000007), 0.1);
        assertEquals("(0.8,-5.551115123125783E-17) should be angle", 90.0,
                AngleUtilities.findAngle(0.8, -5.551115123125783E-17), 0.1);
        assertEquals("(0.8,0.19999999999999996) should be angle", 75.96375653207355,
                AngleUtilities.findAngle(0.8, 0.19999999999999996), 0.1);
        assertEquals("(0.8,0.39999999999999997) should be angle", 63.434948822922024,
                AngleUtilities.findAngle(0.8, 0.39999999999999997), 0.1);
        assertEquals("(0.8,0.6) should be angle", 53.13010235415601, AngleUtilities.findAngle(0.8, 0.6), 0.1);
        assertEquals("(0.8,0.8) should be angle", 45.0, AngleUtilities.findAngle(0.8, 0.8), 0.1);
        assertEquals("(0.8,1.0) should be angle", 38.65980825409008, AngleUtilities.findAngle(0.8, 1.0), 0.1);
        assertEquals("(1.0,-1.0) should be angle", 135.0, AngleUtilities.findAngle(1.0, -1.0), 0.1);
        assertEquals("(1.0,-0.8) should be angle", 128.65980825409008, AngleUtilities.findAngle(1.0, -0.8), 0.1);
        assertEquals("(1.0,-0.6000000000000001) should be angle", 120.96375653207352,
                AngleUtilities.findAngle(1.0, -0.6000000000000001), 0.1);
        assertEquals("(1.0,-0.4000000000000001) should be angle", 111.80140948635182,
                AngleUtilities.findAngle(1.0, -0.4000000000000001), 0.1);
        assertEquals("(1.0,-0.20000000000000007) should be angle", 101.30993247402021,
                AngleUtilities.findAngle(1.0, -0.20000000000000007), 0.1);
        assertEquals("(1.0,-5.551115123125783E-17) should be angle", 90.0,
                AngleUtilities.findAngle(1.0, -5.551115123125783E-17), 0.1);
        assertEquals("(1.0,0.19999999999999996) should be angle", 78.69006752597977,
                AngleUtilities.findAngle(1.0, 0.19999999999999996), 0.1);
        assertEquals("(1.0,0.39999999999999997) should be angle", 68.19859051364818,
                AngleUtilities.findAngle(1.0, 0.39999999999999997), 0.1);
        assertEquals("(1.0,0.6) should be angle", 59.03624346792651, AngleUtilities.findAngle(1.0, 0.6), 0.1);
        assertEquals("(1.0,0.8) should be angle", 51.34019174590992, AngleUtilities.findAngle(1.0, 0.8), 0.1);
        assertEquals("(1.0,1.0) should be angle", 45.0, AngleUtilities.findAngle(1.0, 1.0), 0.1);
    }

    @Test
    public void testCartesianToPolar() {
        double[] test0 = { -1.0, -1.0 };
        double[] answer0 = { 225.0, 1.4142135623730951 };
        assertArrayEquals("[-1.0, -1.0] should be [225.0, 1.4142135623730951]", answer0,
                AngleUtilities.cartesianToPolar(test0), 0.1);
        double[] test1 = { -1.0, -0.8 };
        double[] answer1 = { 231.34019174590992, 1.2806248474865698 };
        assertArrayEquals("[-1.0, -0.8] should be [231.34019174590992, 1.2806248474865698]", answer1,
                AngleUtilities.cartesianToPolar(test1), 0.1);
        double[] test2 = { -1.0, -0.6000000000000001 };
        double[] answer2 = { 239.03624346792648, 1.1661903789690602 };
        assertArrayEquals("[-1.0, -0.6000000000000001] should be [239.03624346792648, 1.1661903789690602]", answer2,
                AngleUtilities.cartesianToPolar(test2), 0.1);
        double[] test3 = { -1.0, -0.4000000000000001 };
        double[] answer3 = { 248.19859051364818, 1.077032961426901 };
        assertArrayEquals("[-1.0, -0.4000000000000001] should be [248.19859051364818, 1.077032961426901]", answer3,
                AngleUtilities.cartesianToPolar(test3), 0.1);
        double[] test4 = { -1.0, -0.20000000000000007 };
        double[] answer4 = { 258.69006752597977, 1.019803902718557 };
        assertArrayEquals("[-1.0, -0.20000000000000007] should be [258.69006752597977, 1.019803902718557]", answer4,
                AngleUtilities.cartesianToPolar(test4), 0.1);
        double[] test5 = { -1.0, -5.551115123125783E-17 };
        double[] answer5 = { 270.0, 1.0 };
        assertArrayEquals("[-1.0, -5.551115123125783E-17] should be [270.0, 1.0]", answer5,
                AngleUtilities.cartesianToPolar(test5), 0.1);
        double[] test6 = { -1.0, 0.19999999999999996 };
        double[] answer6 = { 281.30993247402023, 1.019803902718557 };
        assertArrayEquals("[-1.0, 0.19999999999999996] should be [281.30993247402023, 1.019803902718557]", answer6,
                AngleUtilities.cartesianToPolar(test6), 0.1);
        double[] test7 = { -1.0, 0.39999999999999997 };
        double[] answer7 = { 291.8014094863518, 1.0770329614269007 };
        assertArrayEquals("[-1.0, 0.39999999999999997] should be [291.8014094863518, 1.0770329614269007]", answer7,
                AngleUtilities.cartesianToPolar(test7), 0.1);
        double[] test8 = { -1.0, 0.6 };
        double[] answer8 = { 300.9637565320735, 1.16619037896906 };
        assertArrayEquals("[-1.0, 0.6] should be [300.9637565320735, 1.16619037896906]", answer8,
                AngleUtilities.cartesianToPolar(test8), 0.1);
        double[] test9 = { -1.0, 0.8 };
        double[] answer9 = { 308.6598082540901, 1.2806248474865698 };
        assertArrayEquals("[-1.0, 0.8] should be [308.6598082540901, 1.2806248474865698]", answer9,
                AngleUtilities.cartesianToPolar(test9), 0.1);
        double[] test10 = { -1.0, 1.0 };
        double[] answer10 = { 315.0, 1.4142135623730951 };
        assertArrayEquals("[-1.0, 1.0] should be [315.0, 1.4142135623730951]", answer10,
                AngleUtilities.cartesianToPolar(test10), 0.1);
        double[] test11 = { -0.8, -1.0 };
        double[] answer11 = { 218.65980825409008, 1.2806248474865698 };
        assertArrayEquals("[-0.8, -1.0] should be [218.65980825409008, 1.2806248474865698]", answer11,
                AngleUtilities.cartesianToPolar(test11), 0.1);
        double[] test12 = { -0.8, -0.8 };
        double[] answer12 = { 225.0, 1.1313708498984762 };
        assertArrayEquals("[-0.8, -0.8] should be [225.0, 1.1313708498984762]", answer12,
                AngleUtilities.cartesianToPolar(test12), 0.1);
        double[] test13 = { -0.8, -0.6000000000000001 };
        double[] answer13 = { 233.13010235415598, 1.0 };
        assertArrayEquals("[-0.8, -0.6000000000000001] should be [233.13010235415598, 1.0]", answer13,
                AngleUtilities.cartesianToPolar(test13), 0.1);
        double[] test14 = { -0.8, -0.4000000000000001 };
        double[] answer14 = { 243.43494882292202, 0.894427190999916 };
        assertArrayEquals("[-0.8, -0.4000000000000001] should be [243.43494882292202, 0.894427190999916]", answer14,
                AngleUtilities.cartesianToPolar(test14), 0.1);
        double[] test15 = { -0.8, -0.20000000000000007 };
        double[] answer15 = { 255.96375653207352, 0.8246211251235323 };
        assertArrayEquals("[-0.8, -0.20000000000000007] should be [255.96375653207352, 0.8246211251235323]", answer15,
                AngleUtilities.cartesianToPolar(test15), 0.1);
        double[] test16 = { -0.8, -5.551115123125783E-17 };
        double[] answer16 = { 270.0, 0.8 };
        assertArrayEquals("[-0.8, -5.551115123125783E-17] should be [270.0, 0.8]", answer16,
                AngleUtilities.cartesianToPolar(test16), 0.1);
        double[] test17 = { -0.8, 0.19999999999999996 };
        double[] answer17 = { 284.03624346792645, 0.8246211251235323 };
        assertArrayEquals("[-0.8, 0.19999999999999996] should be [284.03624346792645, 0.8246211251235323]", answer17,
                AngleUtilities.cartesianToPolar(test17), 0.1);
        double[] test18 = { -0.8, 0.39999999999999997 };
        double[] answer18 = { 296.565051177078, 0.8944271909999159 };
        assertArrayEquals("[-0.8, 0.39999999999999997] should be [296.565051177078, 0.8944271909999159]", answer18,
                AngleUtilities.cartesianToPolar(test18), 0.1);
        double[] test19 = { -0.8, 0.6 };
        double[] answer19 = { 306.869897645844, 1.0 };
        assertArrayEquals("[-0.8, 0.6] should be [306.869897645844, 1.0]", answer19,
                AngleUtilities.cartesianToPolar(test19), 0.1);
        double[] test20 = { -0.8, 0.8 };
        double[] answer20 = { 315.0, 1.1313708498984762 };
        assertArrayEquals("[-0.8, 0.8] should be [315.0, 1.1313708498984762]", answer20,
                AngleUtilities.cartesianToPolar(test20), 0.1);
        double[] test21 = { -0.8, 1.0 };
        double[] answer21 = { 321.3401917459099, 1.2806248474865698 };
        assertArrayEquals("[-0.8, 1.0] should be [321.3401917459099, 1.2806248474865698]", answer21,
                AngleUtilities.cartesianToPolar(test21), 0.1);
        double[] test22 = { -0.6000000000000001, -1.0 };
        double[] answer22 = { 210.96375653207352, 1.1661903789690602 };
        assertArrayEquals("[-0.6000000000000001, -1.0] should be [210.96375653207352, 1.1661903789690602]", answer22,
                AngleUtilities.cartesianToPolar(test22), 0.1);
        double[] test23 = { -0.6000000000000001, -0.8 };
        double[] answer23 = { 216.86989764584402, 1.0 };
        assertArrayEquals("[-0.6000000000000001, -0.8] should be [216.86989764584402, 1.0]", answer23,
                AngleUtilities.cartesianToPolar(test23), 0.1);
        double[] test24 = { -0.6000000000000001, -0.6000000000000001 };
        double[] answer24 = { 225.0, 0.8485281374238571 };
        assertArrayEquals("[-0.6000000000000001, -0.6000000000000001] should be [225.0, 0.8485281374238571]", answer24,
                AngleUtilities.cartesianToPolar(test24), 0.1);
        double[] test25 = { -0.6000000000000001, -0.4000000000000001 };
        double[] answer25 = { 236.30993247402023, 0.7211102550927979 };
        assertArrayEquals(
                "[-0.6000000000000001, -0.4000000000000001] should be [236.30993247402023, 0.7211102550927979]",
                answer25, AngleUtilities.cartesianToPolar(test25), 0.1);
        double[] test26 = { -0.6000000000000001, -0.20000000000000007 };
        double[] answer26 = { 251.56505117707798, 0.632455532033676 };
        assertArrayEquals(
                "[-0.6000000000000001, -0.20000000000000007] should be [251.56505117707798, 0.632455532033676]",
                answer26, AngleUtilities.cartesianToPolar(test26), 0.1);
        double[] test27 = { -0.6000000000000001, -5.551115123125783E-17 };
        double[] answer27 = { 270.0, 0.6000000000000001 };
        assertArrayEquals("[-0.6000000000000001, -5.551115123125783E-17] should be [270.0, 0.6000000000000001]",
                answer27, AngleUtilities.cartesianToPolar(test27), 0.1);
        double[] test28 = { -0.6000000000000001, 0.19999999999999996 };
        double[] answer28 = { 288.434948822922, 0.6324555320336759 };
        assertArrayEquals("[-0.6000000000000001, 0.19999999999999996] should be [288.434948822922, 0.6324555320336759]",
                answer28, AngleUtilities.cartesianToPolar(test28), 0.1);
        double[] test29 = { -0.6000000000000001, 0.39999999999999997 };
        double[] answer29 = { 303.69006752597977, 0.7211102550927979 };
        assertArrayEquals(
                "[-0.6000000000000001, 0.39999999999999997] should be [303.69006752597977, 0.7211102550927979]",
                answer29, AngleUtilities.cartesianToPolar(test29), 0.1);
        double[] test30 = { -0.6000000000000001, 0.6 };
        double[] answer30 = { 315.0, 0.8485281374238571 };
        assertArrayEquals("[-0.6000000000000001, 0.6] should be [315.0, 0.8485281374238571]", answer30,
                AngleUtilities.cartesianToPolar(test30), 0.1);
        double[] test31 = { -0.6000000000000001, 0.8 };
        double[] answer31 = { 323.13010235415595, 1.0 };
        assertArrayEquals("[-0.6000000000000001, 0.8] should be [323.13010235415595, 1.0]", answer31,
                AngleUtilities.cartesianToPolar(test31), 0.1);
        double[] test32 = { -0.6000000000000001, 1.0 };
        double[] answer32 = { 329.03624346792645, 1.1661903789690602 };
        assertArrayEquals("[-0.6000000000000001, 1.0] should be [329.03624346792645, 1.1661903789690602]", answer32,
                AngleUtilities.cartesianToPolar(test32), 0.1);
        double[] test33 = { -0.4000000000000001, -1.0 };
        double[] answer33 = { 201.80140948635182, 1.077032961426901 };
        assertArrayEquals("[-0.4000000000000001, -1.0] should be [201.80140948635182, 1.077032961426901]", answer33,
                AngleUtilities.cartesianToPolar(test33), 0.1);
        double[] test34 = { -0.4000000000000001, -0.8 };
        double[] answer34 = { 206.565051177078, 0.894427190999916 };
        assertArrayEquals("[-0.4000000000000001, -0.8] should be [206.565051177078, 0.894427190999916]", answer34,
                AngleUtilities.cartesianToPolar(test34), 0.1);
        double[] test35 = { -0.4000000000000001, -0.6000000000000001 };
        double[] answer35 = { 213.6900675259798, 0.7211102550927979 };
        assertArrayEquals(
                "[-0.4000000000000001, -0.6000000000000001] should be [213.6900675259798, 0.7211102550927979]",
                answer35, AngleUtilities.cartesianToPolar(test35), 0.1);
        double[] test36 = { -0.4000000000000001, -0.4000000000000001 };
        double[] answer36 = { 225.0, 0.5656854249492381 };
        assertArrayEquals("[-0.4000000000000001, -0.4000000000000001] should be [225.0, 0.5656854249492381]", answer36,
                AngleUtilities.cartesianToPolar(test36), 0.1);
        double[] test37 = { -0.4000000000000001, -0.20000000000000007 };
        double[] answer37 = { 243.43494882292202, 0.44721359549995804 };
        assertArrayEquals(
                "[-0.4000000000000001, -0.20000000000000007] should be [243.43494882292202, 0.44721359549995804]",
                answer37, AngleUtilities.cartesianToPolar(test37), 0.1);
        double[] test38 = { -0.4000000000000001, -5.551115123125783E-17 };
        double[] answer38 = { 270.0, 0.4000000000000001 };
        assertArrayEquals("[-0.4000000000000001, -5.551115123125783E-17] should be [270.0, 0.4000000000000001]",
                answer38, AngleUtilities.cartesianToPolar(test38), 0.1);
        double[] test39 = { -0.4000000000000001, 0.19999999999999996 };
        double[] answer39 = { 296.565051177078, 0.447213595499958 };
        assertArrayEquals("[-0.4000000000000001, 0.19999999999999996] should be [296.565051177078, 0.447213595499958]",
                answer39, AngleUtilities.cartesianToPolar(test39), 0.1);
        double[] test40 = { -0.4000000000000001, 0.39999999999999997 };
        double[] answer40 = { 315.0, 0.5656854249492381 };
        assertArrayEquals("[-0.4000000000000001, 0.39999999999999997] should be [315.0, 0.5656854249492381]", answer40,
                AngleUtilities.cartesianToPolar(test40), 0.1);
        double[] test41 = { -0.4000000000000001, 0.6 };
        double[] answer41 = { 326.30993247402023, 0.7211102550927979 };
        assertArrayEquals("[-0.4000000000000001, 0.6] should be [326.30993247402023, 0.7211102550927979]", answer41,
                AngleUtilities.cartesianToPolar(test41), 0.1);
        double[] test42 = { -0.4000000000000001, 0.8 };
        double[] answer42 = { 333.434948822922, 0.894427190999916 };
        assertArrayEquals("[-0.4000000000000001, 0.8] should be [333.434948822922, 0.894427190999916]", answer42,
                AngleUtilities.cartesianToPolar(test42), 0.1);
        double[] test43 = { -0.4000000000000001, 1.0 };
        double[] answer43 = { 338.1985905136482, 1.077032961426901 };
        assertArrayEquals("[-0.4000000000000001, 1.0] should be [338.1985905136482, 1.077032961426901]", answer43,
                AngleUtilities.cartesianToPolar(test43), 0.1);
        double[] test44 = { -0.20000000000000007, -1.0 };
        double[] answer44 = { 191.30993247402023, 1.019803902718557 };
        assertArrayEquals("[-0.20000000000000007, -1.0] should be [191.30993247402023, 1.019803902718557]", answer44,
                AngleUtilities.cartesianToPolar(test44), 0.1);
        double[] test45 = { -0.20000000000000007, -0.8 };
        double[] answer45 = { 194.03624346792648, 0.8246211251235323 };
        assertArrayEquals("[-0.20000000000000007, -0.8] should be [194.03624346792648, 0.8246211251235323]", answer45,
                AngleUtilities.cartesianToPolar(test45), 0.1);
        double[] test46 = { -0.20000000000000007, -0.6000000000000001 };
        double[] answer46 = { 198.43494882292202, 0.632455532033676 };
        assertArrayEquals(
                "[-0.20000000000000007, -0.6000000000000001] should be [198.43494882292202, 0.632455532033676]",
                answer46, AngleUtilities.cartesianToPolar(test46), 0.1);
        double[] test47 = { -0.20000000000000007, -0.4000000000000001 };
        double[] answer47 = { 206.565051177078, 0.44721359549995804 };
        assertArrayEquals(
                "[-0.20000000000000007, -0.4000000000000001] should be [206.565051177078, 0.44721359549995804]",
                answer47, AngleUtilities.cartesianToPolar(test47), 0.1);
        double[] test48 = { -0.20000000000000007, -0.20000000000000007 };
        double[] answer48 = { 225.0, 0.2828427124746191 };
        assertArrayEquals("[-0.20000000000000007, -0.20000000000000007] should be [225.0, 0.2828427124746191]",
                answer48, AngleUtilities.cartesianToPolar(test48), 0.1);
        double[] test49 = { -0.20000000000000007, -5.551115123125783E-17 };
        double[] answer49 = { 270.0, 0.20000000000000007 };
        assertArrayEquals("[-0.20000000000000007, -5.551115123125783E-17] should be [270.0, 0.20000000000000007]",
                answer49, AngleUtilities.cartesianToPolar(test49), 0.1);
        double[] test50 = { -0.20000000000000007, 0.19999999999999996 };
        double[] answer50 = { 315.0, 0.28284271247461906 };
        assertArrayEquals("[-0.20000000000000007, 0.19999999999999996] should be [315.0, 0.28284271247461906]",
                answer50, AngleUtilities.cartesianToPolar(test50), 0.1);
        double[] test51 = { -0.20000000000000007, 0.39999999999999997 };
        double[] answer51 = { 333.434948822922, 0.4472135954999579 };
        assertArrayEquals(
                "[-0.20000000000000007, 0.39999999999999997] should be [333.434948822922, 0.4472135954999579]",
                answer51, AngleUtilities.cartesianToPolar(test51), 0.1);
        double[] test52 = { -0.20000000000000007, 0.6 };
        double[] answer52 = { 341.565051177078, 0.6324555320336759 };
        assertArrayEquals("[-0.20000000000000007, 0.6] should be [341.565051177078, 0.6324555320336759]", answer52,
                AngleUtilities.cartesianToPolar(test52), 0.1);
        double[] test53 = { -0.20000000000000007, 0.8 };
        double[] answer53 = { 345.9637565320735, 0.8246211251235323 };
        assertArrayEquals("[-0.20000000000000007, 0.8] should be [345.9637565320735, 0.8246211251235323]", answer53,
                AngleUtilities.cartesianToPolar(test53), 0.1);
        double[] test54 = { -0.20000000000000007, 1.0 };
        double[] answer54 = { 348.69006752597977, 1.019803902718557 };
        assertArrayEquals("[-0.20000000000000007, 1.0] should be [348.69006752597977, 1.019803902718557]", answer54,
                AngleUtilities.cartesianToPolar(test54), 0.1);
        double[] test55 = { -5.551115123125783E-17, -1.0 };
        double[] answer55 = { 180.0, 1.0 };
        assertArrayEquals("[-5.551115123125783E-17, -1.0] should be [180.0, 1.0]", answer55,
                AngleUtilities.cartesianToPolar(test55), 0.1);
        double[] test56 = { -5.551115123125783E-17, -0.8 };
        double[] answer56 = { 180.0, 0.8 };
        assertArrayEquals("[-5.551115123125783E-17, -0.8] should be [180.0, 0.8]", answer56,
                AngleUtilities.cartesianToPolar(test56), 0.1);
        double[] test57 = { -5.551115123125783E-17, -0.6000000000000001 };
        double[] answer57 = { 180.0, 0.6000000000000001 };
        assertArrayEquals("[-5.551115123125783E-17, -0.6000000000000001] should be [180.0, 0.6000000000000001]",
                answer57, AngleUtilities.cartesianToPolar(test57), 0.1);
        double[] test58 = { -5.551115123125783E-17, -0.4000000000000001 };
        double[] answer58 = { 180.0, 0.4000000000000001 };
        assertArrayEquals("[-5.551115123125783E-17, -0.4000000000000001] should be [180.0, 0.4000000000000001]",
                answer58, AngleUtilities.cartesianToPolar(test58), 0.1);
        double[] test59 = { -5.551115123125783E-17, -0.20000000000000007 };
        double[] answer59 = { 180.00000000000003, 0.20000000000000007 };
        assertArrayEquals(
                "[-5.551115123125783E-17, -0.20000000000000007] should be [180.00000000000003, 0.20000000000000007]",
                answer59, AngleUtilities.cartesianToPolar(test59), 0.1);
        double[] test60 = { -5.551115123125783E-17, -5.551115123125783E-17 };
        double[] answer60 = { 225.0, 7.850462293418876E-17 };
        assertArrayEquals("[-5.551115123125783E-17, -5.551115123125783E-17] should be [225.0, 7.850462293418876E-17]",
                answer60, AngleUtilities.cartesianToPolar(test60), 0.1);
        double[] test61 = { -5.551115123125783E-17, 0.19999999999999996 };
        double[] answer61 = { 0.0, 0.19999999999999996 };
        assertArrayEquals("[-5.551115123125783E-17, 0.19999999999999996] should be [0.0, 0.19999999999999996]",
                answer61, AngleUtilities.cartesianToPolar(test61), 0.1);
        double[] test62 = { -5.551115123125783E-17, 0.39999999999999997 };
        double[] answer62 = { 0.0, 0.39999999999999997 };
        assertArrayEquals("[-5.551115123125783E-17, 0.39999999999999997] should be [0.0, 0.39999999999999997]",
                answer62, AngleUtilities.cartesianToPolar(test62), 0.1);
        double[] test63 = { -5.551115123125783E-17, 0.6 };
        double[] answer63 = { 0.0, 0.6 };
        assertArrayEquals("[-5.551115123125783E-17, 0.6] should be [0.0, 0.6]", answer63,
                AngleUtilities.cartesianToPolar(test63), 0.1);
        double[] test64 = { -5.551115123125783E-17, 0.8 };
        double[] answer64 = { 0.0, 0.8 };
        assertArrayEquals("[-5.551115123125783E-17, 0.8] should be [0.0, 0.8]", answer64,
                AngleUtilities.cartesianToPolar(test64), 0.1);
        double[] test65 = { -5.551115123125783E-17, 1.0 };
        double[] answer65 = { 0.0, 1.0 };
        assertArrayEquals("[-5.551115123125783E-17, 1.0] should be [0.0, 1.0]", answer65,
                AngleUtilities.cartesianToPolar(test65), 0.1);
        double[] test66 = { 0.19999999999999996, -1.0 };
        double[] answer66 = { 168.6900675259798, 1.019803902718557 };
        assertArrayEquals("[0.19999999999999996, -1.0] should be [168.6900675259798, 1.019803902718557]", answer66,
                AngleUtilities.cartesianToPolar(test66), 0.1);
        double[] test67 = { 0.19999999999999996, -0.8 };
        double[] answer67 = { 165.96375653207352, 0.8246211251235323 };
        assertArrayEquals("[0.19999999999999996, -0.8] should be [165.96375653207352, 0.8246211251235323]", answer67,
                AngleUtilities.cartesianToPolar(test67), 0.1);
        double[] test68 = { 0.19999999999999996, -0.6000000000000001 };
        double[] answer68 = { 161.565051177078, 0.6324555320336759 };
        assertArrayEquals("[0.19999999999999996, -0.6000000000000001] should be [161.565051177078, 0.6324555320336759]",
                answer68, AngleUtilities.cartesianToPolar(test68), 0.1);
        double[] test69 = { 0.19999999999999996, -0.4000000000000001 };
        double[] answer69 = { 153.43494882292202, 0.447213595499958 };
        assertArrayEquals(
                "[0.19999999999999996, -0.4000000000000001] should be [153.43494882292202, 0.447213595499958]",
                answer69, AngleUtilities.cartesianToPolar(test69), 0.1);
        double[] test70 = { 0.19999999999999996, -0.20000000000000007 };
        double[] answer70 = { 135.0, 0.28284271247461906 };
        assertArrayEquals("[0.19999999999999996, -0.20000000000000007] should be [135.0, 0.28284271247461906]",
                answer70, AngleUtilities.cartesianToPolar(test70), 0.1);
        double[] test71 = { 0.19999999999999996, -5.551115123125783E-17 };
        double[] answer71 = { 90.00000000000001, 0.19999999999999996 };
        assertArrayEquals(
                "[0.19999999999999996, -5.551115123125783E-17] should be [90.00000000000001, 0.19999999999999996]",
                answer71, AngleUtilities.cartesianToPolar(test71), 0.1);
        double[] test72 = { 0.19999999999999996, 0.19999999999999996 };
        double[] answer72 = { 45.0, 0.28284271247461895 };
        assertArrayEquals("[0.19999999999999996, 0.19999999999999996] should be [45.0, 0.28284271247461895]", answer72,
                AngleUtilities.cartesianToPolar(test72), 0.1);
        double[] test73 = { 0.19999999999999996, 0.39999999999999997 };
        double[] answer73 = { 26.565051177077976, 0.44721359549995787 };
        assertArrayEquals(
                "[0.19999999999999996, 0.39999999999999997] should be [26.565051177077976, 0.44721359549995787]",
                answer73, AngleUtilities.cartesianToPolar(test73), 0.1);
        double[] test74 = { 0.19999999999999996, 0.6 };
        double[] answer74 = { 18.434948822922024, 0.6324555320336759 };
        assertArrayEquals("[0.19999999999999996, 0.6] should be [18.434948822922024, 0.6324555320336759]", answer74,
                AngleUtilities.cartesianToPolar(test74), 0.1);
        double[] test75 = { 0.19999999999999996, 0.8 };
        double[] answer75 = { 14.036243467926454, 0.8246211251235323 };
        assertArrayEquals("[0.19999999999999996, 0.8] should be [14.036243467926454, 0.8246211251235323]", answer75,
                AngleUtilities.cartesianToPolar(test75), 0.1);
        double[] test76 = { 0.19999999999999996, 1.0 };
        double[] answer76 = { 11.30993247402023, 1.019803902718557 };
        assertArrayEquals("[0.19999999999999996, 1.0] should be [11.30993247402023, 1.019803902718557]", answer76,
                AngleUtilities.cartesianToPolar(test76), 0.1);
        double[] test77 = { 0.39999999999999997, -1.0 };
        double[] answer77 = { 158.19859051364818, 1.0770329614269007 };
        assertArrayEquals("[0.39999999999999997, -1.0] should be [158.19859051364818, 1.0770329614269007]", answer77,
                AngleUtilities.cartesianToPolar(test77), 0.1);
        double[] test78 = { 0.39999999999999997, -0.8 };
        double[] answer78 = { 153.43494882292202, 0.8944271909999159 };
        assertArrayEquals("[0.39999999999999997, -0.8] should be [153.43494882292202, 0.8944271909999159]", answer78,
                AngleUtilities.cartesianToPolar(test78), 0.1);
        double[] test79 = { 0.39999999999999997, -0.6000000000000001 };
        double[] answer79 = { 146.30993247402023, 0.7211102550927979 };
        assertArrayEquals(
                "[0.39999999999999997, -0.6000000000000001] should be [146.30993247402023, 0.7211102550927979]",
                answer79, AngleUtilities.cartesianToPolar(test79), 0.1);
        double[] test80 = { 0.39999999999999997, -0.4000000000000001 };
        double[] answer80 = { 135.0, 0.5656854249492381 };
        assertArrayEquals("[0.39999999999999997, -0.4000000000000001] should be [135.0, 0.5656854249492381]", answer80,
                AngleUtilities.cartesianToPolar(test80), 0.1);
        double[] test81 = { 0.39999999999999997, -0.20000000000000007 };
        double[] answer81 = { 116.56505117707799, 0.4472135954999579 };
        assertArrayEquals(
                "[0.39999999999999997, -0.20000000000000007] should be [116.56505117707799, 0.4472135954999579]",
                answer81, AngleUtilities.cartesianToPolar(test81), 0.1);
        double[] test82 = { 0.39999999999999997, -5.551115123125783E-17 };
        double[] answer82 = { 90.0, 0.39999999999999997 };
        assertArrayEquals("[0.39999999999999997, -5.551115123125783E-17] should be [90.0, 0.39999999999999997]",
                answer82, AngleUtilities.cartesianToPolar(test82), 0.1);
        double[] test83 = { 0.39999999999999997, 0.19999999999999996 };
        double[] answer83 = { 63.434948822922024, 0.44721359549995787 };
        assertArrayEquals(
                "[0.39999999999999997, 0.19999999999999996] should be [63.434948822922024, 0.44721359549995787]",
                answer83, AngleUtilities.cartesianToPolar(test83), 0.1);
        double[] test84 = { 0.39999999999999997, 0.39999999999999997 };
        double[] answer84 = { 45.0, 0.565685424949238 };
        assertArrayEquals("[0.39999999999999997, 0.39999999999999997] should be [45.0, 0.565685424949238]", answer84,
                AngleUtilities.cartesianToPolar(test84), 0.1);
        double[] test85 = { 0.39999999999999997, 0.6 };
        double[] answer85 = { 33.69006752597977, 0.7211102550927979 };
        assertArrayEquals("[0.39999999999999997, 0.6] should be [33.69006752597977, 0.7211102550927979]", answer85,
                AngleUtilities.cartesianToPolar(test85), 0.1);
        double[] test86 = { 0.39999999999999997, 0.8 };
        double[] answer86 = { 26.565051177077976, 0.8944271909999159 };
        assertArrayEquals("[0.39999999999999997, 0.8] should be [26.565051177077976, 0.8944271909999159]", answer86,
                AngleUtilities.cartesianToPolar(test86), 0.1);
        double[] test87 = { 0.39999999999999997, 1.0 };
        double[] answer87 = { 21.801409486351815, 1.0770329614269007 };
        assertArrayEquals("[0.39999999999999997, 1.0] should be [21.801409486351815, 1.0770329614269007]", answer87,
                AngleUtilities.cartesianToPolar(test87), 0.1);
        double[] test88 = { 0.6, -1.0 };
        double[] answer88 = { 149.03624346792648, 1.16619037896906 };
        assertArrayEquals("[0.6, -1.0] should be [149.03624346792648, 1.16619037896906]", answer88,
                AngleUtilities.cartesianToPolar(test88), 0.1);
        double[] test89 = { 0.6, -0.8 };
        double[] answer89 = { 143.13010235415598, 1.0 };
        assertArrayEquals("[0.6, -0.8] should be [143.13010235415598, 1.0]", answer89,
                AngleUtilities.cartesianToPolar(test89), 0.1);
        double[] test90 = { 0.6, -0.6000000000000001 };
        double[] answer90 = { 135.0, 0.8485281374238571 };
        assertArrayEquals("[0.6, -0.6000000000000001] should be [135.0, 0.8485281374238571]", answer90,
                AngleUtilities.cartesianToPolar(test90), 0.1);
        double[] test91 = { 0.6, -0.4000000000000001 };
        double[] answer91 = { 123.6900675259798, 0.7211102550927979 };
        assertArrayEquals("[0.6, -0.4000000000000001] should be [123.6900675259798, 0.7211102550927979]", answer91,
                AngleUtilities.cartesianToPolar(test91), 0.1);
        double[] test92 = { 0.6, -0.20000000000000007 };
        double[] answer92 = { 108.43494882292201, 0.6324555320336759 };
        assertArrayEquals("[0.6, -0.20000000000000007] should be [108.43494882292201, 0.6324555320336759]", answer92,
                AngleUtilities.cartesianToPolar(test92), 0.1);
        double[] test93 = { 0.6, -5.551115123125783E-17 };
        double[] answer93 = { 90.0, 0.6 };
        assertArrayEquals("[0.6, -5.551115123125783E-17] should be [90.0, 0.6]", answer93,
                AngleUtilities.cartesianToPolar(test93), 0.1);
        double[] test94 = { 0.6, 0.19999999999999996 };
        double[] answer94 = { 71.56505117707798, 0.6324555320336759 };
        assertArrayEquals("[0.6, 0.19999999999999996] should be [71.56505117707798, 0.6324555320336759]", answer94,
                AngleUtilities.cartesianToPolar(test94), 0.1);
        double[] test95 = { 0.6, 0.39999999999999997 };
        double[] answer95 = { 56.30993247402023, 0.7211102550927979 };
        assertArrayEquals("[0.6, 0.39999999999999997] should be [56.30993247402023, 0.7211102550927979]", answer95,
                AngleUtilities.cartesianToPolar(test95), 0.1);
        double[] test96 = { 0.6, 0.6 };
        double[] answer96 = { 45.0, 0.848528137423857 };
        assertArrayEquals("[0.6, 0.6] should be [45.0, 0.848528137423857]", answer96,
                AngleUtilities.cartesianToPolar(test96), 0.1);
        double[] test97 = { 0.6, 0.8 };
        double[] answer97 = { 36.86989764584399, 1.0 };
        assertArrayEquals("[0.6, 0.8] should be [36.86989764584399, 1.0]", answer97,
                AngleUtilities.cartesianToPolar(test97), 0.1);
        double[] test98 = { 0.6, 1.0 };
        double[] answer98 = { 30.963756532073546, 1.16619037896906 };
        assertArrayEquals("[0.6, 1.0] should be [30.963756532073546, 1.16619037896906]", answer98,
                AngleUtilities.cartesianToPolar(test98), 0.1);
        double[] test99 = { 0.8, -1.0 };
        double[] answer99 = { 141.34019174590992, 1.2806248474865698 };
        assertArrayEquals("[0.8, -1.0] should be [141.34019174590992, 1.2806248474865698]", answer99,
                AngleUtilities.cartesianToPolar(test99), 0.1);
        double[] test100 = { 0.8, -0.8 };
        double[] answer100 = { 135.0, 1.1313708498984762 };
        assertArrayEquals("[0.8, -0.8] should be [135.0, 1.1313708498984762]", answer100,
                AngleUtilities.cartesianToPolar(test100), 0.1);
        double[] test101 = { 0.8, -0.6000000000000001 };
        double[] answer101 = { 126.86989764584402, 1.0 };
        assertArrayEquals("[0.8, -0.6000000000000001] should be [126.86989764584402, 1.0]", answer101,
                AngleUtilities.cartesianToPolar(test101), 0.1);
        double[] test102 = { 0.8, -0.4000000000000001 };
        double[] answer102 = { 116.56505117707799, 0.894427190999916 };
        assertArrayEquals("[0.8, -0.4000000000000001] should be [116.56505117707799, 0.894427190999916]", answer102,
                AngleUtilities.cartesianToPolar(test102), 0.1);
        double[] test103 = { 0.8, -0.20000000000000007 };
        double[] answer103 = { 104.03624346792648, 0.8246211251235323 };
        assertArrayEquals("[0.8, -0.20000000000000007] should be [104.03624346792648, 0.8246211251235323]", answer103,
                AngleUtilities.cartesianToPolar(test103), 0.1);
        double[] test104 = { 0.8, -5.551115123125783E-17 };
        double[] answer104 = { 90.0, 0.8 };
        assertArrayEquals("[0.8, -5.551115123125783E-17] should be [90.0, 0.8]", answer104,
                AngleUtilities.cartesianToPolar(test104), 0.1);
        double[] test105 = { 0.8, 0.19999999999999996 };
        double[] answer105 = { 75.96375653207355, 0.8246211251235323 };
        assertArrayEquals("[0.8, 0.19999999999999996] should be [75.96375653207355, 0.8246211251235323]", answer105,
                AngleUtilities.cartesianToPolar(test105), 0.1);
        double[] test106 = { 0.8, 0.39999999999999997 };
        double[] answer106 = { 63.434948822922024, 0.8944271909999159 };
        assertArrayEquals("[0.8, 0.39999999999999997] should be [63.434948822922024, 0.8944271909999159]", answer106,
                AngleUtilities.cartesianToPolar(test106), 0.1);
        double[] test107 = { 0.8, 0.6 };
        double[] answer107 = { 53.13010235415601, 1.0 };
        assertArrayEquals("[0.8, 0.6] should be [53.13010235415601, 1.0]", answer107,
                AngleUtilities.cartesianToPolar(test107), 0.1);
        double[] test108 = { 0.8, 0.8 };
        double[] answer108 = { 45.0, 1.1313708498984762 };
        assertArrayEquals("[0.8, 0.8] should be [45.0, 1.1313708498984762]", answer108,
                AngleUtilities.cartesianToPolar(test108), 0.1);
        double[] test109 = { 0.8, 1.0 };
        double[] answer109 = { 38.65980825409008, 1.2806248474865698 };
        assertArrayEquals("[0.8, 1.0] should be [38.65980825409008, 1.2806248474865698]", answer109,
                AngleUtilities.cartesianToPolar(test109), 0.1);
        double[] test110 = { 1.0, -1.0 };
        double[] answer110 = { 135.0, 1.4142135623730951 };
        assertArrayEquals("[1.0, -1.0] should be [135.0, 1.4142135623730951]", answer110,
                AngleUtilities.cartesianToPolar(test110), 0.1);
        double[] test111 = { 1.0, -0.8 };
        double[] answer111 = { 128.65980825409008, 1.2806248474865698 };
        assertArrayEquals("[1.0, -0.8] should be [128.65980825409008, 1.2806248474865698]", answer111,
                AngleUtilities.cartesianToPolar(test111), 0.1);
        double[] test112 = { 1.0, -0.6000000000000001 };
        double[] answer112 = { 120.96375653207352, 1.1661903789690602 };
        assertArrayEquals("[1.0, -0.6000000000000001] should be [120.96375653207352, 1.1661903789690602]", answer112,
                AngleUtilities.cartesianToPolar(test112), 0.1);
        double[] test113 = { 1.0, -0.4000000000000001 };
        double[] answer113 = { 111.80140948635182, 1.077032961426901 };
        assertArrayEquals("[1.0, -0.4000000000000001] should be [111.80140948635182, 1.077032961426901]", answer113,
                AngleUtilities.cartesianToPolar(test113), 0.1);
        double[] test114 = { 1.0, -0.20000000000000007 };
        double[] answer114 = { 101.30993247402021, 1.019803902718557 };
        assertArrayEquals("[1.0, -0.20000000000000007] should be [101.30993247402021, 1.019803902718557]", answer114,
                AngleUtilities.cartesianToPolar(test114), 0.1);
        double[] test115 = { 1.0, -5.551115123125783E-17 };
        double[] answer115 = { 90.0, 1.0 };
        assertArrayEquals("[1.0, -5.551115123125783E-17] should be [90.0, 1.0]", answer115,
                AngleUtilities.cartesianToPolar(test115), 0.1);
        double[] test116 = { 1.0, 0.19999999999999996 };
        double[] answer116 = { 78.69006752597977, 1.019803902718557 };
        assertArrayEquals("[1.0, 0.19999999999999996] should be [78.69006752597977, 1.019803902718557]", answer116,
                AngleUtilities.cartesianToPolar(test116), 0.1);
        double[] test117 = { 1.0, 0.39999999999999997 };
        double[] answer117 = { 68.19859051364818, 1.0770329614269007 };
        assertArrayEquals("[1.0, 0.39999999999999997] should be [68.19859051364818, 1.0770329614269007]", answer117,
                AngleUtilities.cartesianToPolar(test117), 0.1);
        double[] test118 = { 1.0, 0.6 };
        double[] answer118 = { 59.03624346792651, 1.16619037896906 };
        assertArrayEquals("[1.0, 0.6] should be [59.03624346792651, 1.16619037896906]", answer118,
                AngleUtilities.cartesianToPolar(test118), 0.1);
        double[] test119 = { 1.0, 0.8 };
        double[] answer119 = { 51.34019174590992, 1.2806248474865698 };
        assertArrayEquals("[1.0, 0.8] should be [51.34019174590992, 1.2806248474865698]", answer119,
                AngleUtilities.cartesianToPolar(test119), 0.1);
        double[] test120 = { 1.0, 1.0 };
        double[] answer120 = { 45.0, 1.4142135623730951 };
        assertArrayEquals("[1.0, 1.0] should be [45.0, 1.4142135623730951]", answer120,
                AngleUtilities.cartesianToPolar(test120), 0.1);

    }
}