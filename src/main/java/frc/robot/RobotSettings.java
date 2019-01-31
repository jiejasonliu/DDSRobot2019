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
        TURN_SPEED = 0.625,
        DRIVE_DIRECTION = 1, //negative to invert wheels

        //slider calibrations
        SLIDER_TOP = 0,
        SLIDER_MIDDLE = 0,
        SLIDER_BOTTOM = 0,
        SLIDER_SPEED = 0.5,

        //nom nom calibrations
        NOM_NOM_SPEED = 0.5,
        NOM_NOM_RELEASE_SPEED = 0.6,

        //PID corrections
        kP = 0.11,
        kI = 0.06;

        //autonomous timings (in seconds)
}
