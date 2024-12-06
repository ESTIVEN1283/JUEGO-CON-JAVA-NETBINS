package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Jugador {
    Laberinto lab = new Laberinto();
    private int x = 40;
    private int y = 40;
    private final int ancho = 40;
    private final int alto = 40;
    private final int movimiento = 40;
    
    public void paint(Graphics grafico){
        grafico.setColor(Color.darkGray); //Color de relleno
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.BLACK); //Color de contorno
        grafico.drawOval(x, y, ancho, alto);
    }
    
    public void teclaPresionada(KeyEvent evento){
        int [][] laberinto = lab.obtenerLaberinto();
        if (evento.getKeyCode() == 37){ //Izquierda
            if (laberinto[y/40][(x/40)-1] != 1)
                x = x - movimiento;
            else
                JOptionPane.showMessageDialog(null, "Bloqueado");        
        } 
                            
        if (evento.getKeyCode() == 39){ //Derecha
            if (laberinto[y/40][(x/40)+1] != 1)
                x = x + movimiento;
            else
                JOptionPane.showMessageDialog(null, "Bloqueado");
        }
        
        if (evento.getKeyCode() == 38){ //Arriba
            if (laberinto[(y/40)-1][x/40] != 1)
                y = y - movimiento;
            else
                JOptionPane.showConfirmDialog(null, "¿volver a jugar?");
                    
        }
        
        if (evento.getKeyCode() == 40){ //Abajo
            if (laberinto[(y/40)+1][x/40] != 1)    
                y = y + movimiento;
            else
                JOptionPane.showInputDialog(null, "Bloqueado");
        }    
    }
}
