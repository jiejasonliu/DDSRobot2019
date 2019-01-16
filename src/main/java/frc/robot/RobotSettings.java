package frc.robot;

public class RobotSettings {
    public static double
        //drive train settings
        DRIVE_SPEED = 0.75, //1.0 max (100% of top speed)
        DRIVE_DIRECTION = -1, //negative to invert wheels
        DRIVE_SPEED_SLOW = 0.50, //slow speed is usually used when cube raiser is high || try 0.55, 0.575/8, still too slow.

        //grabber settings
        GRABBER_INTAKE_SPEED = 0.6,
        GRABBER_RELEASE_SPEED = 0.7,

        //ball launcher settings
        LAUNCHER_SPEED = 1.0,
        LAUNCHER_DIRECTION = -1,

        //autonomous settings & PID corrections
        DEFAULT_AUTONOMOUS_DRIVE_SPEED = 0.65,
        kP = 0.11,
        kI = 0.06,

        //autonomous timings (in seconds)
        TRIAL_ONE = 4.2, // 45.43in/sec at TSA room for Robot speed 0.65
        BALL_LAUNCH = 5.0,
        TRIAL_TWO = 4.3;

    public static void setDriveSpeed(double speed) {
        DRIVE_SPEED = speed;
    }

    public static void setDefaultAutonomousDriveSpeed(double speed) {
        DEFAULT_AUTONOMOUS_DRIVE_SPEED = speed;
    }

    public static int convertSecondsToTimerUnit(double secs) {
        return (int) (secs * 50);
    }
}
