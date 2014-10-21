/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Kotak;

/**
 *
 * @author asus
 */
public class Lantai extends Kotak {

    @Override
    public boolean status(int row, int col) {
        if(this.papan[row][col].equals("O"))
        {
            return true;
        } else return false;
    }

    @Override
    public void isi() {
       this.isiLantaiKosong();
       this.isiLantaiIsi1();
    }
    
    private void isiLantaiKosong()
    {
        for(int i =0; i< this.papan.length;i++)
       {
           for(int j= 0; j<this.papan.length;j++)
           {
               this.papan[i][j]="O";
           }
       }
    }
    
     /**
     *  | O O O X O X O O O |
     *  | O X O X O X O O O |   O lantai kosong
     *  | O X X X O X X O O |   X lantai isi
     *  | O X O O O O X X O |
     *  | O X O O O O O O O |
     *  | O X X O O X X X O |
     *  | O O O O O X O X O |
     *  | O X X X O O O X X |
     *  | X O O O O X O O O |
     */
    private void isiLantaiIsi1()
    {
        for(int i =0; i< 3; i++)
        {
            this.papan[i][3]="X";
            this.papan[i][5]="X";
        }
        this.papan[1][1]="X";
        for(int j = 0; j< 9; j++)
        {
            if(j!=0 && j!=4 && j!=7 && j!=8)
            {
                this.papan[2][j]="X";
            }
        }
        for(int k = 3; k< 6; k++)
        {
            this.papan[k][1]="X";
        }
        this.papan[5][2]="X";
        this.papan[3][6]="X";
        this.papan[3][7]="X";
        for(int u = 5; u< 8; u++)
        {
            this.papan[5][u]="X";
        }
        this.papan[6][5]="X";
        this.papan[6][7]="X";
        this.papan[7][7]="X";
        this.papan[7][8]="X";
        for(int o = 1; o<4 ; o++)
        {
            this.papan[7][o]="X";
        }
        this.papan[8][0]="X";
        this.papan[8][5]="X";
    }
  
    public String[][] getPapan()
    {
        return this.papan;
    }
}
