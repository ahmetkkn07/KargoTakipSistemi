package kts;

import java.sql.SQLException;

public class Test 
{
    public static void main(String[] args) throws SQLException 
    {

        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(GirisYap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
            GirisYap giris = new GirisYap();
            giris.setVisible(true);
    }
}
