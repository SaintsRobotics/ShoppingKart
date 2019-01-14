package com.saintsrobotics.swerveDrive.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.input.OI.XboxInput;
import com.saintsrobotics.swerveDrive.output.SwerveWheel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveControl extends RunEachFrameTask {
  private XboxInput xboxInput;
  private SwerveWheel w1;
  private SwerveWheel w2;
  private SwerveWheel w3;
  private SwerveWheel w4;
  double[] speedMultiplier = {0.25, 1};
  double turnMultiplier = 1;
  private int speedMultiplierPosition = 0;

  private double currentHead = 0;

  // full dimensions of the robot (from wheel to wheel)
  private final double LENGTH = 25.5;
  private final double WIDTH = 24;
  private int currentZone = 0; //arbitrary value
  
//  zone boundaries deciding when to add power to front or side wheels when turning
// 2_______1
// |\     /|
// | \ 1 / |
// |  \ /  |   boundaries listed on the edges
// | 2 \ 4 |   zones listed on the inside
// |  / \  |
// | / 3 \ |
// |/_____\|
// 3       4
  
  private final double BOUND_1 = Math.toDegrees(Math.atan(WIDTH / LENGTH));
  private final double BOUND_2 = 360 - Math.toDegrees(Math.atan(WIDTH / LENGTH));
  private final double BOUND_3 = 180 + Math.toDegrees(Math.atan(WIDTH / LENGTH));
  private final double BOUND_4 = 180 - Math.toDegrees(Math.atan(WIDTH / LENGTH));

  public SwerveControl(XboxInput xboxInput, SwerveWheel w1, SwerveWheel w2, SwerveWheel w3,
      SwerveWheel w4) {
    //wheels normally defined in the order of the quadrants on a cartesian plane
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

    double leftStickX = xboxInput.leftStickX();
    double leftStickY = -xboxInput.leftStickY();
    double rightStickX = xboxInput.rightStickX() * this.turnMultiplier;
    // double xAxis = xboxInput.DPAD_LEFT() ? -1 : xboxInput.DPAD_RIGHT() ? 1 : 0;
    // double yAxis = xboxInput.DPAD_UP() ? 1 : xboxInput.DPAD_DOWN() ? -1 : 0;

    double targetVelocity = Math.sqrt(Math.pow(leftStickX, 2) + Math.pow(leftStickY, 2))
        * this.speedMultiplier[speedMultiplierPosition];
    if (targetVelocity > 1) {
      targetVelocity = 1;
    }
    double targetHead = this.findRobotHeading(leftStickX, leftStickY);

    double targetVelocity1 = targetVelocity;
    double targetVelocity2 = targetVelocity;
    double targetVelocity3 = targetVelocity;
    double targetVelocity4 = targetVelocity;

    
    //is there a more efficient way to do this with async or using a different task?
    this.updateZone(targetHead);
    switch (this.currentZone) {
      case 1:
        targetVelocity1 -= rightStickX/2;
        targetVelocity2 += rightStickX/2;
        targetVelocity3 += rightStickX/2;
        targetVelocity4 -= rightStickX/2;
        break;
      case 2:
        targetVelocity1 -= rightStickX/2;
        targetVelocity2 -= rightStickX/2;
        targetVelocity3 += rightStickX/2;
        targetVelocity4 += rightStickX/2;
        break;
      case 3:
        targetVelocity1 += rightStickX/2;
        targetVelocity2 -= rightStickX/2;
        targetVelocity3 -= rightStickX/2;
        targetVelocity4 += rightStickX/2;
        break;
      case 4:
        targetVelocity1 += rightStickX/2;
        targetVelocity2 += rightStickX/2;
        targetVelocity3 -= rightStickX/2;
        targetVelocity4 -= rightStickX/2;
        break;
    }
    
    SmartDashboard.putNumber("zone ", this.currentZone);
    SmartDashboard.putNumber("rightStickX ", rightStickX);
    SmartDashboard.putNumber("targetHead ", targetHead);
    SmartDashboard.putNumber("leftStickX ", leftStickX);
    SmartDashboard.putNumber("leftStickY ", leftStickY);
    SmartDashboard.putNumber("speedMultiplier ", this.speedMultiplier[speedMultiplierPosition]);
    SmartDashboard.putNumber("targetVelocity ", targetVelocity);
    
    this.currentHead = w2.getTurningEncoder();

    //makes sure the wheels don't turn more than 90 degrees for one direction change
    double diff = 0;
    if (Math.abs(targetHead - this.currentHead) > 180) {
      diff = 360 - Math.abs(targetHead - this.currentHead);
    }
    else { 
      diff = Math.abs(targetHead - this.currentHead);
    }
    if (diff > 90) {
      targetVelocity1 = -targetVelocity1;
      targetVelocity2 = -targetVelocity2;
      targetVelocity3 = -targetVelocity3;
      targetVelocity4 = -targetVelocity4;
      targetHead = (180.0 + targetHead) % 360.0;
    }
    
    w1.setHeadAndVelocity(targetHead, targetVelocity1);
    w2.setHeadAndVelocity(targetHead, targetVelocity2);
    w3.setHeadAndVelocity(targetHead, targetVelocity3);
    w4.setHeadAndVelocity(targetHead, targetVelocity4);
    

  }

  public double findRobotHeading(double x, double y) {
    // finds the direction (angle) that the robot should be moving based on joystick input
    if (y == 0 && x < 0)
      return 270.00;
    if (y == 0 && x > 0)
      return 90.00;
    double angle = 0;
    double theta = Math.abs(Math.toDegrees(Math.atan(x / y)));
    // if u ever get to it, or u want to give programming members busy-work, try to clean up this code
    if (x >= 0 && y < 0) {
      angle = 90;
      return angle + 90 - theta;
    } else if (x <= 0 && y < 0)
      angle = 180.0;
    else if (x < 0 && y > 0) {
      angle = 270;
      return angle + 90 - theta;
    }
    return angle + theta;
  }

  public void updateZone(double direction) {
    //constantly updates which zone the leftStick is in
    //'direction' is the absolute direction that the robot is driving
    if (direction > this.BOUND_1 && direction <= this.BOUND_4) {
      this.currentZone = 4;
    }
    else if (direction > this.BOUND_4 && direction <= this.BOUND_3) {
      this.currentZone = 3;
    }
    else if (direction > this.BOUND_3 && direction <= this.BOUND_2) {
      this.currentZone = 2;
    }
    else {
      this.currentZone = 1;
    }
  }

//  private boolean shouldInvert(double prevHeading, double targetHead) {
//    double diff = 0;
//    if (Math.abs(targetHead - this.currentHead) > 180) {
//      diff = 360 - Math.abs(targetHead - this.currentHead);
//    } else {
//      diff = Math.abs(targetHead - this.currentHead);
//    }
//
//    if (diff > 90) {
//      return true;
//    }
//    return false;
//  }
}
