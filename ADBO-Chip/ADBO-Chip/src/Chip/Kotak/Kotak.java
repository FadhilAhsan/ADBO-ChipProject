package Chip.Kotak;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella (2013730071).
 */
public abstract class Kotak {
    
    protected String[][] papan;
    
    public Kotak(int size)
    {
        this.papan=new String[size][size];
    }
    
    public abstract boolean status();
    
    public abstract void isi();
    
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
}
