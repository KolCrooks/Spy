package com.NemianStudios.Display;

import com.NemianStudios.Util.Settings;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

public class resizeEvent extends GLFWWindowSizeCallback {

    Vector2f windowSize = new Vector2f(Settings.gameSettings.WIDTH, Settings.gameSettings.HEIGHT);

    @Override
    public void invoke(long window, int width, int height) {
        windowSize.x = width;
        windowSize.y = height;
    }

    public Vector2f getWindowSize() {
        return windowSize;
    }
}
