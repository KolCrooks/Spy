package com.NemianStudios.Entitys;


import com.jogamp.opengl.GL2;

import java.util.Vector;

public class EntityManager {
    private Vector<ModelEntity> loadedEntities = new Vector<ModelEntity>();

    public EntityManager() {
    }

    public void addtocommandlist(ModelEntity m) {
        loadedEntities.add(m);
    }

    public void display(GL2 gl) {
        for (ModelEntity Entity : loadedEntities) {
            gl.glPushMatrix();
            gl.glTranslatef((float) Entity.getPos().x, (float) Entity.getPos().y, (float) Entity.getPos().z);
            gl.glRotatef((float) Entity.getPitch(), 1, 0, 0);
            gl.glRotatef((float) Entity.getYaw(), 0, 1, 0);
            Entity.getModel().opengldraw(gl);
            gl.glPopMatrix();
        }
    }
}

