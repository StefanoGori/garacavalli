/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Mirko
 */
public class Cavallo extends JPanel {
    int cordx;
    int cordy;
    Image img;
    
    public Cavallo(int yy, int xx){
        cordx =0;
        cordy=yy;
        Toolkit tk= Toolkit.getDefaultToolkit();
        img = tk.getImage("src/garacavalli/cavallo.jpg");
        img=img.getScaledInstance(90,90, Image.SCALE_SMOOTH);
        MediaTracker mt= new MediaTracker(this);
        mt.addImage(img,1);
        try{mt.waitForID(1);}
        catch(InterruptedException e){}
    }
    
    public void setCordx(int n){
        cordx=n;
    }
    
    public int getCordx(){
        return cordx;
    }
    
    public void paint(Graphics ca){
        ca.drawImage(img, cordx, cordy, null);
    }
    protected ImageIcon createImageIcon(String path,String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}
}
