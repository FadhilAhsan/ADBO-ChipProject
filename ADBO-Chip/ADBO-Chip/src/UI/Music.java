/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import javazoom.jlme.util.Player;

/**
 * Kelas music bagi papan permainan 
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella 
 * (2013730071).
 */
public class Music {
   private static String filename; //attribut berupa namaFile dalam String
   private static Player player; // attribut player untuk menjalankan sound

   /**
    * Method untuk menjalankan sound
    * @param tidak ada
    * @return tidak ada karena bertipe void
    */
public static void play() {
        try {
            URL url;
            FileInputStream fis     = new FileInputStream("Sound/01.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            @Override
            public void run() {
                try { player.play();
                      //player.play();

                }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();

    }

/**
 * Method untuk menghentikan sound
 * @param tidak ada
 * @return tidak ada karena bertipe void
 */
    public void close()
       {
           player.stop();
       }
}
