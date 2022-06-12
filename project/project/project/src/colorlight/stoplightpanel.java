package colorlight;

import static java.awt.Component.RIGHT_ALIGNMENT;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wolfpack
 */
public class stoplightpanel extends javax.swing.JPanel {
    // mutable and immutable Varaibles
    String btn1="Start";
    String btn2="Stop";
    String textView="Thread Time";

    public stoplightpanel(String btn1, String  btn2,String textView) {
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.textView=textView;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public String getBtn1() {
        return btn1;
    }

    public String getBtn2() {
        return btn2;
    }
    
    
    JButton startbtn;
    JButton stopbtn ;
    JLabel red_label;
    
    int num=0;

    JTextField red_text;

    public boolean status =true;
    
    
    stopLightDrawing light =new stopLightDrawing();
    public int times[] ={1,1,1};
    
    
    
    
    public stoplightpanel(){
        startbtn =new JButton(btn1);
        stopbtn =new JButton(btn2);
        red_label =new JLabel(textView);

        red_text =new JTextField();

       
        red_text.setPreferredSize(new Dimension(50,30));

        buttonListner l =new buttonListner();
        startbtn.addActionListener(l);
        buttonendlistner e =new buttonendlistner();
        stopbtn.addActionListener(e);
      
        light.setPreferredSize(new Dimension(550, 170));
        light.setAlignmentX(RIGHT_ALIGNMENT);
        add(light);
        add(startbtn);
        add(stopbtn);
        add(red_label);
        add(red_text);

        
    }
    
    
    class buttonListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int times[] ={1,1,1};
            status =true;
            
            times[0] =Integer.parseInt(red_text.getText().trim());
            int num1 =Integer.parseInt(red_text.getText().trim());
            System.out.println("Thread Time Set : "+num1);
 
            num=num1;

            
            if(red_text.getText()==null ){
                 times =new int[] {1,1,1};
            } 
            

            
            light.changeColor();
            mainthread m =new mainthread();
            Thread main =new Thread(m);
            main.start();
        }
    }
    class changecolor{
        public void change(){
            light.changeColor();
         
        }
    }    
    class buttonendlistner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            status =false;
            
            
        }
    }
    
    class mainthread implements Runnable{
        
        public void run(){
            
      
            while(status){
                for (int i = 0; i < 3; i++) {
                    
                    synchronized(this) {
                        long k =times[i];
                        printhread p =new printhread((times[i]));
                        changecolor chngclr =new changecolor();
                        chngclr.change();
//                        System.out.println(num1);

//exception handling
                        try{
                            k*=num;
                            Thread.sleep(k);
                            p.start();
                          
                        }
                        catch(InterruptedException inp){
                            inp.printStackTrace();
                        }
                    } 
                    
                    System.out.println("change light color");
                }
                
            }
        }
    }
    
    class printhread extends Thread{
        int timess;
        public printhread(int t){
            
            this.timess =t; 
        }
        @Override
        public void run(){
           
            for (int j = 0; j <1; j++) {
                System.out.println("now light:"+" after "+(num)+" milli seconds will change color");
            }
            synchronized(this){
                
                this.notifyAll();
            } 
        }
    }
    
    static int threadCount(int k){
        // check thread sleep time
        if (k<=0){
            return 0;
        }
        else{
        return k;    
        }       
    } 
}
    
    
    