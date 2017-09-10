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
            Entity.getModel().opengldraw(gl);
        }
    }
}

