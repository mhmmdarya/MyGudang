/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.barang;

import DB.Barang;
import DB.Supplier;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import views.login.Login;

/**
 *
 * @author ASUS
 */
public class TambahBarang extends javax.swing.JFrame {

    /**
     * Creates new form TambahBarang
     */
    public TambahBarang() {
        initComponents();
        setLocationRelativeTo(null);
        setList();
        
        // set icon
        ImageIcon icon = new ImageIcon(Login.class.getResource("/assets/images/icon.png"));
        setIconImage(icon.getImage());
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
        listSupplier = new javax.swing.JComboBox<>();
        namaTxt = new javax.swing.JTextField();
        jumlahBarang = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(83, 113, 136));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSupplierActionPerformed(evt);
            }
        });
        jPanel1.add(listSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 309, -1));
        jPanel1.add(namaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 309, -1));
        jPanel1.add(jumlahBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 309, -1));

        jLabel1.setBackground(new java.awt.Color(83, 113, 136));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama Barang");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 77, -1));

        jLabel2.setBackground(new java.awt.Color(83, 113, 136));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jumlah");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 77, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Supplier");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 77, -1));

        btnTambah.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnTambah.setText("T A M B A H");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 400, -1));

        jLabel5.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tambah Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/inventory-management.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSupplierActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_listSupplierActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String nama = namaTxt.getText();
        int jumlah = (int) jumlahBarang.getValue();
        String supp = listSupplier.getSelectedItem().toString();
        if (nama.isEmpty() || jumlah == 0) {
            JOptionPane.showMessageDialog(null, "Isi data barang terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            int idSupplier = supplierModel.findId(supp);
            barangModel.insertBarang(nama, jumlah, idSupplier);
            JOptionPane.showMessageDialog(null, "Berhasil menginput barang", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    public void setList() {
        Object[][] listData = supplierModel.getList();
        for (int i = 0; i < listData.length; i++) {
            listSupplier.addItem((String) listData[i][1]);
        }
    }

    private Barang barangModel = new Barang("barang");
    private Supplier supplierModel = new Supplier("supplier");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jumlahBarang;
    private javax.swing.JComboBox<String> listSupplier;
    private javax.swing.JTextField namaTxt;
    // End of variables declaration//GEN-END:variables
}
