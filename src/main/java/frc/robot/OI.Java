package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.commands.TogglePiston;

public class OI {
    
        // Joysticks 
        public static Joystick driveStick = new Joystick(RobotMap.DRIVESTICK_PORT);
        public static Joystick controller = new Joystick(RobotMap.CONTROLSTICK_PORT);
    
        //buttons
        JoystickButton togglePiston = new JoystickButton(driveStick, 1);

        //instanciate all the button operations
        public OI(){
        
        togglePiston.whenReleased(new TogglePiston());

        }
    }