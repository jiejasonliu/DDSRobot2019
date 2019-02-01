package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotSettings;

public class SystemControlCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
	public SystemControlCommand() {
        requires(Robot.sys);
	}

	protected void initialize() {
	}

	@Override
	protected void execute() {
        RobotSettings.changeRotationSpeed(getTurnSpeed());
	}

    /**
     * Uses the slider axis to work out the turn speed designated. 
     * Turn speed will never exceed highest turn speed or go below lowest turn speed.
     * @return The turn speed with respect to the axis.
     */
    public double getTurnSpeed() {
        double slider_axis = Robot.oi.getJoystick().getRawAxis(3) + 1; //add 1 to change range of [-1,1] to [0,2]
        double sliderPercentage = (slider_axis / 2); //get % of the slider on Joystick (+ is 100%, - is 0%). Range is [0,1]

        double highestTurnSpeed = Robot.sys.getDefaultRotationSpeed();
        double lowestTurnSpeed = RobotSettings.LOWEST_POSSIBLE_TURN_SPEED;
        double range = highestTurnSpeed - lowestTurnSpeed; //distance between lowest and highest speed

        return (lowestTurnSpeed) + (range * sliderPercentage);
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
        end();
	}
}
