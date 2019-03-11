package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotSettings;
import frc.robot.commands.LocateTargetCommand;
import frc.robot.helper.Direction;

public class Limelight extends Subsystem {

    public static class LLData {
        public final double xOffset, yOffset, area, targetExists, skew;

        public LLData(double xOffset, double yOffset, double area, double targetExists, double skew) {
            this.xOffset = xOffset; //tx   
            this.yOffset = yOffset; //ty
            this.area = area; //ta
            this.targetExists = targetExists; //tv
            this.skew = skew; //ts
        }
    }

    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry tx = table.getEntry("tx"); //X-offset of target (Limelight 2: -29.8 to 29.8 deg.)
    private NetworkTableEntry ty = table.getEntry("ty"); //Y-offset of target (Limelight 2: -22.85 to 22.85 deg.)
    private NetworkTableEntry tv = table.getEntry("tv"); //Whether the limelight has a valid target (either 0 or 1)
    private NetworkTableEntry ta = table.getEntry("ta"); //Area of target in image (0-100%)
    private NetworkTableEntry ts = table.getEntry("ts"); //Skew or rotation of target (-90.0 to 0.0 deg.)
    private NetworkTableEntry tl = table.getEntry("tl"); //Limelight latency contribution (in ms.)


    // Gets camera modes and pipelines from Limelight
    private NetworkTableEntry ledMode = table.getEntry("ledMode"); //0-3
    private NetworkTableEntry camMode = table.getEntry("camMode"); //0-1
    private NetworkTableEntry pipeline = table.getEntry("pipeline"); //0-9
    
    /**
     * Sets the mode to the one applicable for tracking the reflective tape (low exposure).
     */
    public void setTrackingMode() {
        pipeline.setNumber(0); //pipeline #0
        camMode.setNumber(0); //turn on vision processing
        ledMode.setNumber(0); //lime LEDs: on (based off of settings in pipeline)
    }

    /**
     * Sets the mode to the one applicable for camera vision.
     */
    public void setDriveCamMode() {
        pipeline.setNumber(1); //pipeline #1
        camMode.setNumber(1); //turn off vision processing; digital camera mode
        ledMode.setNumber(0); //lime LEDS: off (based off of settings in pipeline)
    }

    /**
     * Grabs the data of the current LLData instance.
     * @return The instance of LLData that has the data of the next iteration
     */
    public LLData getData() {
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        double skew = ts.getDouble(0.0);
        double v = tv.getDouble(0.0);
        
        return new Limelight.LLData(x, y, area, v, skew);
    }

    public double getHeadingError() {
        var limelightData = this.getData(); //Java 10 'var' automatically creates new LLData object.
     
        double minDrive = RobotSettings.MIN_TURN_POWER; //speed the motor will move the robot regardless of how miniscule the error is
        double kP = RobotSettings.kP; //constant for turn power
        double xOffset = limelightData.xOffset;
        double heading = 0.0; //should be opposite of offset (in signs)

        if (xOffset > 1.0) {
            heading = ((kP * xOffset) + minDrive);
            System.out.println("GOING LEFT");
        } else { //xOffset less than or equal to 1.0
            heading = ((kP * xOffset) - minDrive);
            System.out.println("GOING RIGHT");
        }

        return heading;
    }

    public double getSpeedCorrection() {
        double speedConstant = RobotSettings.SEEK_MAX_SPEED;
        double areaConstant = (speedConstant / RobotSettings.TARGET_AREA) / 1.5; //3.0 is a trial and error calibration value
        double speedPorportion = speedConstant - (areaConstant * this.getData().area);
        
        return speedPorportion;
    }
    
    @Override
    public void initDefaultCommand() {
    }
}