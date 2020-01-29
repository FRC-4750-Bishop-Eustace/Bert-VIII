package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * Drives the drive train with a joystick
 */

public class TankDrive extends Command {

    public TankDrive() {
        // Require the drive train
        requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        // Pass the joystick values to joystickDrive()
        if (!Robot.driveTrain.reversed()) {
            Robot.driveTrain.joystickDrive(-OI.driveStick.getY(), OI.driveStick.getThrottle());
        } else {
            Robot.driveTrain.joystickDrive(OI.driveStick.getY(), OI.driveStick.getThrottle());
        }
    }

    @Override
    protected boolean isFinished() {
        // Never finish
        return false;
    }

}