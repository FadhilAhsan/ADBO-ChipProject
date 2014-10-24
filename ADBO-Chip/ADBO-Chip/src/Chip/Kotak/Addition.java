/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip.Kotak;

import Chip.Chip;
import java.util.Random;

/**
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella 
 * (2013730071).
 */
public class Addition extends Kotak {

    protected int banyakIC;
    protected int banyakFire;
    protected Lantai l;
    private String[][] copyPapan;

    public Addition(Lantai lantai) {
        this.banyakIC = 10;
        this.banyakFire=2;
        this.l = lantai;
    }

    public void copyPapan() {
        this.copyPapan = this.l.getPapan();
    }

    @Override
    public boolean status(int row, int col) {
        if (this.copyPapan[row][col].equals("W")) {
            return true;
        } else if (this.copyPapan[row][col].equals("=")) {
            if (this.banyakIC == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void isi() {
        this.isiFinish1();
        this.isiBarrier1();
        this.isiIC();
        this.isiFire();
    }

    private void isiFinish1() {
        this.copyPapan[0][4] = "W";
    }

    private void isiBarrier1() {
        this.copyPapan[1][4] = "=";
    }

    private void isiIC() {
        int count = 0;
        for (int i = 0; i < this.banyakIC; i++) {
            Random randrow = new Random();
            Random randcol = new Random();
            int row = randrow.nextInt(8);
            int col = randcol.nextInt(8);
            if (this.copyPapan[row][col].equals("O")) {
                this.copyPapan[row][col] = "C";
                count++;
            }
        }
        this.banyakIC = count;    
    }

    @Override
    public String[][] getPapan() {
        return this.copyPapan;
    }

    @Override
    public void updateLantai(Chip chip, int direction) {
        int panjang = this.copyPapan.length;
        if (direction == 2) {
            if (chip.getRow() + 1 < panjang) {
                if (this.copyPapan[chip.getRow() + 1][chip.getCol()].equals("C")) {
                    this.banyakIC--;
                } 
            }
        } else if (direction == 8) {
            if (chip.getRow() - 1 > 0) {
                if (this.copyPapan[chip.getRow() - 1][chip.getCol()].equals("C")) {
                    this.banyakIC--;
                } 
            }
        } else if (direction == 4) {
            if (chip.getCol() - 1 > 0) {

                if (this.copyPapan[chip.getRow()][chip.getCol() - 1].equals("C")) {
                    this.banyakIC--;
                }
            }
        } else {
            if(chip.getCol()+1 <panjang)
            {
                if (this.copyPapan[chip.getRow()][chip.getCol() + 1].equals("C")) {
                    this.banyakIC--;
                }
            }
        }
        
        if(this.banyakIC==0 || this.check()==true)
        {
            this.copyPapan[1][4]="O";
            this.l.setPapan("O", 1, 4);
        }
    }
    
    private boolean check()
    {
        boolean bool=true;
        for(int i=0; i<this.copyPapan.length;i++)
        {
            for(int j =0; j< this.copyPapan.length; j++)
            {
                if(this.copyPapan[i][j].equals("C"))
                {
                    bool=false;
                }
            }
        }
        return bool;
    }
    
    private void isiFire()
    {
        for (int i = 0; i < this.banyakFire; i++) {
            Random randrow = new Random();
            Random randcol = new Random();
            int row = randrow.nextInt(1)+3;
            int col = randcol.nextInt(1)+2;
            if (this.copyPapan[row][col].equals("O")) {
                this.copyPapan[row][col] = "F";
            }
        }   
    }
}
