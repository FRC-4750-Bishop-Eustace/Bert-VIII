package frc.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.commands.TankDrive;
import frc.robot.RobotMap;

/**
 * This class manages the drive train
 */
public class DriveTrain extends Subsystem {

    // Create motors
    public WPI_TalonSRX leftMaster, leftFollowerOne, leftFollowerTwo, rightMaster, rightFollowerOne, rightFollowerTwo;
    // Create drive
    DifferentialDrive robotDrive;
    boolean slowMode = true;
    boolean reversed = false;

    // encoder & unit conversion
    public Encoder leftDriveEncoder, rightDriveEncoder;

    double distancePerPulse =  1.0 / 4096 * 16.48 / 1 * 8 * Math.PI / 12;
    
    // The total degrees off we can call "on target"
    double driveStraightTolerance = 0.005;
    double limelightTolerance = 0.7;
    // PID constants
    double kP = 0.15;
    double setpoint = 0;

    public DriveTrain(int leftMasterId, int leftFollowerOneId, int leftFollowerTwoId, 
                      int rightMasterId, int rightFollowerOneId, int rightFollowerTwoId) {
        // Initialize motors
        leftMaster = new WPI_TalonSRX(leftMasterId);
        leftFollowerOne = new WPI_TalonSRX(leftFollowerOneId);
        leftFollowerTwo = new WPI_TalonSRX(leftFollowerTwoId);
        rightMaster = new WPI_TalonSRX(rightMasterId);
        rightFollowerOne = new WPI_TalonSRX(rightFollowerOneId);
        rightFollowerTwo = new WPI_TalonSRX(rightFollowerTwoId);

        // encoders
      //  leftDriveEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_A, RobotMap.LEFT_DRIVE_ENCODER_B, reversed, EncodingType.k4X);
      //  rightDriveEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_A, RobotMap.RIGHT_DRIVE_ENCODER_B, reversed, EncodingType.k4X);
        
      //  leftDriveEncoder.setDistancePerPulse(distancePerPulse);
      //  rightDriveEncoder.setDistancePerPulse(distancePerPulse);

        // initialize encoders
       // leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        //rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

        // Set motor and encoder phases
        leftMaster.setInverted(false);
        leftMaster.setSensorPhase(false);
        rightMaster.setInverted(false);
        rightMaster.setSensorPhase(true);

        // Set motors to follow masters
        leftFollowerOne.follow(leftMaster);
        leftFollowerTwo.follow(leftMaster);
        rightFollowerOne.follow(rightMaster);
        rightFollowerTwo.follow(rightMaster);
        leftFollowerOne.setInverted(InvertType.FollowMaster);
        leftFollowerTwo.setInverted(InvertType.FollowMaster);
        rightFollowerOne.setInverted(InvertType.FollowMaster);
        rightFollowerTwo.setInverted(InvertType.FollowMaster);
        
        robotDrive = new DifferentialDrive(leftMaster, rightMaster);
        // Stop "output not updated often enough" error from printing
        robotDrive.setSafetyEnabled(false); 
    }

    // Get the counts

    public double getLeftCount(){
       return leftDriveEncoder.getRaw();
    }

    public double getRightCount(){
       return rightDriveEncoder.getRaw();
    }

    //Get the distance in feet

    public double getLeftDistanceInFeet(){
       return leftDriveEncoder.getDistance() / 12;
    }

    public double getRightDistanceInFeet(){
        return rightDriveEncoder.getDistance() / 12;
    }

    // Reset Options

    public void resetLeftEncoder(){
        leftDriveEncoder.reset();
    }

    public void resetRightEncoder(){
        rightDriveEncoder.reset();
    }

    public void reset(){
        leftDriveEncoder.reset();
        rightDriveEncoder.reset();
    }

    /**
     * Passes speed and rotate values to the drive train
     * 
     * @param speed  + is forward, - is backward
     * @param rotate + is right, - is left
     */
    public void joystickDrive(double speed, double rotate) {
        robotDrive.arcadeDrive(cube(speed), cube(rotate));
        // .28, .15
    }

    /**
     * Reverses the drive train
     * 
     * @param _reversed true for reversed, false for regular
     */
    public void reverseDriveTrain(boolean _reversed) {
        reversed = _reversed;
    }

    /**
     * Returns whether the drive train is reversed
     */
    public boolean reversed() {
        return reversed;
    }

     /**
     * Makes the drive train go to slow mode
     * 
     * @param _slowMode true for slow, false for regular
     */
     public void slowModeDrive(boolean _slowMode){
        slowMode = _slowMode;
     }
    
    public boolean slowMode(){
        return slowMode;
    }
    /**
     * Turns the drive train
     * 
     * @param speed + is right, - is left
     */
    public void turn(double speed) {
        robotDrive.arcadeDrive(0, -speed);
    }

    /**
     * Brakes all motors on the drive train
     */
    public void brake() {
        leftMaster.stopMotor();
        rightMaster.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    /**
     * Desensitizes the joystick values at low speeds
     */
    protected double cube(double value) {
        return 0.2 * Math.pow(value, 3) + (1 - 0.2) * value;
 
    }
}