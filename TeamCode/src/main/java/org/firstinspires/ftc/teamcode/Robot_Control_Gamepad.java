package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import  com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * This code for Controlling Robot with Gamepad.
 */

@TeleOp(name = "Robot Control")
public class Robot_Control_Gamepad extends OpMode {
    DcMotor l_motor;
    DcMotor r_motor;

    double deadzone = 0.1;
    double sencitivity = 0.5;
    double maxMotorPower = 1;



    @Override
    public void init(){
        l_motor = hardwareMap.get(DcMotor.class, "l_m");
        r_motor  = hardwareMap.get(DcMotor.class, "r_m");
        telemetry.addData("Hardware","initialized");
    }
    @Override
    public void loop(){

        double frondBack = gamepad1.right_stick_x;
        double turnRate = gamepad1.left_stick_y;
        double S_fB = sencitivity * frondBack;
        double s_t = sencitivity * turnRate;

        /**if (abs(frondBack) < deadzone) {

            frondBack = 0;
            turnRate = gamepad1.right_stick_x;
        }
         */


        double lm_power = S_fB + s_t;
        double rm_power = S_fB- s_t;


        if (lm_power > 1) {
            lm_power = maxMotorPower;
        }

        if (lm_power < -1) {
            lm_power = -maxMotorPower;
        }

        if (rm_power > 1) {
            rm_power = maxMotorPower;
        }

        if (rm_power < -1) {
            rm_power = -maxMotorPower;
        }

        if (frondBack > 0) {

            l_motor.setPower(lm_power);
            r_motor.setPower(rm_power);
        }

        else{
            l_motor.setPower(rm_power);
            r_motor.setPower(lm_power);
        }



        telemetry.addData("Left Pow", l_motor.getPower());
        telemetry.addData("Left Encoder", l_motor.getCurrentPosition());
        telemetry.addData("Right Pow", r_motor.getPower());
        telemetry.addData("Right Encoder", r_motor.getCurrentPosition());


    }
}
