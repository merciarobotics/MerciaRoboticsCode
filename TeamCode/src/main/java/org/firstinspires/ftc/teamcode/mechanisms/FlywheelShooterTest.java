package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlywheelShooterTest {
    private DcMotor lf_wheel; //UltraplanetaryMotor0
    private DcMotor rf_wheel; //UltraplanetaryMotor1
    private DcMotor rb_wheel; //UltraplanetaryMotor2
    private DcMotor lb_wheel; //UltraplanetaryMotor2


    public void init(HardwareMap hwMap){

        lb_wheel = hwMap.get(DcMotor.class, "lb_wheel"); // match name in config file
        lb_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lb_wheel.setDirection(DcMotor.Direction.FORWARD);

        lf_wheel = hwMap.get(DcMotor.class, "lf_wheel"); // match name in config file
        lf_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lf_wheel.setDirection(DcMotor.Direction.FORWARD);

        rb_wheel = hwMap.get(DcMotor.class, "rb_wheel"); // match name in config file
        rb_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rb_wheel.setDirection(DcMotor.Direction.FORWARD);

        rf_wheel = hwMap.get(DcMotor.class, "rf_wheel"); // match name in config file
        rf_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rf_wheel.setDirection(DcMotor.Direction.FORWARD);


    }    public void setMotorSpeed1(double speed1) {
        lf_wheel.setPower(speed1);


    }   public void setMotorSpeed2(double speed2){
        rf_wheel.setPower(speed2);

    }   public void setMotorSpeed3(double speed3){
        lb_wheel.setPower(speed3);

    }   public void setMotorSpeed4(double speed4){
        rb_wheel.setPower(speed4);

    }


}
