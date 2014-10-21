/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;
/**
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella (2013730071)
 */
public class Chip {
    
    protected int row;
    protected int col;
    
    public Chip()
    {
        this.row=0;
        this.col=2;
    }
    
    public void move(int direction){
        switch (direction) {
            case '2': this.row--; break;
            case '4': this.col--; break;
            case '6': this.col++; break;
            case '8': this.row++; break;
        }
    }
     
    public int getRow(){
        return row;
    }
    
    public int getCol() {
        return col;
    }
}
