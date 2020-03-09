package frc.robot;

public class RobotMap {

    // Joystick ports (USB)
    public static final int DRIVESTICK_PORT = 0;
    public static final int CONTROLSTICK_PORT = 1;

    // Drive train motor IDs (CAN)
    public static final int LEFT_MASTER_ID = 0; 
    public static final int LEFT_FOLLOWER_ONE_ID = 1;
    public static final int LEFT_FOLLOWER_TWO_ID = 2;
    public static final int RIGHT_MASTER_ID = 13; 
    public static final int RIGHT_FOLLOWER_ONE_ID = 14;
    public static final int RIGHT_FOLLOWER_TWO_ID = 15;

    // drive encoders
    //public static final int LEFT_DRIVE_ENCODER_A = 0;
    //public static final int LEFT_DRIVE_ENCODER_B = 1;
    //public static final int RIGHT_DRIVE_ENCODER_A = 2;    
    //public static final int RIGHT_DRIVE_ENCODER_B = 3;

    // Climb encoders
    //public static final int LEFT_CLIMB_ENCODER_A = 4;
    //public static final int LEFT_CLIMB_ENCODER_B = 5;
    //public static final int RIGHT_CLIMB_ENCODER_A = 6;
    //public static final int RIGHT_CLIMB_ENCODER_B = 7;
   
    // climb motors
    public static int LEFT_CLIMBER_MOTOR = 6;
    public static int RIGHT_CLIMBER_MOTOR = 5;

    // Digital Inputs
    public static final int INTAKE_IR_SENSOR = 9;
    public static final int BOTTOM_OF_TRANSPORT_IR_SENSOR = 8;
    public static final int TOP_OF_TRANSPORT_IR_SENSOR = 7;
    public static final int SHOOTER_IR_SENSOR = 6;

    // Intestine Transport Motors
  	public static final int CONVEYOR_4_ID = 12;
	  public static final int CONVEYOR_3_ID = 10;
    public static final int CONVEYOR_2_ID = 11;
 
    // Shooter Motors
    public static final int SHOOTER_1_ID = 3;
    public static final int SHOOTER_2_ID = 4;

    //shooter encoder
    public static final int FLYWHEEL_ENCODER_A = 1;
    public static final int FLYWHEEL_ENCODER_B = 0;
    
    // Shooter constants
    public static final double kP = 1; // P value
    public static final double kI = 0; // I value
    public static final double kD = 0; // D value
    public static final double kShooterToleranceRPS = 50; // degree with which the rps can vary
    public static final double kShooterTargetRPS = 4000;
    public static final double kShooterFreeRPS = 5300;

    // Feeder constants 
    public static final double kSVolts = 2;
    public static final double kVVoltSecondsPerRotation =
        // Should have value 12V at free speed...
        12.0 / kShooterFreeRPS;

    public static final double kFeederSpeed = 0.5;

}