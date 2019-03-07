package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;

public class Pneumatics extends Subsystem {

    private Solenoid disk = new Solenoid(RobotMap.PNEUMATIC_SOLENOID);
    private Solenoid robot = new Solenoid(RobotMap.ROBOT_LIFTER_SOLENOID);

    public boolean isFront = false;

    /**
     * Decompresses and releases the disk.
     */
    public void decompressDisk() {
        disk.set(true);
    }

    /**
     * Compress pneumatics and puts the launch pin back in.
     */
    public void compressDisk() {
        disk.set(false);
    }

    /**
     * Decompresses pneumatics and lifts the robot up.
     */
    public void decompressLifterFront() {
        robot.set(true);
    }

    /**
     * Compress pneumatics and puts robot back down.
     */
    public void compressLifterFront() {
        robot.set(false);
    }

    /**
     * Decompresses pneumatics and lifts the robot up.
     */
    public void decompressLifterBack() {
        robot.set(true);
    }

    /**
     * Compress pneumatics and puts robot back down.
     */
    public void compressLifterBack() {
        robot.set(false);
    }
    
    @Override
    protected void initDefaultCommand() {
    }
}