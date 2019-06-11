/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.subsystems.SwerveSubsystem;

/**
 * An example command. You can replace me with your own command.
 */
public class SwerveDriveCommand extends Command {
    private SwerveSubsystem m_subsystem;
    private BooleanSupplier m_fieldRelativeButton;

    public SwerveDriveCommand(BooleanSupplier fieldRelative, Consumer<Double> transX) {
        requires(Robot.getInstance().swerveSubsystem);
        this.m_subsystem = Robot.getInstance().swerveSubsystem;
    }

    // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      m_subsystem.getPidController().reset();
      m_subsystem.getPidController().enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (this.m_fieldRelativeButton.getAsBoolean()) {
        // Gyro coords are continous so this restricts it to 360 degrees
        double robotAngle = ((this.m_subsystem.getGyro().pidGet() % 360) + 360) % 360;

        // Temporary save of x and y pre-translation
        double tempX = leftStickX;
        double tempY = leftStickY;

        // Overwriting x and y
        leftStickX = (tempX * Math.cos(Math.toRadians(robotAngle)))
                - (tempY * Math.sin(Math.toRadians(robotAngle)));
        leftStickY = (tempX * Math.sin(Math.toRadians(robotAngle)))
                + (tempY * Math.cos(Math.toRadians(robotAngle)));
    }


  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      m_subsystem.getPidController().disable();
      m_subsystem.setTranslationVector(0, 0);
      m_subsystem.setRotationVector(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
