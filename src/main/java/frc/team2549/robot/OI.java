package frc.team2549.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// Operator Interface
public class OI {
	public Joystick ctrl = new Joystick(0);

	// Axes
    public int driveYi = 0;
    public int driveXi = 1;
    public int driveRi = 4;
    public int driveRLi = 2;
    public int driveRRi = 3;
    public double driveY, driveX, driveR;

    // Buttons
    public int toggleSpeed = 7;

    public boolean isHalfSpeed = false;
    public double speed = 1;

	public void update() {

        if(ctrl.getRawButtonReleased(7)) {
            isHalfSpeed = !isHalfSpeed;
            if(isHalfSpeed) {
                speed = .35;
                System.out.println("OI: Set speed to half");
            }
            else if(!isHalfSpeed) {
                speed = 1;
                System.out.println("OI: Set speed to full");
            }
        }

		driveY = -ctrl.getRawAxis(driveYi) * speed;

		driveX = ctrl.getRawAxis(driveXi) * speed;

		driveR = ((ctrl.getRawAxis(driveRi) != 0)
                ? -ctrl.getRawAxis(driveRi) // Drive with stick
                : ctrl.getRawAxis(driveRLi) - ctrl.getRawAxis(driveRRi))    // Drive with triggers
                * speed;
	}
}
