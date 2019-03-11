package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotSettings;
import frc.robot.helper.Direction;

public class LocateTargetCommand extends Command {

    private Direction initMotion = Direction.CLOCKWISE;
    private int clockwise = 1;

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
    public LocateTargetCommand(Direction motion) {
        requires(Robot.limelight);
        requires(Robot.driveTrain);
        initMotion = motion;
    }

    @Override
    protected void initialize() {
        Robot.limelight.setTrackingMode();

        if (initMotion == Direction.COUNTERCLOCKWISE) {
            clockwise = -1;
        } else { //set clockwise, can delete this but leaving it for readability since init (default: 1)
            clockwise = 1;
        }
    }

    @Override
    protected void execute() {
        var limelightData = Robot.limelight.getData(); //Java 10 'var' automatically creates new LLData object.
        
        if (limelightData.targetExists != 0.0) { //no target
            double speed = Robot.limelight.getSpeedCorrection();
            double heading = Robot.limelight.getHeadingError();

            System.out.println("Speed: " + speed);
            System.out.println("Heading: " + heading);

            Robot.driveTrain.arcadeDrive(speed*1.25, heading);
        }
    }

    @Override
    protected boolean isFinished() {
        boolean finished = Robot.limelight.getData().area >= RobotSettings.TARGET_AREA;
        return finished;
    }

    @Override
    protected void end() {
        Robot.limelight.setDriveCamMode();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
