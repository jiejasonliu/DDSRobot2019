package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class NomNomReleaseCommand extends Command {

    /**
     * requires(Subsystem subsystem) is crucial where any other Command (including instances) 
     * with the same subsystem requirement will call Command#interrupted() on the last command.
     */
	public NomNomReleaseCommand() {
        requires(Robot.nomNom);
	}

	protected void initialize() {
	}

	@Override
	protected void execute() {
        Robot.nomNom.release();
	}

	@Override
	protected boolean isFinished() {
		return false;
    }

	@Override
	protected void end() {
        Robot.nomNom.stopMotor();
	}

	@Override
	protected void interrupted() {
        end();
	}
}
