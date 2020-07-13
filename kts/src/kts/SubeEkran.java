package kts;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author samet
 */
public class SubeEkran extends javax.swing.JFrame {

    ResultSet rs = null;
    public Object item = null;
    boolean tekrar=false; 
    
    public SubeEkran() {
        
        initComponents();
        myinitComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        setTitle("Şubeler");
        
        //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        DocumentFilter filter = new UppercaseDocumentFilter();
        
        AbstractDocument musteri_ad_doc = (AbstractDocument) jTextField_sube_ad.getDocument();
        musteri_ad_doc.setDocumentFilter(filter);
        
        jTextField_sube_arama.setUI(new JTextFieldHintUI("Arama Yapmak İçin Şube Numarasını Giriniz", Color.BLACK));
        
        subesorgu();
        
        buton_sube_guncelle.setEnabled(false);
        buton_sube_sil.setEnabled(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_sube_ad = new javax.swing.JTextField();
        combobox_sube_il = new javax.swing.JComboBox();
        combobox_sube_ilce = new javax.swing.JComboBox();
        jTextField_sube_telefon_no = new javax.swing.JTextField();
        buton_sube_ekle = new javax.swing.JButton();
        label_sube_ıd = new javax.swing.JLabel();
        buton_geri = new javax.swing.JButton();
        buton_temizle = new javax.swing.JButton();
        buton_sube_ara = new javax.swing.JButton();
        jTextField_sube_arama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sube_table = new javax.swing.JTable();
        buton_sube_sil = new javax.swing.JButton();
        buton_sube_guncelle = new javax.swing.JButton();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Şube Adı");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(25, 124, 51, 16);

        jLabel2.setText("Şube İl ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(25, 169, 44, 16);

        jLabel3.setText("Şube İlçe");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(25, 214, 53, 16);

        jLabel4.setText("Telefon No");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(25, 259, 62, 16);

        jTextField_sube_ad.setNextFocusableComponent(combobox_sube_il);
        getContentPane().add(jTextField_sube_ad);
        jTextField_sube_ad.setBounds(105, 121, 148, 22);

        combobox_sube_il.setNextFocusableComponent(combobox_sube_ilce);
        combobox_sube_il.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_sube_ilİtemStateChanged(evt);
            }
        });
        getContentPane().add(combobox_sube_il);
        combobox_sube_il.setBounds(105, 166, 148, 22);

        combobox_sube_ilce.setNextFocusableComponent(jTextField_sube_telefon_no);
        getContentPane().add(combobox_sube_ilce);
        combobox_sube_ilce.setBounds(105, 211, 148, 22);

