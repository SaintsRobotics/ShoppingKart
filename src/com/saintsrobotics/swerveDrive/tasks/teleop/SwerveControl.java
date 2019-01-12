package com.saintsrobotics.swerveDrive.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.input.OI.XboxInput;
import com.saintsrobotics.swerveDrive.output.SwerveWheel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveControl extends RunEachFrameTask{
  XboxInput xboxInput;
  SwerveWheel w1;
  SwerveWheel w2;
  SwerveWheel w3;
  SwerveWheel w4;
  
   public SwerveControl(XboxInput xboxInput, SwerveWheel w1, SwerveWheel w2, SwerveWheel w3, SwerveWheel w4) {
    this.xboxInput = xboxInput;
    this.w1 = w1;
    this.w2 = w2;
    this.w3 = w3;
    this.w4 = w4;
  }
  
  @Override
  public void runEachFrame() {
    double speedMultiplier = 0.33;
    double xAxis = xboxInput.leftStickX();
    double yAxis = -xboxInput.leftStickY();
    double targetVelocity = Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2)) * speedMultiplier;
    if (targetVelocity > 1) targetVelocity = 1;
    double targetHead = this.findRobotHeading(xAxis, yAxis);
    
    w1.setHeadAndVelocity(targetHead, targetVelocity);
    w2.setHeadAndVelocity(targetHead, targetVelocity);
    w3.setHeadAndVelocity(targetHead, targetVelocity);
    w4.setHeadAndVelocity(targetHead, targetVelocity);
    
    SmartDashboard.putNumber("targethead", targetHead);
    SmartDashboard.putNumber("speedMultiplier", speedMultiplier);
    SmartDashboard.putNumber("targetVelocity", targetVelocity);
}
  
  public double findRobotHeading(double x, double y) {
    //finds the direction (angle) that the robot should be moving based on joystick input
    if (y == 0 && x < 0) return 270.00;
    if (y == 0 && x > 0) return 90.00;
    double angle = 0;
    double theta = Math.abs(Math.toDegrees(Math.atan(x/y)));
    //if u ever get to it, or u want to give programming members busy-work, try to clean up this code
    if (x >= 0 && y < 0) {angle = 90; return angle+90-theta;}
    else if (x <= 0 && y < 0) angle = 180.0;
    else if (x < 0 && y > 0) { angle = 270; return angle+90-theta;}
    return angle + theta;
  }
}
