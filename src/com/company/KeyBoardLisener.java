package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyBoardLisener implements KeyListener {
    Game game;
    ArrayList<MyKey> keys=new ArrayList<>();
    public KeyBoardLisener(Game game) {
        this.game=game;
        keys.add(new MyKey("run",KeyEvent.VK_R,false,false));
        keys.add(new MyKey("edit",KeyEvent.VK_E,false,false));
        keys.add(new MyKey("state",KeyEvent.VK_S,false,false));
        keys.add(new MyKey("next",KeyEvent.VK_N,false,false));
        keys.add(new MyKey("write",KeyEvent.VK_W,false,false));
        keys.add(new MyKey("delete",KeyEvent.VK_W,false,false));
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                keys.get(4).hold = false;
                break;
            case KeyEvent.VK_D:
                keys.get(5).hold = false;
                break;
            default:
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_R:
                keys.get(0).active=!keys.get(0).active;
                if (keys.get(0).active) {
                    keys.get(1).active = false;
                }
                break;
            case KeyEvent.VK_E:
                keys.get(1).active=!keys.get(1).active;
                if (keys.get(1).active) {
                    keys.get(0).active = false;
                    keys.get(2).active = false;
                }
                break;
            case KeyEvent.VK_S:

                keys.get(2).active=!keys.get(2).active;
                if (keys.get(0).active) {
                    keys.get(1).active = false;
                }
                break;
            case KeyEvent.VK_N:
                if(keys.get(2).active) {
                    keys.get(3).active = true;
                }
                break;
            case KeyEvent.VK_W:
                if(keys.get(1).active){
                    keys.get(4).hold=true;
                }
                break;
            case KeyEvent.VK_D:
                if(keys.get(1).active){
                    keys.get(5).hold=true;
                }
                break;
            default:
                break;

        }
    }


}
