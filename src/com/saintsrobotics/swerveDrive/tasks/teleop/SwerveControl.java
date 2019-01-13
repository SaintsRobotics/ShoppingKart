package com.saintsrobotics.swerveDrive.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.input.OI.XboxInput;
import com.saintsrobotics.swerveDrive.output.SwerveWheel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveControl extends RunEachFrameTask{
  private XboxInput xboxInput;
  private SwerveWheel w1;
  private SwerveWheel w2;
  private SwerveWheel w3;
  private SwerveWheel w4;
  double[] speedMultiplier = {0.5, 1};
  private int speedMultiplierPosition = 0;
  
  private double prevHead = 0;
  private double diff = 0;
  
   public SwerveControl(XboxInput xboxInput, SwerveWheel w1, SwerveWheel w2, SwerveWheel w3, SwerveWheel w4) {
    this.xboxInput = xboxInput;
    this.w1 = w1;
    this.w2 = w2;
    this.w3 = w3;
    this.w4 = w4;
  }
  
  @Override
  public void runEachFrame() {
    if (xboxInput.A()) {
      this.speedMultiplierPosition += 1;
      this.speedMultiplierPosition %= speedMultiplier.length;
    }
    
    double xAxis = xboxInput.leftStickX();
    double yAxis = -xboxInput.leftStickY();
//    double xAxis = xboxInput.DPAD_LEFT() ? -1 : xboxInput.DPAD_RIGHT() ? 1 : 0;
//    double yAxis = xboxInput.DPAD_UP() ? 1 : xboxInput.DPAD_DOWN() ? -1 : 0;
    
    double targetVelocity = Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2)) * this.speedMultiplier[speedMultiplierPosition];
    if (targetVelocity > 1) targetVelocity = 1;
    double targetHead = this.findRobotHeading(xAxis, yAxis);

    SmartDashboard.putNumber("prevHead ", prevHead);
//    if (Math.abs(prevHead - targetHead) > Math.abs(prevHead - Math.abs(180 - targetHead))) { 
//      targetVelocity = -targetVelocity;
//      targetHead = Math.abs(180 - targetHead);
//    }
    
//    if (prevHead == 0) {
    prevHead = w2.getTurningEncoder();
//    }
    if (Math.abs(targetHead - this.prevHead) > 180) {
      this.diff = 360 - Math.abs(targetHead - this.prevHead);
    }
    else {
      this.diff = Math.abs(targetHead - this.prevHead);
    }
    
    if (this.diff > 90) {
      targetHead += 180;
      targetHead %= 360;
      targetVelocity = -targetVelocity;
    }
    
    w1.setHeadAndVelocity(targetHead, targetVelocity);
    w2.setHeadAndVelocity(targetHead, targetVelocity);
    w3.setHeadAndVelocity(targetHead, targetVelocity);
    w4.setHeadAndVelocity(targetHead, targetVelocity);
    
    SmartDashboard.putNumber("targethead ", targetHead);
    SmartDashboard.putNumber("speedMultiplier ", this.speedMultiplier[speedMultiplierPosition]);
    SmartDashboard.putNumber("targetVelocity ", targetVelocity);
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
