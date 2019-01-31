package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;
import frc.robot.commands.SliderPositionCommand;
import frc.robot.commands.SystemControlCommand;
import frc.robot.helper.Position;

public class SystemControl extends Subsystem {

    private double defaultRotationSpeed = RobotSettings.TURN_SPEED;
    /**
     * Change the rotation speed for the Robot.
     */
    public void changeRotationSpeed(double rotationSpeed) {
        RobotSettings.changeRotationSpeed(rotationSpeed);
    }

    public double getDefaultRotationSpeed() {
        return this.defaultRotationSpeed;
    }

    /**
	 * Automatically starts the command on Robot initialization. Lowers the slider or prepares it to the bottom level.
	 * @see DriveTrain#initDefaultCommand() references
     * @see Slider#initDefaultCommand() references
	 */
    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new SystemControlCommand());
    }
}