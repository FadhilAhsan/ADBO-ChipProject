/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chip.Kotak;

import Chip.*;
import java.util.Arrays;

/**
 * Kelas tester untuk engine permainan
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella 
 * (2013730071).
 */
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        LantaiIsi k = new LantaiIsi();
        k.isi();
        Addition a = new Addition( k);
        a.copyPapan();
        a.isi();
        Chip me = new Chip(a);
        while(k.isFinished(me).equalsIgnoreCase("null"))
        {
            k.printLantai();
            int direction=sc.nextInt();
            a.updateLantai(me, direction);
            k.updateLantai(me, direction);  
        }    
        System.out.println(k.isFinished(me));
    }
}
