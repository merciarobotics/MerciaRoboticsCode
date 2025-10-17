package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.FlywheelShooterTest;

@Autonomous
public class FlywheelShooterTestPractice extends OpMode {

    FlywheelShooterTest test = new FlywheelShooterTest();

    @Override
    public void init(){
        test.init(hardwareMap);
    }

    @Override
    public void loop() {
        test.setMotorSpeed1(1);
    }
}