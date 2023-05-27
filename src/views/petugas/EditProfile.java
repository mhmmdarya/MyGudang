/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.petugas;

import DB.Petugas;
import javax.swing.JOptionPane;
import tools.Security;
import tools.Session;

/**
 *
 * @author ASUS
 */
public class EditProfile extends javax.swing.JFrame {

    /**
     * Creates new form EditProfile
     */
    public EditProfile(int id) {
        initComponents();
        String[] data = petugasModel.getDataById(id);
        setData(data);
    }

    private void setData(String[] data) {
        namaTxt.setText(data[0]);
        emailTxt.setText(data[1]);
        usernameTxt.setText(data[2]);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namaTxt = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGantiPassword = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 65, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(namaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 206, -1));
        jPanel1.add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 206, -1));
        jPanel1.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 206, -1));

        jToggleButton1.setText("Ganti Profil");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 124, -1));

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Nama");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 37, -1));

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Email");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 37, -1));

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 58, -1));

        btnGantiPassword.setText("Ganti Password");
        btnGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGantiPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(btnGantiPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 146, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(namaTxt.getText().isEmpty() || emailTxt.getText().isEmpty() || usernameTxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Silahkan isi data dengan lengkap");
            return;
        }
        String input = JOptionPane.showInputDialog(null, "Masukkan Password anda", "Confirm Password", JOptionPane.INFORMATION_MESSAGE);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Isi password terlebih dahulu");
        } else {
            String hash = Security.hashPassword(input);
            if (petugasModel.confirmPassword(Session.getId(), hash)) {
                String[] datas = {namaTxt.getText(), emailTxt.getText(), usernameTxt.getText()};
                petugasModel.editProfile(Session.getId(), datas);
                JOptionPane.showMessageDialog(null, "Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnGantiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGantiPasswordActionPerformed
        new GantiPassword().setVisible(true);
    }//GEN-LAST:event_btnGantiPasswordActionPerformed

    private Petugas petugasModel = new Petugas("petugas");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGantiPassword;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField namaTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
