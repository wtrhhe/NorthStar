package org.firstinspires.ftc.teamcode.Drivetrain;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

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
        r_motor.setDirection(DcMotor.Direction.FORWARD);

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

    public void encoderDrive(int leftTarget, int rightTarget, double speed) {
        // Ensure that the motors are in the correct mode
        l_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        r_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Set the target positions for both motors
        l_motor.setTargetPosition(leftTarget);
        r_motor.setTargetPosition(rightTarget);

        // Set the desired speed for both motors
        l_motor.setPower(speed);
        r_motor.setPower(speed);

        // Wait until both motors reach their target positions
        while (l_motor.isBusy() && r_motor.isBusy()) {
            // You can add additional logic or conditions here if needed
        }

        // Stop the motors after reaching the target positions
        l_motor.setPower(0);
        r_motor.setPower(0);

        // Set the motors back to the original mode
        l_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        r_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

}
