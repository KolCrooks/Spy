package com.NemianStudios.Display;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.sun.javafx.geom.Vec3d;

public class Camera {

    public static int yaw = 90;
    public static int pitch = 90;
    public static double fovY = 90;
    public static double aspectratio = Window.frame.getWidth() / Window.frame.getHeight();
    public static Vec3d pos = new Vec3d(0, 0, 0);

    public void updateCamera(GL2 gl, GLU glu) {
        //TODO add stuff to this
        gl.glRotatef(yaw, 1, 0, 0); // to rotate about the x-axis
        gl.glRotatef(pitch, 0, 1, 0); // to rotate about the y-axis
    }

    public void setPos(GL2 gl, int x, int y, int z) {
        gl.glTranslatef(x, y, z);
    }

    public void Move(Vec3d pos) {
        Camera.pos.x += pos.x;
        Camera.pos.y += pos.y;
        Camera.pos.z += pos.z;
    }

    public void pan(int var) {
        yaw += var;
    }

    public void tilt(int var) {
        pitch += var;
    }

    public void init(GLU glu) {
        glu.gluPerspective(fovY, aspectratio,
                0/**Specifies the distance from the viewer to the near clipping plane**/,
                10000/**Specifies the distance from the viewer to the far clipping plane**/);

    }

}
