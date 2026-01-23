package org.firstinspires.ftc.teamcode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.RobotOrientatedMechanisms;

@TeleOp
public class RobotOrientatedTeleOp extends OpMode {
int intakeState;
int flywheelState;
double flywheel;

    RobotOrientatedMechanisms mechanisms = new RobotOrientatedMechanisms();
    @Override
    public void init() {
        mechanisms.init(hardwareMap);
        intakeState = 0;
        flywheelState = 1;

    }
    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y;
        double speedStrafe = gamepad1.left_stick_x;
        double speedRotate = gamepad1.right_stick_x;
        double intake = -gamepad1.left_trigger;

        switch (intakeState) {
            case 0:
                if (gamepad1.dpad_down) {
                    intakeState = 1;
                }
                break;
            case 1:
                intake = intake*-1;
                if (gamepad1.dpad_up) {
                    intakeState = 0;
                }
                break;
        }
        switch (flywheelState) {
            case 0:
                flywheel = 0.7;
                if (gamepad2.dpad_down){
                    flywheelState = 1;
                }
                break;
            case 1:
                flywheel = 0;
                if (gamepad2.dpad_up) {
                    flywheelState = 0;
                }
                break;
        }
        //if(gamepad1.a){
        //    mechanisms.setServoPos(90);
        //} else if (gamepad1.b){
        //    mechanisms.setServoPos(-90);
        //}



        telemetry.addData("x", speedStrafe);
        telemetry.addData("y", speedForward);
        telemetry.addData("r", speedRotate);
        telemetry.addData("i", intake);
        telemetry.addData("f", flywheel);

        mechanisms.setMotorSpeed1(speedForward+speedStrafe+speedRotate);
        mechanisms.setMotorSpeed2(speedForward-speedStrafe-speedRotate);
        mechanisms.setMotorSpeed3(speedForward-speedStrafe+speedRotate);
        mechanisms.setMotorSpeed4(speedForward+speedStrafe-speedRotate);
        mechanisms.setServoPos(intake);
        mechanisms.setMotorSpeed6(flywheel);

    }
}
