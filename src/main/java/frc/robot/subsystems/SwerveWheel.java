package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.util.PidConfig;

public class SwerveWheel {

	private SpeedController m_driveMotor;
	private PIDSource m_encoder;
	private PIDController m_pidController;

	private static int[] PIVOT_LOC;

	private double[] m_wheelLoc;
	private double[] m_rotationVector;
	private double m_radius;

	public SwerveWheel(SpeedController driveMotor, PIDOutput turnMotor, PIDSource encoder, PidConfig pidConfig, double[] wheelLoc) {
		if (PIVOT_LOC == null) {
			throw new NullPointerException("Set the pivot point of your robot by calling SwerveWheel.setPivotLoc(int[]) before you construct a SwerveWheel.");
		}

		this.m_driveMotor = driveMotor;
		this.m_encoder = encoder;
		this.m_wheelLoc = wheelLoc;
		
		this.m_pidController = new PIDController(pidConfig.kP, pidConfig.kI, pidConfig.kD, this.m_encoder,
				(output) -> turnMotor.pidWrite(output));
		this.m_pidController.setAbsoluteTolerance(pidConfig.tolerance);
		this.m_pidController.setOutputRange(-01, 01);
		this.m_pidController.setInputRange(0, 360);
		this.m_pidController.setContinuous();
		this.m_pidController.reset();
		this.m_pidController.enable();

		this.m_rotationVector = new double[] { wheelLoc[1] - PIVOT_LOC[1], PIVOT_LOC[0] - wheelLoc[0] };
		this.m_radius = Math.sqrt(Math.pow((wheelLoc[0] - PIVOT_LOC[0]), 2) + Math.pow((wheelLoc[1] - PIVOT_LOC[1]), 2));
	}

	public void setHeadAndVelocity(double targetHead, double targetVelocity) {
		double diff = 0.0;
		double currentHead = this.m_encoder.pidGet();
		if (Math.abs(targetHead - currentHead) > 180) {
			diff = 360 - Math.abs(targetHead - currentHead);
		} else {
			diff = Math.abs(targetHead - currentHead);
		}
		if (diff > 90) {
			targetHead += 180;
			targetHead %= 360;
			targetVelocity = -targetVelocity;
		}

		this.setVelocity(targetVelocity);
		this.m_pidController.setSetpoint(targetHead);
	}

	/**
	 * 
	 * @param velocity double between -1 and 1.  0 being stopped
	 */
	public void setVelocity(double velocity) {
		this.m_driveMotor.set(velocity);
	}

	/**
	 * 
	 * @return The distance of the wheel to the pivot point
	 */
	public double getRadius() {
		return this.m_radius;
	}

	/**
	 * this value is unique to every wheel.  It is based on the pivot point and wheel location.
	 * 
	 * @return the directon (in the form of a slope) that the wheel will face when it is turning without any translational input
	 */
	public double[] getRotationVector() {
		return this.m_rotationVector;
	}

	/**
	 * 
	 * @param newLoc new pivot location
	 * @param wheels array of all SwerveWheels to update each of their rotationVectors.  (because this is a static method)
	 */
	public static void setPivotLoc(int[] newLoc, SwerveWheel[] wheels) {
		PIVOT_LOC = newLoc;

		for (SwerveWheel wheel : wheels) {
			wheel.m_rotationVector = new double[] { wheel.m_wheelLoc[1] - PIVOT_LOC[1], PIVOT_LOC[0] - wheel.m_wheelLoc[0] };
		}
	}
}