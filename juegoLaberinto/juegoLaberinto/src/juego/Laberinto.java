package juego;

import java.awt.Color;
import java.awt.Graphics;

public class Laberinto {
    private int fila = 0;
    private int columna = 0;
    private final int numeroFilas = 13;
    private final int numeroColumnas = 23;
    private final int anchoPared = 40;
    private final int altoPared = 40;
    
    public void paint(Graphics grafico){
        int[][] laberinto = obtenerLaberinto();
        for (fila = 0; fila < numeroFilas; fila++){
            for (columna = 0; columna < numeroColumnas; columna++){
                if(laberinto[fila][columna] == 1){
                    grafico.setColor(Color.yellow);
                    grafico.fillRect(columna*40, fila*40, anchoPared, altoPared);
                    grafico.setColor(Color.orange);
                    grafico.drawRect(columna*40, fila*40, anchoPared, altoPared);
                }
            }
        }
    }
    
    public int[][] obtenerLaberinto(){
        int laberinto[][] = 
        {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
            {1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,0,1,1},
            {1,0,1,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
            {1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1},
            {1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1},
            {1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1},
            {1,0,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,1,0,0,0,0,1},
            {1,1,1,1,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,1},
            {1,0,0,0,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        };
        
        return laberinto;
    }
}
