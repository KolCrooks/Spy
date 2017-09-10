package com.NemianStudios.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyBoard implements KeyListener {

    public static class keys {
        public static boolean w;
        public static boolean a;
        public static boolean s;
        public static boolean d;

    }

    keys Keys;

    public keyBoard() {
        Keys = new keys();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Key Pressed
        switch (e.getKeyChar()) {
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
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void update() {
        MovementManager.Command command = new MovementManager.Command();
        command.addcommand(MovementManager.Command.MOVECAMERAPOSTION);
        if (keys.w) {
            command.Move(0, 1, 0);
        }
        if (keys.a) {
            command.Move(1, 0, 0);
        }
        if (keys.s) {
            command.Move(0, -1, 0);
        }
        if (keys.d) {
            command.Move(-1, 0, 0);
        }


    }
}
