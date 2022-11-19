package com.github.majidshoorabi.webcam;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WebcamMain1 {
    public static void main(String[] args) throws IOException {

        // How to take an image
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        ImageIO.write(webcam.getImage(), "JPG", new File("Image.jpg"));
        webcam.close();
    }
}
