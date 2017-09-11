package com.NemianStudios.Entitys;

import org.lwjgl.opengl.*;
import com.sun.javafx.geom.Vec3d;

public class ModelEntity {


    private Vec3d pos = new Vec3d(0, 0, 0);
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

    public Vec3d getPos() {
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
