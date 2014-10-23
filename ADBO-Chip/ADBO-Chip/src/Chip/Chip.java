/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;

import Chip.Kotak.*;

/**
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071)
 */
public class Chip {

    protected int row;
    protected int col;
    protected Addition add;
    protected String[][] papanPermainan;

    public Chip(Addition add) {
        this.row = 0;
        this.col = 2;
        this.add = add;
        this.papanPermainan = add.getPapan();
        this.papanPermainan[row][col] = "?";
    }

    public void move(int direction) {
        boolean temp = this.moveBoolean(direction);
        if (this.moveBoolean(direction)==true) {
            switch (direction) {
                case 2:
                    this.row++;
                    break;
                case 4:
                    this.col--;
                    break;
                case 6:
                    this.col++;
                    break;
                case 8:
                    this.row--;
                    break;
            }
        } 
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private boolean moveBoolean(int direction) {
        boolean bool = true;
        if (direction == 2) {
            int simpan = this.getRow() + 1;
            
            if (simpan > papanPermainan.length-1) {
                bool = false;
            }
            else {
                if (papanPermainan[simpan][col].equals("O")) {
                    bool = true;
                } else if (papanPermainan[simpan][col].equals("X")) {
                    bool = false;
                } 
            }
            
        } else if (direction == 8) {
            int simpan = this.getRow() - 1;
            if (simpan < 0) {
                bool = false;
            }
            else {
                if (papanPermainan[simpan][col].equals("O")) {
                    bool = true;
                } else if (papanPermainan[simpan][col].equals("X")) {
                    bool = false;
                } else if (papanPermainan[simpan][col].equals("=")) {
                    bool=false;
                }
            }
            
        } else if (direction == 4) {
            int simpan = this.getCol() - 1;
            if (simpan < 0) {
                bool = false;
            }
            else {
                if (papanPermainan[row][simpan].equals("O")) {
                    bool = true;
                } else if (papanPermainan[row][simpan].equals("X")) {
                    bool = false;
                }
            }
            
        } else {
            int simpan = this.getCol() + 1;
            if (simpan > papanPermainan.length-1) {
                bool = false;
            }
            else {
                if (papanPermainan[row][simpan].equals("O")) {
                    bool = true;
                } else if (papanPermainan[row][simpan].equals("X")) {
                    bool = false;
                }
            }
        }
        return bool;
    }
}
