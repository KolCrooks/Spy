package com.NemianStudios.Entitys;

import com.NemianStudios.Util.GLModel;
import com.NemianStudios.Util.ModelLoaderOBJ;
import com.jogamp.opengl.GL2;
import com.sun.javafx.geom.Vec3d;

public class ModelEntity {


    private Vec3d pos = new Vec3d(0, 0, 0);
    private double yaw = 0;
    private double pan = 0;
    private GLModel model;

    public void loadobject(GL2 gl, String ObjectPath, String MTLPath) {
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

}
