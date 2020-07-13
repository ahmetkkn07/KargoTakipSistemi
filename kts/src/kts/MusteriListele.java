
package kts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MusteriListele extends javax.swing.JFrame 
{
    public MusteriListele() 
    {
        initComponents();
        setTitle("Müşteri Listesi");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        String sorgu = "select m.kts_mst_tc, m.kts_mst_ad, m.kts_mst_soyad, kts_mst_telefon, " +
                    "il.kts_il_ad, ilce.kts_ilce_ad, a.kts_adr_mah_sokak, a.kts_adr_numara, a.kts_adr_acik_adres " +
                    "from kts_musteri m, kts_adres a, kts_iller il, kts_ilceler ilce " +
                    "where m.kts_mst_id = a.kts_adr_mst_id and a.kts_adr_il_id = il.kts_il_id and (ilce.KTS_ILCE_ID = a.KTS_ADR_ILce_ID and ilce.KTS_ILCE_IL_ID =a.KTS_ADR_IL_ID)";
        try 
       {
            Connection con = null;
            OracleCon orc = new OracleCon();
            con = orc.OracleCon(con);
               
            Statement statement=con.createStatement();
             
            ResultSet resultset = statement.executeQuery(sorgu);
             
            resultSetToTableModel(resultset, table);
             
       } 
       
       catch (SQLException ex) 
       {
           
           Logger.getLogger(SubeEkran.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException
        {
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
            String header[] = {"T.C. Kimlik No", "Ad", "Soyad", "Telefon", "İl", "İlçe", "Mahalle Sokak", "Kapı No", "Açık Adres"};

             for(int i=0;i<table.getColumnCount();i++)
             {
                TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);

                column1.setHeaderValue(header[i]);
             }  
       }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        buton_geri = new javax.swing.JButton();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "T.C. Kimlik No", "Ad", "Soyad", "Telefon", "İl", "İlçe", "Mahalle Sokak", "Kapı No", "Açık Adres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 32, 800, 483);

        buton_geri.setBackground(new java.awt.Color(255, 51, 51));
        buton_geri.setText("< Geri");
        buton_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_geriActionPerformed(evt);
            }
        });
        getContentPane().add(buton_geri);
        buton_geri.setBounds(0, 0, 69, 25);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, -10, 800, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buton_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_geriActionPerformed
        this.dispose();
        MusteriEkle ekran = new MusteriEkle();
        ekran.setVisible(true);
    }//GEN-LAST:event_buton_geriActionPerformed

    
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(MusteriListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusteriListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusteriListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusteriListele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new MusteriListele().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_geri;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_arka_plan;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
