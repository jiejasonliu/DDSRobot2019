package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SliderPositionCommand;
import frc.robot.helper.Position;

public class Slider extends Subsystem {

    private Victor slider = new Victor(RobotMap.SLIDER_WINCH);

    public void raise() {

    }

    public void lower() {

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