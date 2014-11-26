/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Kotak;

/**
 * Kelas ini digunakan untuk menambahkan dinding yang tidak bisa dilewati.
 * Tujuan pembuatan kelas ini adalah agar stage dapat ditambah bila diperlukan.
 * 
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class LantaiIsi extends Lantai {
    
    @Override
    public void isi() {
        this.isiLantaiKosong();
        this.isiLantaiIsi();
    }
    
    /**
     * Method untuk mengisi lantai, bila "o" kosong dan "x" sudah terisi
     *
     * @param tidak ada
     * @return tidak ada karena bertipe void
     */
    private void isiLantaiIsi() {
        for (int i = 1; i < 4; i++) {
            this.papan[i][4] = "X";
            this.papan[i][6] = "X";
        }
        this.papan[2][2] = "X";
        for (int j = 1; j < 10; j++) {
            if (j != 1 && j != 5 && j != 8 && j != 9) {
                this.papan[3][j] = "X";
            }
        }
        for (int k = 4; k < 7; k++) {
            this.papan[k][2] = "X";
        }
        this.papan[6][3] = "X";
        this.papan[6][4] = "X";
        this.papan[4][7] = "X";
        this.papan[4][9] = "X";
        this.papan[2][8] = "X";
        for (int u = 6; u < 8; u++) {
            this.papan[6][u] = "X";
        }
        this.papan[6][5] = "X";
        this.papan[6][7] = "X";
        this.papan[6][8] = "X";
        this.papan[7][7] = "X";
        this.papan[7][8] = "X";
        for (int o = 2; o < 5; o++) {
            this.papan[8][o] = "X";
        }
        this.papan[8][8] = "X";
        this.papan[8][9] = "X";
        this.papan[9][1] = "X";
        this.papan[9][6] = "X";
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i==0 || i==10) {
                    this.papan[i][j] = "X";
                }
                else if (j==0 || j==10) {
                    this.papan[i][j] = "X";
                }
            }
        }
    }
}