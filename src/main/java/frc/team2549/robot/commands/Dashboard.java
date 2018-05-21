package frc.team2549.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.team2549.robot.Robot;
import frc.team2549.robot.subsystems.Drivetrain;

public class Dashboard extends Command {

    public Dashboard() {
    }

    protected void initialize() {
        requires(Robot.drivetrain);
        requires(Robot.sensors);
    }

    protected void execute() {
        SmartDashboard.putNumberArray("Motors", Robot.drivetrain.getMotors());
        SmartDashboard.putNumber("Angle", Robot.sensors.getAngle());
        SmartDashboard.putNumberArray("Accel", Robot.sensors.getAccel());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
