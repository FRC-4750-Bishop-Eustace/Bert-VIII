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

    // Digital sensor ports (DIO)
    public static final int HATCH_SENSOR = 2;
    public static final int CARGO_SENSOR = 3;

    // Analog sensor ports (Analog)
    public static final int PRESSURE_SENSOR = 0;

    // Hatch piston IDs (PCM)
    public static final int HATCH_PISTON_ID = 0;

    // Pincer piston ID (PCM)
    public static final int PINCER_ID = 2;

    // Pusher piston ID (PCM)
    public static final int PUSHER_FOR_ID = 0;
    public static final int PUSHER_REV_ID = 1;

    // Cargo arm motor IDs (CAN)
    public static final int CARGO_ARM_ID = 8;

    // Sleigh piston IDs (PCM)
    public static final int SLEIGH_ID = 3;

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

    // Cargo Arm Constants
    public static final double CARGO_ARM_SPEED = -0.45;
    public static final boolean CARGO_ARM_INVERT = false;
    public static final boolean CARGO_ARM_PHASE = true;
    public static final int CARGO_ARM_TOLERANCE = 0;
    public static final int CARGO_PLACE_COUNTS = 350;
    public static final int CARGO_FLOOR_COUNTS = 1100;
    public static final int CARGO_ROCKET_COUNTS = 550;
    public static final int CARGO_RESET_COUNTS = 0;

    // Talon SRX Constants
    public static final int TIMEOUT = 30;
    public static final int PID_INDEX = 0;

    // Pressure Constants
    public static final double PRESSURE_CONST = 4.8;

    // Lifter Ports (PCM)
    public static final int FRONT_LIFTER = 4;
    public static final int BACK_LIFTER = 5;
}