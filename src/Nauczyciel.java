import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Nauczyciel extends Osoba implements Tabelowe{
    private String tytul;
    public Nauczyciel(String tytul,String imie, String nazwisko, Date dataUrodzenia){
        super(imie,nazwisko,dataUrodzenia);
        this.tytul=tytul;
    }

    @Override
    public String toString(){
        return tytul+" "+imie+" "+nazwisko;
    }
}
