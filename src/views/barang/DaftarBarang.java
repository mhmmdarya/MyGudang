/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.barang;

import views.login.Login;
import DB.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tools.Session;
import tools.Converter;

/**
 *
 * @author ASUS
 */
public class DaftarBarang extends javax.swing.JFrame {

    /**
     * Creates new form NewFrame
     */
    public DaftarBarang() {
        initComponents();
        setLocationRelativeTo(null);
//        JOptionPane.showMessageDialog(null, "Hallo " + nama, "Selamat Datang", JOptionPane.PLAIN_MESSAGE);
        labelNama.setText(nama);
        labelRole.setText(role);
        editBtn.setVisible(false);
        labelJmlBarang.setText("" + barang.getTotalData());
        labelTransaksi.setText("" + barangKeluar.getTotalData());
        btnPetugas.setVisible(false);
        if (role.equalsIgnoreCase("admin")) {
            btnPetugas.setVisible(true);
        }
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
        panelBarang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelJmlBarang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelBarang2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelTransaksi1 = new javax.swing.JLabel();
        panelBarang1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelTransaksi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        labelRole = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        findBarang = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        btnPetugas = new javax.swing.JButton();
        test = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(83, 113, 136));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarang.setBackground(new java.awt.Color(51, 47, 208));
        panelBarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Barang");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelBarang.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        labelJmlBarang.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelJmlBarang.setForeground(new java.awt.Color(255, 255, 255));
        labelJmlBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJmlBarang.setText("0");
        panelBarang.add(labelJmlBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        jPanel1.add(panelBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 210, 80));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            barang.getDataBarang(),
            listBarang
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 950, 500));

        panelBarang2.setBackground(new java.awt.Color(84, 180, 53));
        panelBarang2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBarang2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Transaksi Barang Masuk");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelBarang2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        labelTransaksi1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelTransaksi1.setForeground(new java.awt.Color(255, 255, 255));
        labelTransaksi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTransaksi1.setText("0");
        panelBarang2.add(labelTransaksi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        jPanel1.add(panelBarang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 210, 80));

        panelBarang1.setBackground(new java.awt.Color(237, 43, 42));
        panelBarang1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBarang1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Transaksi Barang Keluar");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelBarang1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        labelTransaksi.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        labelTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTransaksi.setText("0");
        panelBarang1.add(labelTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        jPanel1.add(panelBarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 80));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, 30));

        labelNama.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelNama.setForeground(new java.awt.Color(51, 51, 51));
        labelNama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNama.setText("nama");
        jPanel2.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 590, 30));

        labelRole.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelRole.setForeground(new java.awt.Color(51, 51, 51));
        labelRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRole.setText("role");
        jPanel2.add(labelRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 590, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jButton1.setText("Tambah Barang Baru");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 160, 30));

        findBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                findBarangKeyTyped(evt);
            }
        });
        jPanel1.add(findBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 192, 180, 30));

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 130, 30));

        btnPetugas.setText("Daftar Petugas");
        jPanel1.add(btnPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 120, 30));

        test.setText("jLabel4");
        jPanel1.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Session.resetAll();
        new Login().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new EditBarang().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int nomor = jTable1.getSelectedRow();
        this.idBarang = Integer.parseInt(jTable1.getValueAt(nomor, 0).toString());
        findBarang.setText(jTable1.getValueAt(nomor, 0).toString());
        editBtn.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        new EditBarang(this.idBarang).setVisible(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void findBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findBarangKeyTyped
        // TODO add your handling code here:
        String findName = findBarang.getText();
        test.setText(findBarang.getText());
        Object[][] datas = Converter.convertArray(barang.findBarangByName(findName));
        jTable1.setModel(new DefaultTableModel(datas, listBarang));
    }//GEN-LAST:event_findBarangKeyTyped

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
            java.util.logging.Logger.getLogger(DaftarBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarBarang().setVisible(true);
            }
        });
    }

    private int idBarang = 0;
    private String nama = Session.getName();
    private String role = Session.getRole();
    private Barang barang = new Barang("barang");
    private BarangKeluar barangKeluar = new BarangKeluar("barang_keluar");
    private String[] listBarang = {"ID", "Nama Barang", "Jumlah", "Nama Supplier"};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPetugas;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField findBarang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelJmlBarang;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRole;
    private javax.swing.JLabel labelTransaksi;
    private javax.swing.JLabel labelTransaksi1;
    private javax.swing.JPanel panelBarang;
    private javax.swing.JPanel panelBarang1;
    private javax.swing.JPanel panelBarang2;
    private javax.swing.JLabel test;
    // End of variables declaration//GEN-END:variables
}
