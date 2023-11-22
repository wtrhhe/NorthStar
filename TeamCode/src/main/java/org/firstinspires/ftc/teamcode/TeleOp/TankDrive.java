package org.firstinspires.ftc.teamcode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import  com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Drivetrain.TankDrivetrain;


@TeleOp(name = "TankDrive")
public class TankDrive extends LinearOpMode {
    public TankDrivetrain robot = new TankDrivetrain();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);

        double leftPower;
        double rightPower;

        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            if (drive > 0) {
                robot.l_motor.setPower(leftPower);
                robot.r_motor.setPower(rightPower);
            } else {
                robot.l_motor.setPower(rightPower);
                robot.r_motor.setPower(leftPower);
            }


            telemetry.addData("Left Pow", robot.l_motor.getPower());
            telemetry.addData("Left Encoder", robot.l_motor.getCurrentPosition());
            telemetry.addData("Right Pow", robot.r_motor.getPower());
            telemetry.addData("Right Encoder", robot.r_motor.getCurrentPosition());


        }
}

