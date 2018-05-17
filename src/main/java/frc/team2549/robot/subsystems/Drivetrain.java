package frc.team2549.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Talon;

import frc.team2549.robot.RobotMap;
import frc.team2549.robot.commands.DriveTeleop;

public class Drivetrain extends Subsystem {

	private MecanumDrive m_drive;
	
	private Talon m_frontLeftMotor;
	private Talon m_frontRightMotor;
	private Talon m_rearLeftMotor;
	private Talon m_rearRightMotor;
	
    public Drivetrain() {
    	m_frontLeftMotor = new Talon(RobotMap.frontLeftMotor);
    	m_frontRightMotor = new Talon(RobotMap.frontRightMotor);
    	m_rearLeftMotor = new Talon(RobotMap.rearLeftMotor);
    	m_rearRightMotor = new Talon(RobotMap.rearRightMotor);
    	
    	m_drive = new MecanumDrive(m_frontLeftMotor, m_rearLeftMotor, m_frontRightMotor, m_rearRightMotor);
    }
    
    public void drive(double ySpeed, double xSpeed, double zRotation) {
    	m_drive.driveCartesian(ySpeed, xSpeed, zRotation);
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveTeleop());
    }
}

