
package colorlight;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class stopLightDrawing extends JComponent{
    
    Color gray =Color.gray;
    Color black =Color.black;
    Color go =gray;
    Color stop =Color.red;
    Color ready =gray;
    
    String Activelight ="red";
    public void paintComponent(Graphics g){
        g.setColor(black);
        g.fillRect(0, 0, 450, 150);
        
        g.setColor(gray);
        
        g.setColor(stop);
        g.fillOval(80, 45, 70, 70);
        
        g.setColor(ready);
        g.fillOval(200, 45, 70, 70);
        
        g.setColor(go);
        g.fillOval(320, 45, 70, 70);
     
        //changeColor();
        //changeColor();

    }
    
    public void changeColor(){
        //System.out.println("change color function called");
        if(Activelight=="red"){
            Activelight ="yellow";
            stop =gray;
            ready =Color.yellow;
            go =gray;
        }
        else if(Activelight =="yellow"){
            Activelight ="green";
            stop=gray;
            ready =gray;
            go =Color.green;
        }else{
            Activelight ="red";
            stop =Color.red;
            ready =gray;
            go =gray;
        }
        repaint();
    }
}
