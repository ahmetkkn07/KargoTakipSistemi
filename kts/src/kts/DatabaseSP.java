package kts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sun.swing.SwingAccessor;

public class DatabaseSP 
{   
    public int sp_login(Connection con, int id, String sifre, int yetki) throws SQLException
    {
        try
        {
            String proc = "{call login(?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setInt(1, id);
            stmt.setString(2, sifre);
            stmt.registerOutParameter(3, java.sql.Types.INTEGER);
            stmt.execute(); 
            yetki = stmt.getInt(3);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return yetki;
    }
    
    public String sp_adres_bul(Connection con, String tc) throws SQLException
    {
        String adres = "";
        try
        {
            String proc = "{call adres_bul(?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, tc);
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            stmt.execute(); 
            adres = stmt.getString(2);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return adres;
    }
     
    public String[] sp_kargo_ekle(Connection con, String gnd_tc, String alc_tc, int krg_tur, float desi) throws SQLException
    {
        String[] krg_parametes = new String[2];
        try
        {
            String proc = "{call kargo_ekle(?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, gnd_tc);
            stmt.setString(2, alc_tc);
            stmt.setInt(3, krg_tur);
            stmt.setFloat(4, desi);
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR); //kargo_id
            stmt.registerOutParameter(6, java.sql.Types.NUMERIC); //fiyat
            stmt.execute(); 
            krg_parametes[0] = stmt.getString(5);
            krg_parametes[1] = stmt.getString(6);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return krg_parametes;
    }
    
    public String[] sp_kargo_takip(Connection con, String takip_no) throws SQLException
    {
        String[] tkp_parametes = new String[8];
        try
        {
            String proc = "{call kargo_takip(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, takip_no);
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);//gnd_adsoyad
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);//alc_adsoyad
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);//kbl_tarih
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR);//durum
            stmt.registerOutParameter(6, java.sql.Types.VARCHAR);//son_islem
            stmt.registerOutParameter(7, java.sql.Types.VARCHAR);//hata
            stmt.execute(); 
            tkp_parametes[0] = stmt.getString(2);
            tkp_parametes[1] = stmt.getString(3);
            tkp_parametes[2] = stmt.getString(4);
            tkp_parametes[3] = stmt.getString(5);
            tkp_parametes[4] = stmt.getString(6);
            tkp_parametes[5] = stmt.getString(7);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return tkp_parametes;
    }
    
    public void sp_musteri_ekle(Connection con, String mst_ad, String mst_soyad, String mst_tc, String mst_telefon, 
                                    String adres_il,String adres_ilce, String adres_mah_sok, String adres_kapi_no, String adres_acik) throws SQLException
    {     
        try
        {
            String proc = "{call mst_ekle(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, mst_ad);
            stmt.setString(2, mst_soyad);
            stmt.setString(3, mst_tc);
            stmt.setString(4, mst_telefon);
            stmt.setString(5, adres_il);
            stmt.setString(6, adres_ilce);
            stmt.setString(7, adres_mah_sok);
            stmt.setString(8, adres_kapi_no);
            stmt.setString(9, adres_acik);
            
            stmt.execute(); 
                     
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
    }
        
    
    public String sp_sube_ekle(Connection con, String sube_ad, String sube_il, String sube_ilce, String sube_telefon) throws SQLException
    {
        String sube_id = "";
        try
        {
            String proc = "{call SUBE_EKLE(?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
            stmt.setString(2, sube_ad);
            stmt.setString(3, sube_il);
            stmt.setString(4, sube_ilce);
            stmt.setString(5, sube_telefon);
           
            stmt.execute(); 
            
            sube_id = stmt.getString(1);
            
            return sube_id;       
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
        return sube_id;
    }
    
    public String sp_calisan_ekle(Connection con, String calisan_ad, String calisan_soyad, String calisan_tc, String calisan_sube) throws SQLException
    {
        String calisan_id = "";
        try
        {
            String proc = "{call CLSN_EKLE(?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            
            stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
            stmt.setString(2, calisan_ad);
            stmt.setString(3, calisan_soyad);
            stmt.setString(4, calisan_tc);
            stmt.setString(5, calisan_sube);
           
            stmt.execute(); 
            
            calisan_id = stmt.getString(1);
 
            return calisan_id;      
        }
        catch(SQLException ex)
        {
            if(ex.getErrorCode() == 20000)
            {
                JOptionPane.showMessageDialog(null, "Girmiş Olduğunuz TC Kimlik Numarası Kayıtlarımızda Bulunmaktadır.", "Başarısız İşlem",JOptionPane.WARNING_MESSAGE);
                return calisan_id;
            }
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
        return calisan_id;
    }
        
     public String[] sp_sube_bul(Connection con, String sube_no) throws SQLException
    {
        String[] tkp_parametes = new String[6];
        try
        {
            String proc = "{call sube_bul(?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, sube_no);
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
            stmt.execute(); 
            tkp_parametes[0] = sube_no;
            tkp_parametes[1] = stmt.getString(2);
            tkp_parametes[2] = stmt.getString(3);
            tkp_parametes[3] = stmt.getString(4);
            tkp_parametes[4] = stmt.getString(5);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return tkp_parametes;
    }
     
     public String[] sp_calisan_bul(Connection con, String calisan_tc) throws SQLException
    {
        String[] clsn_parametes = new String[5];
        try
        {
            String proc = "{call calisan_bul(?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, calisan_tc);
            stmt.registerOutParameter(2, java.sql.Types.NUMERIC);
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
            stmt.execute(); 
            clsn_parametes[0] = calisan_tc;
            clsn_parametes[1] = stmt.getString(2);
            clsn_parametes[2] = stmt.getString(3);
            clsn_parametes[3] = stmt.getString(4);
            clsn_parametes[4] = stmt.getString(5);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return clsn_parametes;
    }
     
     public String[] sp_krg_blg_getir(Connection con, String kargo_no) throws SQLException
    {
        String[] krg_blg_parametes = new String[8];
        try
        { 
            String proc = "{call kargo_bilgi_getir(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, kargo_no);
            stmt.registerOutParameter(2, java.sql.Types.NUMERIC);
            stmt.registerOutParameter(3, java.sql.Types.NUMERIC);
            stmt.registerOutParameter(4, java.sql.Types.NUMERIC);
            stmt.registerOutParameter(5, java.sql.Types.NUMERIC);
            stmt.registerOutParameter(6, java.sql.Types.NUMERIC);
            stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
            stmt.execute(); 
            krg_blg_parametes[0] = kargo_no;
            krg_blg_parametes[1] = stmt.getString(2);
            krg_blg_parametes[2] = stmt.getString(3);
            krg_blg_parametes[3] = stmt.getString(4); //gnd_turu
            krg_blg_parametes[4] = stmt.getString(5); //desi
            krg_blg_parametes[5] = stmt.getString(6); //krg_drm
            krg_blg_parametes[6] = stmt.getString(7);
            krg_blg_parametes[7] = stmt.getString(8);
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return krg_blg_parametes;
    }
     
     public String[] sp_mst_bul(Connection con, String tc) throws SQLException
    {
        String[] mst_parametes = new String[11];
        try
        {
            String proc = "{call mst_bul(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, tc);
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);//ad
            stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(9, java.sql.Types.VARCHAR);
            stmt.registerOutParameter(10, java.sql.Types.VARCHAR);
            stmt.execute(); 
            mst_parametes[0] = tc;
            mst_parametes[1] = stmt.getString(2);//ad
            mst_parametes[2] = stmt.getString(3);
            mst_parametes[3] = stmt.getString(4);
            mst_parametes[4] = stmt.getString(5);
            mst_parametes[5] = stmt.getString(6);
            mst_parametes[6] = stmt.getString(7);
            mst_parametes[7] = stmt.getString(8);
            mst_parametes[8] = stmt.getString(9);
            mst_parametes[9] = stmt.getString(10);
            
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        return mst_parametes;
    }
     
     public void sp_mst_guncelle(Connection con, String tc, String ad, String soyad, String telefon,
                                 String il_kod, String ilce_kod, String mahalle, String kapi_no, String adres) throws SQLException
    {
        try
        {
            String proc = "{call mst_guncelle(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setString(1, tc);
            stmt.setString(2, ad);
            stmt.setString(3, soyad);
            stmt.setString(4, telefon);
            stmt.setString(5, il_kod);
            stmt.setString(6, ilce_kod);
            stmt.setString(7, mahalle);
            stmt.setString(8, kapi_no);
            stmt.setString(9, adres);
          
            stmt.execute(); 

        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
    }
     
     public void sp_sube_guncelle(Connection con, int id, String ad, int il, int ilce, String telefon) throws SQLException
    {
        try
        {
            String proc = "{call sube_guncelle(?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setInt(1,id);
            stmt.setString(2, ad);
            stmt.setInt(3, il);
            stmt.setInt(4, ilce);
            stmt.setString(5, telefon);
            stmt.execute(); 
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
    }
     
      public void sp_calisan_sil(Connection con, int cls_id) throws SQLException
    {
        try
        {
            String proc = "{call calisan_sil(?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setInt(1,cls_id);
           
            stmt.execute(); 
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
    }
      
       public String sp_sube_sil(Connection con, int sube_id) throws SQLException
    {
         String sonuc = "";
                 
        try
        {
            String proc = "{call sube_sil(?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setInt(1, sube_id);
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
           
            stmt.execute(); 
            
            sonuc = stmt.getString(2);
           
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
        return sonuc;
    }
       
        public void sp_calisan_guncelle(Connection con, int id, String tc, String ad, String soyad, int sube) throws SQLException
    {   
        try
        {
            String proc = "{call clsn_guncelle(?, ?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(proc); 
            stmt.setInt(1,id);
            stmt.setString(2, tc);
            stmt.setString(3, ad);
            stmt.setString(4, soyad);
            stmt.setInt(5, sube);
            stmt.execute(); 
        }
        catch(SQLException ex)
        {
            System.out.println("Bir hata oluştu.");
            System.out.println("Açıklaması aşağıda verilmiştir.");
            ex.printStackTrace();
        }
        
    }
     
     
     
    
}
