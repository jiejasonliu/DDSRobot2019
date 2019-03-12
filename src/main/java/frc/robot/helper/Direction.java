package frc.robot.helper;

/**
 * Enum that helps with the rotation of seeker or locator and slider. The logic changes depending on the enum value.
 * 
 * @see frc.robot.commands.LocateTargetCommand (CLOCKWISE, COUNTERCLOCKWISE) -- No longer used as of 03/11/2019
 * @see frc.robot.commands.manual.ManualSliderCommand (UP, DOWN)
 */
public enum Direction {
    CLOCKWISE, COUNTERCLOCKWISE, UP, DOWN;
}