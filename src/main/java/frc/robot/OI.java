package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.helper.Direction;
import frc.robot.helper.Position;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joy = new Joystick(RobotMap.JOYSTICK_PORT);
	private XboxController xbox = new XboxController(0);

	public OI() {
		Button nomNomRelease = new JoystickButton(joy, 1);
		Button nomNomGrab = new JoystickButton(joy, 2);
		Button raiseSlider = new JoystickButton(joy, 7);
		Button lowerSlider = new JoystickButton(joy, 8);
		Button launchDisk = new JoystickButton(joy, 12);
		Button turnSpeed = new JoystickButton(joy, 4);
		Button driveSpeed = new JoystickButton(joy, 3);

		nomNomRelease.whileHeld(new NomNomReleaseCommand());
		nomNomGrab.whileHeld(new NomNomGrabCommand());
		raiseSlider.whileHeld(new ManualSliderCommand(Direction.UP));
		lowerSlider.whileHeld(new ManualSliderCommand(Direction.DOWN));
		turnSpeed.whenPressed(new RotationSpeedCommand());
		driveSpeed.whenPressed(new DriveSpeedCommand());
		launchDisk.whileHeld(new DiskReleaseCommand());

		//create button for locating target
	}

	public Joystick getJoystick() {
		return this.joy;
	}

	public XboxController getController() {
		return this.xbox;
	}
}


