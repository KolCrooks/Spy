package com.NemianStudios.Display;


import info.rockscode.util.*;


public class Camera {

    public static double fovY = 90;
    public static double aspectratio = Window.frame.getWidth() / Window.frame.getHeight();
    public static Vector3f position = new Vector3f(0, 0, 0);
    public static Vector3f rotation;

    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }


    public Matrix4f getViewMatrix(Camera camera) {
        Vector3f cameraPos = camera.getPosition();
        Vector3f rotation = camera.getRotation();

        viewMatrix.identity();
        // First do the rotation so camera rotates over its position
        viewMatrix.rotate((float)Math.toRadians(rotation.x), new Vector3f(1, 0, 0))
                .rotate((float)Math.toRadians(rotation.y), new Vector3f(0, 1, 0));
        // Then do the translation
        viewMatrix.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        return viewMatrix;
    }
    public void updateCamera() {
        if (yaw > 360) {
            yaw -= 360;
        }
        if (yaw < -360) {
            yaw += 360;
        }
        GluLookAt(pos.x, pos.y, pos.z, pos.x + (Math.sin(Math.toRadians(yaw)) * 1000), pos.y + (Math.sin(Math.toRadians(pitch)) * 1000), pos.z + (Math.cos(Math.toRadians(yaw)) * 1000), 0, 1, 0);
        //System.out.println("X: " + pos.x + " Y: " + pos.y + " Z: " + pos.z + " Yaw: " + yaw + " Pitch: " + pitch);
    }

    //Moves camera to Vec3 position
    public void MoveCamera(Vector3f pos) {
        if (pos.z > 0) { //If Key 'W'
            Camera.pos.z += Math.cos(Math.toRadians(yaw)) * 10;
            Camera.pos.x += Math.sin(Math.toRadians(yaw)) * 10;
        } else if (pos.z < 0) { //If Key 'S'
            Camera.pos.z += Math.cos(Math.toRadians(yaw)) * -10;
            Camera.pos.x += Math.sin(Math.toRadians(yaw)) * -10;
        }

        if (pos.x > 0) { //If Key 'A'
            Camera.pos.z += Math.sin(Math.toRadians(yaw) + 90) * 10;
            Camera.pos.x += Math.cos(Math.toRadians(yaw) + 90) * 10;
        } else if (pos.x < 0) { //If Key 'D'
            Camera.pos.z += Math.sin(Math.toRadians(yaw) - 90) * 10;
            Camera.pos.x += Math.cos(Math.toRadians(yaw) - 90) * 10;
        }
        Camera.pos.y += pos.y * 10;
    }

    public void pan(double var) {

        yaw += var;
    }

    public void tilt(double var) {
        if (var > 0) {
            if (pitch + var < 90)
                pitch += var;
        } else if (var < 0) {
            if (pitch + var > -90)
            pitch += var;
        }
        //System.err.println(var);
    }

    public void init(GLU glu) {
        GL(fovY, aspectratio,
                0.5f/**Specifies the distance from the viewer to the near clipping plane**/,
                10000000.0f/**Specifies the distance from the viewer to the far clipping plane**/);

    }
    public Vector3f getPosition(){
        return position;
    }
    public Vector3f getRotation(){
        return rotation;
    }

}
