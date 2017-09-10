package com.NemianStudios.Display;


import com.NemianStudios.Input.Mouse;
import com.NemianStudios.Input.keyBoard;
import com.NemianStudios.Util.Settings;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Window extends JFrame{
     private static final long serialVersionUID = 1L;
    public static Frame frame;
    private static FPSAnimator animator;
    public static DrawListener draw;
    public static keyBoard keyboard;
    public static Mouse mouse;
             public Window(){
                 //getting the capabilities object of GL2 profile
                 final GLProfile profile = GLProfile.get(GLProfile.GL2);
                 GLCapabilities capabilities = new GLCapabilities(profile);

                 // The canvas
                 final GLCanvas glcanvas = new GLCanvas(capabilities);
                 glcanvas.setSize(Settings.gameSettings.WIDTH, Settings.gameSettings.HEIGHT);

                 //creating frame
                 frame = new Frame("Spy");

                 //adding canvas to frame
                 frame.add(glcanvas);
                 frame.setSize(Settings.gameSettings.WIDTH, Settings.gameSettings.HEIGHT);
                 frame.setVisible(true);
                 frame.addWindowListener(new WindowAdapter() {
                     public void windowClosing(WindowEvent we) {
                         animator.stop();
                         frame.dispose();
                     }
                 });
                 animator = new FPSAnimator(25);
                 animator.add(glcanvas);
                 animator.start();
                 mouse = new Mouse();
                 glcanvas.addGLEventListener(draw = new DrawListener());
                 glcanvas.addKeyListener(keyboard = new keyBoard());
                 glcanvas.addMouseListener(mouse);
                 glcanvas.addMouseMotionListener(mouse);
                 glcanvas.addMouseWheelListener(mouse);

             }

}
