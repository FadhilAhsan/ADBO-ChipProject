/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;

/**
 * Kelas sub-class dari sepatu pada game
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class SepatuAir extends Sepatu {

    /**
     * Method untuk menset status sepatu Air
     * @param masukan, bila 2 akan bernilai true selain itu bernilai false
     * @return status sepatu Air
     */
    @Override
    public boolean ubahStatus(int masukan) {
        if (masukan == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method untuk mencetak apakah sepatu Air sudah terpasang
     * @param status
     * @return string "sepatu Air terpasang"
     */
    @Override
    public String notification(boolean status) {
        if (status == true) {
            return "Sepatu Air Terpasang";
        } else {
            return "Sepatu Air Dilepas";
        }
    }

}
