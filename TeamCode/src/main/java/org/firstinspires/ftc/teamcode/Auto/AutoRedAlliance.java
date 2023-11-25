package org.firstinspires.ftc.teamcode.Auto;

/**
 * This is an Auto Driving the Robot and during the presentation for explaining the possibilities of Robot
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;

import org.firstinspires.ftc.teamcode.Drivetrain.TankDrivetrain;

@Autonomous(name="AutoRedAlliance", group="Robot")
@Disabled
public class AutoRedAlliance extends LinearOpMode {

    public TankDrivetrain robot = new TankDrivetrain();

    static final double WHITE_THRESHOLD = 0.5;
    static final double APPROACH_SPEED = 0.25;

    @Override
    public void runOpMode() {
//initialize hardware map
        robot.init(hardwareMap);

        double leftPower;
        double rightPower;

        waitForStart();
        resetRuntime();

        while(opModeIsActive() && getRuntime() < 5000) {
            telemetry.addData("moving forward", "");
            telemetry.update();

        }

        robot.l_motor.setPower(0);
        robot.r_motor.setPower(0);
        sleep(1000);

        robot.l_motor.setPower(-0.5);
        robot.r_motor.setPower(-0.5);
        resetRuntime();

        robot.l_motor.setPower(0.5);
        robot.r_motor.setPower(-0.5);
        resetRuntime();

        while(opModeIsActive() && getRuntime() < 3000) {
            telemetry.addData("turning left", "");
            telemetry.update();
        }

        robot.l_motor.setPower(0);
        robot.r_motor.setPower(0);
        sleep(1000);

        robot.r_motor.setPower(0);
        robot.r_motor.setPower(0);

    }
}