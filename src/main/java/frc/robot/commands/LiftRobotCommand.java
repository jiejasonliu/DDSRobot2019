package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftRobotCommand extends Command {

    private boolean resetBoth = false; 

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     * 
     * @param resetBoth Whether or not this instance of the command should compress both pneumatics.
     */
    public LiftRobotCommand(boolean resetBoth) {
        requires(Robot.pneumatic);
        resetBoth = this.resetBoth;
    }

    protected void initialize() {
        if (!Robot.pneumatic.isFront) {
            Robot.pneumatic.decompressLifterFront(); //front on
            Robot.pneumatic.compressLifterBack(); //back off
        } else {
            Robot.pneumatic.compressLifterFront(); //front off
            Robot.pneumatic.decompressLifterBack(); //back on

            Robot.pneumatic.isFront = false; //set #isFront back to false because front is now compressed
        }
    }

    @Override
    protected void end() {
        if (resetBoth) {
            Robot.pneumatic.compressLifterFront();
            Robot.pneumatic.compressLifterBack();
        } else {
            System.out.println("Robot lifter was interrupted but nothing was done. Click the rset button for the Robot lifter!");
        }
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
