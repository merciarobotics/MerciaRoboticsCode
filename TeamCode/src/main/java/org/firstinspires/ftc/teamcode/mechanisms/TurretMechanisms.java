package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TurretMechanisms {

    public DcMotor turret;

    public void init(HardwareMap hwMap) {

//        turret.setDirection(DcMotor.Direction.FORWARD);
        turret = hwMap.get(DcMotor.class, "turret"); // match name in config file
        turret.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }



//
//    while(){
//        int offsetAngle = 90; // the angle the robot has turned from facing forwards
//        int targetPos = 360 - offsetAngle;


    //}
}
