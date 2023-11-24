package org.firstinspires.ftc.teamcode.Auto;

import org.firstinspires.ftc.teamcode.Drivetrain.TankDrivetrain;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import java.awt.font.NumericShaper;
import java.util.Random;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import  com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Drivetrain.TankDrivetrain;
import org.firstinspires.ftc.teamcode.TeleOp.TankDrive;

public class AutoBlueAlliance {

    public TankDrivetrain robot = new TankDrivetrain();

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        robot.l_motor.setPower(1);
        robot.r_motor.setPower(1);
        sleep(1500);

        robot.l_motor.setPower(1);
        robot.r_motor.setPower(.1);
        sleep(1500);

        robot.l_motor.setPower(.1);
        robot.r_motor.setPower(1);
        sleep(5000);
    }

}
