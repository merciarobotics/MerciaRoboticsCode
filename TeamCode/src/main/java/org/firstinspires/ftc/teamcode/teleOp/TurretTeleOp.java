package org.firstinspires.ftc.teamcode.teleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.RobotOrientatedMechanisms;
import org.firstinspires.ftc.teamcode.mechanisms.TurretMechanisms;

@TeleOp
public class TurretTeleOp extends OpMode {

    TurretMechanisms mechanisms = new TurretMechanisms();

    @Override
    public void init() {
        mechanisms.init(hardwareMap);


    }
    @Override
    public void loop() {
        double tics = mechanisms.getPosition();
        double degrees = tics*360/28;

        mechanisms.setMotorSpeed1(0);
        telemetry.addData("turret", degrees);
        telemetry.update();
    }


}

