/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip.Kotak;
import Chip.Chip;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import java.io.IOException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
/**
 *Kelas tester untuk papan permainan
 * @author Fadhil Ahsan(2013730003), Cheria (2013730002), Janice Sella 
 * (2013730071).
 */
public class TesterWithImage extends JPanel{
    public static final int CANVAS_WIDTH=60*9;
    public static final int CANVAS_HEIGHT=60*9;   
    private Map<String , Image> imgFile;
    private Lantai l=new Lantai();
    private Addition a= new Addition(l);
    private Chip me;
    private boolean isWin=false;
    private String tempImg="F1";

    public TesterWithImage() {
        imgFile=new HashMap<String,Image>();
        l.isi();
        a.copyPapan();
        a.isi();
        me = new Chip(a);
        Image img;
        img = Toolkit.getDefaultToolkit().getImage("Image/Floor/B1.png");
        if(img==null)
        {
            System.err.println("Couldn't find file: ");
        }
        else
        {
                imgFile.put("B1",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Wall/Tree.png");
                imgFile.put("Tree",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Chocobo/F1.png");
                imgFile.put("F1",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Chocobo/L1.png");
                imgFile.put("L1",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Chocobo/R1.png");
                imgFile.put("R1",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Chocobo/B1.png");
                imgFile.put("B1",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/3.gif");
                imgFile.put("3",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Home.png");
                imgFile.put("Home",img);

        }
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        Music.play();
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
              @Override
              public void keyPressed(KeyEvent e) {
                if (isWin==false) {
                  switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                      formKeyPressed(e);
                      break;
                    case KeyEvent.VK_RIGHT:
                      formKeyPressed(e);
                      break;
                    case KeyEvent.VK_DOWN:
                      formKeyPressed(e);
                      break;
                    case KeyEvent.VK_UP:
                      formKeyPressed(e);
                      break;
                  }
                }
              }
            });    
    }
    
    
     private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        switch (evt.getKeyCode()) {
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
    public void left(){
        a.updateLantai(me, 4);
        l.updateLantai(me, 4);
        if (!l.isFinished(me).equals("WIN")) {
           tempImg="L";
           repaint(); 
        }
        else{
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        }  
    }
    
    public void right(){
        a.updateLantai(me, 6);
        l.updateLantai(me, 6);
        if (!l.isFinished(me).equals("WIN")) {
           tempImg="R";
           repaint(); 
        }
        else{
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        }
    }
    
    public void down(){
        a.updateLantai(me, 2);
        l.updateLantai(me, 2);
        if (!l.isFinished(me).equals("WIN")) {
           tempImg="F";
           repaint(); 
        }
        else{
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        }
    }
    
    public void up(){
        a.updateLantai(me, 8);
        l.updateLantai(me, 8); 
        String temp=l.isFinished(me);
        if (!temp.equals("WIN")) {
           tempImg="B";
           repaint(); 
        }
        else{
            JOptionPane.showMessageDialog(this, "Anda memenangkan game ini !");
        }
    }
    
 @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(imgFile.get("F1"), 60, 0, null);
        g.drawImage(imgFile.get("B1"), 60, 0, null);
        g.drawImage(imgFile.get("L1"), 60, 0, null);
        g.drawImage(imgFile.get("R1"), 60, 0, null);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    g.drawImage(imgFile.get("B1"), j*60, i*60, null);
                    if (l.getPapan()[i][j].equalsIgnoreCase("x")) {
                        g.drawImage(imgFile.get("Tree"), j*60, i*60, null);
                    }
                    else if (l.getPapan()[i][j].equalsIgnoreCase("C")) {
                        g.drawImage(imgFile.get("3"), j*60, i*60, null);
                    }
                    else if (l.getPapan()[i][j].equalsIgnoreCase("?")) {
                        g.drawImage(imgFile.get(tempImg), j*60, i*60, null);
                    }
                    else if (l.getPapan()[i][j].equalsIgnoreCase("W")) {
                        g.drawImage(imgFile.get("Home"), j*60, i*60, null);
                    }
                }
            }
     }
         
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new McWinLookAndFeel());
        JFrame frame = new JFrame("Chocobo's Challenge");
        frame.setContentPane(new TesterWithImage());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        Image img=Toolkit.getDefaultToolkit().getImage("Image/icon Chocobo.jpg");
        frame.setIconImage(img);
     }
}
