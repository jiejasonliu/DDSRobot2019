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

	/**
	 * All the fields are factored in by RobotSettings.____SPEED in order to limit how fast the motor can go.
	 * Keep in mind that Command#execute() is ran 50 times per second in correlation to TimedRobot's tick rate.
	 * 
	 * @y_axis Represents the Y-axis of the Joystick which correlates to velocity 
	 * (forward is -1, so it's inverted by multiplying by -1.0)
	 * 
	 * @z_axis Represents the Z-axis of the Joystick  which correlates to rotation speed
	 * (rotation speed matches DifferentialDrive#curvatureDrive() so no changes are needed)
	 */
	@Override
	protected void execute() {
		double y_axis = -1.0 * (Robot.oi.getJoystick().getY()) * RobotSettings.DRIVE_SPEED;
		double z_axis = Robot.oi.getJoystick().getZ() * RobotSettings.TURN_SPEED;

		if (y_axis < 0.1 && y_axis > -0.1) { //sensitivity adjustment
			y_axis = 0.0;
		}

		Robot.driveTrain.drive(y_axis, z_axis);
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
