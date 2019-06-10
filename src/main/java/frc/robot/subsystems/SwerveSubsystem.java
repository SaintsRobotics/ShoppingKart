package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.util.AngleUtilities;
import frc.robot.util.PidConfig;

public class SwerveSubsystem extends Subsystem {
	private static double DYNAMIC_SPEED_COEF = 1;
	private static double STATIC_TRANS_COEF = .1;
	private static double STATIC_ROT_COEF = .9;

	private SwerveWheel[] m_wheels;
	private PIDSource m_gyro;
	private PIDController m_pidController;
	private double m_pidOutput;

	private double m_transX;
	private double m_transY;
	private double m_rotVal;

	private boolean m_isTurning;
	private double m_maxWheelDistance;

	public SwerveSubsystem(SwerveWheel[] wheels, double[] pivotLoc, PIDSource gyro, PidConfig pidConfig,
			double dynSpeedCoef, double stcTransCoef, double stcRotCoef) {
		this(wheels, pivotLoc, gyro, pidConfig);

		DYNAMIC_SPEED_COEF = dynSpeedCoef;
		STATIC_TRANS_COEF = stcTransCoef;
		STATIC_ROT_COEF = stcRotCoef;
	}

	public SwerveSubsystem(SwerveWheel[] wheels, double[] pivotLoc, PIDSource gyro, PidConfig pidConfig) {
		this.m_wheels = wheels;

		for (SwerveWheel s : wheels) {
			if (s.getRadius() > this.m_maxWheelDistance) {
				this.m_maxWheelDistance = s.getRadius();
			}
		}

		this.m_gyro = gyro;

		this.m_pidController = new PIDController(pidConfig.kP, pidConfig.kI, pidConfig.kD, this.m_gyro,
				(output) -> this.m_pidOutput = output);
		this.m_pidController.setAbsoluteTolerance(pidConfig.tolerance);
		this.m_pidController.setOutputRange(-0.4, 0.4);
		this.m_pidController.setInputRange(0, 360);
		this.m_pidController.setContinuous();
		this.m_pidController.reset();
		this.m_pidController.enable();
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand();
	}

	/**
	 * sets horizontal and vertical movement vectors
	 * 
	 * @param x direction (and magnitude) of the horizontal-movement vector
	 * @param y direction (and magnitude) of the vertical-movement vector
	 */
	public void setTranslationVector(double x, double y) {
		this.m_transX = x;
		this.m_transY = y;
	}

	/**
	 * sets the magnitude and direction of rotation vector (eg. turn stick input)
	 * 
	 * @param x the magnitude and direction of the raw rotation vector
	 */
	public void setRotationVector(double x) {
		this.m_rotVal = x;
	}

	/**
	 * sends target heading to pid, in degrees will maintain heading over time, and
	 * is an absolute position
	 * 
	 * @param n the target heading in degrees
	 */
	public void setRobotTargetHead(double n) {
		this.m_pidController.setSetpoint(n);
	}

	/**
	 * The translation and rotation speeds, shift according to how much speed is
	 * input.
	 */
	public void dynamicGainDrive() {
		// Gyro coords are continuous so this restricts it to 360
		double currentHead = ((this.m_gyro.pidGet() % 360) + 360) % 360;

		double rotationInput = this.m_pidOutput;
		if (this.m_rotVal != 0.0) {
			rotationInput = this.m_rotVal;
			this.m_isTurning = true;
		} else if (this.m_rotVal == 0.0 && this.m_isTurning) {
			this.m_pidController.setSetpoint(currentHead);
			this.m_isTurning = false;
		}

		// Doing math with each of the vectors for the SwerveWheels
		// Calculating the rotation vector, then adding that to the translation vector
		// Converting them to polar vectors
		double[][] vectors = new double[m_wheels.length][2];
		for (int i = 0; i < m_wheels.length; i++) {
			vectors[i][0] = m_wheels[i].getRotationVector()[0] * (1 / this.m_maxWheelDistance) * rotationInput
					+ m_transX;
			vectors[i][1] = m_wheels[i].getRotationVector()[1] * (1 / this.m_maxWheelDistance) * rotationInput
					+ m_transY;
			vectors[i] = AngleUtilities.cartesianToPolar(vectors[i]);
		}

		// If any of the velocities are greater than SPEED_COEF, then scale them all
		// down
		boolean needsScale = false;
		double maxVelocity = 0; // an arbitrary value
		int v = 0; // index used for traversing the vectors array
		while (!needsScale && v < vectors.length) {
			needsScale = vectors[v][1] > SwerveSubsystem.DYNAMIC_SPEED_COEF;
			maxVelocity = Math.max(maxVelocity, vectors[v][1]);
			v++;
		}
		if (needsScale) {
			for (double[] i : vectors) {
				i[1] /= maxVelocity;
				i[1] *= DYNAMIC_SPEED_COEF;
			}
		}

		for (int i = 0; i < m_wheels.length; i++) {
			m_wheels[i].setHeadAndVelocity(vectors[i][0], vectors[i][1]);
		}

	}

	/**
	 * There is a maximum speed at which the robot will rotate, and maximum speed at
	 * which the robot will translate.
	 */
	public void staticGainDrive() {
		// Gyro coords are continuous so this restricts it to 360
		double currentHead = ((this.m_gyro.pidGet() % 360) + 360) % 360;

		double rotationInput = this.m_pidOutput;
		if (this.m_rotVal != 0.0) {
			rotationInput = this.m_rotVal;
			this.m_isTurning = true;
		} else if (this.m_rotVal == 0.0 && this.m_isTurning) {
			this.m_pidController.setSetpoint(currentHead);
			this.m_isTurning = false;
		}

		// Doing math with each of the vectors for the SwerveWheels
		// Calculating the rotation vector, then adding that to the translation vector
		// Converting them to polar vectors
		double[][] vectors = new double[m_wheels.length][2];
		for (int i = 0; i < m_wheels.length; i++) {
			vectors[i][0] = m_wheels[i].getRotationVector()[0] * (1 / this.m_maxWheelDistance) * (rotationInput * STATIC_ROT_COEF)
					+ (m_transX * STATIC_TRANS_COEF);
			vectors[i][1] = m_wheels[i].getRotationVector()[1] * (1 / this.m_maxWheelDistance) * (rotationInput * STATIC_ROT_COEF)
					+ (m_transY * STATIC_TRANS_COEF);
			vectors[i] = AngleUtilities.cartesianToPolar(vectors[i]);
		}


		for (int i = 0; i < m_wheels.length; i++) {
			m_wheels[i].setHeadAndVelocity(vectors[i][0], vectors[i][1]);
		}
	}

}
