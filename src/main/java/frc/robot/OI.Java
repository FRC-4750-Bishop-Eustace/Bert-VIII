package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.commands.Indexer;
import frc.commands.ResetIndexer;
import frc.commands.ReverseDriveTrain;
import frc.commands.ReverseIntake;
import frc.commands.RunClimber;
//import frc.commands.RunIntestines;
//import frc.commands.Shoot;
import frc.commands.RunIntake;
import frc.commands.RunShooter;
//import frc.commands.ShootDisable;
//import frc.commands.ShootEnable;
import frc.commands.SlowModeDriveTrain;
import frc.commands.StopClimber;
import frc.commands.StopIntake;
import frc.commands.StopShooter;
//import frc.subsystems.ShooterSubsystem;

public class OI {
    
    // Joysticks 
    public static Joystick driveStick = new Joystick(RobotMap.DRIVESTICK_PORT);
    public static Joystick controller = new Joystick(RobotMap.CONTROLSTICK_PORT);
    
    // joystick buttons
    JoystickButton toggleDirection = new JoystickButton(driveStick, 3);
//    JoystickButton shootButton = new JoystickButton(driveStick, 6);
//    JoystickButton stopShooting = new JoystickButton(driveStick, 5);
    JoystickButton driveStickRunClimber = new JoystickButton(driveStick, 4);
    JoystickButton slowDriveMode = new JoystickButton(driveStick, 2);
//    edu.wpi.first.wpilibj2.command.button.JoystickButton runFeeder = new edu.wpi.first.wpilibj2.command.button.JoystickButton(driveStick, 7);
    JoystickButton noPIDShooterButton = new JoystickButton(driveStick, 1);

    // controller buttons 
    JoystickButton runIntake = new JoystickButton(controller, 8);
    JoystickButton runIndexer = new JoystickButton(controller, 7);
    JoystickButton controllerRunClimber = new JoystickButton(controller, 2);
    JoystickButton resetIndexer = new JoystickButton(controller, 1);
    JoystickButton reverseIntake = new JoystickButton(controller, 3);

    public OI(){
        // buttons on the drivestick
        toggleDirection.whenReleased(new ReverseDriveTrain());
        slowDriveMode.whenReleased(new SlowModeDriveTrain());
       // shootButton.whenPressed(new ShootEnable());
       // stopShooting.whenPressed(new ShootDisable());
       noPIDShooterButton.whileHeld(new RunShooter());
       noPIDShooterButton.whenReleased(new StopShooter());
        
        //buttons on the controller
        runIntake.whileHeld(new RunIntake());
        runIntake.whenReleased(new StopIntake());
        runIndexer.whileHeld(new Indexer());
        resetIndexer.whenPressed(new ResetIndexer());
        controllerRunClimber.whileHeld(new RunClimber());
        controllerRunClimber.whenReleased(new StopClimber());
        reverseIntake.whileHeld(new ReverseIntake());

        }
    }