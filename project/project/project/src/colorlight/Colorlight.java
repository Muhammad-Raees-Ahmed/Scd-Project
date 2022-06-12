/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorlight;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wolfpack
 */
public class Colorlight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame =new JFrame();
        JPanel panel =new stoplightpanel();
        frame.add(panel);
        frame.setSize(600,400);
        //frame.setDefaultCloseOperation(JFrame,Exit_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
                
        
    }
    
}
