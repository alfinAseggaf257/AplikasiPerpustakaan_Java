package tugas.besar.pbo;
import java.sql.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.KoneksiDB;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public final class detail_peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form detail_peminjaman
     */
    public detail_peminjaman() {
        initComponents();
        setLocationRelativeTo(this);
        tampildata();
        tampil_cmb_nip_pegawai();
        tampil_cmb_nik_peminjam();
        tampil_cmb_kode_buku();
        init();
        jbc_tanggal_pinjam.setDateFormatString("yyyy-MM-dd");
    }
    private void init(){
        txt_kode_pinjam.setText("");
    }
    public void tampil_cmb_nip_pegawai()
    {
        try {            
            String sql = "SELECT nip_pegawai FROM pegawai ";
            java.sql.Connection conn=(Connection)Koneksi.KoneksiDB.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()) {                
                Object[] obj = new Object[3];
                obj[0] = res.getString(1); 
                cmb_nip_pegawai.addItem((String) obj[0]);   
            }
            
            res.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(detail_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tampil_cmb_nik_peminjam(){
         try {            
            String sql = "SELECT nik_peminjam FROM peminjam ";
            java.sql.Connection conn=(Connection)Koneksi.KoneksiDB.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()) {                
                Object[] obj = new Object[3];
                obj[0] = res.getString(1); 
                cmb_nik_peminjam.addItem((String) obj[0]);   
            }
            
            res.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(detail_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tampil_cmb_kode_buku(){
         try {            
            String sql = "SELECT kode_buku FROM buku ";
            java.sql.Connection conn=(Connection)Koneksi.KoneksiDB.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()) {                
                Object[] obj = new Object[3];
                obj[0] = res.getString(1); 
                cmb_kode_buku.addItem((String) obj[0]);   
            }
            
            res.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(detail_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tampildata(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Peminjaman");
        model.addColumn("Nama Pegawai");
        model.addColumn("NIP Pegawai");
        model.addColumn("Nama Peminjam");
        model.addColumn("NIK Peminjam");
        model.addColumn("Judul Buku");
        model.addColumn("Kode Buku");
        model.addColumn("Tanggal");
        tbl_detail_pinjam.setModel(model);
        try {            
            String sql = "SELECT * FROM detail_pinjam "
                    + " INNER JOIN pegawai ON detail_pinjam.nip_pegawai=pegawai.nip_pegawai"
                    + " INNER JOIN peminjam ON detail_pinjam.nik_peminjam=peminjam.nik_peminjam"
                    + " INNER JOIN buku ON detail_pinjam.kode_buku=buku.kode_buku";
     
            java.sql.Connection conn=(Connection)Koneksi.KoneksiDB.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()) {                
                Object[] obj = new Object[8];
                obj[0] = res.getString("kode_pinjam"); 
                obj[1] = res.getString("nama_pegawai"); 
                obj[2] = res.getString("nip_pegawai");
                obj[3] = res.getString("nama_peminjam");
                obj[4] = res.getString("nik_peminjam");
                obj[5] = res.getString("judul_buku");
                obj[6] = res.getString("kode_buku");
                obj[7] = res.getString("tanggal_pinjam");
                
                model.addRow(obj);
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(detail_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_detail_pinjam = new javax.swing.JTable();
        txt_kode_pinjam = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        nama2 = new javax.swing.JLabel();
        cmb_nip_pegawai = new javax.swing.JComboBox<>();
        nama = new javax.swing.JLabel();
        cmb_nik_peminjam = new javax.swing.JComboBox<>();
        nama4 = new javax.swing.JLabel();
        nama3 = new javax.swing.JLabel();
        cmb_kode_buku = new javax.swing.JComboBox<>();
        nama5 = new javax.swing.JLabel();
        jbc_tanggal_pinjam = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setBackground(new java.awt.Color(51, 0, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Detail Peminjaman");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbl_detail_pinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_detail_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detail_pinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_detail_pinjam);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_menu.setText("Menu Utama");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        nama2.setBackground(new java.awt.Color(255, 255, 255));
        nama2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama2.setText("Kode Pinjam");

        cmb_nip_pegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));

        nama.setBackground(new java.awt.Color(255, 255, 255));
        nama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama.setText("NIK Peminjam");

        cmb_nik_peminjam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));

        nama4.setBackground(new java.awt.Color(255, 255, 255));
        nama4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama4.setText("NIP Pegawai");

        nama3.setBackground(new java.awt.Color(255, 255, 255));
        nama3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama3.setText("Kode Buku");

        cmb_kode_buku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));

        nama5.setBackground(new java.awt.Color(255, 255, 255));
        nama5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nama5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nama5.setText("Tanggal Pinjam");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama2)
                            .addComponent(nama4))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_nip_pegawai, 0, 198, Short.MAX_VALUE)
                            .addComponent(txt_kode_pinjam)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nama3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_kode_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_nik_peminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(nama)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nama5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbc_tanggal_pinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(292, 292, 292)
                .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kode_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_menu))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_nik_peminjam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(nama3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmb_kode_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbc_tanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_nip_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_detail_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detail_pinjamMouseClicked
        int baris = tbl_detail_pinjam.rowAtPoint(evt.getPoint());
        String tanggal =tbl_detail_pinjam.getValueAt(baris, 7).toString();
        System.out.println(tanggal);
        try {
            java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
            jbc_tanggal_pinjam.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(detail_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        String kode_pinjam =tbl_detail_pinjam.getValueAt(baris, 0).toString();
        txt_kode_pinjam.setText(kode_pinjam);
        String nip_pegawai = tbl_detail_pinjam.getValueAt(baris, 2).toString();
        cmb_nip_pegawai.setSelectedItem(nip_pegawai);
        String nik_peminjam = tbl_detail_pinjam.getValueAt(baris, 4).toString();
        cmb_nik_peminjam.setSelectedItem(nik_peminjam);
        String kode_buku = tbl_detail_pinjam.getValueAt(baris, 6).toString();
        cmb_kode_buku.setSelectedItem(kode_buku);

    }//GEN-LAST:event_tbl_detail_pinjamMouseClicked
    private void resetdata(){
        txt_kode_pinjam.setText(null);
        cmb_nip_pegawai.setSelectedItem(null);
        cmb_nik_peminjam.setSelectedItem(null);
        cmb_kode_buku.setSelectedItem(null);
        jbc_tanggal_pinjam.setDate(null);  
        
    }
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String datechooser = String.valueOf(format.format(jbc_tanggal_pinjam.getDate()));
            
            String sql = "INSERT INTO detail_pinjam (kode_pinjam,nip_pegawai,nik_peminjam,kode_buku,tanggal_pinjam) VALUES "
            + "('"+txt_kode_pinjam.getText()+"',"
            + "'"+cmb_nip_pegawai.getSelectedItem()+"',"
            + "'"+cmb_nik_peminjam.getSelectedItem()+"',"
            + "'"+cmb_kode_buku.getSelectedItem()+"',"
            + "'"+datechooser+"')";

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

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        resetdata();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
         try {
            String sql ="DELETE FROM detail_pinjam WHERE kode_pinjam='"+txt_kode_pinjam.getText()+"'";
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

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        formmenu a = new formmenu();
        a.setVisible(true);
        this.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
          try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String aaa = String.valueOf(format.format(jbc_tanggal_pinjam.getDate()));
            String sql ="UPDATE detail_pinjam SET nip_pegawai = '"+cmb_nip_pegawai.getSelectedItem()+"',"
                    + "nik_peminjam = '"+cmb_nik_peminjam.getSelectedItem()+"',"
                    + "kode_buku = '"+cmb_kode_buku.getSelectedItem()+"',"
                    + "tanggal_pinjam='"+aaa+"'WHERE kode_pinjam = '"+txt_kode_pinjam.getText()+"'";

            java.sql.Connection conn=(Connection)KoneksiDB.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di edit");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        tampildata();
                                      
    }//GEN-LAST:event_btn_editActionPerformed

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
            java.util.logging.Logger.getLogger(detail_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detail_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detail_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detail_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detail_peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cmb_kode_buku;
    private javax.swing.JComboBox<String> cmb_nik_peminjam;
    private javax.swing.JComboBox<String> cmb_nip_pegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jbc_tanggal_pinjam;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nama2;
    private javax.swing.JLabel nama3;
    private javax.swing.JLabel nama4;
    private javax.swing.JLabel nama5;
    private javax.swing.JTable tbl_detail_pinjam;
    private javax.swing.JTextField txt_kode_pinjam;
    // End of variables declaration//GEN-END:variables
}
