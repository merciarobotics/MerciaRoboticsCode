package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class FieldOrientatedMechanisms {
    CRServo.Direction dir;
    private DcMotor frontLeftMotor, backLeftMotor,frontRightMotor,backRightMotor, flywheel1, intake1;
    private IMU imu;

    CRServo servo;

    public void init(HardwareMap hwMap){

        servo = hwMap.get(CRServo.class,"servo_pos");
        dir = servo.getDirection();

        frontLeftMotor = hwMap.get(DcMotor.class,"leftFront");
        backLeftMotor = hwMap.get(DcMotor.class,"leftBack");
        frontRightMotor = hwMap.get(DcMotor.class,"rightFront");
        backRightMotor = hwMap.get(DcMotor.class,"rightBack");

        //frontLeftMotor.setDirection((DcMotorSimple.Direction.REVERSE));
        //backLeftMotor.setDirection((DcMotorSimple.Direction.REVERSE));

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //intake1 = hwMap.get(DcMotor.class, "intake1"); // match name in config file
        //intake1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // intake1.setDirection(DcMotor.Direction.FORWARD);
       // intake1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        flywheel1 = hwMap.get(DcMotor.class, "flywheel1"); // match name in config file
        flywheel1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flywheel1.setDirection(DcMotor.Direction.FORWARD);
        flywheel1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT);
        imu.initialize(new IMU.Parameters(RevOrientation));

    }
    public void drive(double forward,double strafe,double rotate){
        double frontLeftPower = forward + strafe + rotate;
        double backLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backRightPower = forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0;

        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));

        frontLeftMotor.setPower(maxSpeed * (frontLeftPower / maxPower));
        backLeftMotor.setPower(maxSpeed * (backLeftPower / maxPower));
        frontRightMotor.setPower(maxSpeed * (frontRightPower / maxPower));
        backRightMotor.setPower(maxSpeed * (backRightPower / maxPower));
    }

    public void driveFieldRelative(double forward, double strafe, double rotate){
        double theta = Math.atan2(forward,strafe);
        double r = Math.hypot(strafe,forward);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta );
        double newStrafe = r * Math.cos(theta );

        this.drive(newForward,newStrafe,rotate);
    }
   // public void setMotorSpeed1(double speed1){
    //    intake1.setPower(speed1);

    //}
     public void setMotorSpeed2(double speed2){
        flywheel1.setPower(speed2);

   }public void setServo(double power1){
        servo.setPower(power1);

   }
//    public DcMotorSimple.Direction getServo(){
//        return servo.getDirection();
//
//    }


}
