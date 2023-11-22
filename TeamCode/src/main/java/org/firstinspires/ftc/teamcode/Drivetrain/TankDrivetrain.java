package org.firstinspires.ftc.teamcode.Drivetrain;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TankDrivetrain extends Drivetrain{
    public DcMotor l_motor = null;
    public DcMotor r_motor = null;

    @Override
    public void init(HardwareMap ahwMap) {
        //Save reference to Hardware map
        hwMap = ahwMap;

        //Init all motors

        l_motor = hwMap.dcMotor.get("l_m");
        r_motor = hwMap.dcMotor.get("r_m");

        //Setup Motor directions and Encoder settings
        l_motor.setDirection(DcMotor.Direction.REVERSE);
        r_motor.setDirection(DcMotor.Direction.REVERSE);

        l_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        l_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        r_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Stop();
    }

    public void Stop(){
        l_motor.setPower(0);
        r_motor.setPower(0);
    }

}
