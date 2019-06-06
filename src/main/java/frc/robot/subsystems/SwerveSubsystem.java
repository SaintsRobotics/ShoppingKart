package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.util.AngleUtilities;
import frc.robot.util.PidConfig;

public class SwerveSubsystem extends Subsystem {
	private static final double SPEED_COEF = 1;
	public static double[] PIVOT_LOC;

	private SwerveWheel[] wheels;
	private boolean isTurning;
	private double maxRad;

	private ADXRS450_Gyro gyro;

	private PIDController headingPidController;
	private double headingPidOutput;

	private double translationX;
	private double translationY;
	private double rotationX;

	public SwerveSubsystem(SwerveWheel[] wheels, double[] pivotLoc, ADXRS450_Gyro gyro, PidConfig pidConfig) {
		this.wheels = wheels;
		PIVOT_LOC = pivotLoc;

		for (SwerveWheel s : wheels) {
			if (s.getRadius() > this.maxRad) {
				this.maxRad = s.getRadius();
			}
		}

		this.gyro = gyro;
		this.headingPidController = new PIDController(pidConfig.kP,pidConfig.kI,pidConfig.kD,
				this.gyro, (output) -> this.headingPidOutput = output);
		this.headingPidController.setAbsoluteTolerance(pidConfig.tolerance);
		this.headingPidController.setOutputRange(-0.4, 0.4);
		this.headingPidController.setInputRange(0, 360);
		this.headingPidController.setContinuous();
		this.headingPidController.reset();
		this.headingPidController.enable();
	}

	/**
	 * sets horizontal and vertical movement vectors
	 * 
	 * @param x direction (and magnitude) of the horizontal-movement vector
	 * @param y direction (and magnitude) of the vertical-movement vector
	 */
	public void setTranslationVector(double x, double y) {
		this.translationX = x;
		this.translationY = y;
	}

	/**
	 * sets the magnitude and direction of rotation vector (eg. turn stick input)
	 * 
	 * @param x the magnitude and direction of the raw rotation vector
	 */
	public void setRotationVector(double x) {
		this.rotationX = x;
	}

	/**
	 * sends target heading to pid, in degrees will maintain heading over time, and
	 * is an absolute position
	 * 
	 * @param n the target heading in degrees
	 */
	public void setRobotTargetHead(double n) {
		this.headingPidController.setSetpoint(n);
	}

	@Override
	public void initDefaultCommand() {
		SmartDashboard.putNumber("target heading", this.headingPidController.getSetpoint());

		// Gyro coords are continuous so this restricts it to 360
		double currentHead = ((this.gyro.getAngle() % 360) + 360) % 360;

		double rotationInput = this.headingPidOutput;
		if (this.rotationX != 0.0) {
			rotationInput = this.rotationX;
			this.isTurning = true;
		} else if (this.rotationX == 0.0 && this.isTurning) {
			this.headingPidController.setSetpoint(currentHead);
			this.isTurning = false;
		}

		SmartDashboard.putNumber("rotation input", rotationInput);
		SmartDashboard.putNumber("translation x", this.translationX);
		SmartDashboard.putNumber("translation y", this.translationY);
		SmartDashboard.putNumber("rotation pid", this.headingPidOutput);
		// Doing math with each of the vectors for the SwerveWheels
		// Calculating the rotation vector, then adding that to the translation vector
		// Converting them to polar vectors
		double[][] vectors = new double[wheels.length][2];
		for (int i = 0; i < wheels.length; i++) {
			vectors[i][0] = wheels[i].getRotationVector()[0] * (1 / this.maxRad) * rotationInput + translationX;
			vectors[i][1] = wheels[i].getRotationVector()[1] * (1 / this.maxRad) * rotationInput + translationY;
			vectors[i] = AngleUtilities.cartesianToPolar(vectors[i]);
		}

		// If any of the velocities are greater than SPEED_COEF, then scale them all
		// down
		boolean needsScale = false;
		double maxVelocity = 0; // an arbitrary value
		int v = 0; // index used for traversing the vectors array
		while (!needsScale && v < vectors.length) {
			needsScale = vectors[v][1] > SwerveSubsystem.SPEED_COEF;
			maxVelocity = Math.max(maxVelocity, vectors[v][1]);
			v++;
		}
		if (needsScale) {
			for (double[] i : vectors) {
				i[1] /= maxVelocity;
			}
		}

		if (Math.abs(maxVelocity) < 0.05) {
			for (int i = 0; i < wheels.length; i++) {
				wheels[i].setVelocity(0.0);
			}
		} else {
			for (int i = 0; i < wheels.length; i++) {
				wheels[i].setHeadAndVelocity(vectors[i][0], vectors[i][1]);
			}
		}
	}
	
	
	public void setPivotLoc(double[] newLoc) {
		PIVOT_LOC = newLoc;
		
		for (SwerveWheel wheel : this.wheels) {
			wheel.resetRotationVector();
		}
	}    
}