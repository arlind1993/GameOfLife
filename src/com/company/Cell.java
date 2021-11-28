package com.company;

import static com.company.Game.ROWS;

public class Cell {
    boolean alive;
    int pX;
    int pY;
    int aliveNeighbours;
    Cell(int pX, int pY) {
        this.pX = pX;
        this.pY = pY;
    }

    public int getpX() {
        return pX;
    }

    public int getpY() {
        return pY;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    static void updateNeighbours(Cell[][] cells) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < Game.COLS; j++) {
                int neighbours=0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (k==0&&l==0){
                            continue;
                        }
                        if(((i+k)>0)&&((i+k)<(Game.ROWS-1))&&
                                ((j+l)>0)&&((j+l)<(Game.COLS-1)))
                            if(cells[i+k][j+l].alive){
                                neighbours++;
                            }
                    }
                }
                cells[i][j].aliveNeighbours=neighbours;
            }
        }
    }
}