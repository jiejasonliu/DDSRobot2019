package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class DiskReleaseCommand extends TimedCommand {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public DiskReleaseCommand(double time) {
        super(time, Robot.pneumatic);
    }

    protected void initialize() {
        Robot.pneumatic.decompress();
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
