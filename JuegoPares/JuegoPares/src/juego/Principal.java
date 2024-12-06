package juego;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    
    ArrayList <JLabel> etiquetas = new ArrayList();
    SecureRandom numerosAleatorios = new SecureRandom();
    String[] figuraFacil = new String[8];
    String[][] rutaFacil = new String[4][4];
    int[] nums = new int[8];
    int cantClic = 0;
    String[] comparar = new String[2];
    int[] numeroCarta = new int[2];
    int aciertos = 0; 
    int fallas = 0;
    
    public Principal() {
        initComponents();
        setSize(860,470);
        setLocationRelativeTo(this);
        cargarEtiquetas();
        agregarImagenes();
        if (btnJugar.getText().equals("Mostrar"))
            btnJugar.setEnabled(false);
        pnlFacil.setVisible(false);
        btnComparar.setEnabled(false);
    }
    
    void cargarEtiquetas(){
        etiquetas.add(lblF1);
        etiquetas.add(lblF2);
        etiquetas.add(lblF3);
        etiquetas.add(lblF4);
        etiquetas.add(lblF5);
        etiquetas.add(lblF6);
        etiquetas.add(lblF7);
        etiquetas.add(lblF8);
        etiquetas.add(lblF9);
        etiquetas.add(lblF10);
        etiquetas.add(lblF11);
        etiquetas.add(lblF12);
        etiquetas.add(lblF13);
        etiquetas.add(lblF14);
        etiquetas.add(lblF15);
        etiquetas.add(lblF16);
    }

    public int numerosImagen(){
        int numeroGenerado = numerosAleatorios.nextInt(8);
        return numeroGenerado;
    }
    
    void agregarImagenes(){
        for (int fig = 0; fig < figuraFacil.length; fig++)
            figuraFacil[fig] = "/img/"+(fig+1)+".jpg";
    }
    
    void cargarImagenesEtiquetas(){
        int contador = 0;
        
        for(int f = 0; f < rutaFacil.length; f++){
            for(int c = 0; c < rutaFacil[0].length; c++){
                int temp = numerosImagen();
                if (nums[temp] == 2)
                    c--;
                else {
                    rutaFacil[f][c] = figuraFacil[temp];
                    nums[temp]++;
                }
            }
        }
        
        for (int f = 0; f < rutaFacil.length; f++){
            for (int c = 0; c < rutaFacil[0].length; c++){
                etiquetas.get(contador).setOpaque(true);
                etiquetas.get(contador).setIcon(new ImageIcon(getClass().getResource(rutaFacil[f][c])));
                etiquetas.get(contador).setText(""+(contador + 1));
                contador++;
            }
        }
    }
    
    void voltearCartas(){
        for (int i = 0; i < etiquetas.size(); i++){
            etiquetas.get(i).setIcon(null);
            etiquetas.get(i).setBackground(Color.YELLOW);
        }
    }
    
    void mostrarImagen(int numCarta){
        if (cantClic != 2) {
            if (numCarta >= 0 && numCarta <= 3) {
                comparar[cantClic] = rutaFacil[0][numCarta];
                etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaFacil[0][numCarta])));
            } else if (numCarta >= 4 && numCarta <= 7) {
                comparar[cantClic] = rutaFacil[1][numCarta - 4];
                etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaFacil[1][numCarta - 4])));
            } else if (numCarta >= 8 && numCarta <= 11) {
                comparar[cantClic] = rutaFacil[2][numCarta - 8];
                etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaFacil[2][numCarta - 8])));
            } else {
                comparar[cantClic] = rutaFacil[3][numCarta - 12];
                etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaFacil[3][numCarta - 12])));
            }
            numeroCarta[cantClic] = numCarta;
            cantClic++;
            if (cantClic == 2)
                btnComparar.setEnabled(true);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFacil = new javax.swing.JButton();
        btnMedio = new javax.swing.JButton();
        btnDificil = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnComparar = new javax.swing.JButton();
        lblAciertos = new javax.swing.JLabel();
        lblFallas = new javax.swing.JLabel();
        pnlFacil = new javax.swing.JPanel();
        lblF1 = new javax.swing.JLabel();
        lblF2 = new javax.swing.JLabel();
        lblF3 = new javax.swing.JLabel();
        lblF4 = new javax.swing.JLabel();
        lblF8 = new javax.swing.JLabel();
        lblF7 = new javax.swing.JLabel();
        lblF6 = new javax.swing.JLabel();
        lblF5 = new javax.swing.JLabel();
        lblF12 = new javax.swing.JLabel();
        lblF11 = new javax.swing.JLabel();
        lblF10 = new javax.swing.JLabel();
        lblF9 = new javax.swing.JLabel();
        lblF16 = new javax.swing.JLabel();
        lblF15 = new javax.swing.JLabel();
        lblF14 = new javax.swing.JLabel();
        lblF13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnFacil.setText("Fácil");
        btnFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacilActionPerformed(evt);
            }
        });
        getContentPane().add(btnFacil);
        btnFacil.setBounds(49, 29, 72, 25);

        btnMedio.setText("Medio");
        getContentPane().add(btnMedio);
        btnMedio.setBounds(216, 29, 72, 25);

        btnDificil.setText("Difícil");
        getContentPane().add(btnDificil);
        btnDificil.setBounds(381, 29, 72, 25);

        btnJugar.setText("Mostrar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar);
        btnJugar.setBounds(530, 30, 130, 25);

        btnComparar.setText("Comparar");
        btnComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompararActionPerformed(evt);
            }
        });
        getContentPane().add(btnComparar);
        btnComparar.setBounds(724, 29, 92, 25);

        lblAciertos.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblAciertos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAciertos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aciertos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        getContentPane().add(lblAciertos);
        lblAciertos.setBounds(710, 120, 121, 102);

        lblFallas.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lblFallas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFallas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fallas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        getContentPane().add(lblFallas);
        lblFallas.setBounds(700, 300, 121, 102);

        pnlFacil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFacil.setLayout(null);

        lblF1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF1MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF1);
        lblF1.setBounds(23, 8, 70, 70);

        lblF2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF2MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF2);
        lblF2.setBounds(124, 8, 70, 70);

        lblF3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF3MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF3);
        lblF3.setBounds(230, 8, 70, 70);

        lblF4.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF4MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF4);
        lblF4.setBounds(340, 8, 70, 70);

        lblF8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF8MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF8);
        lblF8.setBounds(340, 90, 70, 70);

        lblF7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF7MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF7);
        lblF7.setBounds(230, 90, 70, 70);

        lblF6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF6MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF6);
        lblF6.setBounds(124, 90, 70, 70);

        lblF5.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF5MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF5);
        lblF5.setBounds(23, 90, 70, 70);

        lblF12.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF12MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF12);
        lblF12.setBounds(340, 178, 70, 70);

        lblF11.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF11MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF11);
        lblF11.setBounds(230, 178, 70, 70);

        lblF10.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF10MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF10);
        lblF10.setBounds(124, 178, 70, 70);

        lblF9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF9MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF9);
        lblF9.setBounds(23, 178, 70, 70);

        lblF16.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF16MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF16);
        lblF16.setBounds(340, 266, 70, 70);

        lblF15.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF15MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF15);
        lblF15.setBounds(230, 266, 70, 70);

        lblF14.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF14MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF14);
        lblF14.setBounds(124, 266, 70, 70);

        lblF13.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblF13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblF13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblF13MouseClicked(evt);
            }
        });
        pnlFacil.add(lblF13);
        lblF13.setBounds(23, 266, 70, 70);

        getContentPane().add(pnlFacil);
        pnlFacil.setBounds(23, 81, 440, 347);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacilActionPerformed
        pnlFacil.setVisible(true);
        if (btnJugar.getText().equals("Mostrar"))
            btnJugar.setEnabled(true);
    }//GEN-LAST:event_btnFacilActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        if (rutaFacil[0][0] == null){
            cargarImagenesEtiquetas();
            btnJugar.setText("Comenzar");
        }else{
            voltearCartas();
            btnJugar.setText("Jugando");
            btnJugar.setEnabled(false);
        }
    }//GEN-LAST:event_btnJugarActionPerformed

    private void lblF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF1MouseClicked
        mostrarImagen(Integer.parseInt(lblF1.getText()) - 1);
    }//GEN-LAST:event_lblF1MouseClicked

    private void lblF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF2MouseClicked
        mostrarImagen(Integer.parseInt(lblF2.getText()) - 1);
    }//GEN-LAST:event_lblF2MouseClicked

    private void lblF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF3MouseClicked
        mostrarImagen(Integer.parseInt(lblF3.getText()) - 1);
    }//GEN-LAST:event_lblF3MouseClicked

    private void lblF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF4MouseClicked
        mostrarImagen(Integer.parseInt(lblF4.getText()) - 1);
    }//GEN-LAST:event_lblF4MouseClicked

    private void lblF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF5MouseClicked
        mostrarImagen(Integer.parseInt(lblF5.getText()) - 1);
    }//GEN-LAST:event_lblF5MouseClicked

    private void lblF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF6MouseClicked
        mostrarImagen(Integer.parseInt(lblF6.getText()) - 1);
    }//GEN-LAST:event_lblF6MouseClicked

    private void lblF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF7MouseClicked
        mostrarImagen(Integer.parseInt(lblF7.getText()) - 1);
    }//GEN-LAST:event_lblF7MouseClicked

    private void lblF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF8MouseClicked
        mostrarImagen(Integer.parseInt(lblF8.getText()) - 1);
    }//GEN-LAST:event_lblF8MouseClicked

    private void lblF9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF9MouseClicked
        mostrarImagen(Integer.parseInt(lblF9.getText()) - 1);
    }//GEN-LAST:event_lblF9MouseClicked

    private void lblF10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF10MouseClicked
        mostrarImagen(Integer.parseInt(lblF10.getText()) - 1);
    }//GEN-LAST:event_lblF10MouseClicked

    private void lblF11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF11MouseClicked
        mostrarImagen(Integer.parseInt(lblF11.getText()) - 1);
    }//GEN-LAST:event_lblF11MouseClicked

    private void lblF12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF12MouseClicked
        mostrarImagen(Integer.parseInt(lblF12.getText()) - 1);
    }//GEN-LAST:event_lblF12MouseClicked

    private void lblF13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF13MouseClicked
        mostrarImagen(Integer.parseInt(lblF13.getText()) - 1);
    }//GEN-LAST:event_lblF13MouseClicked

    private void lblF14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF14MouseClicked
        mostrarImagen(Integer.parseInt(lblF14.getText()) - 1);
    }//GEN-LAST:event_lblF14MouseClicked

    private void lblF15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF15MouseClicked
        mostrarImagen(Integer.parseInt(lblF15.getText()) - 1);
    }//GEN-LAST:event_lblF15MouseClicked

    private void lblF16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblF16MouseClicked
        mostrarImagen(Integer.parseInt(lblF16.getText()) - 1);
    }//GEN-LAST:event_lblF16MouseClicked

    private void btnCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompararActionPerformed
        if (comparar[0].equals(comparar[1])) {
            aciertos++;
            lblAciertos.setText("" + aciertos);
            etiquetas.get(numeroCarta[0]).setVisible(false);
            etiquetas.get(numeroCarta[1]).setVisible(false);
            JOptionPane.showMessageDialog(null, "Encontraste su par");
        } else {
            fallas++;
            lblFallas.setText("" + fallas);
            voltearCartas();
        }
        cantClic = 0;
        btnComparar.setEnabled(false);
    }//GEN-LAST:event_btnCompararActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComparar;
    private javax.swing.JButton btnDificil;
    private javax.swing.JButton btnFacil;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnMedio;
    private javax.swing.JLabel lblAciertos;
    private javax.swing.JLabel lblF1;
    private javax.swing.JLabel lblF10;
    private javax.swing.JLabel lblF11;
    private javax.swing.JLabel lblF12;
    private javax.swing.JLabel lblF13;
    private javax.swing.JLabel lblF14;
    private javax.swing.JLabel lblF15;
    private javax.swing.JLabel lblF16;
    private javax.swing.JLabel lblF2;
    private javax.swing.JLabel lblF3;
    private javax.swing.JLabel lblF4;
    private javax.swing.JLabel lblF5;
    private javax.swing.JLabel lblF6;
    private javax.swing.JLabel lblF7;
    private javax.swing.JLabel lblF8;
    private javax.swing.JLabel lblF9;
    private javax.swing.JLabel lblFallas;
    private javax.swing.JPanel pnlFacil;
    // End of variables declaration//GEN-END:variables
}
