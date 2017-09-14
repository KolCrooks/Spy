package com.NemianStudios.Entitys;

import java.util.Vector;

import static org.lwjgl.opengl.GL11.*;

public class EntityManager {
    private Vector<ModelEntity> loadedEntities = new Vector<ModelEntity>();

    public EntityManager() {
    }

    public void addtocommandlist(ModelEntity m) {
        loadedEntities.add(m);
    }

    public void display() {
        for (ModelEntity Entity : loadedEntities) {
            glPushMatrix();
            glTranslatef((float) Entity.getPos().x, (float) Entity.getPos().y, (float) Entity.getPos().z);
            glRotatef((float) Entity.getPitch(), 1, 0, 0);
            glRotatef((float) Entity.getYaw(), 0, 1, 0);
            Entity.getModel().opengldraw(); //TODO: replace this with real draw entity() + logic for weither to draw an enitity
            glPopMatrix();
        }
    }
}

