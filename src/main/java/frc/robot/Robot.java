/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.SwerveWheel;
import frc.robot.util.AbsoluteEncoder;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static Robot instance;

  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public SwerveSubsystem swerveSubsystem;

  private SwerveWheel leftFront;
  private SwerveWheel rightFront;
  private SwerveWheel leftBack;
  private SwerveWheel rightBack;

  private SwerveWheel[] wheels = {rightFront,leftFront,leftBack,rightBack};


  public static synchronized Robot getInstance() {
    if (instance == null) {
      instance = new Robot();
    }
    return instance;
  }


  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

    this.leftFront = new SwerveWheel(new Talon(RobotMap.leftFrontDrive), new Talon(RobotMap.leftFrontTurn),
        new AbsoluteEncoder(RobotMap.leftFrontEncoder, 0, false), RobotMap.drivePidConfig, RobotMap.leftFrontLoc);

    this.leftBack = new SwerveWheel(new Talon(RobotMap.leftBackDrive), new Talon(RobotMap.leftBackTurn),
        new AbsoluteEncoder(RobotMap.leftBackEncoder, 0, false), RobotMap.drivePidConfig, RobotMap.leftBackLoc);
    this.rightFront = new SwerveWheel(new Talon(RobotMap.rightFrontDrive), new Talon(RobotMap.rightFrontTurn),
        new AbsoluteEncoder(RobotMap.rightFrontEncoder, 0, false), RobotMap.drivePidConfig, RobotMap.rightFrontLoc);
    this.rightBack = new SwerveWheel(new Talon(RobotMap.rightBackDrive), new Talon(RobotMap.rightBackTurn),
        new AbsoluteEncoder(RobotMap.rightBackEncoder, 0, false), RobotMap.drivePidConfig, RobotMap.rightBackLoc);

    this.swerveSubsystem = new SwerveSubsystem(this.wheels, RobotMap.pivotLoc, new ADXRS450_Gyro(), RobotMap.headingPidConfig);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // m_autonomousCommand = m_chooser.getSelected();

    // /*
    //  * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
    //  * switch(autoSelected) { case "My Auto": autonomousCommand = new
    //  * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
    //  * ExampleCommand(); break; }
    //  */

    // // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.start();
    // }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
