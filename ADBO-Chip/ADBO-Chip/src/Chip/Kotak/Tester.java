/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Kotak;

import Chip.Chip;
import java.util.Arrays;

/**
 *
 * @author asus
 */
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Lantai k = new Lantai();
        k.isi();
        Addition a = new Addition( k);
        a.copyPapan();
        a.isi();
        Chip me = new Chip(a);
        while(true)
        {
            k.printLantai();
            int direction=sc.nextInt();
            a.updateLantai(me, direction);
            k.updateLantai(me, direction);
        }    
       
    }
}
