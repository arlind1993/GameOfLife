package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
    Game game;
    public MouseHandler(Game game) {
        this.game= game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        check(e);
        int aX=e.getX()/Game.SIZE;
        int aY=e.getY()/Game.SIZE;

        System.out.println("N: "+game.cells[aY][aX].aliveNeighbours);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        check(e);

    }

    private void check(MouseEvent e) {
        int aX=e.getX();
        int aY=e.getY();

        if (game.kl.keys.get(4).hold) {
            //System.out.println(aX+" "+aY);
            game.cells[aY/Game.SIZE][aX/Game.SIZE].alive=true;
            Cell.updateNeighbours(game.cells);
        }
        if (game.kl.keys.get(5).hold) {
            game.cells[aY/Game.SIZE][aX/Game.SIZE].alive=false;
            Cell.updateNeighbours(game.cells);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
