package frc.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
public class Indexer extends InstantCommand {
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.intestineTransport.Indexer();
    Robot.intestineTransport.CellsOnboard();
  }
}