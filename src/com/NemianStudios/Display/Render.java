package com.NemianStudios.Display;

import com.NemianStudios.Entitys.EntityManager;
import com.NemianStudios.Input.MovementManager;
import org.joml.Vector3f;

import static org.lwjgl.opengl.GL11.*;

public class Render {

    public Camera camera;
    public MovementManager movementManager;
    public EntityManager entityManager;

    public Render() {
        //TODO replace the pos with player object
        camera = new Camera(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0));
        movementManager = new MovementManager();
        entityManager = new EntityManager();
    }

    public void init() {
        glEnable(GL_DEPTH_TEST);
        glShadeModel(GL_SMOOTH);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glEnable(GL_CULL_FACE);
        glEnable(GL_NORMALIZE);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        setLight(gl);
        // method body
        camera.init();
        ModelEntity e = new ModelEntity();
        e.loadobject(gl, "D:\\Documents\\Models\\House\\House.obj", "D:\\Documents\\Models\\House\\House.mtl");
        e.setScaler(100000000.f);
//        e.setPitch(-90);
//        ModelEntity e2 = new ModelEntity();
//        e2.loadobject(gl, "C:\\Users\\kol\\Desktop\\Map File type\\XYZ.obj", "C:\\Users\\kol\\Desktop\\Map File type\\XYZ.mtl");
//        e2.setScaler(100.0f);
//        entityManager.addtocommandlist(e2);
        entityManager.addtocommandlist(e);
    }

    public void update() {
        glLoadIdentity();
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
        camera.updateCamera();
        glPushMatrix();
        movementManager.update(camera);
        entityManager.display();
        Window.keyboard.update();

        glPopMatrix();

        glFlush();
    }

    public void Lighting() {

    }
}
