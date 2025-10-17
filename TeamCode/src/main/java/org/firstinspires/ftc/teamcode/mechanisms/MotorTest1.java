package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorTest1 {
    private DcMotor motor; //UltraplanetaryMotor0

    public void init(HardwareMap hwMap){

        motor = hwMap.get(DcMotor.class, "motor"); // match name in config file
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setDirection(DcMotor.Direction.FORWARD);

    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }
}
