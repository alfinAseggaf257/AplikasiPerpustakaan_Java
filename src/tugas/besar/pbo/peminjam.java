/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.besar.pbo;
import java.sql.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.KoneksiDB;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class peminjam extends javax.swing.JFrame {

    /**
     * Creates new form formpeminjam
     */
    public peminjam() {
        initComponents();
        this.setLocationRelativeTo(null);
        init();
        tampildata();
    }

     private void init(){
        txt_nik_peminjam.setText("");
        txt_nama_peminjam.setText("");
        txt_notelp_peminjam.setText("");
        txt_alamat_peminjam.setText("");
        
        cmb_jenkel_peminjam.removeAllItems();
        cmb_jenkel_peminjam.addItem("Laki-laki");
        cmb_jenkel_peminjam.addItem("Perempuan");
    }
    private void tampildata(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIK ");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Nomor Telp");
        model.addColumn("Alamat");
        tbl_peminjam.setModel(model);
        try {            
            String sql = "SELECT * FROM peminjam";
            java.sql.Connection conn=(Connection)Koneksi.KoneksiDB.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()) {                
                Object[] obj = new Object[5];
                obj[0] = res.getString("nik_peminjam"); 
                obj[1] = res.getString("nama_peminjam");
                obj[2] = res.getString("jenkel_peminjam");
                obj[3] = res.getString("notelp_peminjam");
                obj[4] = res.getString("alamat_peminjam");

                model.addRow(obj);
            }
            tbl_peminjam.setModel(model);
            //s.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(peminjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_alamat_peminjam = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        nama3 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_peminjam = new javax.swing.JTable();
        txt_nama_peminjam = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nik_peminjam = new javax.swing.JTextField();
        nama4 = new javax.swing.JLabel();
        btn_hapus = new javax.swing.JButton();
        txt_notelp_peminjam = new javax.swing.JTextField();
        nama1 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        nama2 = new javax.swing.JLabel();
        cmb_jenkel_peminjam = new javax.swing.JComboBox<>();
        btn_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_alamat_peminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 221, 197, 32));

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 259, 94, -1));

        nama3.setBackground(new java.awt.Color(255, 255, 255));
        nama3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama3.setText("Nomor Telp");
        getContentPane().add(nama3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 177, 92, 32));

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 259, 94, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbl_peminjam.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_peminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_peminjamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_peminjam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 293, -1, 115));
        getContentPane().add(txt_nama_peminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 101, 197, 32));

        nama.setBackground(new java.awt.Color(255, 255, 255));
        nama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama.setText("Jenis Kelamin");
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 139, -1, 32));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setForeground(new java.awt.Color(204, 153, 255));

        jLabel1.setBackground(new java.awt.Color(51, 0, 255));
        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Peminjam");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(318, 318, 318))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 757, -1));
        getContentPane().add(txt_nik_peminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 63, 197, 32));

        nama4.setBackground(new java.awt.Color(255, 255, 255));
        nama4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama4.setText("Alamat");
        getContentPane().add(nama4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 221, 150, 32));

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 259, 94, -1));
        getContentPane().add(txt_notelp_peminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 178, 198, 32));

        nama1.setBackground(new java.awt.Color(255, 255, 255));
        nama1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama1.setText("NIK Peminjam");
        getContentPane().add(nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 62, -1, 32));

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 259, 94, -1));

        nama2.setBackground(new java.awt.Color(255, 255, 255));
        nama2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama2.setText("Nama Peminjam");
        getContentPane().add(nama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 95, -1, 32));

        cmb_jenkel_peminjam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmb_jenkel_peminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 139, 198, 32));

        btn_menu.setText("Menu Utama");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });
        getContentPane().add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 62, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
       resetdata();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            String sql ="UPDATE peminjam SET nama_peminjam = '"+txt_nama_peminjam.getText()+"', "
             + "jenkel_peminjam = '"+cmb_jenkel_peminjam.getSelectedItem()+"',"
             + "notelp_peminjam= '"+txt_notelp_peminjam.getText()+"',"
            + "alamat_peminjam= '"+txt_alamat_peminjam.getText()+"' WHERE nik_peminjam = '"+txt_nik_peminjam.getText()+"'";
            System.out.println(sql);
            java.sql.Connection conn=(Connection)KoneksiDB.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di edit");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        tampildata();
        resetdata();
    }//GEN-LAST:event_btn_editActionPerformed

    private void tbl_peminjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_peminjamMouseClicked
        int baris = tbl_peminjam.rowAtPoint(evt.getPoint());
        String nik_peminjam =tbl_peminjam.getValueAt(baris, 0).toString();
        txt_nik_peminjam.setText(nik_peminjam);
        String nama_peminjam = tbl_peminjam.getValueAt(baris,1).toString();
        txt_nama_peminjam.setText(nama_peminjam);
        String jenkel_peminjam = tbl_peminjam.getValueAt(baris, 2).toString();
        cmb_jenkel_peminjam.setSelectedItem(jenkel_peminjam);
        String notelp_peminjam=tbl_peminjam.getValueAt(baris, 3).toString();
        txt_notelp_peminjam.setText(notelp_peminjam);
        String alamat_peminjam=tbl_peminjam.getValueAt(baris, 4).toString();
        txt_alamat_peminjam.setText(alamat_peminjam);
    }//GEN-LAST:event_tbl_peminjamMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            String sql ="DELETE FROM peminjam WHERE nik_peminjam='"+txt_nik_peminjam.getText()+"'";
            java.sql.Connection conn=(Connection)KoneksiDB.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Berhasil di hapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampildata();
        resetdata();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            String sql = "INSERT INTO peminjam (nik_peminjam,nama_peminjam,jenkel_peminjam,notelp_peminjam,alamat_peminjam) VALUES "
            + "('"+txt_nik_peminjam.getText()+"',"
            + "'"+txt_nama_peminjam.getText()+"',"
            + "'"+cmb_jenkel_peminjam.getSelectedItem()+"',"
            + "'"+txt_notelp_peminjam.getText()+"',"
            + "'"+txt_alamat_peminjam.getText()+"')";
            java.sql.Connection conn=(Connection)KoneksiDB.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            tampildata();
            resetdata();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
     
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        formmenu a = new formmenu();
        a.setVisible(true);
        this.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btn_menuActionPerformed
    private void resetdata(){
        txt_nik_peminjam.setText(null);
        txt_nama_peminjam.setText(null);
        cmb_jenkel_peminjam.setSelectedItem(this);
        txt_notelp_peminjam.setText(null);
        txt_alamat_peminjam.setText(null);  
    }
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
            java.util.logging.Logger.getLogger(peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(peminjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new peminjam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cmb_jenkel_peminjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nama1;
    private javax.swing.JLabel nama2;
    private javax.swing.JLabel nama3;
    private javax.swing.JLabel nama4;
    private javax.swing.JTable tbl_peminjam;
    private javax.swing.JTextField txt_alamat_peminjam;
    private javax.swing.JTextField txt_nama_peminjam;
    private javax.swing.JTextField txt_nik_peminjam;
    private javax.swing.JTextField txt_notelp_peminjam;
    // End of variables declaration//GEN-END:variables
}
