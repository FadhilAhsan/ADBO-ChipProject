/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Kotak;

import java.util.Arrays;

/**
 *
 * @author asus
 */
public class Tester {
    public static void main(String[] args) {
        Kotak k = new Lantai();
        k.isi();
        k.printLantai();
        System.out.println();
        for(int i =0; i< k.papan.length;i++)
        {
            for(int j =0; j< k.papan.length;j++)
            {
                System.out.print(k.papan[i][j]);
            }
            System.out.println();
        }      
       
    }
}
