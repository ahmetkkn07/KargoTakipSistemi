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
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author ahm
 */
public class MusteriEkle extends javax.swing.JFrame 
{
    ResultSet rs = null;
    Object item = null;
    
    public MusteriEkle() 
    {      
        setTitle("Müşteri Ekleme Ekranı");

        initComponents();
        myinitComponents();        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        jTextArea_acik_adres.setLineWrap(true);
        
       
        
        //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        DocumentFilter filter = new UppercaseDocumentFilter();
        
        AbstractDocument musteri_ad_doc = (AbstractDocument) jTextField_musteri_ad.getDocument();
        musteri_ad_doc.setDocumentFilter(filter);
       
        AbstractDocument musteri_soyad_doc = (AbstractDocument) jTextField_musteri_soyad.getDocument();
        musteri_soyad_doc.setDocumentFilter(filter);
        
        AbstractDocument musteri_mah_sok_doc = (AbstractDocument) jTextField_mah_sok.getDocument();
        musteri_mah_sok_doc.setDocumentFilter(filter);
        
        AbstractDocument kapi_no_doc = (AbstractDocument) jTextField_kapi_no.getDocument();
        kapi_no_doc.setDocumentFilter(filter);
        
        AbstractDocument acik_adres_doc = (AbstractDocument) jTextArea_acik_adres.getDocument();
        acik_adres_doc.setDocumentFilter(filter);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_musteri_ad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_musteri_soyad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_musteri_tc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_musteri_telefon = new javax.swing.JTextField();
        combobox_il = new javax.swing.JComboBox();
        combobox_ilce = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_mah_sok = new javax.swing.JTextField();
        jTextField_kapi_no = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_acik_adres = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        buton_mst_ekle = new javax.swing.JButton();
        buton_geri = new javax.swing.JButton();
        buton_mst_guncelle = new javax.swing.JButton();
        buton_ekran_temizle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Müşteri Ad");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(35, 135, 61, 16);

        jTextField_musteri_ad.setNextFocusableComponent(jTextField_musteri_soyad);
        jTextField_musteri_ad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_musteri_adKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_musteri_ad);
        jTextField_musteri_ad.setBounds(132, 132, 130, 22);

        jLabel2.setText("Müşteri Soyad");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(33, 175, 81, 16);

