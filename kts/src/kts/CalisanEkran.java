package kts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class CalisanEkran extends javax.swing.JFrame {

    
    ResultSet rs = null;
    public Object item = null;
    boolean tekrar=false; 
    
    
    public CalisanEkran() {
        
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        setTitle("Çalışanlar");
        
        buton_calisan_sil.setEnabled(false);
        buton_calisan_guncelle.setEnabled(false);
        buton_calisan_ara.doClick();
        jTextField_calisan_tc.requestFocus();
        
        //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        DocumentFilter filter = new UppercaseDocumentFilter();
        
        AbstractDocument calisan_ad_doc = (AbstractDocument) jTextField_calisan_ad.getDocument();
        calisan_ad_doc.setDocumentFilter(filter);
        
         AbstractDocument calisan_soyad_doc = (AbstractDocument) jTextField_calisan_soyad.getDocument();
         calisan_soyad_doc.setDocumentFilter(filter);
         
         jTextField_calisan_arama.setUI(new JTextFieldHintUI("Arama Yapmak İçin Çalışan TC Giriniz", Color.BLACK));
        
        //ŞUBE COMBOBOX DOLDURMA İŞLEMLERİ
        String sube_sorgu ="Select kts_sub_id, kts_sub_ad\n" +
                                   "from kts.kts_subeler\n" + 
                                   "ORDER BY(KTS_SUB_AD)";
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
        try 
          {
              Statement stmt = con.createStatement();

              rs = stmt.executeQuery(sube_sorgu);
              
              while (rs.next())
            { 
                combobox_subeler.addItem(new ComboItem(rs.getString("kts_sub_ad"),rs.getString("kts_sub_ıd")));
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
                Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField_calisan_ad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_calisan_soyad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_calisan_tc = new javax.swing.JTextField();
        combobox_subeler = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        buton_geri = new javax.swing.JButton();
        buton_calisan_ekle = new javax.swing.JButton();
        label_calisan_ıd = new javax.swing.JLabel();
        buton_temizle = new javax.swing.JButton();
        buton_calisan_ara = new javax.swing.JButton();
        jTextField_calisan_arama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        calisan_table = new javax.swing.JTable();
        buton_calisan_guncelle = new javax.swing.JButton();
        buton_calisan_sil = new javax.swing.JButton();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Çalışan Ad");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(37, 163, 60, 16);

        jTextField_calisan_ad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_calisan_adKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_calisan_ad);
        jTextField_calisan_ad.setBounds(135, 160, 140, 22);

        jLabel2.setText("Çalışan Soyad");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(37, 209, 80, 16);

        jTextField_calisan_soyad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_calisan_soyadKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_calisan_soyad);
        jTextField_calisan_soyad.setBounds(135, 206, 140, 22);

        jLabel3.setText("Çalışan TC");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(37, 118, 70, 16);

        jTextField_calisan_tc.setNextFocusableComponent(jTextField_calisan_ad);
        jTextField_calisan_tc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_calisan_tcKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_calisan_tc);
        jTextField_calisan_tc.setBounds(135, 115, 140, 22);

        getContentPane().add(combobox_subeler);
        combobox_subeler.setBounds(135, 252, 140, 22);

        jLabel4.setText("Şubeler");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(37, 255, 44, 16);

        buton_geri.setBackground(new java.awt.Color(255, 51, 51));
        buton_geri.setText("< Ana Ekran");
        buton_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_geriActionPerformed(evt);
            }
        });
        getContentPane().add(buton_geri);
        buton_geri.setBounds(12, 16, 103, 25);

        buton_calisan_ekle.setText("Ekle");
        buton_calisan_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_calisan_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_calisan_ekle);
        buton_calisan_ekle.setBounds(135, 313, 81, 25);

        label_calisan_ıd.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(label_calisan_ıd);
        label_calisan_ıd.setBounds(446, 363, 197, 24);

        buton_temizle.setText("Temizle");
        buton_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_temizleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_temizle);
        buton_temizle.setBounds(234, 362, 81, 25);

        buton_calisan_ara.setBackground(new java.awt.Color(51, 255, 51));
        buton_calisan_ara.setText("ARA");
        buton_calisan_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_calisan_araActionPerformed(evt);
            }
        });
        getContentPane().add(buton_calisan_ara);
        buton_calisan_ara.setBounds(666, 66, 108, 25);

        jTextField_calisan_arama.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_calisan_arama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_calisan_aramaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_calisan_arama);
        jTextField_calisan_arama.setBounds(322, 67, 326, 22);

        calisan_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Çalışan TC", "Çalışan ID", "Çalışan Ad", "Çalışan Soyad", "Çalışan Şube"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calisan_table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                calisan_tableFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(calisan_table);
        if (calisan_table.getColumnModel().getColumnCount() > 0) {
            calisan_table.getColumnModel().getColumn(0).setResizable(false);
            calisan_table.getColumnModel().getColumn(1).setResizable(false);
            calisan_table.getColumnModel().getColumn(2).setResizable(false);
            calisan_table.getColumnModel().getColumn(3).setResizable(false);
            calisan_table.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(322, 115, 452, 183);

        buton_calisan_guncelle.setText("Güncelle");
        buton_calisan_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_calisan_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_calisan_guncelle);
        buton_calisan_guncelle.setBounds(234, 313, 81, 25);

        buton_calisan_sil.setText("Sil");
        buton_calisan_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_calisan_silActionPerformed(evt);
            }
        });
        getContentPane().add(buton_calisan_sil);
        buton_calisan_sil.setBounds(135, 362, 77, 25);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, -10, 800, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_calisan_adKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_calisan_adKeyTyped

        String metin = jTextField_calisan_ad.getText();
        int ad_uzunluk = metin.length();

        char karakter = evt.getKeyChar();
        if( (Character.isDigit(karakter) &&( !(karakter==KeyEvent.VK_SPACE))
            || (karakter==KeyEvent.VK_BACK_SPACE) || (karakter==KeyEvent.VK_DELETE) ||ad_uzunluk == 30))
    {
        evt.consume();
        }

    }//GEN-LAST:event_jTextField_calisan_adKeyTyped

    private void jTextField_calisan_soyadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_calisan_soyadKeyTyped

        String metin = jTextField_calisan_soyad.getText();
        int soyad_uzunluk = metin.length();

        char karakter = evt.getKeyChar();
        if( (Character.isDigit(karakter) &&( !(karakter==KeyEvent.VK_SPACE))
            || (karakter==KeyEvent.VK_BACK_SPACE) || (karakter==KeyEvent.VK_DELETE) ||soyad_uzunluk == 30))
    {
        evt.consume();
        }

    }//GEN-LAST:event_jTextField_calisan_soyadKeyTyped

    private void jTextField_calisan_tcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_calisan_tcKeyTyped

        String metin = jTextField_calisan_tc.getText();
        int tc_uzunluk = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || tc_uzunluk == 11 )
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_calisan_tcKeyTyped

    private void buton_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_geriActionPerformed
        this.dispose();
        AnaEkran ekran = new AnaEkran();
        ekran.setVisible(true);
    }//GEN-LAST:event_buton_geriActionPerformed

    private void buton_calisan_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_calisan_ekleActionPerformed
       
        String calisan_ad = jTextField_calisan_ad.getText();
        String calisan_soyad = jTextField_calisan_soyad.getText();
        String calisan_tc = jTextField_calisan_tc.getText();
        
        item = combobox_subeler.getSelectedItem();
        String sube_id = ((ComboItem)item).getValue();
        
        
         if(jTextField_calisan_ad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Çalışan adı boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_calisan_ad.requestFocus();
            return;
        } 
         
         if(jTextField_calisan_soyad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Çalışan soyad boş  geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_calisan_soyad.requestFocus();
            return;
        } 
         
         if(jTextField_calisan_tc.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Çalışan TC boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_calisan_tc.requestFocus();
            return;
        } 

            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                String musteri_id = dbsp.sp_calisan_ekle(con, calisan_ad, calisan_soyad, calisan_tc, sube_id);
                if(!musteri_id.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Eklendi", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
                    buton_temizle.doClick();
                    buton_calisan_ara.doClick(); 
                }  
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            finally
            {
                try 
                {
                    con.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         
            
    }//GEN-LAST:event_buton_calisan_ekleActionPerformed

    private void buton_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_temizleActionPerformed
                
                 jTextField_calisan_ad.setText("");
                 jTextField_calisan_soyad.setText("");
                 jTextField_calisan_tc.setText("");
                 label_calisan_ıd.setText("");
                 buton_calisan_sil.setEnabled(false);
                 buton_calisan_guncelle.setEnabled(false);
                 buton_calisan_ekle.setEnabled(true);
                 combobox_subeler.setSelectedIndex(0);
                 jTextField_calisan_tc.setEditable(true);
                 
                 buton_calisan_ara.doClick();
                 
    }//GEN-LAST:event_buton_temizleActionPerformed
 private void calisansorgu()
        {
            
         String sorgu = "SELECT KTS_CLS_TC, KTS_CLS_ID, KTS_CLS_AD, KTS_CLS_SOYAD, KTS_SUB_AD " +
                        "FROM KTS_CALISANLAR, KTS_SUBELER " +
                        "WHERE KTS_CLS_SUBE_ID = KTS_SUB_ID";
            
        try 
       {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
               
            Statement statement = con.createStatement();

            ResultSet resultset = statement.executeQuery(sorgu);
            
            resultSetToTableModel(resultset, calisan_table);
             
             
       } 
       
       catch (SQLException ex) 
       {
           
           Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
       }

        }
        
        public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException{
        
       
        //Yeni bir table model oluşturuyoruz
        DefaultTableModel tableModel = new DefaultTableModel();

        //Result Setten meta verileri alıyoruz
        ResultSetMetaData metaData = rs.getMetaData();

        //Meta verilerden sütun sayısını alıyoruz
        int columnCount = metaData.getColumnCount();

        //Tüm sütun adlarını meta veriden alıyoruz ve tablo modeline sütun ekliyoruz
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Meta verilerden sütun sayısının büyüklüğüyle Nesneler dizisi yaratıyoruz
        Object[] row = new Object[columnCount];

        //Result set'te arama sonuçlarında geziniyoruz
        while (rs.next()){
            //Nesneler dizisine ayarlanmış belirli bir sonuç dizini ile sütundan nesneyi alıyoruz
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Şimdi, bu nesne dizisini içeren tablo modeline satır olarak ekliyoruz
            tableModel.addRow(row);
        }

        //Şimdi bu tablo modelini kendi tablomuza ekliyoruz 
       
        table.setModel(tableModel);

        tablo_basliklarini_duzenle(table);
        
        table.setDefaultEditor(Object.class, null);    // Gelen veriler ekranda değiştirilemesin diye
    }
        
        public void tablo_basliklarini_duzenle(JTable table)  //Veritabaninda verileri cektikten sonra sütun başlıklarını yeniden adlandırmak için
        {
         
       String header[] = {"Çalışan TC", "Çalışan ID", "Çalışan Ad", "Çalışan Soyad", "Çalışan Şube"};
  
        for(int i=0;i<table.getColumnCount();i++)
        {
        TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);

        column1.setHeaderValue(header[i]);
        }  
         
         
       }
    private void buton_calisan_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_calisan_araActionPerformed

        String calisan_id = jTextField_calisan_arama.getText();

        if(calisan_id.trim().equals(""))
        {
            calisansorgu();
            return;
        }

        String [] kts_calisan_bilgi = new String[5];

        if(calisan_id.length() == 11)
        {
            DatabaseSP dbsp = new DatabaseSP();

            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);

            try
            {
                kts_calisan_bilgi = dbsp.sp_calisan_bul(con, calisan_id);
            }

            catch (SQLException ex)
            {
                Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally
            {
                try
                {
                    con.close();
                }

                catch (SQLException ex)
                {
                    Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            DefaultTableModel aModel = (DefaultTableModel) calisan_table.getModel();
            aModel.setRowCount(0);
            aModel.addRow(kts_calisan_bilgi);
            calisan_table.setModel(aModel);
            resizeColumnWidth(calisan_table);
            calisan_table.setBackground(Color.LIGHT_GRAY);
            calisan_table.getTableHeader().setReorderingAllowed(false);

            calisan_table.setDefaultEditor(Object.class, null);

            jTextField_calisan_arama.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Çalışan TC hatalı girilmiştir. Lütfen tekrar deneyiniz.","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buton_calisan_araActionPerformed

     public void resizeColumnWidth(JTable table) 
    {
        final TableColumnModel columnModel = table.getColumnModel();
        
        for (int column = 0; column < table.getColumnCount(); column++) 
        {
            int width = 16; // Min width
            
            for (int row = 0; row < table.getRowCount(); row++) 
            {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            
            if(width > 300)
                width=300;
            
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    private void jTextField_calisan_aramaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_calisan_aramaKeyTyped

        String metin = jTextField_calisan_arama.getText();
        int calisan_id = metin.length();

        char karakter = evt.getKeyChar();

        if( !(Character.isDigit(karakter)) || calisan_id == 11 )
        {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField_calisan_aramaKeyTyped

    private void buton_calisan_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_calisan_silActionPerformed

        Object[] options = { "Evet", "Hayır" };

        int dialogResult = JOptionPane.showOptionDialog(null, "Çalışanı silmek istediğinize emin misiniz?", "Kontrol",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
        null, options, options[0]);
        
        if(dialogResult == 0 )
        {
             Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                dbsp.sp_calisan_sil(con, calisan_id);
                
                JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Silindi.", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
                 
                buton_temizle.doClick();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            finally
            {
                try 
                {
                    con.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(CalisanEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_buton_calisan_silActionPerformed

    private void buton_calisan_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_calisan_guncelleActionPerformed
        
        String tc = jTextField_calisan_tc.getText();
        String ad = jTextField_calisan_ad.getText();
        String soyad = jTextField_calisan_soyad.getText();
       
        
        item = combobox_subeler.getSelectedItem();
        int sube = Integer.parseInt(((ComboItem)item).getValue());
        

          if(jTextField_calisan_ad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Çalışan adı boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_calisan_ad.requestFocus();
            return;
        } 
         
         if(jTextField_calisan_soyad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Çalışan soyad boş  geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_calisan_soyad.requestFocus();
            return;
        } 
         
         if(jTextField_calisan_tc.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Çalışan TC boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_calisan_tc.requestFocus();
            return;
        } 

        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        DatabaseSP dbsp = new DatabaseSP();
        try 
        {
            dbsp.sp_calisan_guncelle(con, calisan_id, tc, ad, soyad, sube);

             JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Güncellendi.", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
             buton_calisan_ekle.setEnabled(false);
             buton_calisan_guncelle.setEnabled(true);
             buton_calisan_ara.doClick();

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
    }//GEN-LAST:event_buton_calisan_guncelleActionPerformed

    private void calisan_tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calisan_tableFocusGained

        tiklama();
        
    }//GEN-LAST:event_calisan_tableFocusGained

    int calisan_id;
    
     public void tiklama()
    {
       if(tekrar==true) 
       {
          return;
       } 
        
       int index = calisan_table.getSelectedRow();
       TableModel model = calisan_table.getModel();
       
        //Cift tıkladıgını anlayalım diye
       
        
        calisan_table.addMouseListener(new MouseAdapter() 
        { 
            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
                {
                    buton_calisan_ekle.setEnabled(false);
                    buton_calisan_sil.setEnabled(true);
                    buton_calisan_guncelle.setEnabled(true);
                    jTextField_calisan_tc.setEditable(false);
                    int index = calisan_table.getSelectedRow();
                    TableModel model = calisan_table.getModel();

                    jTextField_calisan_tc.setText(model.getValueAt(index, 0).toString());
                    
                    calisan_id = Integer.parseInt(model.getValueAt(index, 1).toString());
                    
                    jTextField_calisan_ad.setText(model.getValueAt(index, 2).toString());
                   
                    jTextField_calisan_soyad.setText(model.getValueAt(index, 3).toString());
                   
                    int sube_ind = subeComboIndex(model.getValueAt(index, 4).toString());
                    combobox_subeler.setSelectedIndex(sube_ind);
                   
                  }       
           }
        });
        
        tekrar=true;
        
    }
     
     private int subeComboIndex(String icerik)
    {   
       int sayac = 0; 
       while(!combobox_subeler.getItemAt(sayac).toString().equals(icerik))
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
            java.util.logging.Logger.getLogger(CalisanEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalisanEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalisanEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalisanEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalisanEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_calisan_ara;
    private javax.swing.JButton buton_calisan_ekle;
    private javax.swing.JButton buton_calisan_guncelle;
    private javax.swing.JButton buton_calisan_sil;
    private javax.swing.JButton buton_geri;
    private javax.swing.JButton buton_temizle;
    private javax.swing.JTable calisan_table;
    private javax.swing.JComboBox combobox_subeler;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_calisan_ad;
    private javax.swing.JTextField jTextField_calisan_arama;
    private javax.swing.JTextField jTextField_calisan_soyad;
    private javax.swing.JTextField jTextField_calisan_tc;
    private javax.swing.JLabel label_arka_plan;
    private javax.swing.JLabel label_calisan_ıd;
    // End of variables declaration//GEN-END:variables
}
