package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TurretMechanisms {

    public DcMotor turret;
    public DcMotor turret2;

    public void init(HardwareMap hwMap) {

//        turret.setDirection(DcMotor.Direction.FORWARD);

        turret = hwMap.get(DcMotor.class, "turret");
        turret.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        turret.setDirection(DcMotorSimple.Direction.REVERSE);
        turret.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        turret2 = hwMap.get(DcMotor.class, "turret2");
        turret2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        turret2.setDirection(DcMotorSimple.Direction.REVERSE);
        turret2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);




    }
    public void setMotorSpeed1(int speed1) {
        turret.setPower(1.0);
        turret.setTargetPosition(speed1);
        turret.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        turret2.setPower(1.0);
        turret2.setTargetPosition(speed1);
        turret2.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }public int getPosition(){
        return turret.getCurrentPosition();

    }

    public int getTargetPos(){
        return turret.getTargetPosition();
    }


//
//    while(){
//        int offsetAngle = 90; // the angle the robot has turned from facing forwards
//        int targetPos = 360 - offsetAngle;


    //}
}
