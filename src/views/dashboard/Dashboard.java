/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.dashboard;

import views.login.Login;
import DB.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tools.Session;
import tools.Converter;
import views.barang.TambahBarang;
import views.petugas.EditProfile;
import views.supplier.EditSupplier;
import views.supplier.TambahSupplier;
import views.transaksi.TransaksiKeluar;


public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        setLabelTotal();
        // set icon
        ImageIcon icon = new ImageIcon(Login.class.getResource("/assets/images/icon.png"));
        setIconImage(icon.getImage());

        labelNama.setText(nama);
        labelRole.setText(role);
        
        // set visible button
        btnHapus.setVisible(false);
        btnHapusSupplier.setVisible(false);
        btnEdit.setVisible(false);
//        btn
        tampilanSupplier.setVisible(false);
        tampilanPetugas.setVisible(false);
        tabelPetugas.setModel(new DefaultTableModel(petugasModel.getAllData(), listPetugas));
        setDataSupplier(supplierModel.selectAll());
    }

    private void setDataSupplier(Object[][] data){
        tabelSupplier.setModel(new DefaultTableModel(data, this.listSupplier));
    }
    
    private void setLabelTotal() {
        totalBarang.setText("" + barang.getTotalData());
        totalBarangMasuk.setText("" + barangMasuk.getTotalDataToday());
        totalBarangKeluar.setText("" + barangKeluar.getTotalDataToday());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        panelUser = new javax.swing.JPanel();
        labelRole = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        petugasKlik = new javax.swing.JLabel();
        barangKlik = new javax.swing.JLabel();
        supplierKlik = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        tampilanBarang = new javax.swing.JPanel();
        panelBarang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalBarang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        panelBarang2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totalBarangMasuk = new javax.swing.JLabel();
        panelBarang1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        totalBarangKeluar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        findBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnBarangMasuk = new javax.swing.JButton();
        btnBarangKeluar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        namaMenu = new javax.swing.JLabel();
        tampilanPetugas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPetugas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAddPetugas = new javax.swing.JButton();
        btnHapusPetugas = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        tampilanSupplier = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelSupplier = new javax.swing.JTable();
        btnSuppBaru = new javax.swing.JButton();
        btnRefreshSupp = new javax.swing.JButton();
        btnHapusSupplier = new javax.swing.JButton();
        btnEditSupplier = new javax.swing.JButton();
        btnLogout2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(83, 113, 136));
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 670));

        panelUser.setBackground(new java.awt.Color(255, 255, 255));
        panelUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true), "M E N U", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("MS PGothic", 2, 14))); // NOI18N
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRole.setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
        labelRole.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRole.setText("role");
        panelUser.add(labelRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, -1));

        labelNama.setBackground(new java.awt.Color(0, 0, 0));
        labelNama.setFont(new java.awt.Font("MS PGothic", 1, 18)); // NOI18N
        labelNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNama.setText("nama");
        labelNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelNamaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelNamaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelNamaMouseExited(evt);
            }
        });
        panelUser.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/home.png"))); // NOI18N
        panelUser.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 270, 430));

        petugasKlik.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        petugasKlik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesIcon/worker.png"))); // NOI18N
        petugasKlik.setText("Daftar Petugas");
        petugasKlik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                petugasKlikMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petugasKlikMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                petugasKlikMouseExited(evt);
            }
        });
        panelUser.add(petugasKlik, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 30));

        barangKlik.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        barangKlik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesIcon/warehouseIcon.png"))); // NOI18N
        barangKlik.setText("Warehouse");
        barangKlik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangKlikMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barangKlikMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barangKlikMouseExited(evt);
            }
        });
        panelUser.add(barangKlik, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        supplierKlik.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        supplierKlik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesIcon/supplier.png"))); // NOI18N
        supplierKlik.setText("Daftar SUPPLIER");
        supplierKlik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierKlikMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierKlikMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplierKlikMouseExited(evt);
            }
        });
        panelUser.add(supplierKlik, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelUser.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 270, 10));

        getContentPane().add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 650));

        jPanel4.setBackground(new java.awt.Color(83, 113, 136));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 670));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1010, 670));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tampilanBarang.setBackground(new java.awt.Color(83, 113, 136));
        tampilanBarang.setPreferredSize(new java.awt.Dimension(1010, 670));
        tampilanBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarang.setBackground(new java.awt.Color(51, 47, 208));
        panelBarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBarang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total Barang");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelBarang.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        totalBarang.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        totalBarang.setForeground(new java.awt.Color(255, 255, 255));
        totalBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBarang.setText("0");
        panelBarang.add(totalBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        tampilanBarang.add(panelBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 210, 80));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            barang.getDataBarang(),
            listBarang
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        tampilanBarang.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 950, 380));

        panelBarang2.setBackground(new java.awt.Color(84, 180, 53));
        panelBarang2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBarang2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Barang Masuk Hari Ini");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelBarang2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        totalBarangMasuk.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        totalBarangMasuk.setForeground(new java.awt.Color(255, 255, 255));
        totalBarangMasuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBarangMasuk.setText("0");
        panelBarang2.add(totalBarangMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        tampilanBarang.add(panelBarang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 210, 80));

        panelBarang1.setBackground(new java.awt.Color(237, 43, 42));
        panelBarang1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBarang1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Barang Keluar Hari ini");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelBarang1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        totalBarangKeluar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        totalBarangKeluar.setForeground(new java.awt.Color(255, 255, 255));
        totalBarangKeluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBarangKeluar.setText("0");
        panelBarang1.add(totalBarangKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        tampilanBarang.add(panelBarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 80));

        jButton1.setText("Tambah Barang Baru");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tampilanBarang.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 160, 30));

        findBarang.setText("Cari barang berdasarkan nama");
        findBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                findBarangKeyTyped(evt);
            }
        });
        tampilanBarang.add(findBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 260, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/inventory-icon-vector-11.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tampilanBarang.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 80));

        btnHapus.setText("Hapus Barang");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        tampilanBarang.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 110, 30));

        btnBarangMasuk.setText("Barang Masuk");
        btnBarangMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangMasukActionPerformed(evt);
            }
        });
        tampilanBarang.add(btnBarangMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 110, 30));

        btnBarangKeluar.setText("Barang Keluar");
        btnBarangKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangKeluarActionPerformed(evt);
            }
        });
        tampilanBarang.add(btnBarangKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 110, 30));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        tampilanBarang.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 630, 120, -1));

        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        tampilanBarang.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, 30));

        btnEdit.setText("Edit Nama Barang");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        tampilanBarang.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 130, 30));

        namaMenu.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        namaMenu.setForeground(new java.awt.Color(255, 255, 255));
        namaMenu.setText("MyGudang");
        tampilanBarang.add(namaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jLayeredPane1.add(tampilanBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 670));

        tampilanPetugas.setBackground(new java.awt.Color(83, 113, 136));
        tampilanPetugas.setPreferredSize(new java.awt.Dimension(1010, 670));
        tampilanPetugas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelPetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelPetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPetugasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelPetugas);

        tampilanPetugas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 840, 400));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Daftar Petugas");
        tampilanPetugas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 230, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/6345962.png"))); // NOI18N
        tampilanPetugas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        btnAddPetugas.setText("Tambah");
        btnAddPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPetugasActionPerformed(evt);
            }
        });
        tampilanPetugas.add(btnAddPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 120, -1));

        btnHapusPetugas.setText("Hapus");
        btnHapusPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPetugasActionPerformed(evt);
            }
        });
        tampilanPetugas.add(btnHapusPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 120, -1));

        btnLogout1.setText("Logout");
        btnLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogout1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogout1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogout1MouseExited(evt);
            }
        });
        btnLogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout1ActionPerformed(evt);
            }
        });
        tampilanPetugas.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, 30));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        tampilanPetugas.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 630, 130, -1));

        jLayeredPane1.add(tampilanPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 670));

        tampilanSupplier.setBackground(new java.awt.Color(83, 113, 136));
        tampilanSupplier.setPreferredSize(new java.awt.Dimension(1010, 670));
        tampilanSupplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSupplierMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelSupplier);

        tampilanSupplier.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 230, 950, 380));

        btnSuppBaru.setText("Tambah Data Supplier Baru");
        btnSuppBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppBaruActionPerformed(evt);
            }
        });
        tampilanSupplier.add(btnSuppBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 190, -1));

        btnRefreshSupp.setText("Refresh");
        btnRefreshSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSuppActionPerformed(evt);
            }
        });
        tampilanSupplier.add(btnRefreshSupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 620, 110, -1));

        btnHapusSupplier.setText("Hapus");
        btnHapusSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusSupplierActionPerformed(evt);
            }
        });
        tampilanSupplier.add(btnHapusSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 110, -1));

        btnEditSupplier.setText("Edit");
        btnEditSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSupplierActionPerformed(evt);
            }
        });
        tampilanSupplier.add(btnEditSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 130, -1));

        btnLogout2.setText("Logout");
        btnLogout2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogout2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogout2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogout2MouseExited(evt);
            }
        });
        btnLogout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout2ActionPerformed(evt);
            }
        });
        tampilanSupplier.add(btnLogout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, -1, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SUPPLIER");
        tampilanSupplier.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 73, 130, 40));

        jLayeredPane1.add(tampilanSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 670));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 1030, 670));

        jPanel6.setBackground(new java.awt.Color(83, 113, 136));
        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 290, -1));

        jPanel7.setBackground(new java.awt.Color(83, 113, 136));
        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 290, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new TambahBarang().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        int nomor = tabelBarang.getSelectedRow();
        this.idBarang = Integer.parseInt(tabelBarang.getValueAt(nomor, 0).toString());
        this.namaBarang = tabelBarang.getValueAt(nomor, 1).toString();
        btnHapus.setVisible(true);
        btnEdit.setVisible(true);
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void findBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findBarangKeyTyped
        // TODO add your handling code here:
        String findName = findBarang.getText();
        Object[][] datas = Converter.convertArray(barang.findBarangByName(findName));
        tabelBarang.setModel(new DefaultTableModel(datas, listBarang));
    }//GEN-LAST:event_findBarangKeyTyped

    public void refresh() {
        totalBarang.setText("" + barang.getTotalData());
        tabelBarang.setModel(new DefaultTableModel(barang.getDataBarang(), listBarang));
        tabelPetugas.setModel(new DefaultTableModel(petugasModel.getAllData(), listPetugas));
        btnHapus.setVisible(false);
        btnEdit.setVisible(false);
        this.idBarang = 0;
        this.idPetugas = 0;
        this.namaBarang = "";
        setLabelTotal();
    }

    private void btnBarangMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangMasukActionPerformed
        // TODO add your handling code here:
        new views.transaksi.TransaksiMasuk().setVisible(true);
    }//GEN-LAST:event_btnBarangMasukActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void petugasKlikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petugasKlikMouseClicked
        // TODO add your handling code here:
        if (role.equalsIgnoreCase("petugas")) {
            JOptionPane.showMessageDialog(null, "Maaf Anda Tidak Dapat Mengakses Ini", "Pesan", JOptionPane.WARNING_MESSAGE);
            tampilanPetugas.setVisible(false);
            tampilanSupplier.setVisible(false);
            tampilanBarang.setVisible(true);
        } else {
            tampilanPetugas.setVisible(true);
            tampilanSupplier.setVisible(false);
            tampilanBarang.setVisible(false);
        }
    }//GEN-LAST:event_petugasKlikMouseClicked

    private void barangKlikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangKlikMouseClicked
        tampilanPetugas.setVisible(false);
        tampilanBarang.setVisible(true);
    }//GEN-LAST:event_barangKlikMouseClicked

    private void petugasKlikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petugasKlikMouseEntered
        petugasKlik.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_petugasKlikMouseEntered

    private void petugasKlikMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petugasKlikMouseExited
        petugasKlik.setForeground(Color.black);
    }//GEN-LAST:event_petugasKlikMouseExited

    private void barangKlikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangKlikMouseEntered
        barangKlik.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_barangKlikMouseEntered

    private void barangKlikMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangKlikMouseExited
        barangKlik.setForeground(Color.black);
    }//GEN-LAST:event_barangKlikMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnLogout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MouseClicked
    }//GEN-LAST:event_btnLogout1MouseClicked

    private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogout1ActionPerformed

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        btnLogout.setForeground(Color.white);
        btnLogout.setBackground(Color.red);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setForeground(Color.black);
        btnLogout.setBackground(Color.white);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MouseEntered
        btnLogout1.setForeground(Color.white);
        btnLogout1.setBackground(Color.red);
    }//GEN-LAST:event_btnLogout1MouseEntered

    private void btnLogout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MouseExited
        btnLogout1.setForeground(Color.black);
        btnLogout1.setBackground(Color.white);
    }//GEN-LAST:event_btnLogout1MouseExited

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (this.idBarang == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih barang yang ingin dihapus terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int option = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?", "WARNING", JOptionPane.WARNING_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            barang.deleteBarang(idBarang);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data barang", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            refresh();
        } else {
            refresh();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (this.idBarang == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih barang yang ingin diedit terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            String editNama = JOptionPane.showInputDialog(null, "Nama Barang", this.namaBarang);
            barang.editNamaBarang(this.idBarang, editNama);
            JOptionPane.showMessageDialog(null, "Berhasil mengedit nama barang", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            refresh();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refresh();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void btnAddPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPetugasActionPerformed
        new views.petugas.TambahPetugas().setVisible(true);
    }//GEN-LAST:event_btnAddPetugasActionPerformed

    private void btnHapusPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPetugasActionPerformed
        if (idPetugas == 0) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int option = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data?", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            petugasModel.deletePetugas(idPetugas);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data petugas", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            refresh();
        } else if(option == JOptionPane.CANCEL_OPTION){
            idPetugas = 0;
        }
    }//GEN-LAST:event_btnHapusPetugasActionPerformed

    private void tabelPetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPetugasMouseClicked
        int nomor = tabelPetugas.getSelectedRow();
        this.idPetugas = Integer.parseInt((String) tabelPetugas.getValueAt(nomor, 0));
    }//GEN-LAST:event_tabelPetugasMouseClicked

    private void btnBarangKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangKeluarActionPerformed
        new TransaksiKeluar().setVisible(true);
    }//GEN-LAST:event_btnBarangKeluarActionPerformed

    private void supplierKlikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierKlikMouseEntered
        supplierKlik.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_supplierKlikMouseEntered

    private void supplierKlikMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierKlikMouseExited
        supplierKlik.setForeground(Color.black);
    }//GEN-LAST:event_supplierKlikMouseExited

    private void supplierKlikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierKlikMouseClicked
        tampilanBarang.setVisible(false);
        tampilanPetugas.setVisible(false);
        tampilanSupplier.setVisible(true);
    }//GEN-LAST:event_supplierKlikMouseClicked

    private void btnSuppBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppBaruActionPerformed
        new TambahSupplier().setVisible(true);
    }//GEN-LAST:event_btnSuppBaruActionPerformed

    private void btnRefreshSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSuppActionPerformed
        refreshSupplier();
    }//GEN-LAST:event_btnRefreshSuppActionPerformed

    private void tabelSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSupplierMouseClicked
        // TODO add your handling code here:
        btnHapusSupplier.setVisible(true);
        int nomor = tabelSupplier.getSelectedRow();
        this.idSupplier = Integer.parseInt((String) tabelSupplier.getValueAt(nomor, 0));
    }//GEN-LAST:event_tabelSupplierMouseClicked

    private void btnHapusSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusSupplierActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data supplier ini?", "Warning", JOptionPane.WARNING_MESSAGE);
        if(option == JOptionPane.OK_OPTION){
            supplierModel.delete(idSupplier);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data supplier", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            refreshSupplier();
        }
    }//GEN-LAST:event_btnHapusSupplierActionPerformed

    private void btnEditSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSupplierActionPerformed
        if(idSupplier == 0){
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin diedit terlebih dahulu", "Warning", JOptionPane.WARNING_MESSAGE);
            refreshSupplier();
        } else {
            new EditSupplier(idSupplier).setVisible(true);
        }
    }//GEN-LAST:event_btnEditSupplierActionPerformed

    private void labelNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNamaMouseClicked
        new EditProfile(Session.getId()).setVisible(true);
    }//GEN-LAST:event_labelNamaMouseClicked

    private void labelNamaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNamaMouseEntered
        labelNama.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_labelNamaMouseEntered

    private void labelNamaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelNamaMouseExited
        labelNama.setForeground(Color.black);
    }//GEN-LAST:event_labelNamaMouseExited

    private void btnLogout2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout2MouseClicked
    }//GEN-LAST:event_btnLogout2MouseClicked

    private void btnLogout2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout2MouseEntered
        btnLogout2.setForeground(Color.white);
        btnLogout2.setBackground(Color.red);
    }//GEN-LAST:event_btnLogout2MouseEntered

    private void btnLogout2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout2MouseExited
        btnLogout2.setForeground(Color.black);
        btnLogout2.setBackground(Color.white);
    }//GEN-LAST:event_btnLogout2MouseExited

    private void btnLogout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout2ActionPerformed
        setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogout2ActionPerformed

    private void refreshSupplier(){
        tabelSupplier.setModel(new DefaultTableModel(supplierModel.selectAll(), listSupplier));
        this.idSupplier = 0;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    private String namaBarang = "";
    private int idBarang = 0;
    private int idPetugas = 0;
    private String nama = Session.getName();
    private String role = Session.getRole();
//    private String role = "Admin";
    private Barang barang = new Barang("barang");
    private BarangMasuk barangMasuk = new BarangMasuk("barang_masuk");
    private BarangKeluar barangKeluar = new BarangKeluar("barang_keluar");
    private String[] listBarang = {"ID Barang", "Nama Barang", "Jumlah", "Nama Supplier"};

    //Deklarasi Petugas
    private Petugas petugasModel = new Petugas("petugas");
    private String[] listPetugas = {"ID", "Nama", "Jenis Kelamin", "Email", "Username", "Role"};

    //Deklarasi Supplier
    private Supplier supplierModel = new Supplier("supplier");
    private String[] listSupplier = {"ID", "Nama", "Alamat", "Nomor Telepon"};
    private int idSupplier = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barangKlik;
    private javax.swing.JButton btnAddPetugas;
    private javax.swing.JButton btnBarangKeluar;
    private javax.swing.JButton btnBarangMasuk;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditSupplier;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapusPetugas;
    private javax.swing.JButton btnHapusSupplier;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnLogout2;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefreshSupp;
    private javax.swing.JButton btnSuppBaru;
    private javax.swing.JTextField findBarang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRole;
    private javax.swing.JLabel namaMenu;
    private javax.swing.JPanel panelBarang;
    private javax.swing.JPanel panelBarang1;
    private javax.swing.JPanel panelBarang2;
    private javax.swing.JPanel panelUser;
    private javax.swing.JLabel petugasKlik;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel supplierKlik;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTable tabelPetugas;
    private javax.swing.JTable tabelSupplier;
    private javax.swing.JPanel tampilanBarang;
    private javax.swing.JPanel tampilanPetugas;
    private javax.swing.JPanel tampilanSupplier;
    private javax.swing.JLabel totalBarang;
    private javax.swing.JLabel totalBarangKeluar;
    private javax.swing.JLabel totalBarangMasuk;
    // End of variables declaration//GEN-END:variables
}
