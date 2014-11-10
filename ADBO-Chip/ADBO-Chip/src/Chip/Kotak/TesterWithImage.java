/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chip.Kotak;
import Chip.Chip;
import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author Alphabeth
 */
public class TesterWithImage extends JFrame{
    JLayeredPane layeredPane;
    JPanel room;
    Lantai l;
    Addition a;
    Chip me;
    JLabel piece ;
    JPanel panel ;
    int counter;
    
    public TesterWithImage(){
        l = new Lantai();
        l.isi();
        Addition a = new Addition(l);
        a.copyPapan();
        a.isi();
        me = new Chip(a);
        
        Dimension boardSize = new Dimension(600, 600);
        setTitle("Chip's Challenge");
         
  
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
 
  
        room = new JPanel();
        layeredPane.add(room, JLayeredPane.DEFAULT_LAYER);
        room.setLayout( new GridLayout(9, 9) );
        room.setPreferredSize( boardSize );
        room.setBounds(0, 0, boardSize.width, boardSize.height);
  
        for (int i = 0; i < 81; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            room.add( square );
            square.setBackground( Color.white );
        }
        
        
        int count=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (l.getPapan()[i][j].equalsIgnoreCase("x")) {
                    piece = new JLabel( new ImageIcon("src/Image/1.gif") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                }
                else if(l.getPapan()[i][j].equalsIgnoreCase("F")){
                    piece = new JLabel( new ImageIcon("src/Image/3.gif") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                }
                else if (l.getPapan()[i][j].equalsIgnoreCase("?")) {
                    piece = new JLabel( new ImageIcon("src/Image/11.gif") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                    counter=count;
                }
                else if(l.getPapan()[i][j].equalsIgnoreCase("C")){
                    piece = new JLabel( new ImageIcon("src/Image/F2.gif") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                }
                else if(l.getPapan()[i][j].equalsIgnoreCase("=")){
                    piece = new JLabel( new ImageIcon("src/Image/1.jpg") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                }
                else if(l.getPapan()[i][j].equalsIgnoreCase("W")){
                    piece = new JLabel( new ImageIcon("src/Image/C1.gif") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                }
                else{
                    piece = new JLabel( new ImageIcon("src/Image/2.gif") );
                    panel = (JPanel)room.getComponent(count);
                    panel.add(piece);
                }
                count++;
            }
            
        }
     
    }
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        JFrame frame = new TesterWithImage();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
     }
}
