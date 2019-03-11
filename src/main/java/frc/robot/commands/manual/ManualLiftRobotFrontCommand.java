package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualLiftRobotFrontCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     * 
     * @param resetBoth Whether or not this instance of the command should compress both pneumatics.
     */
    public ManualLiftRobotFrontCommand() {
        requires(Robot.pneumatic);
    }

    @Override
    protected void execute() {
        Robot.pneumatic.decompressLifterFront();
        //System.out.println("Decompress front");
    }

    @Override
    protected void end() {
        Robot.pneumatic.compressLifterFront();
        //System.out.println("Compress front");
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
