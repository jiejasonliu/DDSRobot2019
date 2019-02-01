package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;
import frc.robot.commands.SliderPositionCommand;
import frc.robot.helper.Position;

public class Slider extends Subsystem {

    private Victor slider = new Victor(RobotMap.SLIDER_WINCH);
    private Position currentPosition = Position.BOTTOM;

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
     * @return The current position
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }

    /**
     * @param Current position to set
     */
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

	/**
	 * Automatically starts the command on Robot initialization. Lowers the slider or prepares it to the bottom level.
	 * @see DriveTrain#initDefaultCommand() references
     * @see SystemControl#initDefaultCommand() references
	 */
    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new SliderPositionCommand(Position.BOTTOM));
    }
}