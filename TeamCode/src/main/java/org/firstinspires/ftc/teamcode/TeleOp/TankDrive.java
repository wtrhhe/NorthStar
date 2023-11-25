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


        waitForStart();

        while (opModeIsActive()) {

            double drive = -gamepad1.left_stick_y;
            double turn = -gamepad1.right_stick_x;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            if (drive >= 0) {
                robot.l_motor.setPower(leftPower);
                robot.r_motor.setPower(rightPower);
            } else {
                robot.l_motor.setPower(rightPower);
                robot.r_motor.setPower(leftPower);
            }

            if(gamepad2.dpad_down){ // arm intake position
                robot.larm.setTargetPosition(-168);
                //servo wrist intake position
                robot.larm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.larm.setPower(Math.abs(0.5));
            }else if(gamepad2.dpad_left){ // arm default position
                robot.larm.setTargetPosition(-80);
                //servo default position
                robot.larm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.larm.setPower(Math.abs(0.5));
            }else if(gamepad2.dpad_up){  // set pixel default position
                robot.larm.setTargetPosition(-10);
                //servo wrist set pixel position
                robot.larm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.larm.setPower(Math.abs(0.5));
            }

            if(gamepad2.right_bumper){ //lift set pixel position
                //robot.lift.setTargetPosition(-80);
                //robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                //robot.lift.setPower(Math.abs(0.5));
            }
            if(gamepad2.left_bumper){ //lift get pixel position
                //robot.lift.setTargetPosition(-80);
                //robot.lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                //robot.lift.setPower(Math.abs(0.5));
            }

            if(gamepad1.right_stick_button && gamepad1.left_stick_button){
                //plane launcher
                robot.plauncher.setPosition(0.7); // plane launcher position
            }
            if(gamepad2.a) { //get a pixels
                robot.plauncher.setPosition(0.7);

            }if(gamepad2.b){ //release a pixels
                robot.plauncher.setPosition(0.7);
            }



            telemetry.addData("Left Pow", robot.l_motor.getPower());
            telemetry.addData("Left Encoder", robot.l_motor.getCurrentPosition());
            telemetry.addData("Right Pow", robot.r_motor.getPower());
            telemetry.addData("Right Encoder", robot.r_motor.getCurrentPosition());
            telemetry.addData("Core hex position", robot.larm.getCurrentPosition());
            telemetry.addData("Claw Servo position", robot.claw1.getPosition());
            telemetry.addData("Wrist Servo position", robot.wrist.getPosition());
            telemetry.addData("Plane Servo position", robot.plauncher.getPosition());
            telemetry.update();
        }

    }

//    public void encoderDrive(double speed,
//                             double leftInches, double rightInches,
//                             double timeoutS) {
//        int newLeftTarget;
//        int newRightTarget;
//
//        // Ensure that the OpMode is still active
//        if (opModeIsActive()) {
//
//            // Determine new target position, and pass to motor controller
//            newLeftTarget = robot.l_motor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
//            newRightTarget = robot.r_motor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
//            robot.l_motor.setTargetPosition(newLeftTarget);
//            robot.r_motor.setTargetPosition(newRightTarget);
//
//            // Turn On RUN_TO_POSITION
//            robot.l_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            robot.r_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            // reset the timeout time and start motion.
//            runtime.reset();
//            robot.l_motor.setPower(Math.abs(speed));
//            robot.r_motor.setPower(Math.abs(speed));
//
//            // keep looping while we are still active, and there is time left, and both motors are running.
//            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
//            // its target position, the motion will stop.  This is "safer" in the event that the robot will
//            // always end the motion as soon as possible.
//            // However, if you require that BOTH motors have finished their moves before the robot continues
//            // onto the next step, use (isBusy() || isBusy()) in the loop test.
//            while (opModeIsActive() &&
//                    (runtime.seconds() < timeoutS) &&
//                    (leftDrive.isBusy() && rightDrive.isBusy())) {
//
//                // Display it for the driver.
//                telemetry.addData("Running to",  " %7d :%7d", newLeftTarget,  newRightTarget);
//                telemetry.addData("Currently at",  " at %7d :%7d",
//                        leftDrive.getCurrentPosition(), rightDrive.getCurrentPosition());
//                telemetry.update();
//            }
//        }
//    }
}

