package com.NemianStudios.Entitys;

import info.rockscode.util.Vector3f;
import org.lwjgl.opengl.*;

public class ModelEntity {


    private Vector3f pos = new Vector3f(0, 0, 0);
    private double yaw = 0;
    private double pitch = 0;
    private float scaler = 1.0f; //1.0 by default
    private Obj model;

    public void loadobject(GL gl, String ObjectPath, String MTLPath) {
        model = ModelLoaderOBJ.LoadModel(ObjectPath, MTLPath, gl);
        if (model == null) {
            System.out.println("ERROR");
        }
    }

    public GLModel getModel() {
        return model;
    }

    public Vector3f getPos() {
        return pos;
    }

    public double getYaw() {
        return yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public float getScaler() {
        return scaler;
    }

    public void setScaler(float scale) {
        scaler = scale;
    }
}
