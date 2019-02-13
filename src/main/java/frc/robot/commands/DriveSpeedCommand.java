package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotSettings;

public class DriveSpeedCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public DriveSpeedCommand() {
        requires(Robot.sys);
    }

    protected void initialize() {
        SmartDashboard.putString("Slider Focus", "Drive Train");
    }

    @Override
    protected void execute() {
        RobotSettings.changeDriveSpeed(Robot.sys.getCalculatedDriveSpeed());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        SmartDashboard.delete("Slider Focus");
    }

    @Override
    protected void interrupted() {
        end();
    }
}
