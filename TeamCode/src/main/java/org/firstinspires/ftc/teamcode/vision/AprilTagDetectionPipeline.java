// File: AprilTagDetectionPipeline.java
package org.firstinspires.ftc.teamcode.vision;

import org.openftc.apriltag.AprilTagDetection;
import org.openftc.apriltag.AprilTagDetector;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Mat;

import java.util.ArrayList;

public class AprilTagDetectionPipeline extends OpenCvPipeline {
    private AprilTagDetector detector;
    private ArrayList<AprilTagDetection> detections = new ArrayList<>();

    public AprilTagDetectionPipeline(double tagSize, double fx, double fy, double cx, double cy) {
        detector = new AprilTagDetector.Builder()
                .setTagSize(tagSize)
                .setLensIntrinsics(fx, fy, cx, cy)
                .build();
    }

    @Override
    public Mat processFrame(Mat input) {
        detections = detector.detect(input);
        return input;
    }

    public ArrayList<AprilTagDetection> getLatestDetections() {
        return detections;
    }
}
