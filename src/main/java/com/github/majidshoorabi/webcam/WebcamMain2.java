package com.github.majidshoorabi.webcam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WebcamMain2 {
    public static void main(String[] args) throws IOException {

        // Take image with custom size of pixels
        Webcam webcam = Webcam.getDefault();

        // Webcam event Listener
        webcam.addWebcamListener(new WebcamListener() {
            @Override
            public void webcamOpen(WebcamEvent webcamEvent) {
                System.out.println("Webcam open");
            }

            @Override
            public void webcamClosed(WebcamEvent webcamEvent) {
                System.out.println("Webcam close");
            }

            @Override
            public void webcamDisposed(WebcamEvent webcamEvent) {
                System.out.println("Webcam dispose");
            }

            @Override
            public void webcamImageObtained(WebcamEvent webcamEvent) {
                System.out.println("Webcam Taken");
            }
        });

        // what size support with my webcam
        for (Dimension supportedSize : webcam.getViewSizes()) {
            System.out.println(supportedSize.toString());
        }

        webcam.setViewSize(new Dimension(640,480));
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        webcam.open();
        ImageIO.write(webcam.getImage(), "PNG", new File("Image.png"));
        webcam.close();

    }
}