/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip.Kotak;

import Chip.Chip;

/**
 * Kelas sub-class dari sebuah Kotak pada papan permainan
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class Lantai extends Kotak {
    
    /**
     * countFire1 menandai apakah lantai yang berisi api sudah pernah di lewati atau belum 
     */
    private int countFire1=0;
    
    /**
     * countFire2 menandai apakah lantai yang berisi api sudah pernah di lewati atau belum 
     */
    private int countFire2=0;
    
    /**
     * countFire1 menandai apakah lantai yang berisi api sudah pernah di lewati atau belum 
     */
    private int countWater1=0;
    
    /**
     * countFire1 menandai apakah lantai yang berisi api sudah pernah di lewati atau belum 
     */
    private int countWater2=0;
    
    /**
     * isFinish manandai apakah chip's sudah berada di kotak finish atau belum;
     */
    private boolean isFinish=false;
    
    /**
     * Method untuk mencek status lantai masih "o" (kosong) atau sudah terisi
     *
     * @param row baris pada papan permainan
     * @param col column pada papan permainan
     * @return true bila masih kosong dan false sebaliknya
     */
    @Override
    public boolean status(int row, int col) {
        if (this.papan[row][col].equals("O")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method untuk mengisi lantai pada papan permainan
     *
     * @param tidak ada
     * @return tidak ada karena bertipe void
     */
    @Override
    public void isi() {
        this.isiLantaiKosong();
    }

    /**
     * Method untuk mencetak papah dengan lantai kosong yang diberi tanda string
     * "O"
     *
     * @param tidak ada
     * @return tidak ada karena bertipe void
     */
    protected void isiLantaiKosong() {
        for (int i = 0; i < this.papan.length; i++) {
            for (int j = 0; j < this.papan[0].length; j++) {
                this.papan[i][j] = "O";
            }
        }
    }

    /**
     * Method getter dari papan permainan dan bertipe array 2 dimensi
     *
     * @param tidak ada
     * @return papan
     */
    public String[][] getPapan() {
        return this.papan;
    }

    /**
     * Method setter pada papan permainan
     *
     * @param input berupa elemen maupun chip
     * @param row baris pada papan permainan
     * @param col column pada papan permainan
     * @return tidak ada karena bertipe void
     */
    public void setPapan(String input, int row, int col) {
        this.papan[row][col] = input;
    }

    /**
     * Method untuk menset papan permainan
     *
     * @param input berupa array 2 dimensi
     * @return tidak ada karena bertipe void
     */
    public void setPapan2(String[][] input) {
        this.papan = input;
    }

    /**
     * Method untuk mengupdate isi lantai dan chip Bila kosong akan diberi tanda
     * "o" dan chip sebagai "?"
     *
     * @param chip
     * @param direction arah dari chip
     * @return tidak ada karena bertipe void
     */
    @Override
    public void updateLantai(Chip chip, int direction) {
        this.papan[chip.getRow()][chip.getCol()] = "O";
        if (direction==0) {
            this.papan[1][5]="W";
        }
        else if (direction==10) {
            this.papan[chip.getRow()][chip.getCol()]="Z";
        }
        else{
            chip.move(direction);
            this.papan[chip.getRow()][chip.getCol()] = "?";
        }
    }

    /**
     * Method untuk mengetahui apapkah chip telah menang atau tidak
     *
     * @param chip
     * @return true bile telah memenangkan game dan false bila sebaliknya
     */
    public String isFinished(Chip chip) {
        if (isFinish==true) {
            this.papan[1][5]="?";
        }
        
        if (this.papan[6][5].equals("Z")) {
            this.papan[6][5]="?";
        }
        
        if (this.papan[4][8].equals("Z")) {
            this.papan[4][8]="?";
        }
        
        if (this.papan[1][5].equals("?")) {
            String temp = "WIN";
            if (isFinish==false) {
                this.papan[1][5]="W";
                isFinish=true;
            }
            return temp;

        } else if (this.papan[6][9].equals("?")) {
             if (countFire1==0) {
                if (chip.getStatusApi() == false) {
                    String temp = "LOSE";
                    return temp;
                }
                else{
                    chip.pasanglepasSepatu(3);
                    countFire1++;
                    return "null";
                }
            }
        } else if (this.papan[9][4].equals("?")) {
            if (countFire2==0) {
                if (chip.getStatusApi() == false) {
                    String temp = "LOSE";
                    return temp;
                }
                else{
                    chip.pasanglepasSepatu(3);
                    countFire2++;
                    return "null";
                }
            }
        } else if (this.papan[4][8].equals("?")) {
            if (countWater1==0) {
                if (chip.getStatusAir() == false) {
                    String temp = "LOSE";
                    this.papan[4][8]="Z";
                    return temp;
                }
                else{
                    chip.pasanglepasSepatu(3);
                    countWater1++;
                    return "null";
                }
            }

        } else if (this.papan[6][5].equals("?")) {
            if (countWater2==0) {
                if (chip.getStatusAir() == false) {
                    String temp = "LOSE";
                    this.papan[6][5]="Z";
                    return temp;
                }
                else{
                    chip.pasanglepasSepatu(3);
                    countWater2++;
                    return "null";
                }
            }
            
        }
        return "null";
    }
}
