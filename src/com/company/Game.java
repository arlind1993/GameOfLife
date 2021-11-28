package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {
    static final int ROWS=50;
    static final int COLS=100;
    static final int SIZE=10;
    static final int DELAY=50;
    Timer timer;

    Cell[][] cells=new Cell[ROWS][COLS];
    MouseHandler mh;
    KeyBoardLisener kl;
    public Game() {
        this.setPreferredSize(new Dimension(COLS * SIZE, ROWS * SIZE));
        this.setFocusable(true);
        mh=new MouseHandler(this);
        kl=new KeyBoardLisener(this);
        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);
        this.addKeyListener(kl);
        fillCells(cells);
        timer=new Timer(DELAY,this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        drawGrid(g);
        drawCells(g);

    }

    private void drawCells(Graphics g) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j].alive){
                    g.fillRect(cells[i][j].pX*Game.SIZE,cells[i][j].pY*Game.SIZE,Game.SIZE,Game.SIZE);
                }
            }
        }
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i <= COLS; i++) {
            g.drawLine(i * SIZE, 0, i * SIZE, ROWS*SIZE);
        }
        for (int i = 0; i <= ROWS; i++) {
            g.drawLine(0, i*SIZE, COLS*SIZE, i*SIZE);
        }
    }

    public void move(){
        Cell[][] temp=new Cell[ROWS][COLS];
        fillCells(temp);
        System.out.println("Moving!!");
        Cell.updateNeighbours(cells);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (cells[i][j].alive){
                    if (cells[i][j].aliveNeighbours>=2&&cells[i][j].aliveNeighbours<=3){
                        temp[i][j].alive=true;
                    }else{
                        temp[i][j].alive=false;
                    }
                }else{
                    if (cells[i][j].aliveNeighbours==3){
                        temp[i][j].alive=true;
                    }else{
                        temp[i][j].alive=false;
                    }
                }
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j].alive=temp[i][j].alive;
            }
        }
    }
    void fillCells(Cell[][] input){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                input[i][j]=new Cell(j,i);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(kl.keys.get(0).name+": "+kl.keys.get(0).active+",  "+
                kl.keys.get(1).name+": "+kl.keys.get(1).active+",  "+
                kl.keys.get(2).name+": "+kl.keys.get(2).active+",  "+
                kl.keys.get(3).name+": "+kl.keys.get(3).active+",  "+
                kl.keys.get(4).name+": "+kl.keys.get(4).hold+",  "+
                kl.keys.get(5).name+": "+kl.keys.get(5).hold);
        if (kl.keys.get(0).active) {
            if (!kl.keys.get(2).active){
                move();
            }
        }
        if (kl.keys.get(2).active){
            if (kl.keys.get(3).active){
                kl.keys.get(3).active=false;
                move();
            }
        }
        repaint();
    }
}
