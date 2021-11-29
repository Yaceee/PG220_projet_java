import java.text.SimpleDateFormat;
import java.util.Date;

public class validDate implements Validable {
    int jour;
    int mois;
    int annee;
    String sdate;

    validDate(int jour, int mois, int annee)
    {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.sdate = Integer.toString(this.jour) + "/" + Integer.toString(this.mois) + "/" + Integer.toString(this.annee);
    }

    public boolean isValid()
    {
        String dateFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            Date tdate = sdf.parse(this.sdate);
        } catch (java.text.ParseException e) {
            return false;
        }
        return true;
        
    }    
}
