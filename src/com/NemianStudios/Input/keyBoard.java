package com.NemianStudios.Input;

import com.NemianStudios.Display.Draw;
import org.lwjgl.glfw.GLFWKeyCallback;



public class keyBoard extends GLFWKeyCallback {

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        //Key Pressed

    }

    public static class keys {
        public static boolean w;
        public static boolean a;
        public static boolean s;
        public static boolean d;
        public static boolean SPACE;
        public static boolean SHIFT;
    }

    keys Keys;

    public keyBoard() {
        Keys = new keys();
    }

    public void update() {
        if (!keys.w && !keys.a && !keys.s && !keys.d) {
            return;
        }
        MovementManager.Command command = new MovementManager.Command();
        command.addcommand(MovementManager.Command.MOVECAMERAPOSTION);
        if (keys.w) {
            command.Move(0, 0, 1);
        }
        if (keys.a) {
            command.Move(1, 0, 0);
        }
        if (keys.s) {
            command.Move(0, 0, -1);
        }
        if (keys.d) {
            command.Move(-1, 0, 0);
        }
        if (keys.d) {
            command.Move(-1, 0, 0);
        }
        if (keys.SPACE) {
            command.Move(0, 1, 0);
        }
        if (keys.SHIFT) {
            command.Move(0, -1, 0);
        }
        Draw.movementManager.addtocommandlist(command);

    }
}
