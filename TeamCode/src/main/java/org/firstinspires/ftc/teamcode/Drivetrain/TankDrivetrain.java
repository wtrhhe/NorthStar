package org.firstinspires.ftc.teamcode.Drivetrain;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class TankDrivetrain extends Drivetrain{
    public DcMotor l_motor = null;
    public DcMotor r_motor = null;
    public DcMotor larm = null;
    //public DcMotor rarm = null;
    public Servo claw1 = null;
    public Servo wrist = null;
    public Servo plauncher = null;

    @Override
    public void init(HardwareMap ahwMap) {
        //Save reference to Hardware map
        hwMap = ahwMap;

        //Init all motors

        l_motor = hwMap.dcMotor.get("l_m");
        r_motor = hwMap.dcMotor.get("r_m");
        larm = hwMap.dcMotor.get("intake");
        //larm = hwMap.dcMotor.get("______");
        claw1 = hwMap.get(Servo.class, "Servo");
        wrist = hwMap.get(Servo.class, "Servo1");
        plauncher = hwMap.get(Servo.class, "Servo2"); //

        //Setup Motor directions and Encoder settings
        l_motor.setDirection(DcMotor.Direction.REVERSE);
        r_motor.setDirection(DcMotor.Direction.FORWARD);
        larm.setDirection(DcMotor.Direction.FORWARD);
        //rarm.setDirection(DcMotor.Direction.FORWARD);

        l_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        larm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rarm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        l_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        r_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        larm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //rarm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Stop();
    }

    public void Stop(){
        l_motor.setPower(0);
        r_motor.setPower(0);
        larm.setPower(0);
        //rarm.setPower(0);
    }

    public void encoderDrive(){
        return;
    }

    public void pointToTarget(double tagBearing, double gain) {
        // Calculate the turning power based on the proportional controller
        double turningPower = tagBearing * gain;

        // Apply the turning power to the motors
        l_motor.setPower(-turningPower);  // Adjust signs based on motor orientation
        r_motor.setPower(turningPower);
    }



}
