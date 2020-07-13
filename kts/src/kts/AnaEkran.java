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

public class AnaEkran extends javax.swing.JFrame 
{
    boolean tekrar=false; 

    public static int yetki_derecesi;
    
    public AnaEkran() 
    {
        setTitle("Ana Ekran");
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        jTextField_takip.setUI(new JTextFieldHintUI("Arama Yapmak İçin Kargo Takip Numarasını Giriniz", Color.BLACK));
        
        yetki_kontrol(yetki_derecesi);
        
      //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
    }

    public void yetki_kontrol (int yetki)
    {
        switch(yetki)
        {
            case 1:
            {
                buton_calisanlar.setEnabled(false);
                buton_subeler.setEnabled(false);
                break;
            }
            case 3:
            {
                buton_calisanlar.setEnabled(true);
                buton_subeler.setEnabled(true);
                break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buton_yeni_kargo = new javax.swing.JButton();
        buton_subeler = new javax.swing.JButton();
        buton_calisanlar = new javax.swing.JButton();
        buton_musteriler = new javax.swing.JButton();
        jTextField_takip = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        kargo_table = new javax.swing.JTable();
        buton_ara = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        buton_yeni_kargo.setText("Yeni Kargo");
        buton_yeni_kargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_yeni_kargoActionPerformed(evt);
            }
        });
        getContentPane().add(buton_yeni_kargo);
        buton_yeni_kargo.setBounds(12, 64, 115, 25);

