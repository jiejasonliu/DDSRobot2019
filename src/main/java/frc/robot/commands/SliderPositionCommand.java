package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotSettings;
import frc.robot.helper.Position;

public class SliderPositionCommand extends Command {

    private Position pos = Position.BOTTOM;
    private double top, mid, bot;

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command
     * @param position Pass in an enum Position so that the Slider knows what position it is looking for
     */
	public SliderPositionCommand(Position position) {
        requires(Robot.slider);
		pos = position;
	}

	protected void initialize() {
        top = RobotSettings.SLIDER_TOP;
        mid = RobotSettings.SLIDER_MIDDLE;
        bot = RobotSettings.SLIDER_BOTTOM;
	}

	@Override
	protected void execute() {
        //need encoder for logic to work
        /*
            if encoder is lower than designated value, call slider.raise()
            else call slider.lower()

        */
	}

	@Override
	protected boolean isFinished() {
		return reachedPoint();
    }

    /**
     * Returns a boolean (true or false) which is passed onto the Command#isFinished() method. <p>
     * In turn, it allows for the slider to stop a certain pre-calibrated positions.
     * @return Whether or not the encoder is at the value calibrated for its position
     */
    private boolean reachedPoint() {
        if (pos == Position.TOP) {
            //encoder at top
        } 
        else if (pos == Position.MIDDLE) {
            //encoder at middle
        }
        else { //if pos = Position.BOTTOM
            //encoder at bottom
        }
        return true; //delete after getting encoder
    }

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
        end();
	}
}
