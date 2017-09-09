package com.NemianStudios;

import com.NemianStudios.Display.Window;
import com.NemianStudios.Util.Settings;
public class Main {
    public static Settings settings;
    public static void main(String[] args) {
        settings = new Settings();
        settings.initSettings();
        settings.parseSettings();
        Window mainWindow = new Window();

    }
}
