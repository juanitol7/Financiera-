
package fabrica.galletas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends javax.swing.JFrame {
    
    private Fabrica fabrica;

    
   
    public Interfaz() {
        initComponents();
        fabrica = new Fabrica();
        for (int i = 1; i <= 8; i++) {
            fabrica.agregarEmpacador(new Empacador("Empacador " + i));
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Registrar paquetes empacados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostrar Rendimiento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Mostrar Promedios ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Empacadores que no continuan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Reiniciar Dia ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(420, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!fabrica.hayEmpaquesRegistrados()) {
            JOptionPane.showMessageDialog(this, "Aún no se han registrado los empaques.");
            return;
        }

        Empacador mejorEmpacador = fabrica.getMejorEmpacador();
        Empacador peorEmpacador = fabrica.getPeorEmpacador();

        JOptionPane.showMessageDialog(this, "Mejor Empacador: " + mejorEmpacador.getNombre()
                + " con " + mejorEmpacador.getTotalEmpaques() + " empaques.\n"
                + "Peor Empacador: " + peorEmpacador.getNombre()
                + " con " + peorEmpacador.getTotalEmpaques() + " empaques.");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (Empacador empacador : fabrica.getEmpacadores()) {
            try {
                String empaquesManana = JOptionPane.showInputDialog(this,
                        "Ingrese los empaques de la mañana para " + empacador.getNombre());
                empacador.setEmpaquesManana(Integer.parseInt(empaquesManana));

                String empaquesTarde = JOptionPane.showInputDialog(this,
                        "Ingrese los empaques de la tarde para " + empacador.getNombre());
                empacador.setEmpaquesTarde(Integer.parseInt(empaquesTarde));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Intente de nuevo.");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!fabrica.hayEmpaquesRegistrados()) {
        JOptionPane.showMessageDialog(this, "Aún no se han registrado los empaques.");
        return;
        }

        double promedioJornada = fabrica.getPromedioJornada();
        double promedioTotal = fabrica.getPromedioTotal();

        JOptionPane.showMessageDialog(this, "Promedio de empaques en la jornada: " + promedioJornada
                + "\nPromedio total de empaques: " + promedioTotal);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    List<Empacador> empacadoresNoContinuan = fabrica.obtenerEmpacadoresNoContinuan();

    if (empacadoresNoContinuan.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los empacadores han superado los 100 empaques.");
    } else {
        StringBuilder mensaje = new StringBuilder("Empacadores que no continúan (menos de 100 empaques):\n");
        for (Empacador empacador : empacadoresNoContinuan) {
            mensaje.append(empacador.getNombre()).append(" con ")
                    .append(empacador.getTotalEmpaques()).append(" empaques.\n");
        }
        JOptionPane.showMessageDialog(this, mensaje.toString());
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        for (Empacador empacador : fabrica.getEmpacadores()) {
        empacador.setEmpaquesManana(0);
        empacador.setEmpaquesTarde(0);
        }
        JOptionPane.showMessageDialog(this, "Los registros de empaques se han reiniciado para un nuevo día.");
    }//GEN-LAST:event_jButton5ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
