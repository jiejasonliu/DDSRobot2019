package frc.robot;

/**
 * This is a class that helps with the framework and foundations of the Robot.
 * It's completely unnecessary, but it's use case for quick-swapping key settings is too efficient to pass on.
 */
public class RobotSettings {
    public static double
        DEBUG_MODE = 0, //implement later (0-off; 1-on)

        //drive train settings
        DRIVE_SPEED = 0.9, //1.0 max (100% of top speed)
        SEEK_MAX_SPEED = 0.75, //for LocateTargetCommand and Limelight
        TURN_SPEED = 0.75,
        LOWEST_TURN_SPEED = 0.4,
        MIN_DRIVE_POWER = 0.1, //lowest power needed to move wheels
        DRIVE_DIRECTION = 1, //negative to invert wheels

        //slider calibrations
        SLIDER_TOP = 0,
        SLIDER_MIDDLE = 0,
        SLIDER_BOTTOM = 0,
        SLIDER_SPEED = 1.0,

        //nom nom calibrations
        NOM_NOM_SPEED = 0.65,
        NOM_NOM_RELEASE_SPEED = 1.0,

        //PID corrections
        kP = 0.11,
        kI = 0.06, //Hi! Bips was here :)

        /* 
         * Trial and error calibration, you can get this ratio by setting an initial SEEK_MAX_SPEED (0.8 in this case),
         * then put the Robot perfectly at the spot where you want it to be at and get the value of the area (LLData#getData().area)
         * 
         * Equation: 
         * > y = speedConstant + (AREA_FACTOR_RATIO * #getData().area)
         * > y = -0.8 + (0.105 * #getData().area) -- when y=0, you are at target
         * In order to derive 0.105 => 0.8 = 0.105 * #getData().area
         * > #getData().area = 0.8/0.105, therefore the area ratio is 0.8/0.105
         */
        AREA_FACTOR_RATIO = 0.8/0.105; 

    public static void changeRotationSpeed(double speed) {
        TURN_SPEED = speed;
    }
}
