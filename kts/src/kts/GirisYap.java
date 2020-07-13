package kts;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GirisYap extends javax.swing.JFrame 
{
    public GirisYap() 
    {
        setTitle("Kargo Giriş Ekranı");
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        textfield_kullanici_adi.requestFocus();
        
         //Pencereyi ekranın ortasına alabilmek için 
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textfield_kullanici_adi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password_field_sifre = new javax.swing.JPasswordField();
        jRadioButton1 = new javax.swing.JRadioButton();
        buton_giris_yap = new javax.swing.JButton();
        buton_kapat = new javax.swing.JButton();
        label_logo = new javax.swing.JLabel();
        label_arka_plan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setText("Kargo Takip Sistemi");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 99, 376, 44);

        textfield_kullanici_adi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textfield_kullanici_adiKeyTyped(evt);
            }
        });
        getContentPane().add(textfield_kullanici_adi);
        textfield_kullanici_adi.setBounds(347, 338, 132, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Kullanıcı Adı");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(249, 341, 80, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Şifre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 380, 40, 16);

        password_field_sifre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_field_sifreKeyPressed(evt);
            }
        });
        getContentPane().add(password_field_sifre);
        password_field_sifre.setBounds(347, 373, 132, 22);

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jRadioButton1.setText("Şifreyi Göster");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseReleased(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(501, 378, 120, 25);

        buton_giris_yap.setText("Giriş Yap");
        buton_giris_yap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_giris_yapActionPerformed(evt);
            }
        });
        getContentPane().add(buton_giris_yap);
        buton_giris_yap.setBounds(390, 420, 83, 25);

        buton_kapat.setBackground(new java.awt.Color(255, 51, 51));
        buton_kapat.setText("Kapat");
        buton_kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buton_kapatActionPerformed(evt);
            }
        });
        getContentPane().add(buton_kapat);
        buton_kapat.setBounds(720, 0, 73, 25);

        label_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FotografPackage/logo.png"))); // NOI18N
        getContentPane().add(label_logo);
        label_logo.setBounds(230, 150, 376, 180);

        label_arka_plan.setIcon(new javax.swing.ImageIcon("C:\\Kts_Fotograflar\\background.png")); // NOI18N
        getContentPane().add(label_arka_plan);
        label_arka_plan.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buton_giris_yapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_giris_yapActionPerformed
        
        String sifre = new String (password_field_sifre.getPassword());
        
        if(textfield_kullanici_adi.getText().trim().equals("") || sifre.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Kullanıcı Adı veya Şifre boş geçilemez!","Giriş Kontrolü",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int kullanici_id = Integer.parseInt(textfield_kullanici_adi.getText().trim());

        DatabaseSP dbsp = new DatabaseSP();
        
        Connection con = null;
        OracleCon orc = new OracleCon();
        con = orc.OracleCon(con);
        
        int yetki = -1;
        try 
        {
            yetki = dbsp.sp_login(con, kullanici_id, sifre, yetki);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GirisYap.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try 
            {
                con.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(GirisYap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(yetki == -1)
        {
            JOptionPane.showMessageDialog(this, "Kullanıcı Adı veya Şifre Hatalı.","Başarısız Giriş",JOptionPane.WARNING_MESSAGE);
        }
        else 
        {
            this.dispose();
            AnaEkran.yetki_derecesi = yetki;
            AnaEkran ekran = new AnaEkran();
            ekran.setVisible(true);
        }
    }//GEN-LAST:event_buton_giris_yapActionPerformed

    private void password_field_sifreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_field_sifreKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            buton_giris_yap.doClick();
    }//GEN-LAST:event_password_field_sifreKeyPressed

    private void buton_kapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buton_kapatActionPerformed
        exit(0);
    }//GEN-LAST:event_buton_kapatActionPerformed

    private void textfield_kullanici_adiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_kullanici_adiKeyTyped
        
        String metin = textfield_kullanici_adi.getText();
        int kullanici_id = metin.length();
       
       char karakter = evt.getKeyChar();
    
       if( !(Character.isDigit(karakter)) || kullanici_id == 5 )
        {
            evt.consume();
        }
       
    }//GEN-LAST:event_textfield_kullanici_adiKeyTyped

    private void jRadioButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MousePressed
        
        password_field_sifre.setEchoChar((char)0); // Karakterleri görünür yapmak için
        
        jRadioButton1.doClick(); // Radiobutton tıklanmış şekilde dursun diye
    }//GEN-LAST:event_jRadioButton1MousePressed

    private void jRadioButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseReleased
        
        password_field_sifre.setEchoChar('*'); // Karakterleri gizlemek için
        
       jRadioButton1.doClick(0); // Radiobutton tıklanmış halden çıkması için
    }//GEN-LAST:event_jRadioButton1MouseReleased

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
            java.util.logging.Logger.getLogger(GirisYap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GirisYap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GirisYap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GirisYap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new GirisYap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buton_giris_yap;
    private javax.swing.JButton buton_kapat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel label_arka_plan;
    private javax.swing.JLabel label_logo;
    private javax.swing.JPasswordField password_field_sifre;
    private javax.swing.JTextField textfield_kullanici_adi;
    // End of variables declaration//GEN-END:variables
}
