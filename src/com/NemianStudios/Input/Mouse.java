package com.NemianStudios.Input;

import com.NemianStudios.Display.DrawListener;
import com.NemianStudios.Display.Window;

import java.awt.*;
import java.awt.event.*;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {

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
        MovementManager.Command c = new MovementManager.Command();
        c.addcommand(MovementManager.Command.MOVECAMERADIRECTION);
        DrawListener.movementManager.addtocommandlist(c);
        double mouseX = e.getX();
        double mouseY = e.getY();
        c.pan(((Window.frame.getWidth() / 2) - mouseX) / 36000000);
        c.tilt(((Window.frame.getHeight() / 2) - mouseY) / 36000000);
        Robot robot;
        try {
            robot = new Robot();
            robot.mouseMove(Window.frame.getWidth() / 2, Window.frame.getHeight() / 2);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

}
