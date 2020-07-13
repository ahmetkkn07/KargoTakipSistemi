package kts;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class KargoDuzenleEkran extends javax.swing.JFrame {

     ResultSet rs = null;
     private int krg_ilk_durum = 1;
     
    public KargoDuzenleEkran() 
    {
       
        setTitle("Kargo Düzenleme Ekranı");
        
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        jTextArea_gnd_adr.setLineWrap(true);
        jTextArea_alc_adr.setLineWrap(true);
        
         //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        combo_doldur();
        
        DocumentFilter filter = new UppercaseDocumentFilter();
        AbstractDocument musteri_ad_doc = (AbstractDocument) jTextField_teslim_alan_kisi.getDocument();
        musteri_ad_doc.setDocumentFilter(filter);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTextfield_kargo_gonderici_TC = new javax.swing.JTextField();
        JTextfield_kargo_alici_TC = new javax.swing.JTextField();
        JTextField_kargo_desi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combobox_gnd_turu = new javax.swing.JComboBox();
        label_takip_no = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_alc_adr = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_gnd_adr = new javax.swing.JTextArea();
        guncelle_buton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        combobox_kts_kargo_durum = new javax.swing.JComboBox();
        jTextField_teslim_alan_kisi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buton_geri = new javax.swing.JButton();
        label_krg_tslm_trh = new javax.swing.JLabel();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Kargo Gönderici TC");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(16, 47, 110, 16);

        jLabel2.setText("Kargo Alıcı TC");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(492, 45, 90, 16);

        jLabel7.setText("Kargo Gönderi Türü");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(253, 236, 130, 16);

        jLabel9.setText("Kargo Desi");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(253, 282, 80, 16);

        JTextfield_kargo_gonderici_TC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextfield_kargo_gonderici_TCFocusLost(evt);
            }
        });
        JTextfield_kargo_gonderici_TC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextfield_kargo_gonderici_TCKeyTyped(evt);
            }
        });
        getContentPane().add(JTextfield_kargo_gonderici_TC);
        JTextfield_kargo_gonderici_TC.setBounds(154, 42, 130, 22);

        JTextfield_kargo_alici_TC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextfield_kargo_alici_TCFocusLost(evt);
            }
        });
        JTextfield_kargo_alici_TC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextfield_kargo_alici_TCKeyTyped(evt);
            }
        });
        getContentPane().add(JTextfield_kargo_alici_TC);
        JTextfield_kargo_alici_TC.setBounds(600, 42, 130, 22);

        JTextField_kargo_desi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextField_kargo_desiKeyTyped(evt);
            }
        });
        getContentPane().add(JTextField_kargo_desi);
        JTextField_kargo_desi.setBounds(401, 279, 120, 22);

        jLabel5.setText("Adres");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 90, 50, 16);

        jLabel6.setText("Adres");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(495, 88, 40, 16);

        combobox_gnd_turu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_gnd_turuİtemStateChanged(evt);
            }
        });
        getContentPane().add(combobox_gnd_turu);
        combobox_gnd_turu.setBounds(401, 233, 120, 22);

        label_takip_no.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(label_takip_no);
        label_takip_no.setBounds(350, 430, 236, 23);

        jTextArea_alc_adr.setColumns(20);
        jTextArea_alc_adr.setRows(5);
        jTextArea_alc_adr.setMaximumSize(new java.awt.Dimension(130, 90));
        jTextArea_alc_adr.setMinimumSize(new java.awt.Dimension(130, 90));
        jScrollPane1.setViewportView(jTextArea_alc_adr);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(600, 88, 130, 100);

        jTextArea_gnd_adr.setColumns(20);
        jTextArea_gnd_adr.setRows(5);
        jTextArea_gnd_adr.setMaximumSize(new java.awt.Dimension(130, 92));
        jTextArea_gnd_adr.setMinimumSize(new java.awt.Dimension(130, 92));
        jTextArea_gnd_adr.setName(""); // NOI18N
        jScrollPane2.setViewportView(jTextArea_gnd_adr);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(154, 90, 130, 98);

        guncelle_buton.setText("Güncelle");
        guncelle_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelle_butonActionPerformed(evt);
            }
        });
        getContentPane().add(guncelle_buton);
        guncelle_buton.setBounds(530, 400, 81, 25);

        jLabel3.setText("Kargo Durumu");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(253, 328, 82, 16);

        combobox_kts_kargo_durum.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_kts_kargo_durumİtemStateChanged(evt);
            }
        });
        getContentPane().add(combobox_kts_kargo_durum);
        combobox_kts_kargo_durum.setBounds(401, 325, 207, 22);

        jTextField_teslim_alan_kisi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_teslim_alan_kisiKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_teslim_alan_kisi);
        jTextField_teslim_alan_kisi.setBounds(400, 370, 210, 22);

        jLabel4.setText("Teslim Alan Kişi");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 370, 110, 16);

        buton_geri.setBackground(new java.awt.Color(255, 51, 51));
        buton_geri.setText("< Ana Ekran");
        buton_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_geriActionPerformed(evt);
            }
        });
        getContentPane().add(buton_geri);
        buton_geri.setBounds(0, 0, 103, 25);
        getContentPane().add(label_krg_tslm_trh);
        label_krg_tslm_trh.setBounds(320, 450, 310, 16);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void combo_doldur()
    {
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
        //KARGO GÖNDERİ TÜRÜ COMBOBOX DOLDURMA İŞLEMLERİ
        String gonderi_turu_sorgu ="Select kts_gnd_tur_ıd, kts_gnd_tur_ad \n" +
                                   "from kts_gonderi_turleri";
        
       
        
        try 
          {
              Statement stmt = con.createStatement();

              rs = stmt.executeQuery(gonderi_turu_sorgu);
              
              while (rs.next())
            { 
                combobox_gnd_turu.addItem(new ComboItem(rs.getString("kts_gnd_tur_ad"),rs.getString("kts_gnd_tur_ıd")));
            }
               
        }

          catch (SQLException ex)
          {
              Logger.getLogger(DatabaseSP.class.getName()).log(Level.SEVERE, null, ex);
          } 
        
        //KARGO GÖNDERİ DURUMU COMBOBOX DOLDURMA İŞLEMLERİ
        String kargo_durum_sorgu ="SELECT kts_krg_drm_id, kts_krg_drm_ad\n" +
                                    "FROM kts_kargo_durumlari";
        
        try 
          {
              Statement stmt = con.createStatement();

              rs = stmt.executeQuery(kargo_durum_sorgu);
              
              while (rs.next())
            { 
                combobox_kts_kargo_durum.addItem(new ComboItem(rs.getString("kts_krg_drm_ad"),rs.getString("kts_krg_drm_id")));
            }
               
        }

          catch (SQLException ex)
          {
              Logger.getLogger(DatabaseSP.class.getName()).log(Level.SEVERE, null, ex);
          } 
        finally
            {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    private void JTextfield_kargo_gonderici_TCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextfield_kargo_gonderici_TCFocusLost

        gnd_tc();
    }//GEN-LAST:event_JTextfield_kargo_gonderici_TCFocusLost

    public void gnd_tc ()
    {
        
        String tc = JTextfield_kargo_gonderici_TC.getText();
        int uzunluk = tc.length();
        if(uzunluk == 11)
        {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try
            {
                String adres = dbsp.sp_adres_bul(con,tc);
                jTextArea_gnd_adr.setText(adres);
                jTextArea_gnd_adr.setEditable(false);
                JTextfield_kargo_gonderici_TC.setEditable(false);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    public void ekran_doldur(String kargo_id)
    {
        String [] kts_krg_blg = new String[8];

        DatabaseSP dbsp = new DatabaseSP();

        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);

            try 
            {
                kts_krg_blg = dbsp.sp_krg_blg_getir(con, kargo_id);
                
                label_takip_no.setText(kts_krg_blg[0]);
                
                JTextfield_kargo_alici_TC.setText(kts_krg_blg[1]);
                alc_tc();
                
                JTextfield_kargo_gonderici_TC.setText(kts_krg_blg[2]);
                gnd_tc();
                
                combobox_gnd_turu.setSelectedIndex(Integer.parseInt(kts_krg_blg[3]) -1 );
                combobox_gnd_turu.setEnabled(false);
                
                JTextField_kargo_desi.setText(kts_krg_blg[4]);
                JTextField_kargo_desi.setEditable(false);
                
                combobox_kts_kargo_durum.setSelectedIndex(Integer.parseInt(kts_krg_blg[5]) -1 );
                krg_ilk_durum = (Integer.parseInt(kts_krg_blg[5]));
                
                if(krg_ilk_durum == 7)
                {
                    jTextField_teslim_alan_kisi.setText(kts_krg_blg[7]);
                    jTextField_teslim_alan_kisi.setEnabled(false);
                    combobox_kts_kargo_durum.setEnabled(false);
                    guncelle_buton.setEnabled(false);
                    combobox_kts_kargo_durum.setEnabled(false);
                    label_krg_tslm_trh.setText("Teslim tarihi: " + kts_krg_blg[6]);
                }
                
               
            }

            catch (SQLException ex) 
            {
                Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally
            {
                try 
                {
                    con.close();
                } 

                catch (SQLException ex) 
                {
                    Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    private void JTextfield_kargo_gonderici_TCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextfield_kargo_gonderici_TCKeyTyped

        String metin = JTextfield_kargo_gonderici_TC.getText();
        int tc_uzunluk = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || tc_uzunluk == 11 )
        {
            evt.consume();
        }
    }//GEN-LAST:event_JTextfield_kargo_gonderici_TCKeyTyped

    private void JTextfield_kargo_alici_TCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextfield_kargo_alici_TCFocusLost
        
        alc_tc();
        
    }//GEN-LAST:event_JTextfield_kargo_alici_TCFocusLost

    public void alc_tc()
    {
        
        String tc = JTextfield_kargo_alici_TC.getText();
        int uzunluk = tc.length();
        if(uzunluk == 11)
        {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try
            {
                String adres = dbsp.sp_adres_bul(con,tc);
                jTextArea_alc_adr.setText(adres);
                jTextArea_alc_adr.setEditable(false);
                JTextfield_kargo_alici_TC.setEditable(false);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    private void JTextfield_kargo_alici_TCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextfield_kargo_alici_TCKeyTyped

        String metin = JTextfield_kargo_alici_TC.getText();
        int tc_uzunluk = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || tc_uzunluk == 11 )
        {
            evt.consume();
        }
    }//GEN-LAST:event_JTextfield_kargo_alici_TCKeyTyped

    private void JTextField_kargo_desiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextField_kargo_desiKeyTyped
        String metin = JTextfield_kargo_gonderici_TC.getText();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) && karakter != KeyEvent.VK_PERIOD )
        {
            evt.consume();
        }
    }//GEN-LAST:event_JTextField_kargo_desiKeyTyped

    private void combobox_gnd_turuİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_gnd_turuİtemStateChanged

        Object item = null;
        item = combobox_gnd_turu.getSelectedItem();
        String gnd = ((ComboItem)item).getValue();

        if(gnd.equals("1"))
        {
            JTextField_kargo_desi.setText("0.5");
            JTextField_kargo_desi.setEnabled(false);
        }
        else
        {
            JTextField_kargo_desi.setText("");
            JTextField_kargo_desi.setEnabled(true);
        }

    }//GEN-LAST:event_combobox_gnd_turuİtemStateChanged

    private void guncelle_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelle_butonActionPerformed
        
        Object item = null;
        item = combobox_kts_kargo_durum.getSelectedItem();
        String krg_drm = ((ComboItem)item).getValue();
        
        if(krg_ilk_durum > Integer.parseInt(krg_drm))
        {
            JOptionPane.showMessageDialog(this, "Kargo Durumu eski bir duruma getirilemez!","Güncelleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String krg_no = label_takip_no.getText();
        String sorgu;
        
        if(krg_drm.equals("7") && jTextField_teslim_alan_kisi.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Teslim alan kişi boş geçilemez.","Güncelleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(krg_drm.equals("7"))
        {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String teslim_alan = jTextField_teslim_alan_kisi.getText();
            sorgu = "UPDATE kts_kargo_bilgileri \n" +
                    "SET kts_krg_durumu = " + krg_drm + "\n, " +
                    "kts_krg_teslim_alan_kisi = '" + teslim_alan + "'\n, " +
                    "kts_krg_teslim_trh = '" + formatter.format(date) + "'\n " +
                    "WHERE kts_krg_id = " + krg_no;
            
            label_krg_tslm_trh.setText("Teslim Tarihi: "+ formatter.format(date));
            guncelle_buton.setEnabled(false);
            combobox_kts_kargo_durum.setEnabled(false);
            jTextField_teslim_alan_kisi.setEnabled(false);
        }
        else
        {
            sorgu = "UPDATE kts_kargo_bilgileri \n" +
                    "SET kts_krg_durumu = " + krg_drm + "\n " +
                    "WHERE kts_krg_id = " + krg_no;
        }
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
        try 
        {
            Statement stmt = con.createStatement();

            stmt.executeUpdate(sorgu);
             
            JOptionPane.showMessageDialog(this, "Kargo Durumu başarıyla güncellenmiştir","Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
            krg_ilk_durum = Integer.parseInt(krg_drm);       
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DatabaseSP.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            try 
            {
                con.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(KargoDuzenleEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }//GEN-LAST:event_guncelle_butonActionPerformed

    private void buton_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_geriActionPerformed
        this.dispose();
        AnaEkran ekran = new AnaEkran();
        ekran.setVisible(true);
    }//GEN-LAST:event_buton_geriActionPerformed

    private void jTextField_teslim_alan_kisiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_teslim_alan_kisiKeyTyped
        String metin = jTextField_teslim_alan_kisi.getText();
        int ad_uzunluk = metin.length();
        
        char karakter = evt.getKeyChar();
        if( (Character.isDigit(karakter) &&( !(karakter==KeyEvent.VK_SPACE)) 
         || (karakter==KeyEvent.VK_BACK_SPACE) || (karakter==KeyEvent.VK_DELETE) ||ad_uzunluk == 30))
        {
             evt.consume();       
        }
    }//GEN-LAST:event_jTextField_teslim_alan_kisiKeyTyped
    public Object item = null;
    private void combobox_kts_kargo_durumİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_kts_kargo_durumİtemStateChanged
        
        item = combobox_kts_kargo_durum.getSelectedItem();
        String durum_temp = ((ComboItem)item).getValue();
        
        if(durum_temp.equals("7"))
        {
            jTextField_teslim_alan_kisi.setEnabled(true);
        }
        else
        {
            jTextField_teslim_alan_kisi.setEnabled(false);
            jTextField_teslim_alan_kisi.setText("");
        }
        
    }//GEN-LAST:event_combobox_kts_kargo_durumİtemStateChanged

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
            java.util.logging.Logger.getLogger(KargoDuzenleEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KargoDuzenleEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KargoDuzenleEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KargoDuzenleEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KargoDuzenleEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField_kargo_desi;
    private javax.swing.JTextField JTextfield_kargo_alici_TC;
    private javax.swing.JTextField JTextfield_kargo_gonderici_TC;
    private javax.swing.JButton buton_geri;
    private javax.swing.JComboBox combobox_gnd_turu;
    private javax.swing.JComboBox combobox_kts_kargo_durum;
    private javax.swing.JButton guncelle_buton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_alc_adr;
    private javax.swing.JTextArea jTextArea_gnd_adr;
    private javax.swing.JTextField jTextField_teslim_alan_kisi;
    private javax.swing.JLabel label_arka_plan;
    private javax.swing.JLabel label_krg_tslm_trh;
    private javax.swing.JLabel label_takip_no;
    // End of variables declaration//GEN-END:variables
}
