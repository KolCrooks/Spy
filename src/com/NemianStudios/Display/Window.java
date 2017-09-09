package com.NemianStudios.Display;


import com.NemianStudios.Util.Settings;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame{
     private static final long serialVersionUID = 1L;

             public Window(){
                 //getting the capabilities object of GL2 profile
                 final GLProfile profile = GLProfile.get(GLProfile.GL2);
                 GLCapabilities capabilities = new GLCapabilities(profile);

                 // The canvas
                 final GLCanvas glcanvas = new GLCanvas(capabilities);
                 glcanvas.addGLEventListener(new DrawListener());
                 glcanvas.setSize(Settings.gameSettings.WIDTH, Settings.gameSettings.HEIGHT);

                 //creating frame
                 final Frame frame = new Frame ("Spy");

                 //adding canvas to frame
                 frame.add(glcanvas);
                 frame.setSize(Settings.gameSettings.WIDTH, Settings.gameSettings.HEIGHT);
                 frame.setVisible(true);
             }

}
