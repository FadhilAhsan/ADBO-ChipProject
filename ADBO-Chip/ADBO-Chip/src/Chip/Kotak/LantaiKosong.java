/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Kotak;

/**
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella (2013730071)
 */
public class LantaiKosong extends Kotak {

    public LantaiKosong(int size) {
        super(size);
    }

    @Override
    public boolean status() {
        return true;
    }

    @Override
    public void isi() {
       for(int i =0; i< this.papan.length;i++)
       {
           for(int j= 0; j<this.papan.length;j++)
           {
               this.papan[i][j]="O";
           }
       }
    }
    

}
