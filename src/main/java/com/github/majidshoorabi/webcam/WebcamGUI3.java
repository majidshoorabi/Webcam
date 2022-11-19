package com.github.majidshoorabi.webcam;

import com.github.sarxos.webcam.Webcam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebcamGUI3 extends javax.swing.JFrame {
    private JPanel mainPanel;
    private JLabel imageHolder;
    private JButton captureButton;
    Webcam webcam;
    Boolean isRunning;

    public WebcamGUI3() {
        initComponents();
        this.isRunning = false;
        this.webcam = Webcam.getDefault();
        this.webcam.setViewSize(new Dimension(320, 240));
        webcam.open();

//        captureButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                // take image
//                 Image image = webcam.getImage();
//                 imageHolder.setIcon(new ImageIcon(image));
//            }
//        });

        captureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // video
                if (!isRunning) {
                    isRunning = true;
                    new VideoFeedTaker().start();
                } else {
                    isRunning = false;
                }
            }
        });
    }

    private void initComponents() {
        setTitle("Image Capture");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(this.mainPanel);
        setSize(320, 300);
    }

    class VideoFeedTaker extends Thread {
        @Override
        public void run() {
            while (true && isRunning) {
                try {
                    Image image = webcam.getImage();
                    imageHolder.setIcon(new ImageIcon(image));

                    /**+
                     * 1000 / 50 = 20 -> 20 frame per a second
                     */
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        WebcamGUI3 webcamGUI = new WebcamGUI3();
    }
}

