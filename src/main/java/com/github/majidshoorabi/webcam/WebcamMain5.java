package com.github.majidshoorabi.webcam;


import java.io.File;

public class WebcamMain5 {
    public static void main(String[] args) {

        // How to save video in file?
        WebcamMain5 videoWriter =  new WebcamMain5();
        videoWriter.startVideoRecord();

    }

    private void startVideoRecord() {
        File saveFile = new File("video.mp4");
    }
}
