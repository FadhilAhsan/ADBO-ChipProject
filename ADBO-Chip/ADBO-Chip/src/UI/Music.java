/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import javazoom.jl.player.Player;

/**
 * Kelas music bagi papan permainan
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class Music extends Thread {

   private static String filename; //attribut berupa namaFile dalam String
   private static Player player; // attribut player untuk menjalankan sound
   private static boolean loop = true;//atribut untuk membuat mp3 bermain terus menerus

   /**
    * Method untuk menjalankan sound
    * @param tidak ada
    * @return tidak ada karena bertipe void
    */
   public static void play() {


        // run in new thread to play in background
        new Thread() {
            @Override
            public void run() {
                try {
                    do {
                        FileInputStream fis = new FileInputStream("Sound/02.mp3");
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        player = new Player(bis);
                        player.play();
                    } while (loop);


                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();

    }
    
 /**
 * Method untuk menghentikan sound
 * @param tidak ada
 * @return tidak ada karena bertipe void
 */
    public void close() {
        loop = false;
        player.close();
        this.interrupt();
    }
}
