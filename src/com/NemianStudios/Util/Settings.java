package com.NemianStudios.Util;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.sql.Struct;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;


public class Settings {

    final private static Charset ENCODING = StandardCharsets.UTF_8;
    private String endl = System.getProperty("line.separator");

    public class GameSettingsStruct{
        public int HEIGHT;
        public int WIDTH;
        boolean FULLSCREEN;
    }

    private String[] Settings_Default = {
      "Height = 600" + endl,       //Data[0]
      "Width = 800" + endl,        //Data[1]
      "Fullscreen = false" + endl, //Data[2]
    };
    public static GameSettingsStruct gameSettings;

    private List<String> settings;

    private Path p = Paths.get("./Settings.txt");


    public void initSettings(){
        gameSettings = new GameSettingsStruct();
        byte data[] = stringarrtobytes(Settings_Default);
        //Find Settings File
        try {
            settings = Read(p.toString());

        }catch(IOException e){
        //Create Settings File if it didn't find one
            System.out.println("Generating new settings file");
                try (OutputStream out = new BufferedOutputStream(
                        Files.newOutputStream(p, CREATE, APPEND))) {
                    out.write(data, 0, data.length);

                } catch (IOException x) { }
            System.out.println("Done creating settings file");
            try {
                settings = Read(p.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    }

    private byte[] stringarrtobytes(String[] s){
        String full = "";
        for(String st : s){
            full += st;
        }
        return full.getBytes();
    }

    public void parseSettings(){
        for(String s : settings){
            switch(s.split(" ")[0].toLowerCase()){
                case "height":
                    gameSettings.HEIGHT = Integer.parseInt(s.split(" ")[2]);
                    break;
                case "width":
                    gameSettings.WIDTH = Integer.parseInt(s.split(" ")[2]);
                    break;
                case "fullscreen":
                    gameSettings.FULLSCREEN = Boolean.parseBoolean(s.split(" ")[2]);
                    break;
            }
        }
    }

    private List<String> Read(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }
}
