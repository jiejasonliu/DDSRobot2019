package frc.robot;

/**
 * This is a class that helps with the framework and foundations of the Robot.
 * It's completely unnecessary, but it's use case for quick-swapping key settings is too efficient to pass on.
 */
public class RobotSettings {
    public static double
        DEBUG_MODE = 0, //implement later (0-off; 1-on)

        //drive train settings
        LOWEST_DRIVE_SPEED = 0.5,
        DRIVE_SPEED = 0.9, //1.0 max (100% of top speed)
        SEEK_MAX_SPEED = 0.4, //for LocateTargetCommand and Limelight
        TURN_SPEED = 0.85,
        LOWEST_TURN_SPEED = 0.4,
        MIN_TURN_POWER = 0.10, //lowest power needed to move wheels
        DRIVE_DIRECTION = 1, //negative to invert wheels

        //slider calibrations
        SLIDER_TOP = 0,
        SLIDER_MIDDLE = 0,
        SLIDER_BOTTOM = 0,
        SLIDER_SPEED = 1.0,
        LIMIT_SWITCH_ON = 0.0, //has to be exactly 0.0 to be off

        //nom nom calibrations
        NOM_NOM_SPEED = 0.65,
        NOM_NOM_RELEASE_SPEED = 1.0,

        //PID corrections
        kP = 0.05,
        kI = 0.06, //Hi! Bips was here :)

        /* 
         * TARGET_AREA is the percentage of ta (area) for Limelight. 
         * It corresponds to how much % of the area is taken before it should go to a complete stop.
         */
        TARGET_AREA = 12.5; 

    public static void changeRotationSpeed(double speed) {
        TURN_SPEED = speed;
    }

    public static void changeDriveSpeed(double speed) {
        DRIVE_SPEED = speed;
    }
}
