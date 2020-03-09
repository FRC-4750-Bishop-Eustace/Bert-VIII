package frc.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
public class ResetIndexer extends InstantCommand {
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.intestineTransport.reset();
  }
}