/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
