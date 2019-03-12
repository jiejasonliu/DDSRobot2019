package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotSettings;
import frc.robot.helper.Direction;

public class LocateTargetCommand extends Command {

    private double delay = Math.ceil(RobotSettings.LL_DELAY * 50.0); //converts seconds to iterative values (1 sec = 50)
    private double currentTimer = 0; //current timer

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call {@link Command#interrupted()} on the last command.
     */
    public LocateTargetCommand() {
        requires(Robot.limelight);
        requires(Robot.driveTrain);
    }

    /**
     * Enables tracking mode via {@link frc.robot.subsystems.Limelight#setTrackingMode()}
     */
    @Override
    protected void initialize() {
        Robot.limelight.setTrackingMode();
    }

    /**
     * Iterates for the timer delay before initiating any methods. <p>
     * Using the limelight data and checking conditionals, 
     * it grabs the corrected porpotional speeds and headings using PID loops.
     * 
     * @see frc.robot.subsystems.Limelight#getSpeedCorrection()
     * @see frc.robot.subsystems.Limelight#getHeadingError()
     */
    @Override
    protected void execute() {
        currentTimer++;
        var limelightData = Robot.limelight.getData(); //Java 10 'var' automatically creates new LLData object.
        
        if (limelightData.targetExists != 0.0 && currentTimer > delay) { //no target
            double speed = Robot.limelight.getSpeedCorrection();
            double heading = Robot.limelight.getHeadingError();

            SmartDashboard.putNumber("Speed", speed);
            SmartDashboard.putNumber("Heading", heading);
            System.out.println("Speed: " + speed);
            System.out.println("Heading: " + heading);

            Robot.driveTrain.arcadeDrive(speed, heading);
        }
    }

    /**
     * Cancels the command (stops the robot entirely) if the Robot hasn't stopped by itself.
     * The condition to stop is based on how much area the rectangle the Robot sees takes relative to the resolution.
     * <p>
     * TARGET_AREA of 10.5 would mean that the rectangular box takes up 10.5% of the screen's total area.
     */
    @Override
    protected boolean isFinished() {
        boolean finished = Robot.limelight.getData().area >= RobotSettings.TARGET_AREA;
        return finished;
    }

    /**
     * When the command is over whether it's cancelled manually by OI toggle or {@link Command#isFinished()} is called,
     * it will set the Robot back to "Drive Camera Mode.""
     */
    @Override
    protected void end() {
        Robot.limelight.setDriveCamMode();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
