package kts;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class YeniKargoEkran extends javax.swing.JFrame 
{
    ResultSet rs = null;
     
    public YeniKargoEkran() 
    {
        
        setTitle("Yeni Kargo Ekranı");
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        jTextArea_gnd_adr.setLineWrap(true);
        jTextArea_alc_adr.setLineWrap(true);
        
                
        //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        //KARGO GÖNDERİ TÜRÜ COMBOBOX DOLDURMA İŞLEMLERİ
        String gonderi_turu_sorgu ="Select kts_gnd_tur_ıd, kts_gnd_tur_ad \n" +
                                   "from kts_gonderi_turleri";
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
        try 
          {
              Statement stmt = con.createStatement();

              rs = stmt.executeQuery(gonderi_turu_sorgu);
              
              while (rs.next())
            { 
                gnd_turu_combobox.addItem(new ComboItem(rs.getString("kts_gnd_tur_ad"),rs.getString("kts_gnd_tur_ıd")));
            }
               
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
                    Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
        label_foto_kargo_tasiyan_adam = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buton_kargo_olustur = new javax.swing.JButton();
        gnd_turu_combobox = new javax.swing.JComboBox();
        label_takip_no = new javax.swing.JLabel();
        jbutton_yeni_kargo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_alc_adr = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_gnd_adr = new javax.swing.JTextArea();
        label_fiyat = new javax.swing.JLabel();
        buton_geri = new javax.swing.JButton();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Kargo Gönderici TC");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(16, 47, 120, 16);

        jLabel2.setText("Kargo Alıcı TC");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(492, 45, 90, 16);

        jLabel7.setText("Kargo Gönderi Türü");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(254, 267, 130, 16);

        jLabel9.setText("Kargo Desi");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(253, 307, 80, 16);

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

        JTextField_kargo_desi.setNextFocusableComponent(buton_kargo_olustur);
        JTextField_kargo_desi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextField_kargo_desiKeyTyped(evt);
            }
        });
        getContentPane().add(JTextField_kargo_desi);
        JTextField_kargo_desi.setBounds(402, 307, 120, 22);

        jLabel5.setText("Adres");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 90, 50, 16);

        label_foto_kargo_tasiyan_adam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FotografPackage/Kargo_tasiyan_adam.png"))); // NOI18N
        getContentPane().add(label_foto_kargo_tasiyan_adam);
        label_foto_kargo_tasiyan_adam.setBounds(302, 32, 182, 220);

        jLabel6.setText("Adres");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(495, 88, 40, 16);

        buton_kargo_olustur.setText("Kargo Oluştur");
        buton_kargo_olustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_kargo_olusturActionPerformed(evt);
            }
        });
        getContentPane().add(buton_kargo_olustur);
        buton_kargo_olustur.setBounds(402, 364, 111, 25);

        gnd_turu_combobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gnd_turu_comboboxİtemStateChanged(evt);
            }
        });
        getContentPane().add(gnd_turu_combobox);
        gnd_turu_combobox.setBounds(402, 267, 120, 22);

        label_takip_no.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(label_takip_no);
        label_takip_no.setBounds(240, 400, 427, 23);

        jbutton_yeni_kargo.setText("Yeni Kargo");
        jbutton_yeni_kargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_yeni_kargoActionPerformed(evt);
            }
        });
        getContentPane().add(jbutton_yeni_kargo);
        jbutton_yeni_kargo.setBounds(531, 364, 111, 25);

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

        label_fiyat.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(label_fiyat);
        label_fiyat.setBounds(240, 430, 394, 30);

        buton_geri.setBackground(new java.awt.Color(255, 51, 51));
        buton_geri.setText("< Ana Ekran");
        buton_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_geriActionPerformed(evt);
            }
        });
        getContentPane().add(buton_geri);
        buton_geri.setBounds(0, 0, 103, 25);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buton_kargo_olusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_kargo_olusturActionPerformed
        
        if(JTextfield_kargo_gonderici_TC.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Gönderici TC boş geçilemez!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
            JTextfield_kargo_gonderici_TC.requestFocus();
            return;
        }         
        if(JTextfield_kargo_alici_TC.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Alıcı TC boş geçilemez!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
            JTextfield_kargo_alici_TC.requestFocus();
            return;
        }       
        if(JTextField_kargo_desi.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Kargo Desi boş geçilemez!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
            JTextField_kargo_desi.requestFocus();
            return;
        }
        
        String gnd_tc = JTextfield_kargo_gonderici_TC.getText();
        String alc_tc = JTextfield_kargo_alici_TC.getText();
        int krg_tur = 1;//combodan alınacak
        Float desi;
        try
        {
            desi = Float.parseFloat(JTextField_kargo_desi.getText());//try catch
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Desi hatalı girildi!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
            JTextField_kargo_desi.setText("");
            JTextField_kargo_desi.requestFocus();
            return;
        }
        
        
        
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                String [] param = new String[2];
                param = dbsp.sp_kargo_ekle(con,gnd_tc, alc_tc, krg_tur, desi);
                label_takip_no.setText("Kargo Takip No: " + param[0]);
                label_fiyat.setText("Ücret: " + param[1] + "TL");
                gnd_turu_combobox.setEnabled(false);
                JTextField_kargo_desi.setEnabled(false);
                
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            finally
            {
                try 
                {
                    con.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }//GEN-LAST:event_buton_kargo_olusturActionPerformed

    private void JTextfield_kargo_gonderici_TCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextfield_kargo_gonderici_TCFocusLost
        
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
                if(!adres.equals("Kişi Kayıtlı Değil"))
                {
                    jTextArea_gnd_adr.setText(adres);
                    jTextArea_gnd_adr.setEnabled(false);
                    JTextfield_kargo_gonderici_TC.setEnabled(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Müşteri Kayıtlı Değildir. Lütfen Önce Müşteri Kaydını Yapınız!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
                    JTextfield_kargo_gonderici_TC.requestFocus();
                    JTextfield_kargo_gonderici_TC.setText("");
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                try 
                {
                    con.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_JTextfield_kargo_gonderici_TCFocusLost

    private void JTextfield_kargo_alici_TCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTextfield_kargo_alici_TCFocusLost
        String tc = JTextfield_kargo_alici_TC.getText();
        int uzunluk = tc.length();
        
        if(JTextfield_kargo_alici_TC.getText().equals(JTextfield_kargo_gonderici_TC.getText()) && !JTextfield_kargo_gonderici_TC.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Alıcı ve Gönderici Aynı Kişi Olamaz!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
             JTextfield_kargo_alici_TC.setEnabled(true);
             JTextfield_kargo_alici_TC.setText("");
             jTextArea_alc_adr.setEnabled(true);
             jTextArea_alc_adr.setText("");  
             JTextfield_kargo_alici_TC.requestFocus();
        }
        else if(uzunluk == 11)
        {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                String adres = dbsp.sp_adres_bul(con,tc);
                if(!adres.equals("Kişi Kayıtlı Değil"))
                {
                    jTextArea_alc_adr.setText(adres);
                    jTextArea_alc_adr.setEnabled(false);
                    JTextfield_kargo_alici_TC.setEnabled(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Müşteri Kayıtlı Değildir. Lütfen Önce Müşteri Kaydını Yapınız!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
                    JTextfield_kargo_alici_TC.requestFocus();
                    JTextfield_kargo_alici_TC.setText("");
                }
                
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            try 
            {
                con.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(YeniKargoEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JTextfield_kargo_alici_TCFocusLost

    private void jbutton_yeni_kargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_yeni_kargoActionPerformed
        
        jTextArea_gnd_adr.setText("");
        jTextArea_gnd_adr.setEnabled(true);
        
        jTextArea_alc_adr.setText("");
        jTextArea_alc_adr.setEnabled(true);
        
        JTextField_kargo_desi.setText("");
        
        JTextfield_kargo_alici_TC.setText("");
        JTextfield_kargo_alici_TC.setEnabled(true);
        
        JTextfield_kargo_gonderici_TC.setText("");
        JTextfield_kargo_gonderici_TC.setEnabled(true);
        
        gnd_turu_combobox.setEnabled(true);
        JTextField_kargo_desi.setEnabled(true);
        
        label_fiyat.setText("");
        label_takip_no.setText("");
        
        
    }//GEN-LAST:event_jbutton_yeni_kargoActionPerformed

    private void JTextfield_kargo_gonderici_TCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextfield_kargo_gonderici_TCKeyTyped
        
        String metin = JTextfield_kargo_gonderici_TC.getText();
        int tc_uzunluk = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || tc_uzunluk == 11 )
        {
         evt.consume();
        }
    }//GEN-LAST:event_JTextfield_kargo_gonderici_TCKeyTyped

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

    private void buton_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_geriActionPerformed
        this.dispose();
        AnaEkran ekran = new AnaEkran();
        ekran.setVisible(true);
    }//GEN-LAST:event_buton_geriActionPerformed

    private void gnd_turu_comboboxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gnd_turu_comboboxİtemStateChanged
        
        Object item = null;
        item = gnd_turu_combobox.getSelectedItem();
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
        
    }//GEN-LAST:event_gnd_turu_comboboxİtemStateChanged

    
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
            java.util.logging.Logger.getLogger(YeniKargoEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YeniKargoEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YeniKargoEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YeniKargoEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YeniKargoEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField_kargo_desi;
    private javax.swing.JTextField JTextfield_kargo_alici_TC;
    private javax.swing.JTextField JTextfield_kargo_gonderici_TC;
    private javax.swing.JButton buton_geri;
    private javax.swing.JButton buton_kargo_olustur;
    private javax.swing.JComboBox gnd_turu_combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_alc_adr;
    private javax.swing.JTextArea jTextArea_gnd_adr;
    private javax.swing.JButton jbutton_yeni_kargo;
    private javax.swing.JLabel label_arka_plan;
    private javax.swing.JLabel label_fiyat;
    private javax.swing.JLabel label_foto_kargo_tasiyan_adam;
    private javax.swing.JLabel label_takip_no;
    // End of variables declaration//GEN-END:variables
}
