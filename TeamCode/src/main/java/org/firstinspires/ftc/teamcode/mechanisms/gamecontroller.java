package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.FlywheelShooterTest;
@TeleOp
public class gamecontroller extends OpMode {


    FlywheelShooterTest test = new FlywheelShooterTest();

    @Override
    public void init() {
        test.init(hardwareMap);
    }

    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y;
        double speedStrafe = gamepad1.left_stick_x;
        double speedRotate = gamepad1.right_stick_x;

        telemetry.addData("x", speedStrafe);
        telemetry.addData("y", speedForward);
        telemetry.addData("r", speedRotate);

        test.setMotorSpeed1(speedForward+speedStrafe+speedRotate);
        test.setMotorSpeed2(speedForward-speedStrafe-speedRotate);
        test.setMotorSpeed3(speedForward-speedStrafe+speedRotate);
        test.setMotorSpeed4(speedForward+speedStrafe-speedRotate);

    }
}
