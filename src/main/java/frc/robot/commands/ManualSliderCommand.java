package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.helper.Direction;

public class ManualSliderCommand extends Command {

    private Direction direction = Direction.UP;
    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public ManualSliderCommand(Direction direction) {
        requires(Robot.slider);
        this.direction = direction;
    }

    protected void initialize() {
    }

    @Override
    protected void execute() {
        switch(direction) {
            case UP:
                Robot.slider.raise();
                break;
            case DOWN:
                Robot.slider.lower();
                break;
                
            default:
                Robot.slider.lower();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
       Robot.slider.stopMotor();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
