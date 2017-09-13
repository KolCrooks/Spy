package com.NemianStudios.Input;

import com.NemianStudios.Display.Draw;
import com.NemianStudios.Display.Window;
import com.NemianStudios.Main;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.awt.*;
import java.awt.event.*;

public class Mouse extends GLFWMouseButtonCallback,GLFWCursorPosCallback{
    Robot robot;

    public Mouse() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //TODO Fix THis
    public void mouseMoved(MouseEvent e) {

        double mouseX = e.getX();
        double mouseY = e.getY();
        double defX = (Main.getWindow().getWidth() + Window.frame.getX()) / 2;
        double defY = (Window.frame.getHeight() + Window.frame.getY()) / 2;

        Draw.camera.pan(((defX) - mouseX) / 200);
        Draw.camera.tilt((((defY) - mouseY) / 100) - 0.31);
        try {
            robot.mouseMove((int) defX, (int) defY);
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }

    @Override
    public void invoke(long window, int button, int action, int mods) {
        //Mouse Button Pressed
    }

    @Override
    public void invoke(long window, double xpos, double ypos) {

    }

    @Override
    public void close() {

    }
}
