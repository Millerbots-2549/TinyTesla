package frc.team2549.robot;

import edu.wpi.first.wpilibj.Joystick;

// Operator Interface
public class OI {
	public Joystick ctrl = new Joystick(0);
	public double driveY, driveX, driveR;

	public void update() {
		driveY = ctrl.getRawAxis(0);
		driveX = ctrl.getRawAxis(1);
		driveR = ctrl.getRawAxis(4);
	}
}
