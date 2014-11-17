/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;

import Chip.Kotak.Addition;

/**
 * Kelas sub-class dari sepatu pada game
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class SepatuApi extends Sepatu {

    /**
     * Method untuk menset status sepatu Api
     * @param masukan, bila 1 akan bernilai true selain itu bernilai false
     * @return status sepatu Api
     */
    @Override
    public boolean ubahStatus(int masukan) {
        if (masukan == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Method untuk mencetak apakah sepatu Api sudah terpasang
     * @param status
     * @return string "sepatu Api terpasang"
     */
    @Override
    public String notification(boolean status) {
        if (status == true) {
            return "Sepatu Api Terpasang";
        } else {
            return "Sepatu Api Dilepas";
        }
    }

}
