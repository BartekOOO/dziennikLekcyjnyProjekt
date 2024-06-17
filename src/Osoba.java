import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Osoba implements Serializable, Tabelowe{
    protected String imie;
    protected String nazwisko;
    protected java.util.Date dataUrodzenia;

    public Osoba(String imie, String nazwisko, Date dataUrodzenia){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dataUrodzenia=dataUrodzenia;
    }
    public String toString(){
        return imie+" "+nazwisko;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getDataUrodzenia() {
        String dzien = String.format("%02d",dataUrodzenia.getDay());
        String miesiac = String.format("%02d",dataUrodzenia.getMonth());
        String rok = String.format("%04d",dataUrodzenia.getYear());
        return dzien+"-"+miesiac+"-"+rok;
    }
}
