package frc.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.subsystems.Piston;

public class TogglePiston extends InstantCommand {

  public TogglePiston() {
    requires(Robot.piston);
  }

  private void requires(Piston piston) {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 
    Robot.piston.toggle();
  }
}
