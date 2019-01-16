/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int
		XBOX_PORT = 0,

		//servo for releasing ball
		SERVO_MOTOR = 0,

		//drive train
		VICTOR_RIGHT1 = 1,
		VICTOR_RIGHT2 = 2,
		VICTOR_LEFT1 = 3,
		VICTOR_LEFT2 = 4,
		//winch
		WINCH_VICTOR = 5,

		//launcher
		LAUNCHER_VICTOR = 6,

		//Munch-do (claw/cube-grabber)
		GRABBER_MOTOR1 = 7,
		GRABBER_MOTOR2 = 8,

		//controller axis for drive train
		CONTROLLER_AXIS_LEFT = 1,
		CONTROLLER_AXIS_RIGHT = 5;
}
