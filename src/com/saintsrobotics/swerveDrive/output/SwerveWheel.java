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

	public SwerveWheel(String name, Motor driveMotor, Motor turnMotor, TurnConfiguration pidConfig) {
		this.name = name;
		this.driveMotor = driveMotor;
		this.turnMotor = turnMotor;
		this.encoder = pidConfig.encoder;

		this.headingPidReceiver = new PIDReceiver();
		this.headingPidController = new PIDController(pidConfig.forwardHeadingKP, 0.0, 0.0, pidConfig.encoder,
				headingPidReceiver);
		this.headingPidController.setAbsoluteTolerance(pidConfig.forwardHeadingTolerance);
		this.headingPidController.setOutputRange(-01, 01);
		this.headingPidController.setInputRange(0, 360);
		this.headingPidController.setContinuous();
		this.headingPidController.reset();
		this.headingPidController.enable();
	}

	public void setHeadAndVelocity(double targetHead, double targetVelocity) {
		double diff = 0.0;
		double currentHead = this.encoder.pidGet();
		if (Math.abs(targetHead - currentHead > 180) {
			diff = 360 - Math.abs(targetHead - currentHead);
		} else {
			diff = Math.abs(targetHead - currentHead);
		}

		if (diff > 90) {
			targetHead += 180;
			targetHead %= 360;
			targetVelocity = -targetVelocity;
		}
		this.targetVelocity = targetVelocity;
		this.targetHead = targetHead;
	}

	public double getTurningEncoder() {
		return this.encoder.pidGet();
	}

	@Override
	public void runEachFrame() {
		this.driveMotor.set(this.targetVelocity);
		this.headingPidController.setSetpoint(this.targetHead);
		double headingOutput = this.headingPidReceiver.getOutput();
		this.turnMotor.set(headingOutput);

		SmartDashboard.putNumber("encoder " + this.name, this.encoder.pidGet());
		SmartDashboard.putNumber("pid output " + this.name, headingOutput);
		SmartDashboard.putNumber("pid error " + this.name, this.headingPidController.getError());
	}
}
