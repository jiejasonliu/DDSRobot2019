package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.helper.Position;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joy = new Joystick(RobotMap.JOYSTICK_PORT);

	public OI() {
		//Button some_button = new JoystickButton(joy, button_id);
		Button topSlider = new JoystickButton(joy, 7);
		Button middleSlider = new JoystickButton(joy, 9);
		Button bottomSlider = new JoystickButton(joy, 11);
		Button nomNomRelease = new JoystickButton(joy, 1);
		Button nomNomGrab = new JoystickButton(joy, 2);

		topSlider.whenPressed(new SliderPositionCommand(Position.TOP));
		middleSlider.whenPressed(new SliderPositionCommand(Position.MIDDLE));
		bottomSlider.whenPressed(new SliderPositionCommand(Position.BOTTOM));
		nomNomRelease.whileHeld(new NomNomReleaseCommand());
		nomNomGrab.whileHeld(new NomNomGrabCommand());

		//create button for locating target
	}

	public Joystick getJoystick() {
		return this.joy;
	}
}


