/*
package frc.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.RobotMap;

public class ShooterSubsystem extends PIDSubsystem {

  public double distancePerPulse = (1/1024) * 6 * Math.PI;

  public final WPI_TalonSRX shooterMotorMaster = new WPI_TalonSRX(RobotMap.SHOOTER_1_ID);
  public final WPI_TalonSRX shooterMotorFollower = new WPI_TalonSRX(RobotMap.SHOOTER_2_ID);
  public final WPI_TalonSRX conveyorFeederMotor = new WPI_TalonSRX(RobotMap.CONVEYOR_4_ID);

  public final Encoder shooterEncoder = new Encoder(RobotMap.FLYWHEEL_ENCODER_A, RobotMap.FLYWHEEL_ENCODER_B, true);
  
  public final SimpleMotorFeedforward flywheelFeedforward = new SimpleMotorFeedforward(RobotMap.kSVolts, RobotMap.kVVoltSecondsPerRotation); //ks is volts & kv is volt seconds per rotation

  // Creates a new Shooter.
  public ShooterSubsystem() {
    // The PIDController used by the subsystem
    super(new PIDController(RobotMap.kP, RobotMap.kI, RobotMap.kD));
    System.out.println("After Super");
    getController().setTolerance(RobotMap.kShooterToleranceRPS);
    shooterEncoder.setDistancePerPulse(distancePerPulse);
    setSetpoint(RobotMap.kShooterTargetRPS);
    System.out.println("Shooting!");

    // Set motor and encoder phases
    shooterMotorMaster.setSensorPhase(false);
    shooterMotorMaster.setInverted(false);

    shooterMotorFollower.follow(shooterMotorMaster);
    shooterMotorFollower.setInverted(InvertType.FollowMaster);
    System.out.println("End of public shooterSubsystem()");
      }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    shooterMotorMaster.setVoltage(output + flywheelFeedforward.calculate(setpoint));
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return shooterEncoder.getRate();
  }

  public boolean atSetpoint() {
    return m_controller.atSetpoint();
  }

  public void runFeeder() {
    conveyorFeederMotor.set(RobotMap.kFeederSpeed);
  }

  public void stopFeeder() {
    conveyorFeederMotor.set(0);
  }
}
*/