package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotSettings;

public class LocateTargetCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public LocateTargetCommand() {
        requires(Robot.limelight);
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.limelight.setTrackingMode();
    }

    @Override
    protected void execute() {
        var limelightData = Robot.limelight.getData(); //Java 10 'var' automatically creates new LLData object.
        if (limelightData.targetExists == 0.0) { //no target
            double meanSpeed = (RobotSettings.LOWEST_TURN_SPEED + RobotSettings.TURN_SPEED) / 2.0; //exactly half of lowest and highest speed
            Robot.driveTrain.curvatureDrive(0, meanSpeed, true); //spin in place
        } else {
            double speed = Robot.limelight.getSpeedCorrection();
            double heading = Robot.limelight.getHeadingError();

            Robot.driveTrain.curvatureDrive(speed, heading, false);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.nomNom.stopMotor();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
