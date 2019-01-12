package com.saintsrobotics.swerveDrive.output;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.output.Motor;
import com.saintsrobotics.swerveDrive.input.AbsoluteEncoder;
import com.saintsrobotics.swerveDrive.util.TurnConfiguration;
import com.saintsrobotics.swerveDrive.util.PIDReceiver;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveWheel extends RunEachFrameTask {
  private Motor driveMotor;
  private Motor turnMotor;
  private double targetHead;
  private double targetVelocity;

  private PIDReceiver headingPidReceiver;
  private PIDController headingPidController;
  private String name;
  private PIDSource encoder;

  public SwerveWheel(String name, Motor driveMotor, Motor turnMotor,
      TurnConfiguration pidConfig) {
    this.name = name;
    this.driveMotor = driveMotor;
    this.turnMotor = turnMotor;
    this.encoder = pidConfig.encoder;

    this.headingPidReceiver = new PIDReceiver();
    this.headingPidController = new PIDController(pidConfig.forwardHeadingKP,
        0.0, 0.0, pidConfig.encoder, headingPidReceiver);
    this.headingPidController.setAbsoluteTolerance(pidConfig.forwardHeadingTolerance);
    this.headingPidController.setOutputRange(-01, 01);
    this.headingPidController.setInputRange(0, 360);
    this.headingPidController.setContinuous();
    this.headingPidController.reset();
    this.headingPidController.enable();
  }

  public void setHeadAndVelocity(double targetHead, double targetVelocity) {
    double currentHead = this.encoder.pidGet();
    this.targetHead = Math.min(Math.abs(currentHead - targetHead), Math.abs(currentHead - Math.abs(180 - targetHead)));
    if (this.targetHead != targetHead) { 
      this.targetVelocity = -targetVelocity;
    }
    else {
      this.targetVelocity = targetVelocity;
    }
  }

  @Override
  public void runEachFrame() {
    this.driveMotor.set(this.targetVelocity);
//    this.headingPidController.enable();
    this.headingPidController.setSetpoint(this.targetHead);
    double headingOutput = this.headingPidReceiver.getOutput();
    this.turnMotor.set(headingOutput);

    SmartDashboard.putNumber("encoder " + this.name, this.encoder.pidGet());
    SmartDashboard.putNumber("pid output " + this.name, headingOutput);
    SmartDashboard.putNumber("pid error " + this.name, this.headingPidController.getError());
/*    SmartDashboard.putNumber("encoder graph " + this.name, this.encoder.pidGet());
    SmartDashboard.putNumber("pid output graph " + this.name, headingOutput);
    SmartDashboard.putNumber("pid error graph " + this.name, this.headingPidController.getError());*/
  }
}
