package com.NemianStudios.Input;

import com.NemianStudios.Display.Draw;
import com.NemianStudios.Display.Window;
import com.NemianStudios.Main;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

import java.awt.*;

public class Pointer extends GLFWCursorPosCallback {

    Vector2f mouse = new Vector2f(0, 0);

    Robot robot;

    public GLFWWindowSizeCallback resizeCallback;

    public Pointer() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void invoke(long window, double xpos, double ypos) {
        if (!(mouse.x == xpos || mouse.y == ypos)) {
            MouseMoved(window, xpos, ypos);
        }
    }

    public void MouseMoved(long window, double xpos, double ypos) {
        mouse.x = (float) xpos;
        mouse.y = (float) ypos;
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

    private void createCallbacks() {

    }

}
