/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mvc.registro;


/**
 *
 * @author Ris3TwO
 */
public class RegistroVehiculo extends javax.swing.JDialog {

    /**
     * Creates new form RegisterVehicle
     * @param parent
     * @param modal
     */
    public int puesto;
    public RegistroVehiculo(java.awt.Frame parent, boolean modal) {
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPuestoNumero = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblNumeroApto = new javax.swing.JLabel();
        txtApartamento = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblNombreVisitante = new javax.swing.JLabel();
        txtNombreVisitante = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lblNombreVisitanteIcono = new javax.swing.JLabel();
        lblPlacaIcono = new javax.swing.JLabel();
        lblNumeroAptoIcono = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        lblNombreVisitante1 = new javax.swing.JLabel();
        lblNombreVisitanteIcono1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setAlignmentX(300.0F);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(153, 153, 0));
        lblTitulo.setText("Registro de Vehículo");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 10));

        lblPuestoNumero.setBackground(new java.awt.Color(0, 0, 0));
        lblPuestoNumero.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPuestoNumero.setText("PUESTO DE ESTACIONAMIENTO Nº");
        jPanel1.add(lblPuestoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        txtPlaca.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(153, 153, 153));
        txtPlaca.setBorder(null);
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 30));

        lblPlaca.setBackground(new java.awt.Color(0, 0, 0));
        lblPlaca.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPlaca.setText("Placa del Vehículo:");
        jPanel1.add(lblPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jSeparator2.setOpaque(true);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 230, 10));

        lblNumeroApto.setBackground(new java.awt.Color(0, 0, 0));
        lblNumeroApto.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblNumeroApto.setText("Número de Apartamento:");
        jPanel1.add(lblNumeroApto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, 20));

        txtApartamento.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtApartamento.setForeground(new java.awt.Color(153, 153, 153));
        txtApartamento.setBorder(null);
        jPanel1.add(txtApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 180, 30));

        jSeparator3.setOpaque(true);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 230, 10));

        lblNombreVisitante.setBackground(new java.awt.Color(0, 0, 0));
        lblNombreVisitante.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblNombreVisitante.setText("Numero de tarjeta");
        jPanel1.add(lblNombreVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        txtNombreVisitante.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNombreVisitante.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreVisitante.setBorder(null);
        jPanel1.add(txtNombreVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 180, 30));

        jSeparator4.setOpaque(true);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 230, 10));

        lblNombreVisitanteIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/026-parking-card-1.png"))); // NOI18N
        jPanel1.add(lblNombreVisitanteIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        lblPlacaIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/039-key-1.png"))); // NOI18N
        jPanel1.add(lblPlacaIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        lblNumeroAptoIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/021-placeholder.png"))); // NOI18N
        jPanel1.add(lblNumeroAptoIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multiply 1.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multiply 2.png"))); // NOI18N
        btnCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multiply 2.png"))); // NOI18N
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, 40));

        btn_save.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right 4.png"))); // NOI18N
        btn_save.setText("Registrar");
        btn_save.setBorder(null);
        btn_save.setBorderPainted(false);
        btn_save.setContentAreaFilled(false);
        btn_save.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right 3.png"))); // NOI18N
        btn_save.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right 3.png"))); // NOI18N
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, 40));

        lblNombreVisitante1.setBackground(new java.awt.Color(0, 0, 0));
        lblNombreVisitante1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblNombreVisitante1.setText("Nombre del Visitante:");
        jPanel1.add(lblNombreVisitante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        lblNombreVisitanteIcono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/026-parking-card-1.png"))); // NOI18N
        jPanel1.add(lblNombreVisitanteIcono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jSeparator5.setOpaque(true);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 230, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistroVehiculo dialog = new RegistroVehiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.out.println("Sslio");
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btn_save;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblNombreVisitante;
    private javax.swing.JLabel lblNombreVisitante1;
    private javax.swing.JLabel lblNombreVisitanteIcono;
    private javax.swing.JLabel lblNombreVisitanteIcono1;
    private javax.swing.JLabel lblNumeroApto;
    private javax.swing.JLabel lblNumeroAptoIcono;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPlacaIcono;
    private javax.swing.JLabel lblPuestoNumero;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApartamento;
    private javax.swing.JTextField txtNombreVisitante;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtn_save() {
        return btn_save;
    }

    public void setBtn_save(JButton btn_save) {
        this.btn_save = btn_save;
    }

    public JLabel getLblPuestoNumero() {
        return lblPuestoNumero;
    }

    public void setLblPuestoNumero(JLabel lblPuestoNumero) {
        this.lblPuestoNumero = lblPuestoNumero;
    }

    public JTextField getTxtApartamento() {
        return txtApartamento;
    }

    public void setTxtApartamento(JTextField txtApartamento) {
        this.txtApartamento = txtApartamento;
    }

    public JTextField getTxtNombreVisitante() {
        return txtNombreVisitante;
    }

    public void setTxtNombreVisitante(JTextField txtNombreVisitante) {
        this.txtNombreVisitante = txtNombreVisitante;
    }

    public JTextField getTxtPlaca() {
        return txtPlaca;
    }

    public void setTxtPlaca(JTextField txtPlaca) {
        this.txtPlaca = txtPlaca;
    }
    

}
