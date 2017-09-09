package com.NemianStudios.Entitys;

import com.NemianStudios.Base.customDataTypes.Model;
import com.NemianStudios.Base.customDataTypes.ModelLoadException;
import com.NemianStudios.Util.WaveFrontLoader;
import com.jogamp.opengl.GL2;

public class ModelEntity {

    private Model model;

    public void loadobject(String uri){
        WaveFrontLoader loader = new WaveFrontLoader();
        try {
            this.model = loader.load(uri);
        }catch(ModelLoadException e){
            e.printStackTrace();
        }
    }

    protected void update(){

    }
    protected void draw(GL2 gl){

    }

}
