package frc.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class ReverseDriveTrain extends InstantCommand {
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.driveTrain.reverseDriveTrain(!Robot.driveTrain.reversed());
  }
}
