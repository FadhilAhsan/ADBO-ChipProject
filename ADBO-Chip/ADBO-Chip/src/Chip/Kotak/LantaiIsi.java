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
        for (int i = 0; i < 3; i++) {
            this.papan[i][3] = "X";
            this.papan[i][5] = "X";
        }
        this.papan[1][1] = "X";
        for (int j = 0; j < 9; j++) {
            if (j != 0 && j != 4 && j != 7 && j != 8) {
                this.papan[2][j] = "X";
            }
        }
        for (int k = 3; k < 6; k++) {
            this.papan[k][1] = "X";
        }
        this.papan[5][2] = "X";
        this.papan[3][6] = "X";
        this.papan[3][7] = "X";
        for (int u = 5; u < 8; u++) {
            this.papan[5][u] = "X";
        }
        this.papan[6][5] = "X";
        this.papan[6][7] = "X";
        this.papan[7][7] = "X";
        this.papan[7][8] = "X";
        for (int o = 1; o < 4; o++) {
            this.papan[7][o] = "X";
        }
        this.papan[8][0] = "X";
        this.papan[8][5] = "X";
    }
}