/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.petugas;

import DB.Petugas;
import java.util.Arrays;
import javax.swing.JOptionPane;
import tools.Security;

/**
 *
 * @author ASUS
 */
public class TambahPetugas extends javax.swing.JFrame {

    /**
     * Creates new form TambahPetugas
     */
    public TambahPetugas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupGender = new javax.swing.ButtonGroup();
        namaTxt = new javax.swing.JTextField();
        radioBtnPria = new javax.swing.JRadioButton();
        radioBtnWanita = new javax.swing.JRadioButton();
        emailTxt = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        pilihRole = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        grupGender.add(radioBtnPria);
        radioBtnPria.setText("Pria");
        radioBtnPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPriaActionPerformed(evt);
            }
        });

        grupGender.add(radioBtnWanita);
        radioBtnWanita.setText("Wanita");
        radioBtnWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnWanitaActionPerformed(evt);
            }
        });

        pilihRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Role", "Admin", "Petugas" }));

        btnTambah.setText("TAMBAH PETUGAS");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama");

        jLabel2.setText("Email");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioBtnPria, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioBtnWanita, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(namaTxt)
                    .addComponent(emailTxt)
                    .addComponent(usernameTxt)
                    .addComponent(passwordTxt)
                    .addComponent(pilihRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBtnPria)
                    .addComponent(radioBtnWanita))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(pilihRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnTambah)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String nama = namaTxt.getText();
        String email = emailTxt.getText();
        String username = usernameTxt.getText();
        char[] password = passwordTxt.getPassword();
        String role = pilihRole.getSelectedItem().toString();
        if (Security.validatePassword(password)) {
            JOptionPane.showMessageDialog(null, "Terdapat Karakter Khusus di Password", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else if (nama.isEmpty() || pilihRole.getSelectedIndex() == 0||email.isEmpty()||this.gender.isEmpty() || username.isEmpty() || password.length == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan isi data hingga lengkap", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else if (petugasModel.checkUser(username)) {
            JOptionPane.showMessageDialog(null, "Username sudah terdaftar", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            String hashPassword = Security.hashPassword(new String(password));
//            nama, jenis_kelamin, email, username, password, role
            String[] data = {nama, this.gender, email, username, hashPassword, role};
            petugasModel.insertPetugas(data);
            JOptionPane.showMessageDialog(null, "Berhasil menambah mendaftarkan petugas", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            resetAll();
        }
    }//GEN-LAST:event_btnTambahActionPerformed
    
    private void resetAll(){
        pilihRole.setSelectedIndex(0);
        namaTxt.setText("");
        emailTxt.setText("");
        passwordTxt.setText("");
        grupGender.clearSelection();
    }
    
    private void radioBtnPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPriaActionPerformed
        // TODO add your handling code here:
        this.gender = radioBtnPria.getText();
    }//GEN-LAST:event_radioBtnPriaActionPerformed

    private void radioBtnWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnWanitaActionPerformed
        // TODO add your handling code here:
        this.gender = radioBtnWanita.getText();
    }//GEN-LAST:event_radioBtnWanitaActionPerformed

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
            java.util.logging.Logger.getLogger(TambahPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPetugas().setVisible(true);
            }
        });
    }
    private String gender = "";
    private Petugas petugasModel = new Petugas("petugas");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JTextField emailTxt;
    private javax.swing.ButtonGroup grupGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField namaTxt;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JComboBox<String> pilihRole;
    private javax.swing.JRadioButton radioBtnPria;
    private javax.swing.JRadioButton radioBtnWanita;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}
