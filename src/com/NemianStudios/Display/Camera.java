package com.NemianStudios.Display;


import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Camera {

    public static float fovY = 90;
    public static float aspectratio = Window.resizeEvent.windowSize.x / Window.resizeEvent.windowSize.y;
    public static Vector3f position = new Vector3f(0, 0, 0);
    public static Vector3f rotation = new Vector3f(0, 0, 0);

    Matrix4f viewMatrix = new Matrix4f();

    public Camera(Vector3f position, Vector3f rotation) {
        Camera.position = position;
        Camera.rotation = rotation;
    }

    public void updateCamera() {
        if (rotation.y > 360) {
            rotation.y -= 360;
        }
        if (rotation.y < -360) {
            rotation.y += 360;
        }
        //TODO make this set the viewangle to be looking at a specific position
        glLoadIdentity();
        FloatBuffer fb = BufferUtils.createFloatBuffer(16);
        glMatrixMode(GL_PROJECTION);

        glLoadMatrixf(viewMatrix.get(fb));
        viewMatrix.identity();
        viewMatrix.transformPosition(position);
        viewMatrix.setRotationXYZ(rotation.x, rotation.y, rotation.z);
        glMatrixMode(GL_MODELVIEW);
        glLoadMatrixf(viewMatrix.get(fb));

    }

    //Moves camera to Vec3 position
    public void MoveCamera(Vector3f pos) {
        if (pos.z > 0) { //If Key 'W'
            Camera.position.z += Math.cos(Math.toRadians(rotation.y)) * 10;
            Camera.position.x += Math.sin(Math.toRadians(rotation.y)) * 10;
        } else if (pos.z < 0) { //If Key 'S'
            Camera.position.z += Math.cos(Math.toRadians(rotation.y)) * -10;
            Camera.position.x += Math.sin(Math.toRadians(rotation.y)) * -10;
        }

        if (pos.x > 0) { //If Key 'A'
            Camera.position.z += Math.sin(Math.toRadians(rotation.y) + 90) * 10;
            Camera.position.x += Math.cos(Math.toRadians(rotation.y) + 90) * 10;
        } else if (pos.x < 0) { //If Key 'D'
            Camera.position.z += Math.sin(Math.toRadians(rotation.y) - 90) * 10;
            Camera.position.x += Math.cos(Math.toRadians(rotation.y) - 90) * 10;
        }
        Camera.position.y += pos.y * 10;
    }

    public void pan(double var) {

        rotation.y += var;
    }

    public void tilt(double var) {
        if (var > 0) {
            if (rotation.x + var < 90)
                rotation.x += var;
        } else if (var < 0) {
            if (rotation.x + var > -90)
                rotation.x += var;
        }
        //System.err.println(var);
    }

    public void init() {
        viewMatrix.setPerspective(fovY, aspectratio, 0.0f, 10000000.0f);

    }
    public Vector3f getPosition(){
        return position;
    }
    public Vector3f getRotation(){
        return rotation;
    }

}
