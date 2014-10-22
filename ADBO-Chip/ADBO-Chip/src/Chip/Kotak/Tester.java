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
        Addition a = new Addition((Lantai) k);
        a.copyPapan();
        a.isi();
        k.printLantai();     
       
    }
}
