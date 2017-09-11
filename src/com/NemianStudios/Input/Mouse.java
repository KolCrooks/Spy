package com.NemianStudios.Input;

import com.NemianStudios.Display.DrawListener;
import com.NemianStudios.Display.Window;

import java.awt.*;
import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
    Robot robot;

    public Mouse() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        //change cursor icon
        Window.frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        double mouseX = e.getX();
        double mouseY = e.getY();
        double defX = (Window.frame.getWidth() + Window.frame.getX()) / 2;
        double defY = (Window.frame.getHeight() + Window.frame.getY()) / 2;

        DrawListener.camera.pan(((defX) - mouseX) / 200);
        DrawListener.camera.tilt((((defY) - mouseY) / 100) - 0.31);
        try {
            robot.mouseMove((int) defX, (int) defY);
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

}
