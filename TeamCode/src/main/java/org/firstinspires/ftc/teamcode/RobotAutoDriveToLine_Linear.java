package org.firstinspires.ftc.teamcode;

/**
 * This is an Auto Driving the Robot and during the presentation for explaining the possibilities of Robot
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

@Autonomous(name="Robot: Autonomous", group="Robot")
@Disabled
public class RobotAutoDriveToLine_Linear extends LinearOpMode {

    /* Declare OpMode members. */
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    NormalizedColorSensor colorSensor;

    static final double WHITE_THRESHOLD = 0.5;
    static final double APPROACH_SPEED = 0.25;

    @Override
    public void runOpMode() {

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "sensor_color");


        leftDrive.setPower(1);
        rightDrive.setPower(1);

        resetRuntime();

        while(opModeIsActive() && getRuntime() < 5000) {
            telemetry.addData("moving forward", "");
            telemetry.update();

        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(1000);

        leftDrive.setPower(-0.5);
        rightDrive.setPower(0.5);
        resetRuntime();

        leftDrive.setPower(0.5);
        rightDrive.setPower(-0.5);
        resetRuntime();

        while(opModeIsActive() && getRuntime() < 3000) {
            telemetry.addData("turning left", "");
            telemetry.update();
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(1000);

        leftDrive.setPower(1);
        rightDrive.setPower(0.2);

    }
}