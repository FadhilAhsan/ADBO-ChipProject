package Chip.Kotak;

import Chip.Chip;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Kelas yang merepresentasikan kumpulan kotak pada papan permainan
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella 
 * (2013730071).
 */
public abstract class Kotak {
    
    protected String[][] papan; // attribut papan permainan berupa array 2 dimensi
    
    public Kotak()
    {
        this.papan=new String[11][11]; // ukuran papan 11x11
    }
    
    /**
     * Method mendapatkan status pada kotak dengan posisi row dan col tertentu dan merupakan method abstract
     * @param row baris pada papan
     * @param col column pada papan
     * @return status kotak
     */
    public abstract boolean status(int row, int col);
    
    /**
     * Method untuk mengisi papan permainan dan merupakan method abstract
     * @param tidak ada
     * @return tidak ada karena bertipe void
     * 
     */
    public abstract void isi();
    
    /**
     * Method untuk mencetak lantai pada papan permainan
     * @param tidak ada
     * @return tidak ada karena bertipe void
     */
    public void printLantai()
    {
        for(int i =0; i< this.papan.length;i++)
        {
            for(int j =0; j< this.papan.length;j++)
            {
                System.out.print(this.papan[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    /**
     * Method getter pada papan permainan berupa array 2 dimensi dan merupakan method abstract
     * @param tidak ada
     * @return papan
     */
    public abstract String[][] getPapan();
    
    /**
     * Method abstract untuk mengupdate sebuah lantai
     * @param chip
     * @param direction dari chip
     * @return tidak ada karena bertipa void
     */
    public abstract void updateLantai(Chip chip,int direction);
}
