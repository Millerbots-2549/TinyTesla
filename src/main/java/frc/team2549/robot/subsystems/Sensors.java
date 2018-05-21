package frc.team2549.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.analog.adis16448.frc.ADIS16448_IMU;

import java.util.ArrayList;
import java.util.List;

// TODO: Get Ultrasonic Sensors working (lots to do)

public class Sensors extends Subsystem {

    private static final ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();
    private static final BuiltInAccelerometer m_accel = new BuiltInAccelerometer();
    private static final ADIS16448_IMU m_imu = new ADIS16448_IMU();

    public Sensors() {
    }

    public double getAngle() {
        return m_gyro.getAngle();
    }

    public Double[] getAccel() {
        List<Double> dir = new ArrayList<Double>(3);
        dir.add(m_accel.getX()); // 0 is X
        dir.add(m_accel.getY()); // 0 is Y
        dir.add(m_accel.getZ()); // 0 is Z
        return (Double[]) dir.toArray();
    }

    public void initDefaultCommand() {
        //    setDefaultCommand(new MySpecialCommand());
    }
}

