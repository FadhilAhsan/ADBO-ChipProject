/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip.Kotak;

import java.util.Random;

/**
 *
 * @author asus
 */
public class Addition extends Kotak {

    protected int banyakIC;
    protected Lantai l;
    private String[][] copyPapan;
    
    public Addition(Lantai lantai) {
        this.banyakIC = 10;
        this.l=lantai;
    }
    
    public void copyPapan()
    {
        this.copyPapan=this.l.getPapan();
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
    }

    private void isiFinish1() {
        this.copyPapan[0][4]="W";
    }

    private void isiBarrier1() {
        this.copyPapan[1][4]="=";
    }

    private void isiIC() {
        int count=0;
        for (int i = 0; i < this.banyakIC; i++) {
            Random randrow = new Random();
            Random randcol = new Random();
            int row = randrow.nextInt(8);
            int col = randcol.nextInt(8);
            if (this.copyPapan[row][col].equals("O")) {
                this.copyPapan[row][col]="C";
                count++;
            }
        }
        this.banyakIC=count;
    }
}
