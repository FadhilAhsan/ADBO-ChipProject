/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;

import Chip.Kotak.*;

/**
 * Kelas yang merepresentasikan chip pada game
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class Chip {

    protected int row;  // posisi chip pada baris tertentu
    protected int col;  // posisi chip pada kolom tertentu
    protected Addition add; // attribut untuk menambahkan chip
    protected String[][] papanPermainan; // attribut merepresentasikan papan permainan pada game
    protected Sepatu sep; // attribut elemen sepatu 
    protected boolean statusSepatuApi; // attribut untuk mengecek status sepatu Api
    protected boolean statusSepatuAir; // attribut untuk mengecek status sepatu Air

    public Chip(Addition add) {
        this.row = 1;
        this.col = 3;
        this.add = add;
        this.papanPermainan = add.getPapan();
        this.papanPermainan[row][col] = "?";
    }

    /**
     * Method untuk menentukan arah gerak sebuah chip
     * @param direction , 2 akan turun, 4 akan ke kiri, 6 ke kanan, 8 akan naik
     * @return tidak ada nilai kembalian
     */
    public void move(int direction) {
        boolean temp = this.moveBoolean(direction);
        if (this.moveBoolean(direction) == true) {
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

    /**
     * Method untuk getter dari posisi row chip
     * @param : tidak ada
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Method untuk getter dari posisi column chip
     * @param tidak ada
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * Method untuk memperoleh status pergerakan chip, bila papan masih ada tempat dan kotak papan belum terisi apapun
     * 
     * @param direction 
     * @return bool ,status chip
     */
    private boolean moveBoolean(int direction) {
        boolean bool = true;
        if (direction == 2) {
            int simpan = this.getRow() + 1;

            if (simpan > papanPermainan.length - 1) {
                bool = false;
            } else {
                if (papanPermainan[simpan][col].equals("O")) {
                    bool = true;
                } else if (papanPermainan[simpan][col].equals("X")) {
                    bool = false;
                }
            }
            if(this.papanPermainan[simpan][col].equals("SF"))
            {
                this.pasanglepasSepatu(1);
            } else if(this.papanPermainan[simpan][col].equals("SA"))
            {
                this.pasanglepasSepatu(2);
            } else{
                
            }

        } else if (direction == 8) {
            int simpan = this.getRow() - 1;
            if (simpan < 0) {
                bool = false;
            } else {
                if (papanPermainan[simpan][col].equals("O")) {
                    bool = true;
                } else if (papanPermainan[simpan][col].equals("X")) {
                    bool = false;
                } else if (papanPermainan[simpan][col].equals("=")) {
                    bool = false;
                }
            }
            if(this.papanPermainan[simpan][col].equals("SF"))
            {
                this.pasanglepasSepatu(1);
            } else if(this.papanPermainan[simpan][col].equals("SA"))
            {
                this.pasanglepasSepatu(2);
            } else{
                
            }

        } else if (direction == 4) {
            int simpan = this.getCol() - 1;
            if (simpan < 0) {
                bool = false;
            } else {
                if (papanPermainan[row][simpan].equals("O")) {
                    bool = true;
                } else if (papanPermainan[row][simpan].equals("X")) {
                    bool = false;
                }
            }
            if(this.papanPermainan[row][simpan].equals("SF"))
            {
                this.pasanglepasSepatu(1);
            } else if(this.papanPermainan[row][simpan].equals("SA"))
            {
                this.pasanglepasSepatu(2);
            } else{
                
            }

        } else if(direction==6) {
            int simpan = this.getCol() + 1;
            if (simpan > papanPermainan.length - 1) {
                bool = false;
            } else {
                if (papanPermainan[row][simpan].equals("O")) {
                    bool = true;
                } else if (papanPermainan[row][simpan].equals("X")) {
                    bool = false;
                }
            }
            if(this.papanPermainan[row][simpan].equals("SF"))
            {
                this.pasanglepasSepatu(1);
            } else if(this.papanPermainan[row][simpan].equals("SA"))
            {
                this.pasanglepasSepatu(2);
            } else{
                
            }
        }else{
            bool=false;
        }
        return bool;
    }

    /**
     * Method untuk mengimplementasi sepatu
     * @param masukan , bila 1 akan dimasukan sepatuApi dan 2 akan dimasukan sepatuAir
     * @return tidak ada nilai kembalian
     */
    public void pasanglepasSepatu(int masukan) {
        if (masukan == 1) {
            this.sep = new SepatuApi();
            this.statusSepatuApi = sep.ubahStatus(masukan);
        } else if (masukan == 2) {
            this.sep = new SepatuAir();
            this.statusSepatuAir = sep.ubahStatus(masukan);
        } else {
            this.statusSepatuApi = false;
            this.statusSepatuAir = false;
        }
    }

    /**
     * Method getter status sepatu Api
     *@param tidak ada 
     * @return statusSepatuApi
     */
    public boolean getStatusApi() {
        return this.statusSepatuApi;
    }

    /**
     * Method untuk memperoleh status sepatu Air
     * @param tidak ada
     * @return statusSepatuAir
     */
    public boolean getStatusAir() {
        return this.statusSepatuAir;
    }

}
