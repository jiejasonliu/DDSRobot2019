package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;
import frc.robot.commands.SliderPositionCommand;
import frc.robot.helper.Position;

public class Slider extends Subsystem {

    private Victor slider = new Victor(RobotMap.SLIDER_WINCH);
    private DigitalInput limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
    private Counter counter = new Counter(limitSwitch);

    private Position currentPosition = Position.BOTTOM;

    /** 
     *  Initialization tasks to be done before any commands are run with this specific subsystem.
     */
    public void updateDashboard() {
        if (RobotSettings.LIMIT_SWITCH_ON > 0.0) {
            SmartDashboard.putBoolean("Limit Switch", Robot.slider.getLimitSwitch().get());
        }
    }

    /**
     * Spins the motor to start raising the slider.
     */
    public void raise() {
        slider.set(RobotSettings.SLIDER_SPEED);
    }

    /**
     * Spin the motor in the opposite direction to start lowering the slider.
     */
    public void lower() {
        slider.set(-1.0 * RobotSettings.SLIDER_SPEED);
    }

    /**
     * Stops the motor that controls the slider.
     */
    public void stopMotor() {
        slider.stopMotor();
    }

    /**
     * Access to the limit switch on the Slider.
     * @return The single instance of the limit switch
     */
    public DigitalInput getLimitSwitch() {
        return this.limitSwitch;
    }

    /**
     * @return The current position
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }

    /**
     * @param Current position to set
     */
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition; //Wow! I believe in you! -Bips
    }

	/**
	 * @see DriveTrain#initDefaultCommand() references
     * @see SystemControl#initDefaultCommand() references
	 */
    @Override
    protected void initDefaultCommand() {
    }
}