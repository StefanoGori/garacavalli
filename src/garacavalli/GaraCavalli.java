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
 * @author stefa
 */
public class GaraCavalli extends JFrame {
    int posizione;
    Cavallo[] partecipanti;
    CavalliInGara[] thread_partecipanti;
    Campo pista;
    public static int numero = 0; //variabile corsie
    Graphics offscreen;
    Image buffer_virtuale;

    public GaraCavalli() {
        super("Gara Cavalli");
        setSize(1000, 1600); 
        setLocation(10, 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pista = new Campo();
        partecipanti = new Cavallo[numero]; 
        thread_partecipanti = new CavalliInGara[numero];
        posizione = 1;

        int partenza = 15;
        for (int xx = 0; xx < numero; xx++) {
            partecipanti[xx] = new Cavallo(partenza, xx + 1);
            thread_partecipanti[xx] = new CavalliInGara(partecipanti[xx], this);
            partenza = partenza + 100;
        }

        this.add(pista);
        setVisible(true);
    }

    public synchronized int getPosizione() {
        return posizione++;
    }

    public synchronized void controlloArrivi() {
        boolean arrivati = true;
        for (int xx = 0; xx < numero; xx++) { 
            if (thread_partecipanti[xx].posizione == 0) {
                arrivati = false;
            }
        }
        if (arrivati) {
            visualizzaClassifica();
        }
    }

    public void visualizzaClassifica() {
        JLabel[] arrivi;
        arrivi = new JLabel[numero]; 
        JFrame classifica = new JFrame("Classifica");
        classifica.setSize(500, 500);
        classifica.setLocation(280, 180);
        classifica.setBackground(Color.BLUE);
        classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
        classifica.getContentPane().setLayout(new GridLayout(numero, 1)); 

        for (int xx = 1; xx < numero + 1; xx++) { 
            for (int yy = 0; yy < numero; yy++) { 
                if (thread_partecipanti[yy].posizione == xx) {
                    arrivi[yy] = new JLabel(xx + " posizione per il cavallo nella " + (yy + 1) + " corsia");
                    arrivi[yy].setFont(new Font("Times New Roman", Font.ITALIC, 20));
                    arrivi[yy].setForeground(Color.BLUE);
                    classifica.getContentPane().add(arrivi[yy]);
                }
            }
        }
        classifica.setVisible(true);
    }

    public void update(Graphics ca) {
        paint(ca);
    }

    public void paint(Graphics ca) {
        if (partecipanti != null) {
            Graphics2D screen = (Graphics2D) ca;
            buffer_virtuale = createImage(1000, 1600); 
            offscreen = buffer_virtuale.getGraphics();
            Dimension d = getSize();
            pista.paint(offscreen);
            for (int xx = 0; xx < numero; xx++) { 
                partecipanti[xx].paint(offscreen);
            }
            screen.drawImage(buffer_virtuale, 0, 20, this);
            offscreen.dispose();
        }
    }

    public static void main(String[] a) {
        NumeroCavalliPartenza s = new NumeroCavalliPartenza();
 
      
        
    }
}
