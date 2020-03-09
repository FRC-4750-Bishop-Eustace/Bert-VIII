package frc.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class StopClimber extends InstantCommand {
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.climber.StopClimber();
    System.out.println("shooter runs!");
  }

}