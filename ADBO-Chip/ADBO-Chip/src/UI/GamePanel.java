/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Chip.Chip;
import Chip.Kotak.Addition;
import Chip.Kotak.LantaiIsi;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.io.IOException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Kelas GamePanel untuk merepresentasikan papan permainan dalam Panel
 *
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella
 * (2013730071).
 */
public class GamePanel extends JPanel implements KeyListener{

    public static final int CANVAS_WIDTH = 59 * 11;
    public static final int CANVAS_HEIGHT = 60 * 11;
    private Map<String, Image> imgFile;
    private LantaiIsi l = new LantaiIsi();
    private Addition a = new Addition(l);
    private Chip me;
    private boolean isWin = false;
    private String tempImg = "F1";
    private int countFire=1,countChip=1;

    public GamePanel() {
        imgFile = new HashMap<String, Image>();
        l.isi();
        a.copyPapan();
        a.isi();
        me = new Chip(a);
        Image img;
        img = Toolkit.getDefaultToolkit().getImage("Image/Floor/B2.png");
        if (img == null) {
            System.err.println("Couldn't find file: ");
        } else {
            imgFile.put("Floor2", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Wall/Tree.png");
            imgFile.put("Tree", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/F1.png");
            imgFile.put("F1", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/F2.png");
            imgFile.put("F2", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/F3.png");
            imgFile.put("F3", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/L1.png");
            imgFile.put("L1", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/L2.png");
            imgFile.put("L2", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/L3.png");
            imgFile.put("L3", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/R1.png");
            imgFile.put("R1", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/R2.png");
            imgFile.put("R2", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/R3.png");
            imgFile.put("R3", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/B1.png");
            imgFile.put("B1", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/B2.png");
            imgFile.put("B2", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Chocobo/B3.png");
            imgFile.put("B3", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Corn.png");
            imgFile.put("Corn", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Home.png");
            imgFile.put("Home", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Fire1.png");
            imgFile.put("Fire1", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Fire2.png");
            imgFile.put("Fire2", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Fire3.png");
            imgFile.put("Fire3", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Fire4.png");
            imgFile.put("Fire4", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Water.png");
            imgFile.put("Water", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/A-Fire.png");
            imgFile.put("A-Fire", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/A-Water.png");
            imgFile.put("A-Water", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Barier1.png");
            imgFile.put("Barier1", img);
            img = Toolkit.getDefaultToolkit().getImage("Image/Ice.png");
            imgFile.put("Ice", img);

        }
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setFocusable(true);
        repaint();
    }
    
    public int getCornLeft(){
       return a.getJumlahCorn();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         if (isWin==false) {
                switch (ke.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        left();
                        break;
                    case KeyEvent.VK_DOWN:
                        down();
                        break;
                    case KeyEvent.VK_UP:
                        up();
                        break;
                    case KeyEvent.VK_RIGHT:
                        right();
                        break;
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void left() {
        a.updateLantai(me, 4);
        l.updateLantai(me, 4);
        if (l.isFinished(me).equals("LOSE")) {
            isWin = true;
            JOptionPane.showMessageDialog(this, "Anda kalah ! :(");
        } else if (l.isFinished(me).equals("WIN")) {
            isWin = true;
            a.updateLantai(me, 0);
            l.updateLantai(me, 0);
            repaint();
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        } else {
            tempImg = "L";
            repaint();
        }
    }

    public void right() {
        a.updateLantai(me, 6);
        l.updateLantai(me, 6);
        if (l.isFinished(me).equals("LOSE")) {
            isWin = true;
            JOptionPane.showMessageDialog(this, "Anda kalah ! :(");
        } else if (l.isFinished(me).equals("WIN")) {
            isWin = true;
            a.updateLantai(me, 0);
            l.updateLantai(me, 0);
            repaint();
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        } else {
            tempImg = "R";
            repaint();
        }
    }

    public void down() {
        a.updateLantai(me, 2);
        l.updateLantai(me, 2);
        if (l.isFinished(me).equals("LOSE")) {
            isWin = true;
            JOptionPane.showMessageDialog(this, "Anda kalah ! :(");
        } else if (l.isFinished(me).equals("WIN")) {
            isWin = true;
            a.updateLantai(me, 0);
            l.updateLantai(me, 0);
            repaint();
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        } else {
            tempImg = "F";
            repaint();
        }
    }

    public void up() {
        a.updateLantai(me, 8);
        l.updateLantai(me, 8);
        if (l.isFinished(me).equals("LOSE")) {
            isWin = true;
            a.updateLantai(me, 10);
            l.updateLantai(me, 10);
            repaint();
            JOptionPane.showMessageDialog(this, "Anda kalah ! :(");
        } else if (l.isFinished(me).equals("WIN")) {
            isWin = true;
            a.updateLantai(me, 0);
            l.updateLantai(me, 0);
            repaint();
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        } else {
            tempImg = "B";
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(imgFile.get("F1"), 60, 0, null);
        g.drawImage(imgFile.get("B1"), 60, 0, null);
        g.drawImage(imgFile.get("L1"), 60, 0, null);
        g.drawImage(imgFile.get("R1"), 60, 0, null);
        g.drawImage(imgFile.get("F2"), 60, 0, null);
        g.drawImage(imgFile.get("B2"), 60, 0, null);
        g.drawImage(imgFile.get("L2"), 60, 0, null);
        g.drawImage(imgFile.get("R2"), 60, 0, null);
        g.drawImage(imgFile.get("F3"), 60, 0, null);
        g.drawImage(imgFile.get("B3"), 60, 0, null);
        g.drawImage(imgFile.get("L3"), 60, 0, null);
        g.drawImage(imgFile.get("R3"), 60, 0, null);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                g.drawImage(imgFile.get("Floor2"), j * 60, i * 60, null);
                if (l.getPapan()[i][j].equalsIgnoreCase("x")) {
                    g.drawImage(imgFile.get("Tree"), j * 60, i * 60, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("C")) {
                    g.drawImage(imgFile.get("Corn"), j * 60+5, i * 60+5, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("?")) {
                    g.drawImage(imgFile.get(tempImg+countChip), j * 60, i * 60, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("W")) {
                    g.drawImage(imgFile.get("Home"), j * 60, i * 60, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("F")) {
                    g.drawImage(imgFile.get("Fire"+countFire), j * 60, i * 60, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("A")) {
                    g.drawImage(imgFile.get("Water"), j * 60, i * 60, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("SA")) {
                    g.drawImage(imgFile.get("A-Water"),j * 60+5, i * 60+5, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("SF")) {
                    g.drawImage(imgFile.get("A-Fire"), j * 60+5, i * 60+5, null);
                } else if (l.getPapan()[i][j].equalsIgnoreCase("=")) {
                    g.drawImage(imgFile.get("Barier1"), j * 60+5, i * 60+5, null);
                } else if(l.getPapan()[i][j].equalsIgnoreCase("Z")){
                    g.drawImage(imgFile.get("Ice"), j * 60+5, i * 60+5, null);
                }
            }
        }
        countFire++;
        countChip++;
        if (countFire>4) {
            countFire=1;
        }
        if (countChip>3) {
            countChip=1;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }
}
