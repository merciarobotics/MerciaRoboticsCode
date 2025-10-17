package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.MotorTest1;

@Autonomous
public class DcMotorPractice extends OpMode {
    MotorTest1 test = new MotorTest1();

    @Override
    public void init(){
        test.init(hardwareMap);
    }

    @Override
    public void loop() {
        test.setMotorSpeed(0.1);
    }
}
