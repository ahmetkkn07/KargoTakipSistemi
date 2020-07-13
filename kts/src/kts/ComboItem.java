
/**
 *
 * @author sametuluerr
 */

package kts;

public class ComboItem
{
    private String metin;
    private String deger;

    public ComboItem(String metin, String deger)
    {
        this.metin = metin;
        this.deger = deger;
    }

    @Override
    public String toString()
    {
        return metin;
    }

    public String getKey()
    {
        return metin;
    }

    public String getValue()
    {
        return deger;
    }
}
