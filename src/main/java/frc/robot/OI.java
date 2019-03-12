package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.commands.manual.ManualLiftRobotBackCommand;
import frc.robot.commands.manual.ManualLiftRobotFrontCommand;
import frc.robot.commands.manual.ManualSliderCommand;
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
		Button nomNomRelease = new JoystickButton(joy, 1); //shoot ball
		Button nomNomGrab = new JoystickButton(joy, 2); //grab ball
		Button raiseSlider = new JoystickButton(joy, 7); //raise height slider
		Button lowerSlider = new JoystickButton(joy, 8); //lower height slider
		Button launchDisk = new JoystickButton(joy, 12); //place game disc
		Button turnSpeed = new JoystickButton(joy, 4); //enable joystick slider prioritization of turn speed
		Button driveSpeed = new JoystickButton(joy, 3); //enable joystick driver prioritization of drive speed
		Button seek = new JoystickButton(joy, 10); //button for limelight seek
		Button frontRobot = new JoystickButton(joy, 9); //front of Robot (nom-nom side) pneumatic
		Button backRobot = new JoystickButton(joy, 11); //back of Robot (slider side) pneumatic

		nomNomRelease.whileHeld(new NomNomReleaseCommand());
		nomNomGrab.whileHeld(new NomNomGrabCommand());
		raiseSlider.whileHeld(new ManualSliderCommand(Direction.UP));
		lowerSlider.whileHeld(new ManualSliderCommand(Direction.DOWN));
		turnSpeed.whenPressed(new RotationSpeedCommand());
		driveSpeed.whenPressed(new DriveSpeedCommand());
		launchDisk.whileHeld(new DiskReleaseCommand());
		seek.toggleWhenActive(new LocateTargetCommand());
		frontRobot.toggleWhenPressed(new ManualLiftRobotFrontCommand());
		backRobot.toggleWhenPressed(new ManualLiftRobotBackCommand());
	}

	public Joystick getJoystick() {
		return this.joy;
	}

	public XboxController getController() {
		return this.xbox;
	}
}


