package frc.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class StopShooter extends InstantCommand {
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.noPIDShooter.stopShooter();
//    Robot.intestineTransport.completeShooting();
    System.out.println("shooter stops!");
  }

}