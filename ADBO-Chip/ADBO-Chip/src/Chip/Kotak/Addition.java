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
    
    public Addition() {
        this.banyakIC = 10;
        l=new Lantai();
    }
    
    public void copyPapan()
    {
        for(int i =0; i<l.papan.length;i++)
        {
            System.arraycopy(l.papan[i], 0, this.papan[i], 0, l.papan.length);
        }
    }

    @Override
    public boolean status(int row, int col) {
        if (this.papan[row][col].equals("W")) {
            return true;
        } else if (this.papan[row][col].equals("=")) {
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
        this.papan[0][4] = "W";
    }

    private void isiBarrier1() {
        this.papan[1][4] = "=";
    }

    private void isiIC() {
        int count=0;
        for (int i = 0; i < this.banyakIC; i++) {
            Random randrow = new Random();
            Random randcol = new Random();
            int row = randrow.nextInt(8);
            int col = randcol.nextInt(8);
            if (this.papan[row][col].equals("O")) {
                this.papan[row][col]="C";
                count++;
            }
        }
        this.banyakIC=count;
    }
}
