package juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego extends JPanel{
    
    Laberinto laberinto = new Laberinto();
    Jugador jugador = new Jugador();
    
    public Juego(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                jugador.teclaPresionada(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
        
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics grafico){
        laberinto.paint(grafico);
        jugador.paint(grafico);
    }
    
    public static void main(String[] args) {
        JFrame ventanita = new JFrame("Juego del Laberinto");
        Juego jueguito = new Juego();
        ventanita.add(jueguito);
        ventanita.setSize(935, 560);
        //ventanita.setLocation(300,200);
        ventanita.setLocationRelativeTo(null);
        ventanita.setVisible(true);
        
        ventanita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            ventanita.repaint();
        }
    }
}