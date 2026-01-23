package org.firstinspires.ftc.teamcode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.mechanisms.FieldOrientatedMechanisms;


@TeleOp
public class FieldOrientatedTeleOp extends OpMode {
    FieldOrientatedMechanisms mechanisms = new FieldOrientatedMechanisms();
    double forward,strafe,rotate,intake,flywheel;
    int flywheelState;
    int intakeState;

    @Override
    public void init(){
        mechanisms.init(hardwareMap);
        flywheelState = 1;
        intakeState = 0;
    }

    @Override
    public void loop(){
        forward = -gamepad1.left_stick_y;
        strafe  = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        intake = -gamepad1.left_trigger;

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
        mechanisms.driveFieldRelative(forward,strafe,rotate);
       // mechanisms.setMotorSpeed1(intake);
        mechanisms.setMotorSpeed2(flywheel);
        mechanisms.setServo(intake);

        telemetry.addData("Forward:", forward);
        telemetry.addData("Strafe:", strafe);
        telemetry.addData("Rotate:", rotate);
        telemetry.addData("Intake:", intake);
        telemetry.addData("Flywheel:", flywheel);
//        telemetry.addData("Servo:", mechanisms.getServo());


    }
}
