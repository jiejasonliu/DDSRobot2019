package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DiskReleaseCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public DiskReleaseCommand()
        requires(Robot.pneumatic);
    }

    protected void initialize() {
        Robot.pneumatic.decompress();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.pneumatic.compress();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
