package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDriveCommand extends Command {

    public TankDriveCommand() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

	@Override
	protected void execute() {
		double left_axis = -Robot.oi.getController().getRawAxis(1);
		double right_axis = -Robot.oi.getController().getRawAxis(5);
		Robot.driveTrain.tankDrive(left_axis, right_axis);
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
	}
}