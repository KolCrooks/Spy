package com.NemianStudios.Input;

import com.NemianStudios.Display.DrawListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyBoard implements KeyListener {

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

    @Override
    public void keyPressed(KeyEvent e) {
        //Key Pressed
        switch (Character.toLowerCase(e.getKeyChar())) {
            case 'w':
                keys.w = true;
                break;

            case 'a':
                keys.a = true;
                break;

            case 's':
                keys.s = true;
                break;

            case 'd':
                keys.d = true;
                break;
        }
        switch (e.getKeyCode()) {
            case 32: //SPACE bar
                keys.SPACE = true;
                break;
            case 16: //SHIFT bar
                keys.SHIFT = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                keys.w = false;
                break;

            case 'a':
                keys.a = false;
                break;

            case 's':
                keys.s = false;
                break;

            case 'd':
                keys.d = false;
                break;

            case ' ':
                keys.SPACE = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

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
        DrawListener.movementManager.addtocommandlist(command);

    }
}
