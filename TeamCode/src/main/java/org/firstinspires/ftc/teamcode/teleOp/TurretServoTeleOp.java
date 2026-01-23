package org.firstinspires.ftc.teamcode.teleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TurretServoMechanisms;

@TeleOp
public class TurretServoTeleOp extends OpMode {

    TurretServoMechanisms mechanisms = new TurretServoMechanisms();


    @Override
    public void init() {
        mechanisms.init(hardwareMap);
    }

    @Override
    public void loop() {
        // telemetry.addData(x);
        if(gamepad1.a){
            mechanisms.setServoRot(-1.0);
        }
        else{
            mechanisms.setServoRot(1.0);
        }
        telemetry.addData("Servo:", mechanisms.getServo());




    }





}
