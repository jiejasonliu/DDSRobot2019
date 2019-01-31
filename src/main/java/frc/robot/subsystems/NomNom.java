package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SliderPositionCommand;
import frc.robot.helper.Position;

public class NomNom extends Subsystem {

    private Victor nomnom = new Victor(RobotMap.NOM_NOM);

    /**
     * Grabs the game-ball by motor that spins the teeth wheels.
     */
    public void grab() {

    }

    /**
     * Releases the game-ball by spinning the teeth wheels in the reverse direction.
     */
    public void release() {
        
    }

    @Override
    protected void initDefaultCommand() {
        
    }
}