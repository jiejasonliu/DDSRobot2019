package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotSettings;
import frc.robot.commands.SystemControlCommand;

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
     * Uses the slider axis to work out the turn speed designated. 
     * Turn speed will never exceed highest turn speed or go below lowest turn speed.
     * @return The turn speed with respect to the axis.
     */
    public double getCalculatedTurnSpeed() {
        double slider_axis = Robot.oi.getJoystick().getRawAxis(3) + 1; //add 1 to change range of [-1,1] to [0,2]
        double sliderPercentage = (slider_axis / 2.0); //get % of the slider on Joystick (+ is 100%, - is 0%). Range is [0,1]

        double highestTurnSpeed = getDefaultRotationSpeed();
        double lowestTurnSpeed = RobotSettings.LOWEST_TURN_SPEED;
        double range = highestTurnSpeed - lowestTurnSpeed; //distance between lowest and highest speed

        double outputTurnSpeed = (lowestTurnSpeed) + (range * sliderPercentage);

        SmartDashboard.putNumber("System Slider", sliderPercentage); //percentage of slider
        SmartDashboard.putNumber("Turn Speed", outputTurnSpeed); //current turn speed of Robot

        return outputTurnSpeed;
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