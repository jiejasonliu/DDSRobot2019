package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.*;
import frc.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project. <p>
 * 
 * The core class for the Robot (aside from Main which creates an instance of this class).
 * Here, the autonomous and periodic functions are defined (ran 50 times a second). 
 * Acts as a backboard for all subsystems (for singletons) and defines the Output/Input.
 * The key thing to note is the Scheduler, but simply, it helps "schedule" the commands in order.
 * 
 * @author Jie "Jason" Liu / Deepzai 
 * @author FIRST Robotics Team 7634 (New Hawks)
*/
public class Robot extends TimedRobot {
	//singletons for subsystems, only one instance per Robot.
	public static DriveTrain driveTrain = new DriveTrain();
	public static Slider slider = new Slider();
	public static NomNom nomNom = new NomNom();
	public static SystemControl sys = new SystemControl();
	public static Limelight limelight = new Limelight();

	public static OI oi;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//initialize subsystems 
		driveTrain = new DriveTrain();
		slider = new Slider();
		nomNom = new NomNom();
		sys = new SystemControl();
		limelight = new Limelight();

		//output/input must be initialized after subsystems
		oi = new OI();

		chooser.setDefaultOption("Persistent Driving", new DriveCommand());
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(slider);
		SmartDashboard.putData(nomNom);
		SmartDashboard.putData(limelight);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//m_autonomousCommand = new AutonomousCommands();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