        jTextField_sube_telefon_no.setNextFocusableComponent(buton_sube_ekle);
        jTextField_sube_telefon_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_sube_telefon_noKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_sube_telefon_no);
        jTextField_sube_telefon_no.setBounds(105, 256, 148, 22);

        buton_sube_ekle.setText("Ekle");
        buton_sube_ekle.setNextFocusableComponent(buton_temizle);
        buton_sube_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_sube_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_sube_ekle);
        buton_sube_ekle.setBounds(105, 315, 77, 25);

        label_sube_ıd.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        getContentPane().add(label_sube_ıd);
        label_sube_ıd.setBounds(444, 364, 187, 23);

        buton_geri.setBackground(new java.awt.Color(255, 51, 51));
        buton_geri.setText("< Ana Ekran");
        buton_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_geriActionPerformed(evt);
            }
        });
        getContentPane().add(buton_geri);
        buton_geri.setBounds(12, 13, 103, 25);

        buton_temizle.setText("Temizle");
        buton_temizle.setNextFocusableComponent(jTextField_sube_ad);
        buton_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_temizleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_temizle);
        buton_temizle.setBounds(200, 364, 81, 25);

        buton_sube_ara.setBackground(new java.awt.Color(51, 255, 51));
        buton_sube_ara.setText("ARA");
        buton_sube_ara.setNextFocusableComponent(buton_temizle);
        buton_sube_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_sube_araActionPerformed(evt);
            }
        });
        getContentPane().add(buton_sube_ara);
        buton_sube_ara.setBounds(669, 78, 108, 25);

        jTextField_sube_arama.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_sube_arama.setNextFocusableComponent(buton_sube_ara);
        jTextField_sube_arama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_sube_aramaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_sube_arama);
        jTextField_sube_arama.setBounds(325, 79, 326, 22);

        sube_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şube ID", "Şube Ad", "Şube İl", "Şube İlçe", "Şube Telefon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sube_table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sube_tableFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(sube_table);
        if (sube_table.getColumnModel().getColumnCount() > 0) {
            sube_table.getColumnModel().getColumn(0).setResizable(false);
            sube_table.getColumnModel().getColumn(1).setResizable(false);
            sube_table.getColumnModel().getColumn(2).setResizable(false);
            sube_table.getColumnModel().getColumn(3).setResizable(false);
            sube_table.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(325, 121, 452, 183);

        buton_sube_sil.setText("Sil");
        buton_sube_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_sube_silActionPerformed(evt);
            }
        });
        getContentPane().add(buton_sube_sil);
        buton_sube_sil.setBounds(105, 364, 77, 25);

        buton_sube_guncelle.setText("Güncelle");
        buton_sube_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_sube_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(buton_sube_guncelle);
        buton_sube_guncelle.setBounds(200, 315, 81, 25);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void subesorgu()
        {
        
         String sorgu = "Select kts_sub_id, kts_sub_ad, kts_il_ad, kts_ilce_ad,\n" +
                           "kts_sub_tlf_no\n" +
                           "from kts_subeler s, kts_iller b, kts_ilceler c\n" +
                           "where s.KTS_SUB_IL_ID = b.KTS_IL_ID\n" +
                           "and b.KTS_IL_ID = c.KTS_ILCE_IL_ID\n" +
                           "and s.KTS_SUB_ILCE_ID = c.KTS_ILCE_ID\n" +
                           "ORDER BY(kts_sub_ad)";
            
        try 
       {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
               
            Statement statement=con.createStatement();
             
            ResultSet resultset = statement.executeQuery(sorgu);
             
            resultSetToTableModel(resultset, sube_table);
             
       } 
       
       catch (SQLException ex) 
       {
         Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
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
            String header[] = {"Şube ID", "Şube Ad", "Şube İl", "Şube İlçe", "Şube Telefon"};

             for(int i=0;i<table.getColumnCount();i++)
             {
                TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);

                column1.setHeaderValue(header[i]);
             }  
       }
        
    private void combobox_sube_ilİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_sube_ilİtemStateChanged
        item = combobox_sube_il.getSelectedItem();
        String il_temp = ((ComboItem)item).getValue();
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
         //İLÇE COMBOBOX DOLDURMA
        String ilce_sorgu = "Select kts_ilce_id, kts_ilce_ad "
                + "from kts_ilceler "
                + "where kts_ilce_il_id  = " + il_temp
                + "ORDER BY(kts_ilce_ad)";
         
        combobox_sube_ilce.removeAllItems();
        
        try 
        {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(ilce_sorgu);
        
            while (rs.next())
            { 
                combobox_sube_ilce.addItem(new ComboItem(rs.getString("kts_ilce_ad"),rs.getString("kts_ilce_id"))); 
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combobox_sube_ilİtemStateChanged

    private void buton_sube_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_sube_ekleActionPerformed
        
        String sube_adi = jTextField_sube_ad.getText();
        
        item = combobox_sube_il.getSelectedItem();
        String sube_il = ((ComboItem)item).getValue();
        
        item = combobox_sube_ilce.getSelectedItem();
        String sube_ilce = ((ComboItem)item).getValue();
        
        String sube_telefon = jTextField_sube_telefon_no.getText();
        
         if(jTextField_sube_ad.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Şube adı boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_sube_ad.requestFocus();
            return;
        } 
         
         if(jTextField_sube_telefon_no.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Şube telefon no boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_sube_telefon_no.requestFocus();
            return;
        } 
         
         Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                String adres_id = dbsp.sp_sube_ekle(con, sube_adi, sube_il, sube_ilce, sube_telefon);
                
                 JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Eklendi", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
                 buton_sube_ara.doClick();
                 label_sube_ıd.setText("Şube Numarası : " + adres_id);
                 buton_temizle.doClick();
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
                    Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_buton_sube_ekleActionPerformed

    private void buton_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_geriActionPerformed
        this.dispose();
        AnaEkran ekran = new AnaEkran();
        ekran.setVisible(true);
    }//GEN-LAST:event_buton_geriActionPerformed

    private void buton_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_temizleActionPerformed
        
        jTextField_sube_ad.setText("");
        jTextField_sube_telefon_no.setText("");
        label_sube_ıd.setText("");
        combobox_sube_il.setSelectedIndex(0);
        buton_sube_ekle.setEnabled(true);
        buton_sube_ara.doClick();
        buton_sube_guncelle.setEnabled(false);
        buton_sube_sil.setEnabled(false);
                 
    }//GEN-LAST:event_buton_temizleActionPerformed

    private void buton_sube_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_sube_araActionPerformed
       
        String sube_id = jTextField_sube_arama.getText();
       
       if(sube_id.trim().equals(""))
       {
           subesorgu();
           return;
       }
       
       String [] kts_sube_bilgi = new String[5];

        if(sube_id.length() == 5)
        {
            DatabaseSP dbsp = new DatabaseSP();

            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);

            try 
            {
                kts_sube_bilgi = dbsp.sp_sube_bul(con, sube_id);
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
                    Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            DefaultTableModel aModel = (DefaultTableModel) sube_table.getModel();
            aModel.setRowCount(0); 
            aModel.addRow(kts_sube_bilgi);
            sube_table.setModel(aModel);
            resizeColumnWidth(sube_table);
            sube_table.setBackground(Color.LIGHT_GRAY);
            sube_table.getTableHeader().setReorderingAllowed(false);

            sube_table.setDefaultEditor(Object.class, null); 
            
            jTextField_sube_arama.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Şube numarası hatalı girilmiştir. Lütfen tekrar deneyiniz.","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE); 
        } 
    }//GEN-LAST:event_buton_sube_araActionPerformed

    private void jTextField_sube_aramaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_sube_aramaKeyTyped
        
        String metin = jTextField_sube_arama.getText();
        int sube_id = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || sube_id == 5 )
        {
         evt.consume();
        }
       
    }//GEN-LAST:event_jTextField_sube_aramaKeyTyped

    private void sube_tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sube_tableFocusGained
        
        tiklama();
        
    }//GEN-LAST:event_sube_tableFocusGained

    int sube_id;
    
    private void buton_sube_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_sube_guncelleActionPerformed
             
        String ad = jTextField_sube_ad.getText();
        
        item = combobox_sube_il.getSelectedItem();
        int il = Integer.parseInt(((ComboItem)item).getValue());
        
        item = combobox_sube_ilce.getSelectedItem();
        int ilce = Integer.parseInt(((ComboItem)item).getValue());
        
        String telefon = jTextField_sube_telefon_no.getText();

         if(ad.trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Şube adı boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_sube_ad.requestFocus();
            return;
        }         
        if(telefon.trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Şube telefon numarası boş geçilemez!","Ekleme Kontrolü",JOptionPane.WARNING_MESSAGE);
            jTextField_sube_telefon_no.requestFocus();
            return;
        }       

        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        DatabaseSP dbsp = new DatabaseSP();
        try 
        {
            dbsp.sp_sube_guncelle(con, sube_id, ad, il, ilce, telefon);

             JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Güncellendi.", "Başarılı İşlem",JOptionPane.INFORMATION_MESSAGE);
             buton_sube_ekle.setEnabled(false);
             buton_sube_guncelle.setEnabled(true);
             buton_sube_ara.doClick();

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
        
    }//GEN-LAST:event_buton_sube_guncelleActionPerformed

    private void buton_sube_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_sube_silActionPerformed

        Object[] options = { "Evet", "Hayır" };

        int dialogResult = JOptionPane.showOptionDialog(null, "Şubeyi silmek istediğinize emin misiniz?", "Kontrol",
        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
        null, options, options[0]);

        if(dialogResult == 0) //Şubeyi silmek istiyorsa
        {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
            DatabaseSP dbsp = new DatabaseSP();
            try 
            {
                String sonuc = dbsp.sp_sube_sil(con, sube_id);
                
                 JOptionPane.showMessageDialog(this, sonuc, "İşlem Sonucu",JOptionPane.INFORMATION_MESSAGE);
                
                if(sonuc.equals("Kayıt başarıyla silindi"))
                {
                    buton_temizle.doClick();
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
            
        }
            
    }//GEN-LAST:event_buton_sube_silActionPerformed

    private void jTextField_sube_telefon_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_sube_telefon_noKeyTyped
        
        String metin = jTextField_sube_telefon_no.getText();
        int tlf_uzunluk = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || tlf_uzunluk == 10 )
        {
         evt.consume();
        }
    }//GEN-LAST:event_jTextField_sube_telefon_noKeyTyped

    public void tiklama()
    {
        
       if(tekrar==true) 
       {
          return;
       } 
        
       int index = sube_table.getSelectedRow();
       TableModel model = sube_table.getModel();
       
        //Cift tıkladıgını anlayalım diye
       
       sube_table.addMouseListener(new MouseAdapter() 
        { 
            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
                {
                    buton_sube_ekle.setEnabled(false);
                    buton_sube_guncelle.setEnabled(true);
                    buton_sube_sil.setEnabled(true);
                    int index = sube_table.getSelectedRow();
                    TableModel model = sube_table.getModel();

                    sube_id = Integer.parseInt(model.getValueAt(index, 0).toString());
                    
                   jTextField_sube_ad.setText(model.getValueAt(index, 1).toString());
                   
                   int il_ind = ilComboIndex(model.getValueAt(index, 2).toString());
                   combobox_sube_il.setSelectedIndex(il_ind);
                   
                   int ilce_ind = ilceComboIndex(model.getValueAt(index, 3).toString());
                   combobox_sube_ilce.setSelectedIndex(ilce_ind);
                   
                   jTextField_sube_telefon_no.setText(model.getValueAt(index, 4).toString());
                   
                  }       
           }
        });
        
        tekrar=true;
        
    }
    
    private int ilComboIndex(String icerik)
    {   
       int sayac = 0; 
       while(!combobox_sube_il.getItemAt(sayac).toString().equals(icerik))
       {  
            sayac++;                
       }    
       return sayac;
    }

    private int ilceComboIndex(String icerik)
    {   
       int sayac = 0; 
       while(!combobox_sube_ilce.getItemAt(sayac).toString().equals(icerik))
       {  
            sayac++;                
       }    
       return sayac;
    }
    
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
    
     private void myinitComponents()
    {
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
                combobox_sube_il.addItem(new ComboItem(rs.getString("kts_il_ad"),rs.getString("kts_il_id"))); 
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    
          //İLÇE COMBOBOX DOLDURMA
        String ilce_sorgu = "Select kts_ilce_id, kts_ilce_ad "
                + "from kts_ilceler "
                + "where kts_ilce_il_id  = 1 "
                + "ORDER BY(kts_ilce_ad)";
         
        
        combobox_sube_ilce.removeAllItems();
        
        try 
        {
        Statement stmt = con.createStatement();

        rs = stmt.executeQuery(ilce_sorgu);
        
            while (rs.next())
            { 
                combobox_sube_ilce.addItem(new ComboItem(rs.getString("kts_ilce_ad"),rs.getString("kts_ilce_id"))); 
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            java.util.logging.Logger.getLogger(SubeEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubeEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubeEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubeEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubeEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_geri;
    private javax.swing.JButton buton_sube_ara;
    private javax.swing.JButton buton_sube_ekle;
    private javax.swing.JButton buton_sube_guncelle;
    private javax.swing.JButton buton_sube_sil;
    private javax.swing.JButton buton_temizle;
    private javax.swing.JComboBox combobox_sube_il;
    private javax.swing.JComboBox combobox_sube_ilce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_sube_ad;
    private javax.swing.JTextField jTextField_sube_arama;
    private javax.swing.JTextField jTextField_sube_telefon_no;
    private javax.swing.JLabel label_arka_plan;
    private javax.swing.JLabel label_sube_ıd;
    private javax.swing.JTable sube_table;
    // End of variables declaration//GEN-END:variables
}
