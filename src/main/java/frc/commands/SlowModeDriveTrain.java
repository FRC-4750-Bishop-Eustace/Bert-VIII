package frc.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class SlowModeDriveTrain extends InstantCommand {
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.driveTrain.slowModeDrive(!Robot.driveTrain.slowMode());
  }
}
