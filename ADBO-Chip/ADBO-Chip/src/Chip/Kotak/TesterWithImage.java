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
 *
 * @author Alphabeth
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
        img = Toolkit.getDefaultToolkit().getImage("Image/Floor/B2.png");
        if(img==null)
        {
            System.err.println("Couldn't find file: ");
        }
        else
        {
                imgFile.put("B2",img);
                img=Toolkit.getDefaultToolkit().getImage("Image/Wall/R2.png");
                imgFile.put("W2",img);
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
        tempImg="L1";
        repaint();
    }
    
    public void right(){
        a.updateLantai(me, 6);
        l.updateLantai(me, 6);
        tempImg="R1";
        repaint();
    }
    
    public void down(){
        a.updateLantai(me, 2);
        l.updateLantai(me, 2);
        tempImg="F1";
        repaint();
    }
    
    public void up(){
        a.updateLantai(me, 8);
        l.updateLantai(me, 8); 
        tempImg="B1";
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                g.drawImage(imgFile.get("B2"), j*60, i*60, null);
                if (l.getPapan()[i][j].equalsIgnoreCase("x")) {
                    g.drawImage(imgFile.get("W2"), j*60, i*60, null);
                }
                else if (l.getPapan()[i][j].equalsIgnoreCase("C")) {
                    g.drawImage(imgFile.get("3"), j*60, i*60, null);
                }
                else if (l.getPapan()[i][j].equalsIgnoreCase("?")) {
                    g.drawImage(imgFile.get(tempImg), j*60, i*60, null);
                }
            }
        }
    }
     
//    JLayeredPane layeredPane;
//    JPanel room;
//    Lantai l;
//    Addition a;
//    Chip me;
//    JLabel piece ;
//    JPanel panel ;
//    int counter;
//    
//    public TesterWithImage(){
//        l = new Lantai();
//        l.isi();
//        Addition a = new Addition(l);
//        a.copyPapan();
//        a.isi();
//        me = new Chip(a);
//        
//        Dimension boardSize = new Dimension(600, 600);
//        setTitle("Chip's Challenge");
//         
//  
//        layeredPane = new JLayeredPane();
//        getContentPane().add(layeredPane);
//        layeredPane.setPreferredSize(boardSize);
// 
//  
//        room = new JPanel();
//        layeredPane.add(room, JLayeredPane.DEFAULT_LAYER);
//        room.setLayout( new GridLayout(9, 9) );
//        room.setPreferredSize( boardSize );
//        room.setBounds(0, 0, boardSize.width, boardSize.height);
//  
//        for (int i = 0; i < 81; i++) {
//            JPanel square = new JPanel( new BorderLayout() );
//            room.add( square );
//            square.setBackground( Color.white );
//        }
//        
//        
//        int count=0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (l.getPapan()[i][j].equalsIgnoreCase("x")) {
//                    piece = new JLabel( new ImageIcon("src/Image/1.gif") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                }
//                else if(l.getPapan()[i][j].equalsIgnoreCase("F")){
//                    piece = new JLabel( new ImageIcon("src/Image/3.gif") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                }
//                else if (l.getPapan()[i][j].equalsIgnoreCase("?")) {
//                    piece = new JLabel( new ImageIcon("src/Image/11.gif") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                    counter=count;
//                }
//                else if(l.getPapan()[i][j].equalsIgnoreCase("C")){
//                    piece = new JLabel( new ImageIcon("src/Image/F2.gif") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                }
//                else if(l.getPapan()[i][j].equalsIgnoreCase("=")){
//                    piece = new JLabel( new ImageIcon("src/Image/1.jpg") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                }
//                else if(l.getPapan()[i][j].equalsIgnoreCase("W")){
//                    piece = new JLabel( new ImageIcon("src/Image/C1.gif") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                }
//                else{
//                    piece = new JLabel( new ImageIcon("src/Image/2.gif") );
//                    panel = (JPanel)room.getComponent(count);
//                    panel.add(piece);
//                }
//                count++;
//            }
//            
//        }
//     
//    }
    
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new McWinLookAndFeel());
        JFrame frame = new JFrame("Chip's Challenge");
        frame.setContentPane(new TesterWithImage());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

     }
}
