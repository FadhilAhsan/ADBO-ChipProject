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

    public TesterWithImage() {
        imgFile=new HashMap<String,Image>();
        l.isi();
        Addition a = new Addition(l);
        a.copyPapan();
        a.isi();
        Chip me = new Chip(a);
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
                img=Toolkit.getDefaultToolkit().getImage("Image/3.gif");
                imgFile.put("3",img);

        }
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        
    }
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
                    g.drawImage(imgFile.get("F1"), j*60, i*60, null);
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
     }
}
