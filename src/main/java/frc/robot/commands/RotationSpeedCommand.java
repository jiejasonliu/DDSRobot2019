package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotSettings;

public class RotationSpeedCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public RotationSpeedCommand() {
        requires(Robot.sys);
    }

    protected void initialize() {
    }

    @Override
    protected void execute() {
        RobotSettings.changeRotationSpeed(Robot.sys.getCalculatedTurnSpeed());
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
