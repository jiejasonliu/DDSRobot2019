package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;
import frc.robot.commands.SliderPositionCommand;
import frc.robot.helper.Position;

public class Slider extends Subsystem {

    private Victor slider = new Victor(RobotMap.SLIDER_WINCH);

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
	 * Automatically starts the command on Robot initialization. Lowers the slider or prepares it to the bottom level.
	 * @see DriveTrain#initDefaultCommand() references
	 */
    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new SliderPositionCommand(Position.BOTTOM));
    }
}