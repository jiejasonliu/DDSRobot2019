package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftRobotCommand extends Command {

    private boolean resetBoth = false; 

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call {@link Command#interrupted()} on the last command.
     * 
     * @param resetBoth Whether or not this instance of the command should compress both pneumatics.
     */
    public LiftRobotCommand(boolean resetBoth) {
        requires(Robot.pneumatic);
        resetBoth = this.resetBoth;
    }

    /**
     * Update: 03/11/2019 -- this is no longer being used.
     * 
     * Note that this.resetBoth is initialized as false, meaning that the first block will always be ran first.
     * This creates a see-saw pattern for the robot with the front always being released first.
     * 
     * @see frc.robot.commands.manual.ManualLiftRobotBackCommand
     * @see frc.robot.commands.manual.ManualLiftRobotFrontCommand
     */
    @Override
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

    /**
     * If the Command is passed with the boolean true, it compresses both (front and back) of the pneumatic solenoids back up.
     */
    @Override
    protected void end() {
        if (resetBoth) {
            Robot.pneumatic.compressLifterFront();
            Robot.pneumatic.compressLifterBack();
        } else {
            System.out.println("Robot lifter was interrupted but nothing was done. Click the reset OI button for the Robot lifter!");
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
