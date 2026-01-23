package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TurretServoMechanisms{
    private CRServo servo;
    public void init(HardwareMap hwMap){
        servo = hwMap.get(CRServo.class,"servo");


    }

    public void setServoRot(double power) {
        servo.setPower(power);
        // x = servo.getDirection();

    }
    public CRServo.Direction getServo(){
        return servo.getDirection();

    }


}
