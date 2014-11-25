/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip.Kotak;

import Chip.Chip;
import java.util.Random;

/**
 * Kelas untuk meimplementasikan elemen pada papan permainan dan sub-class dari Kotak
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella 
 * (2013730071).
 */
public class Addition extends Kotak {

    protected int banyakIC; //attribut jumlah IC
    protected Lantai l; //attribut lantai pada papan permainan
    private String[][] copyPapan; // attribut representasi dari papan permainan

    public Addition(Lantai lantai) {
        this.banyakIC = 10;
        this.l = lantai;
    }

    /**
     * Method untuk mencetak papan permainan dengan lantai
     */
    public void copyPapan() {
        this.copyPapan = this.l.getPapan();
    }

    /**
     * Method untuk mencek apakah papan masih kosong atau tidak
     * @param row baris pada papan
     * @param col columnn pada papan
     * @return true bila masih kosong dan false sebaliknya
     */
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

    /**
     * Method untuk memasukan elemen pada papan
     * @param tidak ada
     * @return tida ada karena bertipe void
     */
    @Override
    public void isi() {
        this.isiFinish1();
        this.isiBarrier1(); 
        this.isiFire();
        this.isiWater();
        this.isiSepatu();
        this.isiIC();
    }

    /**
     * Method untuk menset baris ke 0 dan col 4 pada papan berisi water
     * @param tidak ada
     * @return tidak ada
     */
    private void isiFinish1() {
        this.copyPapan[1][5] = "W";
    }

    /**
     * Method untuk memasukan barrier pada papan baris ke 1 dan col ke 4
     * @param tidak ada
     * @return tidak ada
     */
    private void isiBarrier1() {
        this.copyPapan[2][5] = "=";
    }

    /**
     * Method untuk meimplementasi IC pada papan secara random dan menghitung jumlah IC
     * @param tidak ada
     * @return tidak ada
     */
    private void isiIC() {
        int count = 0;
        this.copyPapan[9][2]="C";
        this.copyPapan[2][7]="C";
        this.copyPapan[3][9]="C";
        count=3;
        for (int i = 0; i < this.banyakIC; i++) {
            Random randrow = new Random();
            Random randcol = new Random();
            int row = randrow.nextInt(10);
            int col = randcol.nextInt(10);
            if (this.copyPapan[row][col].equals("O")) {
                 if (row!=1 &&col!=3) {
                    this.copyPapan[row][col] = "C";
                    System.out.println(row+"=R "+col+"=C");
                    count++; 
                }
            }
        }
        this.banyakIC = count;    
    }

    private void isiSepatu()
    {
        this.copyPapan[1][7]="SF";
        this.copyPapan[4][3]="SF";
        this.copyPapan[9][9]="SA";
        this.copyPapan[7][9]="SA";
    }
    /**
     * Method untuk memperoleh papan permainan dalam bentuk array 2 dimensi
     * @param tidak ada
     * @return copyPapan
     */
    @Override
    public String[][] getPapan() {
        return this.copyPapan;
    }

    /**
     * Method untuk mengupdate lantai sesuai dengan pergerakan chip dan jumlah IC akan berkurang
     * @param chip pemain dalam game
     * @param direction bila 2 chip akan bergerak turun, 4 akan bergerak ke kiri, 6 ke kanan, dan 8 akan naik
     */
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
            this.copyPapan[2][5]="O";
            this.l.setPapan("O", 2, 5);
        }
    }
    
    /**
     * Method untuk mencek status papan masih kosong atau tidak
     * @param tidak ada
     * @return bool 
     */
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
    
    /**
     * Method untuk mengisi fire pada papan pada baris ke 3 col 2 dan baris ke 4 col 2
     * @param tidak ada
     * @return tidak ada karena bertipe void
     */
     private void isiFire()
    {
       this.copyPapan[9][4]="F";
       this.copyPapan[6][9]="F";
    }
     
     /**
      * Method untuk memasukan elemen water pada baris ke 3 dan col 5 dan baris ke 2 col 7
      * @param tidak ada
      * @return tidak ada karena bertipe void
      */
     private void isiWater()
     {
       this.copyPapan[6][5]="A";
       this.copyPapan[4][8]="A";
     }
     
     /**
      * method untuk mendpatkan informasi ada berapa banyak corn yang tersedia di papan
      * @return int yang menyatakan banyanya  corn yang ada di papan
      */
     public int getJumlahCorn(){
         return this.banyakIC;
     }
}
