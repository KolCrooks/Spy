package com.NemianStudios.Display;

import com.NemianStudios.Entitys.EntityManager;
import com.NemianStudios.Entitys.ModelEntity;
import com.NemianStudios.Input.MovementManager;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;


public class DrawListener implements GLEventListener {

    public static DisplayHandle Displayer;
    public static MovementManager movementManager;
    public static EntityManager entityManager;
    public static Camera camera;

    public GLU glu;

    public DrawListener(){
    //Add Display Handle
        glu = new GLU();
        Displayer = new DisplayHandle();
        movementManager = new MovementManager();
        entityManager = new EntityManager();
        camera = new Camera();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glLoadIdentity();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glClearColor(255.0f,255.0f,255.0f,1.0f);
        camera.updateCamera(gl, glu);
        gl.glPushMatrix();
        Displayer.update(gl);
        movementManager.update(camera);
        entityManager.display(gl);
        Window.keyboard.update();


        gl.glPopMatrix();

        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
        gl.glEnable(GL2.GL_CULL_FACE);
        gl.glEnable(GL2.GL_NORMALIZE);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        setLight(gl);
        // method body
        camera.init(glu);
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

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();

        // get the OpenGL 2 graphics object
        if(height <= 0) height = 1;

        // display area to cover the entire window
        gl.glViewport(0, 0, width, height);

        //transforming projection matrix
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        camera.init(glu);
        //transforming model view gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    private void setLight(GL2 gl) {

        gl.glEnable(GL2.GL_LIGHTING);

        float SHINE_ALL_DIRECTIONS = 1;
        float[] lightPos = {-30, 30, 30, SHINE_ALL_DIRECTIONS};
        float[] lightColorAmbient = {0.02f, 0.02f, 0.02f, 1f};
        float[] lightColorSpecular = {0.9f, 0.9f, 0.9f, 1f};

        // Set light parameters.
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_AMBIENT, lightColorAmbient, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_SPECULAR, lightColorSpecular, 0);
        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_DIFFUSE, lightColorSpecular, 0);
        gl.glEnable(GL2.GL_LIGHT1);

    }
}
