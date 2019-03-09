package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.RobotSettings;

public class NomNom extends Subsystem {

    private Spark nomMotor = new Spark(RobotMap.NOM_NOM);

    /**
     * Grabs the game-ball by motor that spins the teeth wheels.
     */
    public void grab() {
        nomMotor.set(RobotSettings.NOM_NOM_SPEED);
    }

    /**
     * Releases the game-ball by spinning the teeth wheels in the reverse direction.
     */
    public void release() {
        nomMotor.set(-1.0 * RobotSettings.NOM_NOM_RELEASE_SPEED);
    }

    /**
     * Stops the motor that spins to teeth wheels.
     */
    public void stopMotor() {
        nomMotor.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {
        
    }
}