package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntestineTransport extends SubsystemBase {

  //create motors
  public WPI_TalonSRX intakeToConveyor2, storageConveyor3;

  //create IR Sensors
  public DigitalInput IntakeIR, bottomOfTransportIR, topOfTransportIR, shooterIR;

 /*
  * Creates a new IntestineTransport.
  */

  public IntestineTransport(int conveyor2ID, int conveyor3ID) {
    // initialize motors
    intakeToConveyor2 = new WPI_TalonSRX(conveyor2ID);
    storageConveyor3 = new WPI_TalonSRX(conveyor3ID);

    // initialize digital inputs
    IntakeIR = new DigitalInput(RobotMap.INTAKE_IR_SENSOR);
    topOfTransportIR = new DigitalInput(RobotMap.BOTTOM_OF_TRANSPORT_IR_SENSOR);
    bottomOfTransportIR = new DigitalInput(RobotMap.TOP_OF_TRANSPORT_IR_SENSOR);
    shooterIR = new DigitalInput(RobotMap.SHOOTER_IR_SENSOR);
  }

public void CellsOnboard(){
  // create variable numberOnboard & initialize it to 0
  double numberOnboard = 0;

  // if returns true, add 1
  if(IntakeIR.get()){
    numberOnboard = numberOnboard + 1;
  }

  // if returns false, subtract 1
  if(shooterIR.get()){
    numberOnboard = numberOnboard - 1;
  }

// checks how many powercells we have onboard
  if(numberOnboard >= 5){
    intakeToConveyor2.stopMotor();
    storageConveyor3.stopMotor();
  }
}

public void Conveyor3(){
  double conveyor3Count = 0;

  if(conveyor3Count >= 4){
    storageConveyor3.stopMotor();
    conveyor3Count = 0;
  
  }else if(bottomOfTransportIR.get()){
  // set expiration is a guess on time- will need testing
    storageConveyor3.set(0.85);
    storageConveyor3.setExpiration(5);
    conveyor3Count = conveyor3Count + 1;
  }
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}