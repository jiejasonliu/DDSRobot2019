package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotSettings;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.TankDriveCommand;

public class DriveTrain extends Subsystem {

	public double kI = RobotSettings.kI;
	public double kP = RobotSettings.kP;
	public double error_angle = 0;

	private Victor left1 = new Victor(RobotMap.MOTOR_LEFT1);
	private Victor left2 = new Victor(RobotMap.MOTOR_LEFT2);
	private Victor right1 = new Victor(RobotMap.MOTOR_RIGHT1);
	private Victor right2 = new Victor(RobotMap.MOTOR_RIGHT2);

	//groups both motors as one drive, both motors required for movement
	private SpeedControllerGroup leftSideDrive = new SpeedControllerGroup(left1, left2);
	private SpeedControllerGroup rightSideDrive = new SpeedControllerGroup(right1, right2);
	public DifferentialDrive drive = new DifferentialDrive(leftSideDrive, rightSideDrive);

	public final double initSpeed = RobotSettings.DRIVE_SPEED; //speed during initialization
	
	/**
	 * Drives using DifferentialDrive#curvatureDrive. <p>
	 * 
	 * Lets the robot turn in place as long as velocity does not exceed the sensitivity factor.
	 * @see DifferentialDrive#curvatureDrive() boolean param3 (isQuickTurn)
	 * @see DriveCommand#execute() for usage of this method
	 * 
	 * @param velocity How fast the robot is going (positive is forwards, negative is backwards)
	 * @param rotation How fast the robot is spinning (positive is clockwise, negative is counter-clockwise)
	 */
	public void drive(double velocity, double rotation) {
		SmartDashboard.putNumber("Velocity", velocity);
		SmartDashboard.putNumber("Current Rotation Speed", rotation);
		double maxDriveSpeed = RobotSettings.DRIVE_SPEED;

		if (Math.abs(velocity) < 0.05) {
			drive.curvatureDrive(velocity, rotation, true); //turn in place
		} else {
			drive.curvatureDrive(velocity, rotation, false); //curves
		}
	}

	/** 
	 * @deprecated Preferably use a proper Joystick or use {@link #curvatureDrive(double, double, boolean)}.
	 * Tank drive makes controlling the Robot difficult in the case of multiple button actions (no free hand for a single driver).
	 */
	@Deprecated
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	/**
	 * Drive that is directly porportional to drive and turn speed.
	 * 
	 * @see frc.robot.commands.LocateTargetCommand#execute()
	 */
	public void arcadeDrive(double speed, double turn) {
		drive.arcadeDrive(speed, turn);
	}

	/**
	 * Used primarily for Limelight camera system's locating mechanism.
	 */
	public void curvatureDrive(double velocity, double rotation, boolean isQuickTurn) {
		drive.curvatureDrive(velocity, rotation, isQuickTurn);
	}

	/**
	 * Automatically starts the command on Robot initialization. You never have to start the command in this case.
	 * @see frc.robot.subsystems.Slider#initDefaultCommand() Slider reference
	 * @see frc.robot.subsystems.SystemControl#initDefaultCommand() SystemControl reference
	 */
	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}
}