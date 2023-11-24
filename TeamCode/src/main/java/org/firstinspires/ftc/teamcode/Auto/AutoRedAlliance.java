package org.firstinspires.ftc.teamcode.Auto;

/**
 * This is an Auto Driving the Robot and during the presentation for explaining the possibilities of Robot
 */

import static java.lang.Runtime.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Drivetrain.TankDrivetrain;

@Autonomous(name="AutoRedAlliance", group="Robot")
public class AutoRedAlliance extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

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

        robot.encoderDrive(700, 700, 0.2);





//        while (opModeIsActive() && runtime.milliseconds() < 1000){
//           robot.debug();
//            telemetry.addData("Runtime", runtime.milliseconds());
//            telemetry.addData("Encoder left", robot.l_motor.getCurrentPosition());
//            telemetry.addData("Encoder right", robot.r_motor.getCurrentPosition());
//            telemetry.addData("Servo Encoder 1", robot.claw1.getPosition());
//            telemetry.addData("Servo Encoder 2", robot.claw2.getPosition());
//            telemetry.update();
//
//        }


//        while (opModeIsActive() && runtime.milliseconds() < 2000){
//            telemetry.addData("Runtime", runtime.milliseconds());
//            telemetry.addData("Encoder left", robot.l_motor.getCurrentPosition());
//            telemetry.addData("Encoder right", robot.r_motor.getCurrentPosition());
//            telemetry.addData("Servo Encoder 1", robot.claw1.getPosition());
//            telemetry.addData("Servo Encoder 2", robot.claw2.getPosition());
//            telemetry.update();
//
//        }
//        resetRuntime();

    }
}