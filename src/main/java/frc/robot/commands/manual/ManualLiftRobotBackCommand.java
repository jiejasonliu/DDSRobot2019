package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualLiftRobotBackCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call {@link Command#interrupted()} on the last command.
     */
    public ManualLiftRobotBackCommand() {
        requires(Robot.pneumatic);
    }

    @Override
    protected void execute() {
        Robot.pneumatic.decompressLifterBack();
        //System.out.println("Decompress back");
    }

    @Override
    protected void end() {
        Robot.pneumatic.compressLifterBack();
        //System.out.println("Compress back");
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