        jTextField_musteri_soyad.setNextFocusableComponent(jTextField_musteri_telefon);
        jTextField_musteri_soyad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_musteri_soyadKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_musteri_soyad);
        jTextField_musteri_soyad.setBounds(132, 172, 130, 22);

        jLabel3.setText("Müşteri TC");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(35, 95, 62, 16);

        jTextField_musteri_tc.setNextFocusableComponent(jTextField_musteri_ad);
        jTextField_musteri_tc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_musteri_tcFocusLost(evt);
            }
        });
        jTextField_musteri_tc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_musteri_tcKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_musteri_tc);
        jTextField_musteri_tc.setBounds(132, 92, 130, 22);

        jLabel4.setText("Telefon");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(35, 215, 43, 16);

        jTextField_musteri_telefon.setNextFocusableComponent(combobox_il);
        jTextField_musteri_telefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_musteri_telefonKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_musteri_telefon);
        jTextField_musteri_telefon.setBounds(132, 212, 130, 22);

        combobox_il.setNextFocusableComponent(combobox_ilce);
        combobox_il.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_ilİtemStateChanged(evt);
            }
        });
        getContentPane().add(combobox_il);
        combobox_il.setBounds(464, 92, 180, 22);

        combobox_ilce.setNextFocusableComponent(jTextField_mah_sok);
        getContentPane().add(combobox_ilce);
        combobox_ilce.setBounds(464, 132, 180, 22);

        jLabel5.setText("İl");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(355, 95, 7, 16);

        jLabel6.setText("İlçe");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(355, 135, 20, 16);

        jLabel7.setText("Mahalle / Sokak");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(355, 175, 91, 16);

        jTextField_mah_sok.setNextFocusableComponent(jTextField_kapi_no);
        getContentPane().add(jTextField_mah_sok);
        jTextField_mah_sok.setBounds(464, 172, 180, 22);

        jTextField_kapi_no.setNextFocusableComponent(jTextArea_acik_adres);
        getContentPane().add(jTextField_kapi_no);
        jTextField_kapi_no.setBounds(464, 212, 180, 22);

        jLabel8.setText("Kapı Numarası");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(355, 215, 82, 16);

        jTextArea_acik_adres.setColumns(20);
        jTextArea_acik_adres.setRows(5);
        jTextArea_acik_adres.setNextFocusableComponent(buton_mst_ekle);
        jScrollPane1.setViewportView(jTextArea_acik_adres);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(464, 252, 180, 70);

        jLabel9.setText("Açık Adres");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(355, 252, 60, 16);

        buton_mst_ekle.setText("Ekle");
        buton_mst_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_mst_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_mst_ekle);
        buton_mst_ekle.setBounds(464, 336, 81, 25);

        buton_geri.setBackground(new java.awt.Color(255, 51, 51));
        buton_geri.setText("< Ana Ekran");
        buton_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_geriActionPerformed(evt);
            }
        });
        getContentPane().add(buton_geri);
        buton_geri.setBounds(0, 0, 103, 25);

        buton_mst_guncelle.setText("Güncelle");
        buton_mst_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_mst_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_mst_guncelle);
        buton_mst_guncelle.setBounds(563, 336, 81, 25);

        buton_ekran_temizle.setText("Temizle");
        buton_ekran_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_ekran_temizleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_ekran_temizle);
        buton_ekran_temizle.setBounds(563, 385, 81, 25);

        jButton1.setText("Tüm Müşterileri Listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(637, 0, 163, 25);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myinitComponents()
    {
        jTextField_musteri_tc.requestFocus();
        //İL COMBOBOX DOLDURMA
        String il_sorgu = "Select kts_il_ad, kts_il_id " +
                          "from kts_iller " +
                          "ORDER BY(kts_il_id)";

        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
                
         try 
        {  
            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(il_sorgu);
        
            while (rs.next())
            { 
                combobox_il.addItem(new ComboItem(rs.getString("kts_il_ad"),rs.getString("kts_il_id"))); 
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
    
          //İLÇE COMBOBOX DOLDURMA
        String ilce_sorgu = "Select kts_ilce_id, kts_ilce_ad "
                + "from kts_ilceler "
                + "where kts_ilce_il_id  = 1 "
                + "ORDER BY(kts_ilce_ad)";
         
        
        combobox_ilce.removeAllItems();
        
        try 
        {
        Statement stmt = con.createStatement();

        rs = stmt.executeQuery(ilce_sorgu);
        
            while (rs.next())
            { 
                combobox_ilce.addItem(new ComboItem(rs.getString("kts_ilce_ad"),rs.getString("kts_ilce_id"))); 
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        buton_mst_guncelle.setEnabled(false);
        
    }
    private void buton_mst_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_mst_ekleActionPerformed
        
        String ad = jTextField_musteri_ad.getText();
        String soyad = jTextField_musteri_soyad.getText();
        String tc = jTextField_musteri_tc.getText();
        String telefon = jTextField_musteri_telefon.getText();
        String mah_sok = jTextField_mah_sok.getText();
        String kapi_no = jTextField_kapi_no.getText();
        String acik_adres = jTextArea_acik_adres.getText();
        
        item = combobox_il.getSelectedItem();
        String il = ((ComboItem)item).getValue();
        
        item = combobox_ilce.getSelectedItem();
        String ilce = ((ComboItem)item).getValue();
        
         if(jTextField_musteri_ad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri adı boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_ad.requestFocus();
            return;
        }         
        if(jTextField_musteri_soyad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri soyad boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_soyad.requestFocus();
            return;
        }       
        if(jTextField_musteri_tc.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri TC boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_tc.requestFocus();
            return;
        }
         if(jTextField_musteri_telefon.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri Telefon boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_telefon.requestFocus();
            return;
        }         
        if(jTextField_mah_sok.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Mahalle / Sokak boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_mah_sok.requestFocus();
            return;
        }       
        if(jTextField_kapi_no.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Kapı no boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_kapi_no.requestFocus();
            return;
        }
        
        
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                dbsp.sp_musteri_ekle(con, ad, soyad, tc, telefon, il, ilce, mah_sok, kapi_no, acik_adres);
                
                 JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Eklendi", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
                 buton_mst_ekle.setEnabled(false);
                 buton_mst_guncelle.setEnabled(true);
                
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
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
    }//GEN-LAST:event_buton_mst_ekleActionPerformed

    private void jTextField_musteri_tcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteri_tcKeyTyped
        
        String metin = jTextField_musteri_tc.getText();
        int tc_uzunluk = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || tc_uzunluk == 11 )
        {
         evt.consume();
        }
    }//GEN-LAST:event_jTextField_musteri_tcKeyTyped

    private void jTextField_musteri_adKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteri_adKeyTyped
        
        String metin = jTextField_musteri_ad.getText();
        int ad_uzunluk = metin.length();
        
        char karakter = evt.getKeyChar();
        if( (Character.isDigit(karakter) &&( !(karakter==KeyEvent.VK_SPACE)) 
         || (karakter==KeyEvent.VK_BACK_SPACE) || (karakter==KeyEvent.VK_DELETE) ||ad_uzunluk == 30))
        {
             evt.consume();       
        }
        
    }//GEN-LAST:event_jTextField_musteri_adKeyTyped

    private void jTextField_musteri_soyadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteri_soyadKeyTyped
        
        String metin = jTextField_musteri_soyad.getText();
        int soyad_uzunluk = metin.length();
        
        char karakter = evt.getKeyChar();
        if( (Character.isDigit(karakter) &&( !(karakter==KeyEvent.VK_SPACE)) 
         || (karakter==KeyEvent.VK_BACK_SPACE) || (karakter==KeyEvent.VK_DELETE) ||soyad_uzunluk == 30))
        {
             evt.consume();       
        }
        
        
    }//GEN-LAST:event_jTextField_musteri_soyadKeyTyped

    private void combobox_ilİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_ilİtemStateChanged
        
        item = combobox_il.getSelectedItem();
        String il_temp = ((ComboItem)item).getValue();
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
         //İLÇE COMBOBOX DOLDURMA
        String ilce_sorgu = "Select kts_ilce_id, kts_ilce_ad "
                + "from kts_ilceler "
                + "where kts_ilce_il_id  = " + il_temp
                + "ORDER BY(kts_ilce_ad)";
         
        combobox_ilce.removeAllItems();
        
        try 
        {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(ilce_sorgu);
        
            while (rs.next())
            { 
                combobox_ilce.addItem(new ComboItem(rs.getString("kts_ilce_ad"),rs.getString("kts_ilce_id"))); 
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        try 
        {
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_combobox_ilİtemStateChanged

    private void buton_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_geriActionPerformed
        this.dispose();
        AnaEkran ekran = new AnaEkran();
        ekran.setVisible(true);
    }//GEN-LAST:event_buton_geriActionPerformed

    private void buton_mst_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_mst_guncelleActionPerformed
        
        String ad = jTextField_musteri_ad.getText();
        String soyad = jTextField_musteri_soyad.getText();
        String tc = jTextField_musteri_tc.getText();
        String telefon = jTextField_musteri_telefon.getText();
        String mah_sok = jTextField_mah_sok.getText();
        String kapi_no = jTextField_kapi_no.getText();
        String acik_adres = jTextArea_acik_adres.getText();
        
        item = combobox_il.getSelectedItem();
        String il = ((ComboItem)item).getValue();
        
        item = combobox_ilce.getSelectedItem();
        String ilce = ((ComboItem)item).getValue();
        
         if(jTextField_musteri_ad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri adı boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_ad.requestFocus();
            return;
        }         
        if(jTextField_musteri_soyad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri soyad boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_soyad.requestFocus();
            return;
        }       
        if(jTextField_musteri_tc.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri TC boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_tc.requestFocus();
            return;
        }
         if(jTextField_musteri_telefon.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Müşteri Telefon boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_musteri_telefon.requestFocus();
            return;
        }         
        if(jTextField_mah_sok.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Mahalle / Sokak boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_mah_sok.requestFocus();
            return;
        }       
        if(jTextField_kapi_no.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Kapı no boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_kapi_no.requestFocus();
            return;
        }
        
        
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                dbsp.sp_mst_guncelle(con, tc, ad, soyad, telefon, il, ilce, mah_sok, kapi_no, acik_adres);
                
                 JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Güncellendi.", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
                 buton_mst_ekle.setEnabled(false);
                 buton_mst_guncelle.setEnabled(true);
                
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
    }//GEN-LAST:event_buton_mst_guncelleActionPerformed

    private void jTextField_musteri_tcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_musteri_tcFocusLost
        
        String tc = jTextField_musteri_tc.getText();
        
        String [] kts_mst_bilgi = new String[11];

        if(tc.length() == 11)
        {
            DatabaseSP dbsp = new DatabaseSP();

            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);

            try 
            {
                kts_mst_bilgi = dbsp.sp_mst_bul(con, tc);
                if(kts_mst_bilgi[9].equals("basarili"))
                {
                    jTextField_musteri_tc.setEditable(false);
                    jTextField_musteri_ad.setText(kts_mst_bilgi[1]);
                    jTextField_musteri_soyad.setText(kts_mst_bilgi[2]);
                    jTextField_musteri_telefon.setText(kts_mst_bilgi[3]);
                    int il_ind = ilComboIndex(kts_mst_bilgi[4]);
                    combobox_il.setSelectedIndex(il_ind);
                    int ilce_ind = ilceComboIndex(kts_mst_bilgi[5]);
                    combobox_ilce.setSelectedIndex(ilce_ind);
                    jTextField_mah_sok.setText(kts_mst_bilgi[6]);
                    jTextField_kapi_no.setText(kts_mst_bilgi[7]);
                    jTextArea_acik_adres.setText(kts_mst_bilgi[8]);
                    buton_mst_guncelle.setEnabled(true);
                    buton_mst_ekle.setEnabled(false);
                }
                else
                {
                    buton_mst_ekle.setEnabled(true);
                    jTextField_musteri_tc.setEditable(true);
                    buton_mst_guncelle.setEnabled(false);
                    return;
                }
                    
            }

            catch (SQLException ex) 
            {
                Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally
            {
                try 
                {
                    con.close();
                } 

                catch (SQLException ex) 
                {
                    Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                   
        }
        
    }//GEN-LAST:event_jTextField_musteri_tcFocusLost

    private void buton_ekran_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_ekran_temizleActionPerformed
        
        jTextField_musteri_ad.setText("");
        jTextField_musteri_soyad.setText("");
        jTextField_musteri_tc.setText("");
        jTextField_musteri_telefon.setText("");
        jTextField_mah_sok.setText("");
        jTextField_kapi_no.setText("");
        jTextArea_acik_adres.setText("");
        buton_mst_ekle.setEnabled(true);
        buton_mst_guncelle.setEnabled(false);
        jTextField_musteri_tc.setEditable(true);
        combobox_il.setSelectedIndex(0);
    }//GEN-LAST:event_buton_ekran_temizleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        MusteriListele ml = new MusteriListele();
        ml.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_musteri_telefonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_musteri_telefonKeyTyped
        
        String metin = jTextField_musteri_telefon.getText();
        int tlf_uzunluk = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || tlf_uzunluk == 10 )
        {
         evt.consume();
        }
       
    }//GEN-LAST:event_jTextField_musteri_telefonKeyTyped

    
    private int ilComboIndex(String icerik)
    {   
       int sayac = 0; 
       while(!combobox_il.getItemAt(sayac).toString().equals(icerik))
       {  
            sayac++;                
       }    
       return sayac;
    }

    private int ilceComboIndex(String icerik)
    {   
       int sayac = 0; 
       while(!combobox_ilce.getItemAt(sayac).toString().equals(icerik))
       {  
            sayac++;                
       }    
       return sayac;
    }
    
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
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusteriEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_ekran_temizle;
    private javax.swing.JButton buton_geri;
    private javax.swing.JButton buton_mst_ekle;
    private javax.swing.JButton buton_mst_guncelle;
    private javax.swing.JComboBox combobox_il;
    private javax.swing.JComboBox combobox_ilce;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_acik_adres;
    private javax.swing.JTextField jTextField_kapi_no;
    private javax.swing.JTextField jTextField_mah_sok;
    private javax.swing.JTextField jTextField_musteri_ad;
    private javax.swing.JTextField jTextField_musteri_soyad;
    private javax.swing.JTextField jTextField_musteri_tc;
    private javax.swing.JTextField jTextField_musteri_telefon;
    private javax.swing.JLabel label_arka_plan;
    // End of variables declaration//GEN-END:variables
}
