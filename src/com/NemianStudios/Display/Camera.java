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

        glu.gluLookAt(pos.x, pos.y, pos.z, pos.x + (Math.cos(yaw) * 100), pos.y + (Math.sin(pitch) * 100), pos.z + (Math.sin(yaw) * 100), 0, 1, 0);
        //System.out.println("X: " + pos.x + " Y: " + pos.y + " Z: " + pos.z + " Yaw: " + yaw + " Pitch: " + pitch);
    }


    public void MoveCamera(Vec3d pos) {
        if (pos.z > 0) {
            Camera.pos.x += Math.cos(yaw) * 10;
            Camera.pos.z += Math.sin(yaw) * 10;
        } else if (pos.z < 0) {
            Camera.pos.x += Math.cos(yaw + 180) * 10;
            Camera.pos.z += Math.sin(yaw + 180) * 10;
        }

        if (pos.x > 0) {
            Camera.pos.x += Math.sin(yaw + 90) * pos.x;
            Camera.pos.z += Math.cos(yaw + 90) * pos.x;
        } else if (pos.x < 0) {
            Camera.pos.x += Math.sin(yaw - 90) * pos.x;
            Camera.pos.z += Math.cos(yaw - 90) * pos.x;
        }
        Camera.pos.y += pos.y;
    }

    public void pan(double var) {

        yaw -= var;
        System.out.println("Pan: " + var);
    }

    public void tilt(double var) {
        if (pitch < 90 || var < 0) {
            pitch += var;
            System.out.println("Tilt: " + var);
        } else if (pitch > -90 || var > 0) {
            pitch += var;
            System.out.println("Tilt: " + var);
        }
    }

    public void init(GLU glu) {
        glu.gluPerspective(fovY, aspectratio,
                0.5f/**Specifies the distance from the viewer to the near clipping plane**/,
                10000.0f/**Specifies the distance from the viewer to the far clipping plane**/);

    }

}
