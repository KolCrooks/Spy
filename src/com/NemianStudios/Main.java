package com.NemianStudios;

import com.NemianStudios.Display.Window;
import com.NemianStudios.Util.Settings;
public class Main {
    public static Settings settings;
    public static Window mainWindow;

    public static void main(String[] args) {
        settings = new Settings();
        settings.initSettings();
        settings.parseSettings();
        mainWindow = new Window();

    }
    public static long getWindow(){
        return mainWindow.window;
    }
}
