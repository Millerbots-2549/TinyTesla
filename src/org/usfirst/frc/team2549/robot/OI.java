package org.usfirst.frc.team2549.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public Joystick ctrl = new Joystick(0);

	public double driveY = ctrl.getRawAxis(1);
	public double driveX = ctrl.getRawAxis(0);
	public double driveR = ctrl.getRawAxis(4);
}
