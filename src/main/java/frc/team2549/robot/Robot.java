
//  ______                     ______                ___               
// /\__  _\__                 /\__  _\              /\_ \              
// \/_/\ \/\_\    ___   __  __\/_/\ \/    __    ____\//\ \      __     
//    \ \ \/\ \ /' _ `\/\ \/\ \  \ \ \  /'__`\ /',__\ \ \ \   /'__`\   
//     \ \ \ \ \/\ \/\ \ \ \_\ \  \ \ \/\  __//\__, `\ \_\ \_/\ \L\.\_ 
//      \ \_\ \_\ \_\ \_\/`____ \  \ \_\ \____\/\____/ /\____\ \__/.\_\
//       \/_/\/_/\/_/\/_/`/___/> \  \/_/\/____/\/___/  \/____/\/__/\/_/
//                          /\___/                                     
//                          \/__/                                      

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
