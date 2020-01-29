package frc.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Piston extends SubsystemBase {
 
 Solenoid piston;

  //Creates a new callable solenoid called piston
  public Piston() {
    piston = new Solenoid(RobotMap.TEST_PISTON_PORT);
  } 

  //toggles the piston (set it to the opposite of it's current value)
  public void toggle() {
    piston.set(!piston.get());
  }

  //true means open
  public void open(){
    piston.set(true);
  }  

  //false means closed
  public void close(){
    piston.set(false);
  }

  public boolean get(){
    return piston.get();
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
