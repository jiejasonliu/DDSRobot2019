package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;

public class DiskPneumatic extends Subsystem {

    private Solenoid pneumatic = new Solenoid(RobotMap.PNEUMATIC_SOLENOID);

    /**
     * Decompresses and releases the disk.
     */
    public void decompress() {
        pneumatic.set(true);
    }

    /**
     * Compress pneumatics and puts the launch pin back in.
     */
    public void compress() {
        pneumatic.set(false);
    }

    @Override
    protected void initDefaultCommand() {
    }
}