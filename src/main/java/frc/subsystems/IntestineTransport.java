package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;

public class IntestineTransport extends SubsystemBase {

  // create motors
  public WPI_TalonSRX intakeConveyor1, storageConveyor2;

  // create IR Sensors
  public DigitalInput IR1, IR2, IR3, IR4; 

  // create indexer counts
  float IR1Count; // counts number that passed IR1
  float IR2Count; // counts number that passed IR2
  float IR3Count; // counts number that passed IR3
  float IR4Count; // counts number that passer IR4
  double numberOnboard; //counts the number of cells we have

  // create timers
  double IR1Timer; // timestamp from last input on IR1
  double IR2Timer; // timestamp from last input on IR2
  double IR3Timer; // timestamp from last input on IR3
  double IR4Timer; // timestamp from last input on IR3
  double intakeTimer; // timestamp since last ball passed intake/IR1
  double transportTimer; // timestamp since last ball passed conveyor2/IR2
  double shooterTimer; // timestamp since last ball passed the shooter
  double lastBallTimer;

  // create IR sensor timeout constant (change value on right to # of cycles to ignore IR sensor)
  // 25 is a guess, but the RIO runs every 2ms & 2 * 25 = 50ms so it should be decently accurate (TEST!)
  int ignoreIRTime = 2 * 10000;

  // create IR sensor value booleans
  boolean IR1State = true;
  boolean IR2State = false;
  boolean IR3State = false;
  boolean IR4State = false;
  boolean previousIR1State = false;
  boolean previousIR2State = false;
  boolean previousIR3State = false;
  boolean previousIR4State = false;

  // motor speeds
  double intakeConveyor1Speed = 0.65;
  double storageConveyor2Speed = 0.45;
 /*
  * Creates a new IntestineTransport.
  */

  public IntestineTransport() {
    // initialize motors
    intakeConveyor1 = new WPI_TalonSRX(RobotMap.CONVEYOR_2_ID);
    storageConveyor2 = new WPI_TalonSRX(RobotMap.CONVEYOR_3_ID);

    // initialize digital inputs
    IR1 = new DigitalInput(RobotMap.INTAKE_IR_SENSOR);
    IR2 = new DigitalInput(RobotMap.BOTTOM_OF_TRANSPORT_IR_SENSOR);
    IR3 = new DigitalInput(RobotMap.TOP_OF_TRANSPORT_IR_SENSOR);
    IR4 = new DigitalInput(RobotMap.SHOOTER_IR_SENSOR);
  }

public void runIntake(){
  if(IR2Count <= 5 && numberOnboard <= 5){
    intakeConveyor1.set(intakeConveyor1Speed);
    //storageConveyor2.set(0.50); //for testing
  } else {
    stopIntake();
    intakeConveyor1.set(intakeConveyor1Speed);
    //storageConveyor2.set(0.50); //for testing
  }
}

public void reverseIntake(){
  intakeConveyor1.set(-intakeConveyor1Speed);
}

public void stopIntake(){
  intakeConveyor1.set(0);
  //storageConveyor2.set(0); //for testing
}

public void CellsOnboard(){
  // create variable numberOnboard & initialize it to 0 - will be used for counting how many onboard
  numberOnboard = 0;

  // if returns true, add 1
  if(getIR1() && numberOnboard <= 5){
    numberOnboard = numberOnboard + 1;
  }

  // if returns false, subtract 1
  if(getIR4() && numberOnboard >= 0){
    numberOnboard = numberOnboard - 1;
  }

// checks how many powercells we have onboard
  if(numberOnboard >= 5){
    intakeConveyor1.set(0);
    storageConveyor2.set(0);
  }

}

public boolean getIR1() {
  boolean newvalIR1 = !IR1.get();
  if(newvalIR1 == previousIR1State){
  } else { // different
    IR1State = newvalIR1;
    if(newvalIR1){
      IR1Count++;
    }
    previousIR1State=newvalIR1;
  }
  return IR1State;
}

public boolean getIR2(){
  boolean newvalIR2 = !IR2.get();
  if(newvalIR2 == previousIR2State){
  } else { // different
    IR2State = newvalIR2;
    if(newvalIR2){
      IR2Count++;
    }
    previousIR2State=newvalIR2;
  }
  return IR2State;
}

public boolean getIR3(){
  boolean newvalIR3 = !IR3.get();
  if(newvalIR3 == previousIR3State){
  } else { // different
    IR3State = newvalIR3;
    if(newvalIR3){
      IR3Count++;
    }
    previousIR3State=newvalIR3;
  }
  return IR3State;
}

public boolean getIR4(){
  boolean newvalIR4 = !IR4.get();
  if(newvalIR4 == previousIR4State){
  } else { // different
    IR4State = newvalIR4;
    if(newvalIR4){
      IR4Count++;
    }
    previousIR4State=newvalIR4;
  }
  System.out.println("getIR4 states " + IR4Count);
  return IR4State;
}

public void Indexer(){

  if(getIR1()){
  // do nothing --> might remove
  }


  if(getIR2()){

    // first 3 balls
    if(IR3Count < 4){
      transportTimer = System.currentTimeMillis();
      System.out.println(transportTimer);
      // if current time - timestamp < 0.7 sec (put into milliseconds) --> run
      while((System.currentTimeMillis() - transportTimer) <= 400){
        storageConveyor2.set(storageConveyor2Speed);
        if ((System.currentTimeMillis() - transportTimer) >= 400){
          storageConveyor2.set(0);
    }
    }
    //4th ball
  } else if(IR3Count >= 3){
    intakeTimer = System.currentTimeMillis();
    // timestamp comparison (in Milliseconds)
    while(System.currentTimeMillis() - intakeTimer <= 50){
      storageConveyor2.set(storageConveyor2Speed);
        if(getIR3()){
          storageConveyor2.set(0);
        }
    // if it's after the timeframe, set it to 0
    }if(System.currentTimeMillis() - transportTimer >= 100){
      storageConveyor2.set(0);
    }
  }

  // 5th ball incrementer
  if(getIR2() && IR1Count == 5){
    stopIntake();
  }
}
}

// complete shooting process by moving 4 & 5 through the system
public void completeShooting(){
  // move the 4th and 5th balls through the system
  if(getIR4() && IR4Count > 1){
    System.out.println("IR4Count is " + IR4Count);
    shooterTimer = System.currentTimeMillis();
    while((System.currentTimeMillis() - shooterTimer) <= 600){
      storageConveyor2.set(storageConveyor2Speed);
      intakeConveyor1.set(intakeConveyor1Speed);
    }
    if((System.currentTimeMillis() - shooterTimer) >= 600){
      storageConveyor2.set(0);
      intakeConveyor1.set(0);
    }
    }
}

  public void reset(){
  //  if(OI.driveStick.getRawButtonReleased(1) && numberOnboard == 0){
      IR1Count = 0;
      IR2Count = 0;
      IR3Count = 0;
      IR4Count = 0;
      numberOnboard = 0;
      System.out.println("Reset!");
    //}
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}