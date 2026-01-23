package org.firstinspires.ftc.teamcode.teleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.RobotOrientatedMechanisms;
import org.firstinspires.ftc.teamcode.mechanisms.TurretMechanisms;

@TeleOp
public class TurretTeleOp extends OpMode {

    TurretMechanisms mechanisms = new TurretMechanisms();
    double flywheel;
    private final DcMotor turret;

    int flywheelState;

    public TurretTeleOp(DcMotor turret) {
        this.turret = turret;
    }


    public void init() {
        flywheelState = 0;


    }

    public void loop() {
        turret.setPower(0.0);
        telemetry.addData("turret", turret.getCurrentPosition());
        telemetry.update();
    }


}

