/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MulticastPeer;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Brais
 */
public class Interfaz extends javax.swing.JFrame {

  private  static MulticastSocket socket = null;
  private  static InetAddress grupo = null;
  private  static Recibir hilo = null;

    public Interfaz(MulticastSocket s, InetAddress group) throws IOException {
        initComponents();
        socket = s;
        grupo = group;
        hilo = new Recibir(this, socket);
        hilo.start();
    }

    private Interfaz() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBEnviar = new javax.swing.JButton();
        jTFEscribir = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAChat = new javax.swing.JTextArea();
        jBResetear1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBEnviar.setText("Enviar");
        jBEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEnviarMouseClicked(evt);
            }
        });
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        jTAChat.setColumns(20);
        jTAChat.setRows(5);
        jScrollPane1.setViewportView(jTAChat);

        jBResetear1.setText("Reset");
        jBResetear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBResetear1MouseClicked(evt);
            }
        });
        jBResetear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetear1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Computación Distribuida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTFEscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBEnviar)
                            .addComponent(jBResetear1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFEscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBEnviar))
                    .addComponent(jBResetear1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEnviarMouseClicked
    }//GEN-LAST:event_jBEnviarMouseClicked

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        if (!jTFEscribir.equals(null)) {
            byte[] m = new byte[100];
            m = jTFEscribir.getText().getBytes();
            DatagramPacket messageOut = new DatagramPacket(m, m.length, grupo, 5000);
            try {
                socket.send(messageOut);
                jTFEscribir.setText(null);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    
    public void Imprimir(String imprimir){
                            jTAChat.setText(jTAChat.getText()+imprimir);

    }
    private void jBResetear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBResetear1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBResetear1MouseClicked

    private void jBResetear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetear1ActionPerformed
        // TODO add your handling code here:
        jTFEscribir.setText(null);
    }//GEN-LAST:event_jBResetear1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBResetear1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAChat;
    private javax.swing.JTextField jTFEscribir;
    // End of variables declaration//GEN-END:variables

    private static class Recibir extends Thread {
        
        private Interfaz interfaz;
        private MulticastSocket socket1;
        
        public Recibir(Interfaz aThis, MulticastSocket socket) throws IOException {
            
            this.interfaz=aThis;
            this.socket1=socket;
        }

        public void run() {
            String imprimir = "";
            for (int i = 0; i < 3; i++) 
            {
                byte[] buffer = new byte[1000];
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                try {
                    socket1.receive(messageIn);
                    imprimir = new String(messageIn.getData(),"UTF-8");
                    imprimir = imprimir.trim();
                    imprimir = imprimir + "\n";
                    interfaz.Imprimir(imprimir);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                
 
                i = 1;
            }
            //socket.leaveGroup(group);

        }
    }
}
