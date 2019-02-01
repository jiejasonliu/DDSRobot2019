package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotSettings;
import frc.robot.commands.DriveCommand;

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

	//public ADXRS450_Gyro gyro  = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	public final double initSpeed = RobotSettings.DRIVE_SPEED; //speed during initialization
	
	/**
	 * Drives using DifferentialDrive#curvatureDrive. <p>
	 * 
	 * Lets the robot turn in place as long as velocity does not exceed the sensitivity factor.
	 * @see DifferentialDrive#curvatureDrive() boolean param3 (isQuickTurn)
	 * 
	 * @param velocity How fast the robot is going (positive is forwards, negative is backwards)
	 * @param rotation How fast the robot is spinning (positive is clockwise, negative is counter-clockwise)
	 */
	public void drive(double velocity, double rotation) {
		SmartDashboard.putNumber("Velocity", velocity);
		SmartDashboard.putNumber("Rotation Speed", rotation);

		if (velocity > 0.15 || velocity < -0.15) {
			drive.curvatureDrive(velocity, rotation, false); //curves
		} else {
			drive.curvatureDrive(velocity, rotation, true); //turn in place
		}
	}

	public double dataTransfer(double data, int dataID) {
		return data;
	}

	/**
	 * Automatically starts the command on Robot initialization. You never have to start the command in this case.
	 * @see Slider#initDefaultCommand() references
	 * @see SystemControl#initDefaultCommand() references
	 */
	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}
}