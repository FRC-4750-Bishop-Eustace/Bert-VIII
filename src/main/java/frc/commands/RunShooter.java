package frc.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class RunShooter extends InstantCommand {
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.noPIDShooter.runShooter();
    Robot.intestineTransport.completeShooting();
    System.out.println("shooter runs!");
  }

}