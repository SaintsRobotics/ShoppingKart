/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.util.PidConfig;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  public static int rightFrontTurn = 0;
  public static int leftFrontTurn = 1;
  public static int leftBackTurn = 2;
  public static int rightBackTurn = 3; 

  public static int rightFrontDrive = 4;
  public static int leftFrontDrive = 5;
  public static int leftBackDrive = 6;
  public static int rightBackDrive = 7; 

  public static int rightFrontEncoder = 0;
  public static int leftFrontEncoder = 1;
  public static int leftBackEncoder = 2;
  public static int rightBackEncoder = 3;
  
  public static PidConfig drivePidConfig = new PidConfig(0.02, 0, 0, 2.5);

  public static double[] rightFrontLoc = { 12, 12 };
	public static double[] leftFrontLoc = { -12, 12 };
	public static double[] leftBackLoc = { -12, -12 };
	public static double[] rightBackLoc = { 12, -12 };
  public static double[] pivotLoc = {0,0};  
  
  
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
