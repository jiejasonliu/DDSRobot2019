/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotSettings;
import frc.robot.commands.DriveCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {

	public double kI = RobotSettings.kI;
	public double kP = RobotSettings.kP;
	public double error_angle = 0;

	private Victor left1 = new Victor(RobotMap.VICTOR_LEFT1);
	private Victor left2 = new Victor(RobotMap.VICTOR_LEFT2);
	private Victor right1 = new Victor(RobotMap.VICTOR_RIGHT1);
	private Victor right2 = new Victor(RobotMap.VICTOR_RIGHT2);

	//groups both motors as one drive, both motors required for movement
	public SpeedControllerGroup leftSideDrive = new SpeedControllerGroup(left1, left2);
	public SpeedControllerGroup rightSideDrive = new SpeedControllerGroup(right1, right2);
	public DifferentialDrive drive = new DifferentialDrive(leftSideDrive, rightSideDrive);

	public ADXRS450_Gyro gyro  = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	public final double initSpeed = RobotSettings.DRIVE_SPEED; //speed during initialization

	public void tankDrive(double left_axis, double right_axis) {
		double speed = RobotSettings.DRIVE_SPEED;
		drive.tankDrive(left_axis * speed, right_axis * speed);
	}

	public void driveStraight(double velocity, double output) {
		drive.arcadeDrive(velocity, output);
	}

	public void stopAutonomous() {
		drive.tankDrive(0.7,0.7);
	}

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}
}
