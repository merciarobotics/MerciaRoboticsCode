package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotOrientatedMechanisms {
    private DcMotor lf_wheel; //UltraplanetaryMotor0
    private DcMotor rf_wheel; //UltraplanetaryMotor1
    private DcMotor rb_wheel; //UltraplanetaryMotor2
    private DcMotor lb_wheel; //UltraplanetaryMotor2
    private DcMotor intake1;
    private DcMotor flywheel1;
    private CRServo servoPos;


    public void init(HardwareMap hwMap){

        servoPos = hwMap.get(CRServo.class, "servo_pos");

        lb_wheel = hwMap.get(DcMotor.class, "leftBack"); // match name in config file
        lb_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lb_wheel.setDirection(DcMotor.Direction.FORWARD);
        lb_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lf_wheel = hwMap.get(DcMotor.class, "leftFront"); // match name in config file
        lf_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lf_wheel.setDirection(DcMotor.Direction.REVERSE);
        lf_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        rb_wheel = hwMap.get(DcMotor.class, "rightBack"); // match name in config file
        rb_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rb_wheel.setDirection(DcMotor.Direction.REVERSE);
        rb_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        rf_wheel = hwMap.get(DcMotor.class, "rightFront"); // match name in config file
        rf_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rf_wheel.setDirection(DcMotor.Direction.FORWARD);
        rf_wheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //intake1 = hwMap.get(DcMotor.class, "intake1"); // match name in config file
        //intake1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //intake1.setDirection(DcMotor.Direction.FORWARD);
        //intake1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        flywheel1 = hwMap.get(DcMotor.class, "flywheel1"); // match name in config file
        flywheel1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flywheel1.setDirection(DcMotor.Direction.FORWARD);


    }    public void setMotorSpeed1(double speed1) {
        lf_wheel.setPower(speed1);


    }   public void setMotorSpeed2(double speed2){
        rf_wheel.setPower(speed2);

    }   public void setMotorSpeed3(double speed3){
        lb_wheel.setPower(speed3);

    }   public void setMotorSpeed4(double speed4){
        rb_wheel.setPower(speed4);

    }   public void setMotorSpeed5(double speed5){
        intake1.setPower(speed5);

    }   public void setMotorSpeed6(double speed6){
        flywheel1.setPower(speed6);

    }   public void setServoPos(double angle){
        servoPos.setPower(angle);

    }


}
