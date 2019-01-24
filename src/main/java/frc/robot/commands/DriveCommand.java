/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotSettings;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	public DriveCommand() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
	}

	@Override
	protected void execute() {
		double y_axis = -1.0 * (Robot.oi.getJoystick().getY()) * RobotSettings.DRIVE_SPEED;
		double rotation = Robot.oi.getJoystick().getZ() * RobotSettings.TURN_SPEED;

		if (y_axis < 0.1 && y_axis > -0.1) { //sensitivity adjustment
			y_axis = 0.0;
		}

		Robot.driveTrain.drive(y_axis, rotation);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		System.out.println("FATAL ERROR!!! Drive Train has been interrupted.");
		end();
	}
}
