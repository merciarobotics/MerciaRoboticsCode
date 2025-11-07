package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.apriltag.AprilTagDetection;

import org.firstinspires.ftc.teamcode.vision.AprilTagDetectionPipeline;

import java.util.ArrayList;

@Autonomous(name = "AprilTag Auto", group = "Autonomous")
public class AprilTagAuto extends LinearOpMode {

    OpenCvCamera camera;
    AprilTagDetectionPipeline pipeline;

    // Camera calibration values (adjust if you want calibrate camera)
    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;
    double tagSize = 0.166; // meters

    @Override
    public void runOpMode() {
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName);

        pipeline = new AprilTagDetectionPipeline(tagSize, fx, fy, cx, cy);
        camera.setPipeline(pipeline);

        camera.openCameraDeviceAsync(() -> {
            camera.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
        });

        telemetry.addLine("Initializing camera...");
        telemetry.update();

        while (!isStarted() && !isStopRequested()) {
            ArrayList<AprilTagDetection> detections = pipeline.getLatestDetections();

            if (detections.size() > 0) {
                AprilTagDetection tag = detections.get(0);

                telemetry.addData("Tag ID", tag.id);
                telemetry.addData("Translation X (in)", tag.ftcPose.x);
                telemetry.addData("Translation Y (in)", tag.ftcPose.y);
                telemetry.addData("Translation Z (in)", tag.ftcPose.z);
                telemetry.addData("Yaw (deg)", tag.ftcPose.yaw);
                telemetry.addData("Pitch (deg)", tag.ftcPose.pitch);
                telemetry.addData("Roll (deg)", tag.ftcPose.roll);
            } else {
                telemetry.addLine("No tag detected");
            }

            telemetry.update();
            sleep(20);
        }

        waitForStart();

        ArrayList<AprilTagDetection> detections = pipeline.getLatestDetections();
        if (detections.size() > 0) {
            int tagId = detections.get(0).id;

            if (tagId == 21) {
                // Autonomous path for motif 21
                telemetry.addLine("fire balls in GPP pattern");
            } else if (tagId == 22) {
                // Autonomous path for motif 22
                telemetry.addLine("fire balls in PGP pattern");
            } else if (tagId == 23) {
                // Autonomous path for motif 23
                telemetry.addLine("fire balls in PPG pattern");
            } else {
                telemetry.addLine("Unknown tag ID");
            }
        } else {
            telemetry.addLine("No tag detected at start");
        }

        telemetry.update();
    }
}
