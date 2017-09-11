package com.NemianStudios.Display;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.sun.javafx.geom.Vec3d;


public class Camera {

    public static double yaw = 0;
    public static double pitch = 0;
    public static double fovY = 90;
    public static double aspectratio = Window.frame.getWidth() / Window.frame.getHeight();
    public static Vec3d pos = new Vec3d(0, 0, 0);

    public void updateCamera(GL2 gl, GLU glu) {
        if (yaw > 360) {
            yaw -= 360;
        }
        if (yaw < -360) {
            yaw += 360;
        }
        glu.gluLookAt(pos.x, pos.y, pos.z, pos.x + (Math.cos(Math.toRadians(yaw)) * 1000), pos.y + (Math.sin(Math.toRadians(pitch)) * 1000), pos.z + (Math.sin(Math.toRadians(yaw)) * 1000), 0, 1, 0);
        //System.out.println("X: " + pos.x + " Y: " + pos.y + " Z: " + pos.z + " Yaw: " + yaw + " Pitch: " + pitch);
    }

    //Moves camera to Vec3 position
    public void MoveCamera(Vec3d pos) {
        if (pos.z > 0) { //If Key 'W'
            Camera.pos.x += Math.cos(yaw) * 10;
            Camera.pos.z += Math.sin(yaw) * 10;
        } else if (pos.z < 0) { //If Key 'S'
            Camera.pos.x -= Math.cos(yaw) * 10;
            Camera.pos.z -= Math.sin(yaw) * 10;
        }

        if (pos.x > 0) { //If Key 'A'
            Camera.pos.x += Math.sin(yaw + 90) * 10;
            Camera.pos.z += Math.cos(yaw + 90) * 10;
        } else if (pos.x < 0) { //If Key 'D'
            Camera.pos.x += Math.sin(yaw - 90) * 10;
            Camera.pos.z += Math.cos(yaw - 90) * 10;
        }
        Camera.pos.y += pos.y;
    }

    public void pan(double var) {

        yaw -= var;
    }

    public void tilt(double var) {
        if (var > 0) {
            if (pitch + var < 90)
                pitch += var;
        } else if (var < 0) {
            if (pitch + var > -90)
            pitch += var;
        }
        System.err.println(var);
    }

    public void init(GLU glu) {
        glu.gluPerspective(fovY, aspectratio,
                0.5f/**Specifies the distance from the viewer to the near clipping plane**/,
                10000.0f/**Specifies the distance from the viewer to the far clipping plane**/);

    }

}
