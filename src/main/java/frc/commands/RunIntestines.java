package frc.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class RunIntestines extends InstantCommand {
  public RunIntestines() {
  addRequirements(Robot.intestineTransport);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.intestineTransport.CellsOnboard();
    Robot.intestineTransport.Conveyor3();
  }
}
