package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int
		JOYSTICK_PORT = 0,

		//Drive Train
		MOTOR_LEFT1 = 1,
		MOTOR_LEFT2 = 3,
		MOTOR_RIGHT1 = 2,
		MOTOR_RIGHT2 = 4,

		//Slider
		SLIDER_WINCH = 0,
		LIMIT_SWITCH = 0,

		//nom nom
		NOM_NOM = 6,

		//pneumatics
		SOLENOID_DISK1 = 0,
		SOLENOID_DISK2 = 1,
		SOLENOID_LIFTER_FRONT1 = 2,
		SOLENOID_LIFTER_FRONT2 = 3,
		SOLENOID_LIFTER_BACK1 = 6,
		SOLENOID_LIFTER_BACK2 = 7;
}
