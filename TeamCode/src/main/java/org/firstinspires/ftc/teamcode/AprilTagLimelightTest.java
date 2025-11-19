package org.firstinspires.ftc.teamcode;
import com.qualcom.robotcore.eventloop.opmode.OpMode;

public class AprilTagLimelightTest extends Opmode {
    private LimeLight3A limelight;
    public void init(){
        limelight = hardwareMap.get(LimeLight3A.class, "limelight");
        limelight.pipelineSwitch(/*index:*/ 8); //april tag #11
    }
    public void start(){

    }
    public void loop(){

    }
}