        buton_subeler.setText("Şubeler");
        buton_subeler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_subelerActionPerformed(evt);
            }
        });
        getContentPane().add(buton_subeler);
        buton_subeler.setBounds(12, 235, 115, 25);

        buton_calisanlar.setText("Çalışanlar");
        buton_calisanlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_calisanlarActionPerformed(evt);
            }
        });
        getContentPane().add(buton_calisanlar);
        buton_calisanlar.setBounds(12, 178, 115, 25);

        buton_musteriler.setText("Müşteriler");
        buton_musteriler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_musterilerActionPerformed(evt);
            }
        });
        getContentPane().add(buton_musteriler);
        buton_musteriler.setBounds(12, 121, 115, 25);

        jTextField_takip.setBackground(new java.awt.Color(204, 204, 204));
        jTextField_takip.setToolTipText("Kargo No'ya göre arama yapın");
        jTextField_takip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_takipKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_takipKeyTyped(evt);
            }
        });
        getContentPane().add(jTextField_takip);
        jTextField_takip.setBounds(145, 67, 488, 22);

        kargo_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gönderici", "Alıcı", "Kabul Tarihi", "Durumu", "Son İşlem Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kargo_table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kargo_tableFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(kargo_table);
        if (kargo_table.getColumnModel().getColumnCount() > 0) {
            kargo_table.getColumnModel().getColumn(0).setResizable(false);
            kargo_table.getColumnModel().getColumn(1).setResizable(false);
            kargo_table.getColumnModel().getColumn(2).setResizable(false);
            kargo_table.getColumnModel().getColumn(3).setResizable(false);
            kargo_table.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(145, 105, 627, 202);

        buton_ara.setBackground(new java.awt.Color(51, 255, 51));
        buton_ara.setText("Ara");
        buton_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_araActionPerformed(evt);
            }
        });
        getContentPane().add(buton_ara);
        buton_ara.setBounds(645, 67, 127, 25);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("< Çıkış Yap");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(12, 376, 115, 25);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, -10, 800, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buton_yeni_kargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_yeni_kargoActionPerformed

        YeniKargoEkran yeniKargoekran = new YeniKargoEkran();
        yeniKargoekran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buton_yeni_kargoActionPerformed

    private void jTextField_takipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_takipKeyTyped
         String metin = jTextField_takip.getText();
        int takip_uzunluk = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || takip_uzunluk == 11 )
        {
         evt.consume();
        }
    }//GEN-LAST:event_jTextField_takipKeyTyped

    private void buton_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_araActionPerformed
       
        String kargo_takip_no = jTextField_takip.getText();
        String [] kts_krg_tkp_blg = new String[6];

        if(kargo_takip_no.length() == 11)
        {
            DatabaseSP dbsp = new DatabaseSP();

            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);

            try 
            {
                kts_krg_tkp_blg = dbsp.sp_kargo_takip(con, kargo_takip_no);
            }

            catch (SQLException ex) 
            {
                Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
            }

            finally
            {
                try 
                {
                    con.close();
                } 

                catch (SQLException ex) 
                {
                    Logger.getLogger(AnaEkran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            DefaultTableModel aModel = (DefaultTableModel) kargo_table.getModel();
            aModel.setRowCount(0); 
            aModel.addRow(kts_krg_tkp_blg);
            kargo_table.setModel(aModel);
            resizeColumnWidth(kargo_table);
            //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            kargo_table.setBackground(Color.LIGHT_GRAY);
            kargo_table.getTableHeader().setReorderingAllowed(false); //samete atma

            kargo_table.setDefaultEditor(Object.class, null); 
            
            if(!kts_krg_tkp_blg[5].equals("hata_yok")) //hata var ise
            {
                ((DefaultTableModel)kargo_table.getModel()).setRowCount(0);
                JOptionPane.showMessageDialog(null, kts_krg_tkp_blg[5] , "Ana Ekran", JOptionPane.WARNING_MESSAGE);
                ((DefaultTableModel)kargo_table.getModel()).setRowCount(0);
                jTextField_takip.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Kargo Takip Numarası hatalı girilmiştir. Lütfen tekrar deneyiniz.","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE); 
        } 
    }//GEN-LAST:event_buton_araActionPerformed

    private void jTextField_takipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_takipKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            buton_ara.doClick();
    }//GEN-LAST:event_jTextField_takipKeyPressed

    private void buton_musterilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_musterilerActionPerformed
        this.dispose();
        MusteriEkle mstekle = new MusteriEkle();
        mstekle.setVisible(true);
    }//GEN-LAST:event_buton_musterilerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        GirisYap grsyp = new GirisYap();
        grsyp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buton_subelerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_subelerActionPerformed
        
        SubeEkran ekran = new SubeEkran();
        ekran.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_buton_subelerActionPerformed

    private void buton_calisanlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_calisanlarActionPerformed
        
        CalisanEkran ekran = new CalisanEkran();
        ekran.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_buton_calisanlarActionPerformed

    private void kargo_tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kargo_tableFocusGained
        
        tiklama();
        
    }//GEN-LAST:event_kargo_tableFocusGained

    public void tiklama()
    {   
       if(tekrar==true) 
       {
          return;
       } 
        
       int index = kargo_table.getSelectedRow();
       TableModel model = kargo_table.getModel();
       
       String takip_no = model.getValueAt(index, 0).toString();
       
        //Cift tıkladıgını anlayalım diye
       
        
        kargo_table.addMouseListener(new MouseAdapter() 
        { 
            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
                {
                    int index = kargo_table.getSelectedRow();
                    TableModel model = kargo_table.getModel();

                    String takip_no = model.getValueAt(index, 0).toString();

                    KargoDuzenleEkran duzenle_ekran = new KargoDuzenleEkran();
                    duzenle_ekran.setVisible(true);
                    duzenle_ekran.ekran_doldur(jTextField_takip.getText());
                    
                    dispose();
                      
                }       
           }
        });
        
        tekrar=true;
        
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
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaEkran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_ara;
    private javax.swing.JButton buton_calisanlar;
    private javax.swing.JButton buton_musteriler;
    private javax.swing.JButton buton_subeler;
    private javax.swing.JButton buton_yeni_kargo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_takip;
    private javax.swing.JTable kargo_table;
    private javax.swing.JLabel label_arka_plan;
    // End of variables declaration//GEN-END:variables
}
