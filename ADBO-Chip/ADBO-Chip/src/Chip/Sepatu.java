/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;

import Chip.Kotak.Addition;

/**
 * Kelas yang merepresentasikan sepatu pada game
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public abstract class Sepatu {

    public abstract boolean ubahStatus(int masukan); //method untuk mengecek sepatu Api atau sepatu Air yang dimasukan

    public abstract String notification(boolean status); // method untuk mencetak sepatu pada papan permainan
}
