package frc.robot;

public class RobotMap {

    // Joystick ports (USB)
    public static final int DRIVESTICK_PORT = 0;
    public static final int CONTROLSTICK_PORT = 1;

    // Drive train motor IDs (CAN)
    public static final int LEFT_MASTER_ID = 2;
    public static final int LEFT_FOLLOWER_ONE_ID = 0;
    public static final int LEFT_FOLLOWER_TWO_ID = 1;
    public static final int RIGHT_MASTER_ID = 5;
    public static final int RIGHT_FOLLOWER_ONE_ID = 3;
    public static final int RIGHT_FOLLOWER_TWO_ID = 4;

    //Piston ports
    public static final int TEST_PISTON_PORT = 1;

    // Drive Train Constants
    public static final double WHEEL_RADIUS = 3;
    public static final double CIRCUMFERENCE = 2 * Math.PI * WHEEL_RADIUS;
    public static final int PULSES_PER_REVOLUTION = 4096;
    public static final boolean LEFT_INVERT = false;
    public static final boolean LEFT_PHASE = false;
    public static final boolean RIGHT_INVERT = false;
    public static final boolean RIGHT_PHASE = true;
    public static final int DRIVE_TOLERANCE = 5;
    public static final double STOP_DISTANCE = 4.5;

    // Talon SRX Constants
    public static final int TIMEOUT = 30;
    public static final int PID_INDEX = 0;

    // Pressure Constants
    public static final double PRESSURE_CONST = 4.8;

    // Lifter Ports (PCM)
    public static final int FRONT_LIFTER = 4;
    public static final int BACK_LIFTER = 5;
}