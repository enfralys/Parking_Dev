/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author leonardo
 */
public class VisorTarjeta extends javax.swing.JDialog {

    /**
     * Creates new form Registro_Tarjeta
     */
    public VisorTarjeta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPeatones = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tlbHistorialTarjeta = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        txtNombrePeaton5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBuscaT = new javax.swing.JTextField();
        lbltiempo = new javax.swing.JLabel();
        txtconfig = new javax.swing.JTextField();
        btnconfig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnRegistroTarjeta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPeatones.setBackground(new java.awt.Color(255, 255, 255));
        pnlPeatones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlPeatones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Tarjetas");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 5, -1, -1));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, -20, 960, 90));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 820, 30));

        tlbHistorialTarjeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nro Parqueadero", "Codigo Interno"
            }
        ));
        jScrollPane4.setViewportView(tlbHistorialTarjeta);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 880, 320));

        pnlPeatones.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 880, 380));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombrePeaton5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombrePeaton5.setForeground(new java.awt.Color(153, 153, 153));
        txtNombrePeaton5.setBorder(null);
        jPanel11.add(txtNombrePeaton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 180, 30));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("Buscar Nro Parqueadero");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, -1));

        txtBuscaT.setToolTipText("Ingrese el  codigo de la tarjeta");
        jPanel11.add(txtBuscaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 310, 30));

        lbltiempo.setText("2 H");
        lbltiempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel11.add(lbltiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 30, 40));

        txtconfig.setText("                 ");
        jPanel11.add(txtconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, 20));

        btnconfig.setBackground(new java.awt.Color(255, 255, 255));
        btnconfig.setForeground(new java.awt.Color(255, 255, 255));
        btnconfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico_Save.png"))); // NOI18N
        btnconfig.setToolTipText("");
        btnconfig.setBorder(new javax.swing.border.MatteBorder(null));
        btnconfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfigActionPerformed(evt);
            }
        });
        jPanel11.add(btnconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 40, 40));

        jLabel2.setText("Insfractores");
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));
        jPanel11.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        pnlPeatones.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 880, 130));

        btnRegistroTarjeta.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnRegistroTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-20.png"))); // NOI18N
        btnRegistroTarjeta.setText("Registro de Tarjeta");
        btnRegistroTarjeta.setBorder(null);
        btnRegistroTarjeta.setBorderPainted(false);
        btnRegistroTarjeta.setContentAreaFilled(false);
        btnRegistroTarjeta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-30.png"))); // NOI18N
        btnRegistroTarjeta.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-30.png"))); // NOI18N
        btnRegistroTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroTarjetaActionPerformed(evt);
            }
        });
        pnlPeatones.add(btnRegistroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 967, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPeatones, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPeatones, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroTarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroTarjetaActionPerformed

    private void btnconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnconfigActionPerformed

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
            java.util.logging.Logger.getLogger(VisorTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisorTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisorTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisorTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisorTarjeta dialog = new VisorTarjeta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JButton getBtnRegistroTarjeta() {
        return btnRegistroTarjeta;
    }

    public void setBtnRegistroTarjeta(JButton btnRegistroTarjeta) {
        this.btnRegistroTarjeta = btnRegistroTarjeta;
    }

    public JTextField getTxtBuscaT() {
        return txtBuscaT;
    }

    public void setTxtBuscaT(JTextField txtBuscaT) {
        this.txtBuscaT = txtBuscaT;
    }

    public JTable getTlbHistorialTarjeta() {
        return tlbHistorialTarjeta;
    }

    public void setTlbHistorialTarjeta(JTable tlbHistorialTarjeta) {
        this.tlbHistorialTarjeta = tlbHistorialTarjeta;
    }
    public JButton getbtnconfig() {
        return btnconfig;
    }

    public void setbtnconfig(JButton btnconfig) {
        this.btnconfig = btnconfig;
    }
    
    public JTextField getTxtConfig() {
        return txtconfig;
    }

    public void setTxtConfig(JTextField txtconfig) {
        this.txtconfig = txtconfig;
    }
    public JLabel getlbltiempo() {
        return lbltiempo;
    }

    public void setlbltiempo(JLabel lbltiempo) {
        this.lbltiempo = lbltiempo;
    }
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistroTarjeta;
    private javax.swing.JButton btnconfig;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbltiempo;
    private javax.swing.JPanel pnlPeatones;
    private javax.swing.JTable tlbHistorialTarjeta;
    private javax.swing.JTextField txtBuscaT;
    private javax.swing.JTextField txtNombrePeaton5;
    private javax.swing.JTextField txtconfig;
    // End of variables declaration//GEN-END:variables

    
}
