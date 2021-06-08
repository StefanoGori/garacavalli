/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garacavalli;

/**
 *
 * @author stefa
 */
public class CavalliInGara implements Runnable {
    Cavallo cavallo;
    GaraCavalli campo;
    int velocita;
    Thread t;
    int conta;
    int posizione;

    public CavalliInGara(Cavallo c, GaraCavalli ca) {
        cavallo = c;
        campo = ca;
        velocita = 2;
        t = new Thread(this);
        t.start();
        conta = 0;
        posizione = 0;
    }
    
    

  
    public void run() {
       int dimImmagine = 79;
       int dimPista = 960;
       while((cavallo.getCordx()+dimImmagine)<dimPista){
           if((conta%10)==0)
               velocita = (int)(Math.random()*4+1);
           cavallo.setCordx(cavallo.getCordx()+velocita);
           conta++;
           try{Thread.sleep(75);}
           catch(Exception e){}
           campo.repaint();
       }
       
       posizione = campo.getPosizione();
       campo.controlloArrivi();
    }
    
}
