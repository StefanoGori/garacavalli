/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author stefa
 */
public class NumeroCavalliPartenza implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel pannello = new JPanel();

    String[] n = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private JComboBox combo = new JComboBox(n);
    private JButton conferma = new JButton("Conferma");
    private JLabel titolo = new JLabel("Gara di cavalli!");
    private JLabel descrizione = new JLabel("Scegli il numero di corsie dei cavalli!");

    public NumeroCavalliPartenza() {  //pannello iniziale
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //centro il frame nel mezzo dello schermo
        pannello.setSize(600, 400);
        pannello.setBackground(Color.WHITE);
        pannello.setLayout(null);
        frame.add(pannello);

        titolo.setBounds(200, 20, 200, 40);

        descrizione.setBounds(180, 60, 400, 40);

        combo.setBounds(200, 90, 100, 40);

        conferma.setBounds(200, 120, 100, 40);

        conferma.addActionListener(this);

        pannello.add(combo);
        pannello.add(conferma);
        pannello.add(titolo);
        pannello.add(descrizione);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nCavalli = combo.getSelectedItem().toString();

        int nCav = Integer.parseInt(nCavalli); //converto da string a intero

        GaraCavalli.numero = nCav;
        
        frame.dispose();
        
        new GaraCavalli();

    }
}
