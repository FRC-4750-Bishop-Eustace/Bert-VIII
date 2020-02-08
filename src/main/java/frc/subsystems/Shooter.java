package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  // create motors
public WPI_TalonSRX shooterMotor1, shooterMotor2, conveyorToShooter;
  // create motor controllers
public SpeedControllerGroup shooter;
  // create differential drive
public DifferentialDrive driveShooter;
  /**
   * Creates a new Shooter.
   */
public Shooter(int shooterMotor1ID, int shooterMotor2ID, int shooterConveyorID) {
   // initialize motors
    shooterMotor1 = new WPI_TalonSRX(shooterMotor1ID);
    shooterMotor2 = new WPI_TalonSRX(shooterMotor2ID);
    conveyorToShooter = new WPI_TalonSRX(shooterConveyorID);

   // set the motors to follow in order to spin correctly
    shooterMotor2.follow(shooterMotor1);
  

    driveShooter = new DifferentialDrive(shooterMotor1, shooterMotor2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}