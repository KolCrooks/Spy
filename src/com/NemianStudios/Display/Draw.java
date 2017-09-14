package com.NemianStudios.Display;

public class Draw {


    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final gl =drawable.getGL().get();

        // get the OpenGL 2 graphics object
        if(height <= 0) height = 1;

        // display area to cover the entire window
        glViewport(0, 0, width, height);

        //transforming projection matrix
        glMatrixMode(.GL_PROJECTION)
        glLoadIdentity();
        camera.init(glu);
        //transforming model view glLoadIdentity();
        glMatrixMode(.GL_MODELVIEW)
        glLoadIdentity();
    }

    private void setLight(gl) {

        glEnable(.GL_LIGHTING)

        float SHINE_ALL_DIRECTIONS = 1;
        float[] lightPos = {-30, 30, 30, SHINE_ALL_DIRECTIONS};
        float[] lightColorAmbient = {0.02f, 0.02f, 0.02f, 1f};
        float[] lightColorSpecular = {0.9f, 0.9f, 0.9f, 1f};

        // Set light parameters.
        glLightfv(.GL_LIGHT1, GL_POSITION, lightPos, 0)
        glLightfv(.GL_LIGHT1, GL_AMBIENT, lightColorAmbient, 0)
        glLightfv(.GL_LIGHT1, GL_SPECULAR, lightColorSpecular, 0)
        glLightfv(.GL_LIGHT1, GL_DIFFUSE, lightColorSpecular, 0)
        glEnable(.GL_LIGHT1)

    }
}
