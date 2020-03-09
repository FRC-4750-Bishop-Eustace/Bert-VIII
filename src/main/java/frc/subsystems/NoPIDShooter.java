package frc.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class NoPIDShooter extends SubsystemBase {
  public final WPI_TalonSRX shooterMotorMaster = new WPI_TalonSRX(RobotMap.SHOOTER_1_ID);
  public final WPI_TalonSRX shooterMotorFollower = new WPI_TalonSRX(RobotMap.SHOOTER_2_ID);
  public final WPI_TalonSRX transportToShooter = new WPI_TalonSRX(RobotMap.CONVEYOR_4_ID);
  public double shooterDelayTime;
  /**
   * Creates a new NoPIDShooter.
   */
  public NoPIDShooter() {
    shooterMotorMaster.setSensorPhase(false);
    shooterMotorMaster.setInverted(false);

    shooterMotorFollower.follow(shooterMotorMaster);
    shooterMotorFollower.setInverted(InvertType.FollowMaster);
  }

public void runShooter(){
  shooterMotorMaster.set(1);
  shooterDelayTime = System.currentTimeMillis();
  while((System.currentTimeMillis() - shooterDelayTime) <= 875){
    ;
  }
  if((System.currentTimeMillis() - shooterDelayTime) >= 875){
    transportToShooter.set(0.40);
  }
}

public void stopShooter(){
  shooterMotorMaster.set(0);
  transportToShooter.set(0);
}



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
