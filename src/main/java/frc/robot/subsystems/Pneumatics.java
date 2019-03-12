package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;

public class Pneumatics extends Subsystem {

    private DoubleSolenoid disk = new DoubleSolenoid(RobotMap.SOLENOID_DISK1, RobotMap.SOLENOID_DISK2);

    private DoubleSolenoid robotBack = new DoubleSolenoid(RobotMap.SOLENOID_LIFTER_FRONT1, RobotMap.SOLENOID_LIFTER_FRONT2);
    private DoubleSolenoid robotFront = new DoubleSolenoid(RobotMap.SOLENOID_LIFTER_BACK1, RobotMap.SOLENOID_LIFTER_BACK2);

    public boolean isFront = false;

    /**
     * Decompresses and releases the disk.
     */
    public void decompressDisk() {
        disk.set(Value.kReverse);
    }

    /**
     * Compress pneumatics and puts the launch pin back in.
     */
    public void compressDisk() {
        disk.set(Value.kForward);
    }

    /**
     * Decompresses pneumatics and lifts the robot up.
     */
    public void decompressLifterFront() {
        robotFront.set(Value.kReverse);
    }

    /**
     * Compress pneumatics and puts robot back down.
     */
    public void compressLifterFront() {
        robotFront.set(Value.kForward);
    }
    
    /**
     * Decompresses pneumatics and lifts the robot up.
     */
    public void decompressLifterBack() {
        robotBack.set(Value.kReverse);
    }

    /**
     * Compress pneumatics and puts robot back down.
     */
    public void compressLifterBack() {
        robotBack.set(Value.kForward);
    }
    
    @Override
    protected void initDefaultCommand() {
    }
}