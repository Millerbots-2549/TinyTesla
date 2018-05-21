//  _______ _             _______             __
// /__  __/(_)____ __  __/__  __/___   _____ / /____ 
//   / /  __ / __ \\ \/ /  / /  / _ \ / ___// // __ \
//  / /  / // / / / \  /  / /  /  __/(__  )/ // /_/ /
// /_/  /_//_/ /_/  / /  /_/   \___//____//_/ \___\_\
//                 /_/

package frc.team2549.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team2549.robot.commands.Dashboard;
import frc.team2549.robot.subsystems.Drivetrain;
import frc.team2549.robot.subsystems.Sensors;

public class Robot extends TimedRobot {
	public static OI oi;
	public static Drivetrain drivetrain = new Drivetrain();
	public static Sensors sensors = new Sensors();

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		oi.update();
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
