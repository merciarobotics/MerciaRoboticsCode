package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.teamcode.mechanisms.AiprilTagWebCam;

public class AprilTagWebcamExample extends OpMode {
    AprilTagWebcam aprilTagWebcam = new AprilTagWebcam();

    @Override
    public void init(){
        aprilTagWebcam.init(hardwareMap,telemetry);
    }
    @Override
    public void loop(){
        aprilTagWebcam.update();
        AprilTagDetection id20 = aprilTagWebcam.getTagByspecificId(20);
        telemetry.addData("id20 String",id20.toString());
    }

}
