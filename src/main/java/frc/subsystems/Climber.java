package frc.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase {

// motors
//public WPI_TalonSRX leftClimber = new WPI_TalonSRX(RobotMap.LEFT_CLIMBER_MOTOR);
//public WPI_TalonSRX rightClimber = new WPI_TalonSRX(RobotMap.RIGHT_CLIMBER_MOTOR);

// encoders
//public Encoder leftClimbEncoder, rightClimbEncoder;

// encoder conversion
//double distancePerPulse =  1.0 / 4096 * 45 / 1 * 1 * Math.PI / 12;

public final WPI_TalonSRX climberFollower = new WPI_TalonSRX(RobotMap.LEFT_CLIMBER_MOTOR);
public final WPI_TalonSRX climberMaster = new WPI_TalonSRX(RobotMap.RIGHT_CLIMBER_MOTOR);

  public Climber() {
    climberMaster.setSensorPhase(false);
    climberMaster.setInverted(false);

    climberFollower.follow(climberMaster);
    climberFollower.setInverted(InvertType.FollowMaster);
  }


// Creates a new Climber.
//  public Climber() {

    // initiaize encoders
    //leftClimbEncoder = new Encoder(RobotMap.LEFT_CLIMB_ENCODER_A, RobotMap.RIGHT_CLIMB_ENCODER_B, false, EncodingType.k4X);
    //rightClimbEncoder = new Encoder(RobotMap.RIGHT_CLIMB_ENCODER_A, RobotMap. RIGHT_CLIMB_ENCODER_B, true, EncodingType.k4X);
  
    // set follower IDs
//    rightClimber.follow(leftClimber);
//    rightClimber.setInverted(InvertType.FollowMaster);

    // encoder distances
//    leftClimbEncoder.setDistancePerPulse(distancePerPulse);
//    rightClimbEncoder.setDistancePerPulse(distancePerPulse);

//    leftClimber.setSelectedSensorPosition(0, 0, 60);
//    rightClimber.setSelectedSensorPosition(0, 0, 60);

    // initialize encoders
//    leftClimber.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
//    rightClimber.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    // Set motor and encoder phases
//    leftClimber.setInverted(false);
//    rightClimber.setInverted(true);
  

  public void RunClimber(){
    climberMaster.set(0.60);
  }

  public void StopClimber(){
    climberMaster.set(0);
  }
}
 
/*
  // Get the counts
  public double getLeftCount(){
    return leftClimbEncoder.getRaw();
 }

 public double getRightCount(){
    return rightClimbEncoder.getRaw();
 }

 //Get the distance in feet
 public double getLeftDistanceInFeet(){
    return leftClimbEncoder.getDistance() / 12;
 }

 public double getRightDistanceInFeet(){
     return rightClimbEncoder.getDistance() / 12;
 }

 // Reset Options
 public void resetLeftEncoder(){
     leftClimbEncoder.reset();
 }

 public void resetRightEncoder(){
     rightClimbEncoder.reset();
 }

 public void reset(){
     leftClimbEncoder.reset();
     rightClimbEncoder.reset();
 }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
*/