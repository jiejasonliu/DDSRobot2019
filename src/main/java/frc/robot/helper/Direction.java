package frc.robot.helper;

/**
 * Enum that helps with the rotation of seeker or locator and slider. The logic changes depending on the enum value.
 * 
 * @see LocateTargetCommand
 * @see ManualSliderCommand
 */
public enum Direction {
    CLOCKWISE, COUNTERCLOCKWISE, UP, DOWN;
}