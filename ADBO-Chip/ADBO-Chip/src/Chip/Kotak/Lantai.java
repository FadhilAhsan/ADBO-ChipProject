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
     * "o::
     *
     * @param tidak ada
     * @return tidak ada karena bertipe void
     */
    protected void isiLantaiKosong() {
        for (int i = 0; i < this.papan.length; i++) {
            for (int j = 0; j < this.papan.length; j++) {
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
        chip.move(direction);
        this.papan[chip.getRow()][chip.getCol()] = "?";  
    }

    /**
     * Method untuk mengetahui apapkah chip telah menang atau tidak
     *
     * @param chip
     * @return true bile telah memenangkan game dan false bila sebaliknya
     */
    public String isFinished(Chip chip) {
        if (this.papan[0][4].equals("?")) {
            String temp = "WIN";
            return temp;

        } else if (this.papan[3][2].equals("?")) {
            if (chip.getStatusApi() == false) {
                String temp = "LOSE";
                return temp;
            }
        } else if (this.papan[4][2].equals("?")) {
            if (chip.getStatusApi() == false) {
                String temp = "LOSE";
                return temp;
            }
        } else if (this.papan[3][5].equals("?")) {
            if (chip.getStatusAir() == false) {
                String temp = "LOSE";
                return temp;
            }

        } else if (this.papan[2][7].equals("?")) {
            if (chip.getStatusAir() == false) {
                String temp = "LOSE";
                return temp;
            }
        }
        return "null";
    }
}
