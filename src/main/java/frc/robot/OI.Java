package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.commands.ReverseDriveTrain;
import frc.commands.Shoot;

public class OI {
    
        // Joysticks 
        public static Joystick driveStick = new Joystick(RobotMap.DRIVESTICK_PORT);
        public static Joystick controller = new Joystick(RobotMap.CONTROLSTICK_PORT);
    
        //buttons
        JoystickButton toggleDirection = new JoystickButton(driveStick, 1);
        JoystickButton shootButton = new JoystickButton(driveStick, 2);


        //instanciate all the button operations
        public OI(){
            toggleDirection.whenReleased(new ReverseDriveTrain());
            shootButton.whenReleased(new Shoot());
        }
    }