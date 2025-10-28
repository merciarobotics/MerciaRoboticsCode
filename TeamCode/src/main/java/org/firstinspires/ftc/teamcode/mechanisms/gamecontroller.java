package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.FlywheelShooterTest;
@TeleOp
public class gamecontroller extends OpMode {
int intakeState;

    FlywheelShooterTest test = new FlywheelShooterTest();
    @Override
    public void init() {
        test.init(hardwareMap);
        intakeState = 0;

    }
    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y;
        double speedStrafe = gamepad1.left_stick_x;
        double speedRotate = gamepad1.right_stick_x;
        double intake = gamepad1.left_trigger;
        double flywheel = gamepad1.right_trigger;
        int intakeDirection = 0;
        int flywheelDirection = 1;
        switch (intakeState) {
            case 0:
                telemetry.addLine("Intake = Forward");
                intakeDirection = 1;
                if (gamepad1.dpad_down){
                    intakeState = 1;
                }
                break;
            case 1:
                telemetry.addLine("Intake = Reverse");
                intakeDirection = -1;
                if (gamepad1.dpad_up){
                    intakeState = 0;
                }
                break;

        }


        telemetry.addData("x", speedStrafe);
        telemetry.addData("y", speedForward);
        telemetry.addData("r", speedRotate);
        telemetry.addData("i", intake*intakeDirection);
        telemetry.addData("f", flywheel*flywheelDirection);

        test.setMotorSpeed1(speedForward+speedStrafe+speedRotate);
        test.setMotorSpeed2(speedForward-speedStrafe-speedRotate);
        test.setMotorSpeed3(speedForward-speedStrafe+speedRotate);
        test.setMotorSpeed4(speedForward+speedStrafe-speedRotate);
        test.setMotorSpeed5(intake*intakeDirection);
        test.setMotorSpeed6(flywheel*flywheelDirection);

    }
}
