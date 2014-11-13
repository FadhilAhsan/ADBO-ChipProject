/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip;

import Chip.Kotak.Addition;

/**
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class SepatuApi extends Sepatu {

    @Override
    public boolean ubahStatus(int masukan) {
        if (masukan == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String notification(boolean status) {
        if (status == true) {
            return "Sepatu Api Terpasang";
        } else {
            return "Sepatu Api Dilepas";
        }
    }

}
